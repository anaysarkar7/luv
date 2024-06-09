package com.luv.service;

import com.luv.dao.request.ShortenUrlRequest;
import com.luv.dao.response.ShortenUrlResponse;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    public ShortenUrlResponse createShortUrl(ShortenUrlRequest shortenUrlRequest) {
        return null;
    }

    public String getLongUrl(String shortUrlId) {
        return "";
    }

}
