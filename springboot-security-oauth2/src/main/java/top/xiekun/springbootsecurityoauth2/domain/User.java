package top.xiekun.springbootsecurityoauth2.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by xk on 2018/11/26
 */
@Entity
@Table(name = "user")
@Data
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String password;
}
