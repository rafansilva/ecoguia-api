package com.ecoguia.ecoguia_api.core.security;

import com.ecoguia.ecoguia_api.core.security.dto.LoginRequest;
import com.ecoguia.ecoguia_api.core.security.dto.LoginResponse;
import com.ecoguia.ecoguia_api.domain.model.Permissao;
import com.ecoguia.ecoguia_api.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
public class TokenController {

    private final JwtEncoder jwtEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public TokenController(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        var user = usuarioRepository.findByEmail(loginRequest.email());

        if (user.isEmpty() || !user.get().isLoginCorrect(loginRequest, passwordEncoder)) {
            throw new BadCredentialsException("Usuário ou senha é inválido!");
        }

        var now = Instant.now();
        var expiresIn = 4000L;

        var scopes = user.get().getRoles()
                .stream()
                .map(Permissao::getNome)
                .collect(Collectors.joining(" "));

        var claims = JwtClaimsSet.builder()
                .issuer("ecoguia-backend")
                .subject(user.get().getId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .claim("scope", scopes)
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn));
    }
}
