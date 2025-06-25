package me.kimbeumryong.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.kimbeumryong.springbootdeveloper.dto.CreateAccessTokenRequest;
import me.kimbeumryong.springbootdeveloper.dto.CreateAccessTokenResponse;
import me.kimbeumryong.springbootdeveloper.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenApiController {

    private final TokenService tokenService;

    public ResponseEntity<CreateAccessTokenResponse> createNewAccessToken(@RequestBody CreateAccessTokenRequest request) {
        String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());

        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateAccessTokenResponse(newAccessToken));
    }
}
