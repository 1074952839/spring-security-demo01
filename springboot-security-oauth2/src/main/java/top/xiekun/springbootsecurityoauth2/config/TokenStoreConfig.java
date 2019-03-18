//package top.xiekun.springbootsecurityoauth2.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
//
///**
// * Created by xk on 2018/11/28
// */
//@Configuration
//public class TokenStoreConfig {
//        @Autowired
//        private RedisConnectionFactory redisConnectionFactory;
//
//        @Bean
//        public TokenStore tokenStore(){
//                return new RedisTokenStore(redisConnectionFactory);
//        }
//}//todo 开启该配置你会发现我们的token会存在redis里，因为，我的application.yml文件已经配置Redis数据源了，
// todo 而且pom文件也引入了Redis依赖了。这样我们每次启动服务时，就不会每次更换token（Redis的token不能过期）
