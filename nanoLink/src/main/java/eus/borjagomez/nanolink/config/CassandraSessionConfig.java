package eus.borjagomez.nanolink.config;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.loadbalancing.LoadBalancingPolicy;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.cassandra.config.*;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.core.cql.session.init.ResourceKeyspacePopulator;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.lang.NonNull;

import java.util.List;

@Configuration
@EnableCassandraRepositories
public class CassandraSessionConfig extends AbstractSessionConfiguration {

    private final static Logger log = org.slf4j.LoggerFactory.getLogger(CassandraSessionConfig.class);

    private final String keyspace;
    private final String contactPoints;
    private final int port;
    private final String localDatacenter;

    CassandraSessionConfig(
            @Value("${spring.cassandra.keyspace-name}") String keyspace,
            @Value("${spring.cassandra.contact-points}") String contactPoints,
            @Value("${spring.cassandra.port}") int port,
            @Value("${spring.cassandra.local-datacenter}") String localDatacenter) {
        this.keyspace = keyspace;
        this.contactPoints = contactPoints;
        this.port = port;
        this.localDatacenter = localDatacenter;
        log.info("CassandraSessionConfig created with keyspace: {}, contactPoints: {}, port: {}, localDatacenter: {}",
                keyspace, contactPoints, port, localDatacenter);
    }

    /**
     * Return the name of the keyspace to connect to.
     *
     * @return must not be {@literal null}.
     */
    @Override
    protected @NonNull String getKeyspaceName() {
        return keyspace;
    }

    /**
     * Returns the local data center name used for
     * {@link LoadBalancingPolicy}, defaulting to {@code datacenter1}.
     * Typically, required when connecting a Cassandra cluster. Not required when using an Astra connection bundle.
     *
     * @return the local data center name. Can be {@literal null} when using an Astra connection bundle.
     */
    @Override
    protected String getLocalDataCenter() {
        return localDatacenter;
    }

    /**
     * Returns the Cassandra port. Defaults to {@code 9042}.
     *
     * @return the Cassandra port
     * @see CqlSessionFactoryBean#DEFAULT_PORT
     */
    @Override
    protected int getPort() {
        return port;
    }

    /**
     * Returns the list of keyspace creations to be run right after initialization.
     *
     * @return the list of keyspace creations, may be empty but never {@code null}.
     */
    @Override
    @NotNull
    protected @NonNull List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        final CreateKeyspaceSpecification specification =
                CreateKeyspaceSpecification.createKeyspace(keyspace)
                        .ifNotExists()
                        .with(KeyspaceOption.DURABLE_WRITES, true)
                        .withSimpleReplication();
        return List.of(specification);
    }

    @Bean
    @Primary
    public SessionFactoryFactoryBean cassandraSessionFactory(CqlSession cqlSession, Environment environment, CassandraConverter converter) {
        SessionFactoryFactoryBean session = new SessionFactoryFactoryBean();

        final ResourceKeyspacePopulator resourceKeyspacePopulator = new ResourceKeyspacePopulator();
        resourceKeyspacePopulator.addScript(new ClassPathResource("schema.cql"));
        session.setKeyspacePopulator(resourceKeyspacePopulator);

        session.setSession(cqlSession);
        session.setConverter(converter);
        Binder binder = Binder.get(environment);
        binder.bind("spring.cassandra.schema-action", SchemaAction.class).ifBound(session::setSchemaAction);
        return session;
    }

    @Bean
    @Override
    // Overriding the default method to ensure that the CqlSessionFactoryBean is created with the correct configuration
    public @NonNull CqlSessionFactoryBean cassandraSession() {
        log.info("Creating CqlSessionFactoryBean with contactPoints: {}, keyspace: {}, port: {}, localDatacenter: {}",
                contactPoints, keyspace, port, localDatacenter);

        CqlSessionFactoryBean bean = new CqlSessionFactoryBean();

        bean.setContactPoints(contactPoints);
        bean.setKeyspaceCreations(getKeyspaceCreations());
        bean.setKeyspaceDrops(getKeyspaceDrops());
        bean.setKeyspaceName(keyspace);
        bean.setLocalDatacenter(localDatacenter);
        bean.setPort(port);
        bean.setSessionBuilderConfigurer(super.getSessionBuilderConfigurer());

        return bean;
    }

}
