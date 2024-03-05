package eus.borjagomez.nanolink.repository;

import eus.borjagomez.nanolink.model.UrlMapping;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UrlMappingRepository extends CassandraRepository<UrlMapping, String>{
}
