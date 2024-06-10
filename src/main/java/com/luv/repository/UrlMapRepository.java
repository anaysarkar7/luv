package com.luv.repository;

import com.luv.model.UrlMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlMapRepository extends JpaRepository<UrlMap, String> {
    Optional<UrlMap> findByShortUrlId(String shortUrlId);
}
