package eus.borjagomez.nanolink.mapper;

import eus.borjagomez.nanolink.dto.CreateUrlMappingRequest;
import eus.borjagomez.nanolink.dto.UpdateUrlMappingRequest;
import eus.borjagomez.nanolink.domain.UrlMapping;

import java.sql.Timestamp;

public class UrlMappingMapper {

    private UrlMappingMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static UrlMapping mapToUrlMapping(CreateUrlMappingRequest createUrlMappingRequest, UrlMapping urlMapping) {
        urlMapping.setMappingId(createUrlMappingRequest.getMappingId());
        urlMapping.setLongUrl(createUrlMappingRequest.getLongUrl());
        urlMapping.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        Timestamp expiryDate = createUrlMappingRequest.getExpiryDate();
        if (expiryDate != null) {
            urlMapping.setExpiryDate(expiryDate);
        }
        urlMapping.setHitCount(0);
        urlMapping.setCreatedBy(createUrlMappingRequest.getCreatedBy());
        return urlMapping;
    }

    public static UrlMapping mapToUrlMapping(UpdateUrlMappingRequest updateUrlMappingRequest, UrlMapping urlMapping) {
        final String newLongUrl = updateUrlMappingRequest.getLongUrl();
        if (newLongUrl != null && !newLongUrl.isEmpty()){
            urlMapping.setLongUrl(newLongUrl);
        }
        final Timestamp expiryDate = updateUrlMappingRequest.getExpiryDate();
        if (expiryDate != null) {
            urlMapping.setExpiryDate(expiryDate);
        }
        urlMapping.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        urlMapping.setUpdatedBy(updateUrlMappingRequest.getUpdatedBy());
        return urlMapping;
    }
}
