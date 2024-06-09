package com.luv.dao.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ShortenUrlRequest {
    @NotBlank(message = "Please provide longUrl!")
    private String longUrl;
}
