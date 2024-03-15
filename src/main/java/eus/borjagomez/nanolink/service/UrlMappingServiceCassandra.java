package eus.borjagomez.nanolink.service;

import eus.borjagomez.nanolink.dto.CreateUrlMappingDto;
import eus.borjagomez.nanolink.mapper.UrlMappingMapper;
import eus.borjagomez.nanolink.model.UrlMapping;
import eus.borjagomez.nanolink.repository.UrlMappingRepository;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Optional;

@Service
public class UrlMappingServiceCassandra implements IUrlMappingService{

    private final UrlMappingRepository urlMappingRepository;

    public UrlMappingServiceCassandra(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    public void createUrlMapping(CreateUrlMappingDto createUrlMappingDto) {
        UrlMapping urlMapping = UrlMappingMapper.mapToUrlMapping(createUrlMappingDto, new UrlMapping());
        Optional<UrlMapping> optionalUrlMapping = urlMappingRepository.findById(urlMapping.getMappingId());
        if (optionalUrlMapping.isPresent()) {
            System.err.println("Mapping already exists " + optionalUrlMapping.get());
            throw new RuntimeException("Mapping already exists");
        }
        urlMappingRepository.save(urlMapping);
    }

    @Override
    public URI getLongUri(String mappingId) {
        Optional<UrlMapping> optionalUrlMapping = urlMappingRepository.findById(mappingId);
        if (optionalUrlMapping.isEmpty()) {
            System.err.println("Mapping doesn't exists " + mappingId);
            throw new RuntimeException("Mapping doesn't exist");
        }
        final UrlMapping urlMapping = optionalUrlMapping.get();
        updateHitCount(urlMapping);
        updateLastHitDate(urlMapping);
        return URI.create(urlMapping.getLongUrl());
    }

    @Override
    public void updateHitCount(UrlMapping urlMapping) {
        urlMapping.setHitCount(urlMapping.getHitCount() + 1);
        urlMappingRepository.save(urlMapping);
    }

    @Override
    public void updateLastHitDate(UrlMapping urlMapping) {
        urlMapping.setLastHitDate(new Timestamp(System.currentTimeMillis()));
        urlMappingRepository.save(urlMapping);
    }
}
