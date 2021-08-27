package hr.tvz.zdelarec.escapecroatioaservices.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * Configures Spring Security and defines security related beans.
 *
 * @author kristijan.zdelarec
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Autowired data source.
     */
    @Autowired
    DataSource dataSource;

    /**
     * Project security configuration.
     * @param http {@link HttpSecurity}
     * @throws Exception exception
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/login", "/api/**");
        http.headers().frameOptions().sameOrigin();
        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .mvcMatchers("/login*", "/api/**", "/assets/**", "/error").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard", true)
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);
    }

    /**
     * Configuration for authentication.
     * @param auth {@link AuthenticationManagerBuilder}
     * @throws Exception
     */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder());
    }

    /**
     * Configuration for web security.
     * @param web {@link WebSecurity}
     */
    @Override
    public void configure(final WebSecurity web) {
        web.ignoring().antMatchers("/static/**");
    }

    /**
     * Password encoder.
     * @return {@link BCryptPasswordEncoder}
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
