package me.kimbeumryong.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.kimbeumryong.springbootdeveloper.domain.RefreshToken;
import me.kimbeumryong.springbootdeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}
