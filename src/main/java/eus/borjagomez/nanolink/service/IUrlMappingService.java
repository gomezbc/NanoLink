package eus.borjagomez.nanolink.service;

import eus.borjagomez.nanolink.dto.CreateUrlMappingDto;
import eus.borjagomez.nanolink.model.UrlMapping;

import java.net.URI;

public interface IUrlMappingService {

    void createUrlMapping(CreateUrlMappingDto createUrlMappingDto);

    URI getLongUri(String mappingId);

    void updateHitCount(UrlMapping urlMapping);

    void updateLastHitDate(UrlMapping urlMapping);
}
