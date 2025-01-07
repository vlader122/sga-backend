package com.blumbit.vlader122.sga.config;

import java.io.IOException;


import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.blumbit.vlader122.sga.models.Usuario;
import com.blumbit.vlader122.sga.repository.UsuarioRepository;
import com.blumbit.vlader122.sga.services.UsuarioService;
import com.blumbit.vlader122.sga.utils.JWTUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAutentication extends OncePerRequestFilter{
    private final JWTUtils jwtUtils;
    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String usuario;
        if (StringUtils.isEmpty(authHeader) || !StringUtils.startsWith(authHeader, "Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(7);
        usuario = jwtUtils.extraerUsuario(jwt);
        Usuario entradausuario = usuarioRepository.findById(Long.parseLong(usuario)).orElse(null);
        if (StringUtils.isNotEmpty(usuario) && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails usuarioDetalle = usuarioService.loadUserByUsername(entradausuario.usuario);
            if (jwtUtils.tokenValido(jwt, usuarioDetalle)) {
                SecurityContext context = SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(usuarioDetalle, null, usuarioDetalle.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                context.setAuthentication(authToken);
                SecurityContextHolder.setContext(context);
            }
        }
        filterChain.doFilter(request, response);
    }

}
