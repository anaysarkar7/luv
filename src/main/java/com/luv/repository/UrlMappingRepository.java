package com.luv.repository;

import com.luv.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, String> {
    Optional<UrlMapping> findByShortUrlId(String shortUrlId);
}
