package com.blumbit.vlader122.sga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.blumbit.vlader122.sga.models.Accesos;
import com.blumbit.vlader122.sga.models.Usuario;
import com.blumbit.vlader122.sga.utils.JWTUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthService {

    AuthenticationManager authenticationManager;
    
    UserDetailsService usuarioDetalle;

    JWTUtils jwtUtil;

    public Accesos login(Usuario usuario) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getUsuario(), usuario.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = usuarioDetalle.loadUserByUsername(usuario.getUsuario());
            String jwt = jwtUtil.generarToken(userDetails);
            Accesos accesos = new Accesos(jwt);
            return accesos;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
