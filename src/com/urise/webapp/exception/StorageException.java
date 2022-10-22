package com.urise.webapp.exception;

public class StorageException extends RuntimeException {
    private final String uuid;

    public StorageException(String message, String uuid1) {
        super(message);
        this.uuid = uuid1;
    }

    public StorageException(String message, String uuid, Exception e) {
        super(message, e);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
