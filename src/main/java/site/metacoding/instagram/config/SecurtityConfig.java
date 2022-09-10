package site.metacoding.instagram.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 해당 파일로 시큐리티를 활성화
@Configuration // IoC
public class SecurtityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super 삭제 - 기존 시큐리티가 가지고 있는 기능이 다 비활성화됨
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**")
                .authenticated() // 로그인 페이지로 보낸다.
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/auth/signin")
                .defaultSuccessUrl("/"); // 로그인이 성공적이었을 경우
    }
}
