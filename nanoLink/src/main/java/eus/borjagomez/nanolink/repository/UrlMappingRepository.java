package eus.borjagomez.nanolink.repository;

import eus.borjagomez.nanolink.domain.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, String> {
}
