package com.HotelBookingService.HotelBookingBackend.JWT;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.app.jwtSecret}")
    private String jwtSecret;

    @Value("${spring.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String getJwtFromHeader(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        logger.debug("authHeader: "+authHeader);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String generateTokenFromUsername(UserDetails userDetails) {
        String username = userDetails.getUsername();
        return Jwts.builder().subject(username)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime()+jwtExpirationMs))
                .signWith(key())
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().verifyWith((SecretKey) key())
                .build().parseSignedClaims(token)
                .getPayload().getSubject();
    }

    public boolean validateToken(String token) {
        try{
            System.out.println("Validating token: "+token);
            Jwts.parser().verifyWith((SecretKey) key())
                    .build().parseSignedClaims(token);
            return true;
        }catch(MalformedJwtException e){
            logger.error("MalformedJwtException: "+e.getMessage());
        }catch(ExpiredJwtException e){
            logger.error("ExpiredJwtException: "+e.getMessage());
        }catch(UnsupportedJwtException e){
            logger.error("UnsupportedJwtException: "+e.getMessage());
        }catch(IllegalArgumentException e){
            logger.error("IllegalArgumentException: "+e.getMessage());
        }

        return false;
    }

}
