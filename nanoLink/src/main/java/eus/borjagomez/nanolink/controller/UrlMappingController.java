package eus.borjagomez.nanolink.controller;

import eus.borjagomez.nanolink.constants.RestURI;
import eus.borjagomez.nanolink.constants.UrlMappingConstants;
import eus.borjagomez.nanolink.dto.CreateUrlMappingRequest;
import eus.borjagomez.nanolink.dto.OkResponse;
import eus.borjagomez.nanolink.dto.UpdateUrlMappingRequest;
import eus.borjagomez.nanolink.service.IUrlMappingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlMappingController {

    private final IUrlMappingService urlMappingService;

    public UrlMappingController(IUrlMappingService urlMappingService) {
        this.urlMappingService = urlMappingService;
    }

    @PostMapping(value = RestURI.CREATE_URL_MAPPING, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OkResponse> createUrlMapping(@Valid @RequestBody CreateUrlMappingRequest createUrlMappingRequest) {
        urlMappingService.createUrlMapping(createUrlMappingRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new OkResponse(UrlMappingConstants.STATUS_201, UrlMappingConstants.MESSAGE_201));
    }

    @GetMapping(value = RestURI.GET_URL_MAPPING)
    public ResponseEntity<Object> redirectToLongUrl(@PathVariable String mappingId) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(urlMappingService.getLongUri(mappingId))
                .build();
    }

    @PutMapping(value = RestURI.UPDATE_URL_MAPPING, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OkResponse> updateUrlMapping(@Valid @RequestBody UpdateUrlMappingRequest updateUrlMappingRequest, @PathVariable String mappingId) {
        urlMappingService.updateUrlMapping(updateUrlMappingRequest, mappingId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new OkResponse(UrlMappingConstants.STATUS_200, UrlMappingConstants.MESSAGE_200_UPDATE));
    }

    @DeleteMapping(value = RestURI.DELETE_URL_MAPPING, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OkResponse> deleteUrlMapping(@PathVariable String mappingId) {
        urlMappingService.deleteUrlMapping(mappingId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new OkResponse(UrlMappingConstants.STATUS_200, UrlMappingConstants.MESSAGE_200_DELETE));
    }

}
