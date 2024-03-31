package eus.borjagomez.nanolink.exception;

public class UrlMappingAlreadyExistsException extends RuntimeException {

    public UrlMappingAlreadyExistsException(){
        super();
    }

    public UrlMappingAlreadyExistsException(String message) {
        super(message);
    }
}
