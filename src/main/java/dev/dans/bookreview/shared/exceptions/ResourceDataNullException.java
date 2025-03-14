package dev.dans.bookreview.shared.exceptions;

public class ResourceDataNullException extends RuntimeException {
    public ResourceDataNullException(String message) {
        super(message + " cannot be null");
    }
}
