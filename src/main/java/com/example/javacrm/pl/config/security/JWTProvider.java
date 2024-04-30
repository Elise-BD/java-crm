package com.example.javacrm.pl.config.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.javacrm.dal.entities.Utilisateur;
import com.example.javacrm.dal.enums.Role;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;

import java.time.Instant;
import java.util.List;

@Component
public class JWTProvider {

    //Signature
    private static final String JWT_SECRET = "wKpAo8hEghvfVZuCZuw566pyHPWxjL3MD2YMhwoz4iimk96AksQSXSYHMuUzZb2vKgttdcg5efvt4LJWYhS76M";
    //Delai de validité
    private static final long EXPIRES_AT = 1_800_000;
    // Nom en tête
    private static final String AUTH_HEADER = "Authorization";
    //Type
    private static final String TOKEN_PREFIX = "Bearer ";

    private final UserDetailsService userDetailsService;

    public JWTProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String generateToken(String username, List<Role> roles){
        return TOKEN_PREFIX + JWT.create()
                .withSubject(username)
                .withClaim("roles",roles.stream().map(Enum::toString).toList())
                .withExpiresAt(Instant.now().plusMillis(EXPIRES_AT))
                .sign(Algorithm.HMAC512(JWT_SECRET));
    }

    public String extractToken(HttpServletRequest request) {
        String header = request.getHeader(AUTH_HEADER);

        if (header == null || !header.startsWith(TOKEN_PREFIX))
            return null;

        return header.replaceFirst(TOKEN_PREFIX, "");
    }

    public boolean validateToken(String token) {

        try {

            //1 le bon JWT_SECRET à été utilisé (le même algorithme de cryptage)
            //2 token n'est pas expiré
            DecodedJWT jwt = JWT.require(Algorithm.HMAC512(JWT_SECRET))
                    .acceptExpiresAt(EXPIRES_AT)
                    .withClaimPresence("sub")
                    .build()
                    .verify(token);

            //3 token créé a partir d'un User existant et actif
            String username = jwt.getSubject();
            Utilisateur user = (Utilisateur) userDetailsService.loadUserByUsername(username);
            return user.isEnabled();


        } catch (JWTVerificationException | UsernameNotFoundException ex) {
            return false;
        }
    }

    public Authentication createAuthentication(String token) {
        DecodedJWT jwt = JWT.decode(token);

        String username = jwt.getSubject();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        return new UsernamePasswordAuthenticationToken(
                userDetails.getUsername(),
                null,
                userDetails.getAuthorities()
        );
    }
}
