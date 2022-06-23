package kz.arab.SingularityHackathon.demo.config;


import kz.arab.SingularityHackathon.demo.security.jwt.JwtConfigurer;
import kz.arab.SingularityHackathon.demo.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtTokenProvider jwtTokenProvider;

    private static final String ADMIN_ENDPOINT = "/api/v1/admin/**";
    private static final String LOGIN_ENDPOINT = "/api/v1/auth/login";


    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/register", "/api/v1/auth/login", "/swagger-ui/**", "/v3/api-docs/**", "/h2-console/**").permitAll()
                .antMatchers("/api/v1/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated();

        http.apply(new JwtConfigurer(jwtTokenProvider));
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.cors()
//                .and()
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/auth/*").permitAll()
//                .antMatchers("/limits/").permitAll()
//                .antMatchers("/instance/").permitAll()
//                .antMatchers("/consul/").permitAll()
//                .antMatchers("/swagger-ui/").permitAll()
//
//                .antMatchers("/swagger-resources/").permitAll()
//                .antMatchers("/v2/").permitAll()
//                .antMatchers("/report/").permitAll()
//                .antMatchers("/admin/poll/").permitAll()
//                .antMatchers("/v3/").permitAll()
//                .antMatchers("/docs/").permitAll()
//                .antMatchers("/error").permitAll()
//                .anyRequest().authenticated();
//
//        http.exceptionHandling().accessDeniedHandler(
//                (request, response, accessDeniedException) -> response.setStatus(HttpServletResponse.SC_UNAUTHORIZED)
//        );
//
//        http.apply(tokenFilterConfigurer);
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger-ui/", "/v3/api-docs/", "/h2-console/**");
    }
}
