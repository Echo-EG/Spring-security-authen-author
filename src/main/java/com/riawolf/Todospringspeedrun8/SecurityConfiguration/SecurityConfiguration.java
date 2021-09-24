package com.riawolf.Todospringspeedrun8.SecurityConfiguration;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    UserDetailsService userDetailsService;


    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService);

    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/superadmin/**").hasAuthority("SUPERADMIN")
                .antMatchers("/admin/**").hasAnyAuthority("SUPERADMIN", "ADMIN")
                .antMatchers("/user/**").hasAnyAuthority("ADMIN", "SUPERADMIN","USER")
                .and().formLogin();

    }

}

//            auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery("select username, pasword, enabled from Users where username = ?")
//                .authoritiesByUsernameQuery("select username, role from Users where username = ?");


//                .dataSource(dataSource)
////                .usersByUsernameQuery("select username, pasword, enabled from Users where username = ?")
////                .authoritiesByUsernameQuery("select username, role from Users where username = ?");
//                .usersByUsernameQuery("select username ,pasword ,enabled "
//                        + "from Users "
//                        + "where username = ?")
//                .authoritiesByUsernameQuery("select username, role "
//                        + "from Users "
//                        + "where username = ?");

