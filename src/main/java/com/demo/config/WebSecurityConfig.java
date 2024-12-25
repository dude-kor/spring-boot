package com.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http.csrf(AbstractHttpConfigurer::disable)
        .formLogin(formLogin -> formLogin.usernameParameter("username")
            .passwordParameter("password").loginPage("/login").loginProcessingUrl("/login-process")
            .defaultSuccessUrl("/main", true).failureUrl("/login-fail"))
        .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
            // 특정 권한을 소유하고 있는 사용자
            // .requestMatchers(AntPathRequestMatcher.antMatcher("/auth/**")).authenticated()
            // ADMIN 권한을 소유하고 있는 사용자
            // .requestMatchers("/controller/**").hasAnyRole("ADMIN").anyRequest().permitAll())
            .anyRequest().permitAll())
        // https://velog.io/@kide77/Spring-Boot-3.x-Security-기본-설정-및-변화
        .headers(headersConfigurer -> headersConfigurer
            .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
        .build();
  }

  public UserDetailsService userDetailsService() {
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

    manager.createUser(User.withUsername("user").password("1234").roles("USER").build());
    manager.createUser(User.withUsername("admin").password("1234").roles("ADMIN").build());
    return manager;
  }

  /**
   * https://kedric-me.tistory.com/entry/Spring-Password-Encoder-비밀번호-암호화
   * 
   * @return
   */
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

}
