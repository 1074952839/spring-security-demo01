package top.xiekun.springbootsecurityoauth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.xiekun.springbootsecurityoauth2.domain.User;

/**
 * Created by xk on 2018/11/26
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
        User findByName(String name);
}
