package top.xiekun.springbootsecurityoauth2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xiekun.springbootsecurityoauth2.domain.User;
import top.xiekun.springbootsecurityoauth2.repository.UserRepository;
import top.xiekun.springbootsecurityoauth2.utils.ResponseData;

import java.util.List;

/**
 * Created by xk on 2018/11/26
 */
@RestController
@RequestMapping("/user")
public class UserController {
        @Autowired
        private UserRepository userRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @GetMapping
        @PreAuthorize("hasRole('admin')")
        public List<User> get(){
                return userRepository.findAll();
        }

        @GetMapping("/register")
        public ResponseEntity<ResponseData> insert(User user){
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return ResponseEntity.ok(new ResponseData(userRepository.save(user)));
        }
}
