package dev.dans.bookreview.infra.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestResponseBuilder {
    public static <T> ResponseEntity<RestResponse<T>> build(
            T data,
            String selfLink,
            boolean success,
            HttpStatus status
    ) {
        RestResponse<T> response = new RestResponse<>();
        response.setData(data);
        response.setSelfLink(selfLink);
        response.setSuccess(success);
        response.setStatusCode(status.value());
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response);
    }
}
