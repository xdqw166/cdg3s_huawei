package dynastxu.cdg3s_huawei.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置 Spring Security 过滤器链。
     *
     * @param http HttpSecurity 配置对象
     * @return 构建好的 SecurityFilterChain
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http
                // 配置URL访问权限
                .authorizeHttpRequests(auth -> auth
                        // 允许匿名访问的接口
                        .requestMatchers(
                                "/user/register",
                                "/user/login",
                                "/category/**",
                                "/goods/**",
                                "/goodsImage/**",
                                "/goodsTag/**"
                        ).permitAll()
                        // 其他所有请求都需要认证
                        .anyRequest().authenticated()
                )
                // 禁用 CSRF 保护（适用于无状态 REST API）
                .csrf(AbstractHttpConfigurer::disable)
                // 禁用表单登录（使用自定义认证逻辑）
                .formLogin(AbstractHttpConfigurer::disable)
                // 禁用 HTTP Basic 认证
                .httpBasic(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
