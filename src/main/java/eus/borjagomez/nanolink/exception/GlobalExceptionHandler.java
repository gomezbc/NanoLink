package eus.borjagomez.nanolink.exception;

import eus.borjagomez.nanolink.dto.ErrorResponse;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, @Nullable HttpHeaders headers, @Nullable HttpStatusCode status, @NotNull WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String validationMsg = error.getDefaultMessage();
            validationErrors.put(fieldName, validationMsg);
        });
        logger.info("Bad Request: " + request.getDescription(false) + ", message: " + ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header(HttpHeaders.CONTENT_TYPE, "application/problem+json")
                .body(validationErrors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception exception,
                                                               WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now()
        );
        logger.error("INTERNAL_SERVER_ERROR: " + webRequest.getDescription(false) + ", message: " + exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(HttpHeaders.CONTENT_TYPE, "application/problem+json")
                .body(errorResponse);
    }

    @ExceptionHandler(UrlMappingNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUrlMappingNotFoundException(UrlMappingNotFoundException exception,
                                                                           WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        logger.info("Bad Request: " + webRequest.getDescription(false) + ", message: " + exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header(HttpHeaders.CONTENT_TYPE, "application/problem+json")
                .body(errorResponse);
    }

    @ExceptionHandler(UrlMappingAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUrlMappingAlreadyExistsException(UrlMappingAlreadyExistsException exception,
                                                                                WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        logger.info("Bad Request: " + webRequest.getDescription(false) + ", message: " + exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header(HttpHeaders.CONTENT_TYPE, "application/problem+json")
                .body(errorResponse);
    }

    @ExceptionHandler(MalformedURLException.class)
    public ResponseEntity<ErrorResponse> handleMalformedURLException(MalformedURLException exception,
                                                                     WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        logger.info("Bad Request: " + webRequest.getDescription(false) + ", message: " + exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header(HttpHeaders.CONTENT_TYPE, "application/problem+json")
                .body(errorResponse);
    }
}
