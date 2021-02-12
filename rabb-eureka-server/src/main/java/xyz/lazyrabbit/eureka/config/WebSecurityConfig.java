package xyz.lazyrabbit.eureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 默认情况下添加SpringSecurity依赖的应用每个请求都需要添加CSRF token才能访问，
        // Eureka客户端注册时并不会添加，所以需要配置/eureka/**路径不需要CSRF token。
        http.csrf().ignoringAntMatchers("/eureka/**");
        // 注册时关闭用户认证
        http.authorizeRequests().antMatchers("/**").permitAll();
//        http.authorizeRequests().antMatchers("/eureka/**").permitAll();
        super.configure(http);
    }
}