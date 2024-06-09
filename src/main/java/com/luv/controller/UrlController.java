package com.luv.controller;

import com.luv.dao.request.ShortenUrlRequest;
import com.luv.service.UrlService;
import com.luv.dao.response.BaseResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.luv.util.constant.MiscellaneousConstants.API_VERSION;

@Slf4j
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @GetMapping("/{shortUrlId}")
    public void getLongUrl(
            HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable("shortUrlId") String shortUrlId
    ) throws IOException {
        response.sendRedirect("https://www.google.com");
    }

    @PostMapping(API_VERSION + "/shorten")
    public BaseResponse<?> createShortUrl(
            @RequestBody @Validated ShortenUrlRequest shortenUrlRequestBody
    ) {
        return BaseResponse
                .success(
                    urlService.createShortUrl(shortenUrlRequestBody)
                );
    }

}
