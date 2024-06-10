package com.luv.util.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UrlNotFoundException extends Exception {
    public UrlNotFoundException(String message) {
        super(message);
    }
}
