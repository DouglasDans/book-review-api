package dev.dans.bookreview.infra.handlers;

import dev.dans.bookreview.infra.response.RestResponse;
import dev.dans.bookreview.infra.response.RestResponseBuilder;
import dev.dans.bookreview.shared.exceptions.ResourceDataNullException;
import dev.dans.bookreview.shared.exceptions.ResourceNotFoundException;
import dev.dans.bookreview.shared.utils.GetResponseSelfLink;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<RestResponse<String>> resourceNotFound(ResourceNotFoundException ex) {
        return RestResponseBuilder.build(
                ex.getMessage(),
                GetResponseSelfLink.getSelfLink(),
                false,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ResourceDataNullException.class)
    public ResponseEntity<RestResponse<String>> resourceDataNull(ResourceDataNullException ex) {
        return RestResponseBuilder.build(
                ex.getMessage(),
                GetResponseSelfLink.getSelfLink(),
                false,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<RestResponse<String>> resourceDataNull(HttpRequestMethodNotSupportedException ex) {
        return RestResponseBuilder.build(
                "Method Not Allowed",
                GetResponseSelfLink.getSelfLink(),
                false,
                HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<RestResponse<String>> resourceDataNull(DataIntegrityViolationException ex) {
        return RestResponseBuilder.build(
                "Data Integrity Violation",
                GetResponseSelfLink.getSelfLink(),
                false,
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RestResponse<String>> resourceDataNull(ConstraintViolationException ex) {
        return RestResponseBuilder.build(
                "Database Constraint Violation",
                GetResponseSelfLink.getSelfLink(),
                false,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<RestResponse<String>> resourceDataNull(NoResourceFoundException ex) {
        return RestResponseBuilder.build(
                ex.getMessage(),
                GetResponseSelfLink.getSelfLink(),
                false,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<RestResponse<String>> unexpectedException(Throwable unexpectedException) {
        log.error(unexpectedException.getMessage(), unexpectedException);
        return RestResponseBuilder.build(
                "Unexpected internal server error.",
                GetResponseSelfLink.getSelfLink(),
                false,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
