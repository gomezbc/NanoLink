package eus.borjagomez.nanolink.exception;

public class UrlMappingNotFoundException extends RuntimeException {

    public UrlMappingNotFoundException(){
        super();
    }

    public UrlMappingNotFoundException(String message) {
        super(message);
    }
}
