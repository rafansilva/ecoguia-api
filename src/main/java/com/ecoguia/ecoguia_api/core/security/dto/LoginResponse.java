package com.ecoguia.ecoguia_api.core.security.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}