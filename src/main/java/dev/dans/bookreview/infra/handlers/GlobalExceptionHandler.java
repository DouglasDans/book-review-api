package dev.dans.bookreview.infra.handlers;

import dev.dans.bookreview.infra.response.RestResponse;
import dev.dans.bookreview.infra.response.RestResponseBuilder;
import dev.dans.bookreview.shared.exceptions.ResourceDataNullException;
import dev.dans.bookreview.shared.exceptions.ResourceNotFoundException;
import dev.dans.bookreview.shared.utils.GetResponseSelfLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
