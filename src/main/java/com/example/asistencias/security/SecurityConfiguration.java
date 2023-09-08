package com.example.asistencias.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

//    @Bean
//    public UserDetailsService userDetailsService() {
//        System.out.println("Se ejecutó");
//        UserDetails user = User.withUsername("Lugel")
//                .password(passwordEncoder().encode("Lugel"))
//                .roles("ADMIN", "USER")
//                .build();
//
//        UserDetails carlos = User.withUsername("Carlos")
//                .password(passwordEncoder().encode("Carlos"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user, carlos);
//    }

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(8);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests((authorize) -> {
                    authorize.antMatchers("/public/**").permitAll();
                })
                .authorizeHttpRequests((authorize) -> {
                    authorize.antMatchers("/asistencias").hasRole("ADMIN");
                })
                .authorizeHttpRequests((authorize) -> {
                    authorize.antMatchers("/verify").hasRole("USER");
                })
                .authorizeHttpRequests((authorize) -> {
                    authorize.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults())
        ;
        return httpSecurity.build();
    }
}
