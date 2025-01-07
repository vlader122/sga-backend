package com.blumbit.vlader122.sga.utils;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JWTUtils {

    @Value("${firmaToken}")
    private String firmaToken;

    public String extraerUsuario(String token) {
        return extraerReclamo(token, Claims::getSubject);
    }


    public String generarToken(UserDetails detalleUsuario) {
        return generarToken(new HashMap<>(), detalleUsuario);
    }

    public boolean tokenValido(String token, UserDetails detalleUsuario) {
        final String userName = extraerUsuario(token);
        return (userName.equals(detalleUsuario.getUsername())) && !tokenCaducado(token);
    }

    private <T> T extraerReclamo(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extraerTodosReclamos(token);
        return claimsResolvers.apply(claims);
    }

    private String generarToken(Map<String, Object> extraClaims, UserDetails detalleUsuario) {
        return Jwts.builder().setClaims(extraClaims).setSubject(detalleUsuario.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(obtenerFirma(), SignatureAlgorithm.HS256).compact();
    }

    private boolean tokenCaducado(String token) {
        return extraerCaducado(token).before(new Date());
    }

    private Date extraerCaducado(String token) {
        return extraerReclamo(token, Claims::getExpiration);
    }

    private Claims extraerTodosReclamos(String token) {
        return Jwts.parserBuilder().setSigningKey(obtenerFirma()).build().parseClaimsJws(token)
                .getBody();
    }

    private Key obtenerFirma() {
        byte[] keyBytes = Decoders.BASE64.decode(firmaToken);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
