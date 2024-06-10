package com.luv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "url_mapping", uniqueConstraints = @UniqueConstraint(columnNames = "urlMappingId"))
public class UrlMap {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String urlMappingId;
    @Column(unique = true)
    private String shortUrlId;
    private String longUrl;
}
