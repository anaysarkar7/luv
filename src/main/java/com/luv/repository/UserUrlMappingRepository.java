package com.luv.repository;

import com.luv.model.UrlMap;
import com.luv.model.UserUrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserUrlMappingRepository extends JpaRepository<UserUrlMapping, String> {
    Optional<UserUrlMapping> findByUser(String userId);
}
