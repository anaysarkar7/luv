package com.luv.service;

import com.luv.dao.request.ShortenUrlRequest;
import com.luv.dao.response.ShortenUrlResponse;
import com.luv.model.UrlMap;
import com.luv.model.User;
import com.luv.model.UserUrlMapping;
import com.luv.repository.UrlMapRepository;
import com.luv.repository.UserUrlMappingRepository;
import com.luv.util.exception.UrlNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UrlService {

    private final UrlMapRepository urlMapRepository;
    private final UserUrlMappingRepository userUrlMappingRepository;

    public UrlService(UrlMapRepository urlMapRepository, UserUrlMappingRepository userUrlMappingRepository) {
        this.urlMapRepository = urlMapRepository;
        this.userUrlMappingRepository = userUrlMappingRepository;
    }

    public ShortenUrlResponse createShortUrl(ShortenUrlRequest shortenUrlRequest) {
        UrlMap urlMap = this.urlMapRepository.save(UrlMap.builder()
                .longUrl(shortenUrlRequest.getLongUrl())
                .shortUrlId("")
                .build());
        urlMap.setShortUrlId(this.generateShortUrlId(urlMap.getUrlMappingId()));
        this.urlMapRepository.save(urlMap);
        UserUrlMapping userUrlMapping = UserUrlMapping.builder()
                .urlMap(urlMap)
                .user(null)
                .build();
        this.userUrlMappingRepository.save(userUrlMapping);
        return ShortenUrlResponse.builder()
                .shortUrlId(urlMap.getShortUrlId())
                .longUrl(shortenUrlRequest.getLongUrl())
                .build();
    }

    private String generateShortUrlId(String urlMappingId) {
        return "123";
    }

    /**
     * This function is available without auth, changes to be done carefully.
     */
    public String getLongUrl(String shortUrlId) throws UrlNotFoundException {
        return this.urlMapRepository.findByShortUrlId(shortUrlId).orElseThrow(UrlNotFoundException::new).getLongUrl();
    }

}
