package com.form.base;

public class OceanRuntimeException extends RuntimeException {
    public OceanRuntimeException() {
    }

    public OceanRuntimeException(String message) {
        super(message);
    }

    public OceanRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public OceanRuntimeException(Throwable cause) {
        super(cause);
    }
}
