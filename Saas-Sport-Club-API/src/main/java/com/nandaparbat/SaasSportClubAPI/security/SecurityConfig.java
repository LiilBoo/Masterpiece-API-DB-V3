package com.nandaparbat.SaasSportClubAPI.security;


import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${SaasSportClubAPI.security.jwt.issuer}")
    private String issuer;

    @Value("${SaasSportClubAPI.security.jwt.expiration}")
    private long expiration;

    @Value("${SaasSportClubAPI.security.jwt.zoneId}")
    private String zoneId;

    @Value("${SaasSportClubAPI.security.jwt.secret}")
    private String secret;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().logout().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/api/tournaments/users/**","/api/players/users/**","/api/pairing-styles/users/**",
                        "/api/formats/users/**","/api/teams/users/**").permitAll().and()
                .authorizeRequests().antMatchers("/api/roles/**",
                        "/api/formats/**","/api/pairing-styles/**","/api/tournaments/**","/api/teams/**")
                .hasRole("SUPER_ADMIN").and()
                .authorizeRequests().antMatchers(
                        "/api/tournaments/admin/**","/api/teams/auth/**")
                .hasRole("ADMIN").and()
                .authorizeRequests().antMatchers("/api/tournaments/auth/**")
                .hasRole("ORGANISATOR")
                .anyRequest()
                .authenticated().and().oauth2ResourceServer().jwt();
    };


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable().logout().disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .authorizeRequests().antMatchers("/api/**").permitAll().and()
//                .authorizeRequests()
//                .antMatchers("/api/**",
//                        "/api/**")
//                .permitAll().and().authorizeRequests().anyRequest()
//                .authenticated().and().oauth2ResourceServer().jwt();
//    };

    @Bean
    public JwtDecoder jwtDecoder(){
        SecretKey secretKey = new SecretKeySpec(secret.getBytes(),
                "HMACSHA256");
        return NimbusJwtDecoder.withSecretKey(secretKey).macAlgorithm(MacAlgorithm.HS256).build();
    };

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter(){
        JwtGrantedAuthoritiesConverter authoritiesConverter =
                new JwtGrantedAuthoritiesConverter();

        authoritiesConverter.setAuthoritiesClaimName("roles");
        authoritiesConverter.setAuthorityPrefix("");

        JwtAuthenticationConverter authenticationConverter =
                new JwtAuthenticationConverter();

        authenticationConverter.setJwtGrantedAuthoritiesConverter(authoritiesConverter);

        return authenticationConverter;
    };

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    };

    @Bean
    public JwtProvider jwtProvider() {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return new JwtProvider(issuer, expiration, zoneId, algorithm);
    };
};
