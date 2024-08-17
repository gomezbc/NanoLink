package eus.borjagomez.nanolink.service;

import eus.borjagomez.nanolink.dto.CreateUrlMappingRequest;
import eus.borjagomez.nanolink.dto.UpdateUrlMappingRequest;
import eus.borjagomez.nanolink.exception.UrlMappingAlreadyExistsException;
import eus.borjagomez.nanolink.exception.UrlMappingNotFoundException;
import eus.borjagomez.nanolink.mapper.UrlMappingMapper;
import eus.borjagomez.nanolink.domain.UrlMapping;
import eus.borjagomez.nanolink.repository.UrlMappingRepository;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Optional;

@Service
public class UrlMappingServiceImpl implements IUrlMappingService{

    private final UrlMappingRepository urlMappingRepository;

    public UrlMappingServiceImpl(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    @Override
    public void createUrlMapping(CreateUrlMappingRequest createUrlMappingRequest) {
        UrlMapping urlMapping = UrlMappingMapper.mapToUrlMapping(createUrlMappingRequest, new UrlMapping());
        Optional<UrlMapping> optionalUrlMapping = urlMappingRepository.findById(urlMapping.getMappingId());
        if (optionalUrlMapping.isPresent()) {
            throw new UrlMappingAlreadyExistsException("Mapping already exists");
        }
        urlMappingRepository.save(urlMapping);
    }

    @Override
    public URI getLongUri(String mappingId) {
        Optional<UrlMapping> optionalUrlMapping = urlMappingRepository.findById(mappingId);
        if (optionalUrlMapping.isEmpty()) {
            throw new UrlMappingNotFoundException("Mapping doesn't exist");
        }
        final UrlMapping urlMapping = optionalUrlMapping.get();
        updateHitCount(urlMapping);
        updateLastHitDate(urlMapping);
        return URI.create(urlMapping.getLongUrl());
    }

    @Override
    public void updateUrlMapping(UpdateUrlMappingRequest updateUrlMappingRequest, String mappingId) {
        Optional<UrlMapping> optionalUrlMapping = urlMappingRepository.findById(mappingId);
        if (optionalUrlMapping.isEmpty()) {
            throw new UrlMappingNotFoundException("Mapping doesn't exist");
        }
        UrlMapping urlMapping = UrlMappingMapper.mapToUrlMapping(updateUrlMappingRequest, optionalUrlMapping.get());
        urlMappingRepository.save(urlMapping);
    }

    @Override
    public void deleteUrlMapping(String mappingId) {
        Optional<UrlMapping> optionalUrlMapping = urlMappingRepository.findById(mappingId);
        if (optionalUrlMapping.isEmpty()) {
            throw new UrlMappingNotFoundException("Mapping doesn't exist");
        }
        urlMappingRepository.deleteById(mappingId);
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
