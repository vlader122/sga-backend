package com.blumbit.vlader122.sga.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blumbit.vlader122.sga.models.Usuario;
import com.blumbit.vlader122.sga.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    UsuarioRepository usuariosRepository;
    
    public Page<Usuario> listarUsuarios(Pageable pageable) {
        return usuariosRepository.findAll(pageable);
    }

    public Usuario obtenerById(Long id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    public Usuario guardar(Usuario usuario) {
        return usuariosRepository.save(usuario);
    }

    public void eliminar(Long id) {
        usuariosRepository.deleteById(id);
    }

    public Usuario actualizar(Usuario usuario) {
        return usuariosRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String entradausuario) throws UsernameNotFoundException {
        Usuario usuario = usuariosRepository.findByNombreUsuario(entradausuario);
        if (usuario == null) {
            throw new UsernameNotFoundException("No se encontro al usuario: " + entradausuario);
        } else {
            List<GrantedAuthority> roles = new ArrayList<>();
            return new User(Long.toString(usuario.id), usuario.password, roles);
        }
    }
}
