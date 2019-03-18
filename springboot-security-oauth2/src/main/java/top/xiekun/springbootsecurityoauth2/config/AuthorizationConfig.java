package top.xiekun.springbootsecurityoauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * Created by xk on 2018/11/28
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private UserService userService;

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints)
                throws Exception {
                endpoints.authenticationManager(authenticationManager)
                        .userDetailsService(userService);
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
                clients.inMemory().withClient("app")
                        .secret(passwordEncoder.encode("app"))
                        //.authorizedGrantTypes("password","refresh_token")
                        .authorizedGrantTypes("password")
                        .scopes("all")
                        .accessTokenValiditySeconds(120)
                        .and()
                        .withClient("web")
                        .secret(passwordEncoder.encode("web"))
                        .authorizedGrantTypes("password","refresh_token")
                        //.authorizedGrantTypes("password")
                        .scopes("all")
                        .accessTokenValiditySeconds(3600);
        }
}
