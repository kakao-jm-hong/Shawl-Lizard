package com.lizard.framework.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable() // CSRF 보호 비활성화
        .authorizeRequests()
        .antMatchers("/**").permitAll() // 특정 경로는 인증하지 않음
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .permitAll()
        .and()
        .logout()
        .permitAll();
  }
}
