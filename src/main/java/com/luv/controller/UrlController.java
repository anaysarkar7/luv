package com.luv.controller;

import com.luv.config.security.JwtService;
import com.luv.dao.request.ShortenUrlRequest;
import com.luv.model.User;
import com.luv.service.UrlService;
import com.luv.dao.response.BaseResponse;
import com.luv.util.constant.AuthConstants;
import com.luv.util.constant.MiscellaneousConstants;
import com.luv.util.exception.UrlNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;
    private final JwtService jwtService;

    @GetMapping("/{shortUrlId}")
    public void getLongUrl(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @PathVariable("shortUrlId") String shortUrlId
    ) throws IOException {
        try {
            log.info("Fetching URL corresponding to {}", shortUrlId);
            response.sendRedirect(urlService.getLongUrl(shortUrlId));
        } catch (UrlNotFoundException e) {
            log.warn("No URL found for shortUrlId: {}", shortUrlId);
            response.sendRedirect("https://www.google.com/");//TODO: change with static 404 url not found page
        }
    }

    @PostMapping(MiscellaneousConstants.API_VERSION + "/shorten")
    public BaseResponse<?> createShortUrl(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @RequestBody @Validated ShortenUrlRequest shortenUrlRequestBody
    ) {
        final String authHeader = request.getHeader(AuthConstants.AUTHORIZATION_HEADER);
        final String jwtToken = authHeader.substring(AuthConstants.BEARER_PREFIX_LENGTH);
        final String userEmail = jwtService.extractUsername(jwtToken);
        return BaseResponse.success(urlService.createShortUrl(shortenUrlRequestBody));
    }

}
