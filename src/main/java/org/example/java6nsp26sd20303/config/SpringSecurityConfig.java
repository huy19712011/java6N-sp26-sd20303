package org.example.java6nsp26sd20303.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SpringSecurityConfig {

    private final UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authorize -> {
                    authorize.anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults());

        return http.build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {

        return configuration.getAuthenticationManager();
    }

    //@Bean
    //public UserDetailsService userDetailsService() {
    //
    //    UserDetails customUser = User.builder()
    //            .username("user")
    //            .password(passwordEncoder().encode("123456"))
    //            .roles("USER")
    //            .build();
    //
    //    UserDetails customAdmin = User.builder()
    //            .username("admin")
    //            .password(passwordEncoder().encode("123456"))
    //            .roles("ADMIN")
    //            .build();
    //
    //    return new InMemoryUserDetailsManager(customUser, customAdmin);
    //
    //}
}
