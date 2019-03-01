package top.xiekun.springbootsecurityoauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by xk on 2018/11/26
 */
@Component
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Bean
        private PasswordEncoder passwordEncoder(){
                return new BCryptPasswordEncoder();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http.formLogin()
                        .and()
                        .authorizeRequests()
                        .antMatchers("/user/register").permitAll()//这里我们允许/user/register请求可以直接访问，
                        .anyRequest()
                        .authenticated();
        }
}
