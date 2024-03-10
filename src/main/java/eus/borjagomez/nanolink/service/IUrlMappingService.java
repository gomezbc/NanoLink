package eus.borjagomez.nanolink.service;

import eus.borjagomez.nanolink.dto.CreateUrlMappingDto;
import eus.borjagomez.nanolink.model.UrlMapping;

public interface IUrlMappingService {

    void createUrlMapping(CreateUrlMappingDto createUrlMappingDto);

}
