package com.whpe.config;

import com.whpe.bean.dto.LoginUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("123456").roles("USER");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                if ("chengpei".equalsIgnoreCase(username)) {
                    LoginUserDTO user = new LoginUserDTO();
                    user.setUsername("chengpei");
                    user.setPassword("123456");
                    user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
                    return user;
                }
                throw new UsernameNotFoundException("用户名不存在");
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/imgs/**", "/js/**", "/login/toLogin.do").permitAll()
                .anyRequest().authenticated()

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login/toLogin.do")
                .permitAll()

                .and().httpBasic()

                .and()
                .rememberMe()

                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login/toLogin.do")
                .failureUrl("/login/toLogin.do?authentication_error=true")
                .permitAll();
    }
}
