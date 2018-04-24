/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.operations;

import com.edutech.javaee.finaltest.dto.TokenUserDto;
import com.edutech.javaee.finaltest.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author leolp
 */
public class jwtToken {

    private final String key = "DECODE4416THIS";

    public TokenUserDto create(Usuario usuario) {
        if (usuario != null) {

            String jwtToken = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, key)
                    .setId(usuario.getCodigo())
                    .setSubject(usuario.getNombre())
                    .compact();

            TokenUserDto token = new TokenUserDto("login correcto", usuario.getCodigo(), usuario.getNombre(), jwtToken);
            return token;
        }
        return null;
    }

    public String decoded(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(key))
                .parseClaimsJws(token).getBody();
        return claims.getId();
    }
}
