package eus.borjagomez.nanolink;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableDiscoveryClient
public class NanoLinkApplication {

    @Bean
    @Primary
    @Profile("aws")
    public CqlSession getAWSCqlSession(){
        DriverConfigLoader loader = DriverConfigLoader.fromClasspath("keyspaces-application.conf");
        return CqlSession.builder()
                .withConfigLoader(loader)
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(NanoLinkApplication.class, args);
    }

}
