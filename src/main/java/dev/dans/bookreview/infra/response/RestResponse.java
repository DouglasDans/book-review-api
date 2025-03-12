package dev.dans.bookreview.infra.response;

import lombok.Data;

@Data
public class RestResponse<T> {
    private String selfLink;
    private T data;
    private boolean success;
    private int statusCode;
}