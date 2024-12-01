package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // 약한 결합 방식
    // http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().permitAll());

    http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
        // .requestMatchers("/controller").hasRole("user")
        // .requestMatchers("/controller").hasRole("admin")
        .anyRequest().authenticated())
        .formLogin(formLogin -> formLogin.usernameParameter("username")
            .passwordParameter("password").defaultSuccessUrl("/", true));
    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User.withUsername("user").password("1234").roles("user").build());
    return manager;
  }

  /**
   * https://kedric-me.tistory.com/entry/Spring-Password-Encoder-비밀번호-암호화
   * 
   * @return
   */
  // @Bean
  // public PasswordEncoder passwordEncoder() {
  // return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  // }
}
