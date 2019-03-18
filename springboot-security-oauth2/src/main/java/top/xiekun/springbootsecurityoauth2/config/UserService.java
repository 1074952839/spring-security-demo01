package top.xiekun.springbootsecurityoauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import top.xiekun.springbootsecurityoauth2.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by xk on 2018/11/26
 */
@Component
public class UserService implements UserDetailsService {
        @Autowired
        private UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
                top.xiekun.springbootsecurityoauth2.domain.User user = userRepository.findByName(name);
                if (user != null) {
                        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                        if ("xiekun".equals(user.getName())) {
                                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_admin"));
                        }
                        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_normal"));
                        return new User(user.getName(), user.getPassword(), grantedAuthorities);
                }
                return null;
        }
}
