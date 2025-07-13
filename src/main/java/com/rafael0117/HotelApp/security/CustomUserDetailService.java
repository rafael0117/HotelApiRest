package com.rafael0117.HotelApp.security;

import com.rafael0117.HotelApp.domain.entity.Empleado;
import com.rafael0117.HotelApp.domain.repository.IEmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final IEmpleadoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Empleado empleado = repository.findByUsuario(usuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no registrado"));
        return new User(
                empleado.getUsuario(),
                empleado.getPassword(),
                empleado.getCargos().stream()
                        .map(c -> new SimpleGrantedAuthority(c.name())).toList()
        );
    }
}
