package eus.borjagomez.nanolink.controller;

import eus.borjagomez.nanolink.constants.UrlMappingConstants;
import eus.borjagomez.nanolink.dto.CreateUrlMappingDto;
import eus.borjagomez.nanolink.dto.ResponseDto;
import eus.borjagomez.nanolink.dto.UpdateUrlMappingDto;
import eus.borjagomez.nanolink.service.IUrlMappingService;
import eus.borjagomez.nanolink.service.UrlMappingServiceCassandra;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlMappingController {

    private final IUrlMappingService urlMappingService;

    public UrlMappingController(UrlMappingServiceCassandra urlMappingService) {
        this.urlMappingService = urlMappingService;
    }

    @PostMapping(value = "/api/shorten", consumes = "application/json", produces = {"application/json","application/problem+json"})
    public ResponseEntity<ResponseDto> createUrlMapping(@Valid @RequestBody CreateUrlMappingDto createUrlMappingDto) {
        urlMappingService.createUrlMapping(createUrlMappingDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(UrlMappingConstants.STATUS_201, UrlMappingConstants.MESSAGE_201));
    }

    @GetMapping(value = "/api/{mappingId}", produces = {"application/json","application/problem+json"})
    public ResponseEntity<Object> redirectToLongUrl(@PathVariable String mappingId) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(urlMappingService.getLongUri(mappingId))
                .build();
    }

    @PutMapping(value = "/api/{mappingId}", consumes = "application/json", produces = {"application/json","application/problem+json"})
    public ResponseEntity<ResponseDto> updateUrlMapping(@Valid @RequestBody UpdateUrlMappingDto updateUrlMappingDto, @PathVariable String mappingId) {
        urlMappingService.updateUrlMapping(updateUrlMappingDto, mappingId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(UrlMappingConstants.STATUS_200, UrlMappingConstants.MESSAGE_200_UPDATE));
    }

    @DeleteMapping(value = "/api/{mappingId}", produces = {"application/json","application/problem+json"})
    public ResponseEntity<ResponseDto> deleteUrlMapping(@PathVariable String mappingId) {
        urlMappingService.deleteUrlMapping(mappingId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(UrlMappingConstants.STATUS_200, UrlMappingConstants.MESSAGE_200_DELETE));
    }

}
