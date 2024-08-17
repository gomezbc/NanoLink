package eus.borjagomez.nanolink.service;

import eus.borjagomez.nanolink.dto.CreateUrlMappingRequest;
import eus.borjagomez.nanolink.dto.UpdateUrlMappingRequest;
import eus.borjagomez.nanolink.domain.UrlMapping;

import java.net.URI;

public interface IUrlMappingService {

    void createUrlMapping(CreateUrlMappingRequest createUrlMappingRequest);

    URI getLongUri(String mappingId);

    void updateUrlMapping(UpdateUrlMappingRequest updateUrlMappingRequest, String mappingId);

    void deleteUrlMapping(String mappingId);

    void updateHitCount(UrlMapping urlMapping);

    void updateLastHitDate(UrlMapping urlMapping);
}
