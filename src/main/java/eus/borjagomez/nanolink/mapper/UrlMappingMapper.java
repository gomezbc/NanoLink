package eus.borjagomez.nanolink.mapper;

import eus.borjagomez.nanolink.dto.CreateUrlMappingDto;
import eus.borjagomez.nanolink.dto.UpdateUrlMappingDto;
import eus.borjagomez.nanolink.model.UrlMapping;
import eus.borjagomez.nanolink.utils.UrlParser;

import java.net.MalformedURLException;
import java.sql.Timestamp;

public class UrlMappingMapper {

    public static UrlMapping mapToUrlMapping(CreateUrlMappingDto createUrlMappingDto, UrlMapping urlMapping) {
        urlMapping.setMappingId(createUrlMappingDto.getMappingId());
        urlMapping.setLongUrl(createUrlMappingDto.getLongUrl());
        String parsedUrl;
        try {
            parsedUrl = UrlParser.removeUrlPath(createUrlMappingDto.getLongUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        urlMapping.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        Timestamp expiryDate = createUrlMappingDto.getExpiryDate();
        if (expiryDate != null) {
            urlMapping.setExpiryDate(expiryDate);
        }
        urlMapping.setHitCount(0);
        urlMapping.setCreatedBy(createUrlMappingDto.getCreatedBy());
        return urlMapping;
    }

    public static UrlMapping mapToUrlMapping(UpdateUrlMappingDto updateUrlMappingDto, UrlMapping urlMapping) {
        final String newLongUrl = updateUrlMappingDto.getLongUrl();
        if (newLongUrl != null && !newLongUrl.isEmpty()){
            urlMapping.setLongUrl(newLongUrl);
        }
        final Timestamp expiryDate = updateUrlMappingDto.getExpiryDate();
        if (expiryDate != null) {
            urlMapping.setExpiryDate(expiryDate);
        }
        urlMapping.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        urlMapping.setUpdatedBy(updateUrlMappingDto.getUpdatedBy());
        return urlMapping;
    }
}
