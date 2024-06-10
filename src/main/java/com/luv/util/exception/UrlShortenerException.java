package com.luv.util.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UrlShortenerException extends Exception {
    public UrlShortenerException(String message) {
        super(message);
    }
}
