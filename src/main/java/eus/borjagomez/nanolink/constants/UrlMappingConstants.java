package eus.borjagomez.nanolink.constants;

public class UrlMappingConstants {

    private UrlMappingConstants() {
    }

    public static final String STATUS_200 = "200";
    public static final String STATUS_201 = "201";
    public static final String STATUS_204 = "204";
    public static final String MESSAGE_200_UPDATE = "URL mapping updated successfully";
    public static final String MESSAGE_200_DELETE = "URL mapping deleted successfully";
    public static final String MESSAGE_201 = "URL mapping created successfully";
    public static final String MESSAGE_204 = "URL mapping not found";
    public static final String URL_MAPPING_NOT_FOUND_EXCEPTION_MSG = "The URL mapping provided does not exist";
    public static final String URL_MAPPING_ID_ALREADY_EXISTS_MSG = "A mapping with that id already exists";
    public static final String MALFORMED_URL_EXCEPTION_MSG = "The URL provided is not valid";
    public static final String URL_MAPPING_ID_ALREADY_EXISTS_EXCEPTION_MSG = "The mapping ID provided already exists";
}
