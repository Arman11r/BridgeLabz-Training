package com.employeePayRoll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Basic-auth security setup with two in-memory roles:
 *  - ADMIN: full access (create/update/delete employees, generate payslips)
 *  - EMPLOYEE: read-only access (view employees and payslips)
 *
 * NOTE: This does not scope EMPLOYEE to "their own" payslips only — every
 * authenticated EMPLOYEE can currently read every employee's data. Doing
 * proper row-level scoping would mean linking a username to an employeeId,
 * which is a reasonable next step but out of scope for "basic auth."
 *
 * Credentials are hardcoded here for local dev/demo purposes only.
 * In a real app these would come from a database + registration flow.
 */
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails employee = User.builder()
                .username("employee")
                .password(passwordEncoder.encode("employee123"))
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(admin, employee);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Stateless REST API using HTTP Basic - no browser form login, no CSRF tokens needed.
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        // Reads: either role
                        .requestMatchers(HttpMethod.GET, "/employees", "/employees/**").hasAnyRole("ADMIN", "EMPLOYEE")
                        // Writes: ADMIN only
                        .requestMatchers(HttpMethod.POST, "/employees").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/employees/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/employees/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/employees/*/payslips").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(basic -> {});

        return http.build();
    }
}
