package com.example.asistencias.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Agregamos lógica de cargar la información del usuario desde la base de datos.
        System.out.println("Se inició sesión con " + username);
        if(!username.equals("Lugel")){
            throw new UsernameNotFoundException("Usuario " + username + " no existe");
        }
        return User.withUsername(username)
                // CUANDO CONSULTEN DE LA BASE DE DATOS NO ENCRIPTEN DOS VECES
                .password(passwordEncoder().encode(username))
                .roles("ADMIN")
                .build();
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(8);
    }
}
