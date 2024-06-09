package com.luv.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class ShortenUrlResponse {
    private String name;
    private String longUrl;
    private String shortUrlId;
    private Date createdAt;
}
