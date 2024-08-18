package eus.borjagomez.nanolink.constants;

public class RestURI {
    private RestURI() {
        throw new IllegalStateException("Constant class");
    }

    public static final String CREATE_URL_MAPPING = "/api/shorten";

    public static final String GET_URL_MAPPING = "/{mappingId}";

    public static final String UPDATE_URL_MAPPING = "/api/{mappingId}";

    public static final String DELETE_URL_MAPPING = "/api/{mappingId}";

}
