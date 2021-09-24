package com.riawolf.Todospringspeedrun8.SecurityConfiguration;

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


//                .dataSource(dataSource)
////                .usersByUsernameQuery("select username, pasword, enabled from Users where username = ?")
////                .authoritiesByUsernameQuery("select username, role from Users where username = ?");
//                .usersByUsernameQuery("select username ,pasword ,enabled "
//                        + "from Users "
//                        + "where username = ?")
//                .authoritiesByUsernameQuery("select username, role "
//                        + "from Users "
//                        + "where username = ?");

//                Out of the box spring security using defaultSchema can create and authenticate users
//                example below
//                .withDefaultSchema()
//                .withUser(
//                        User.withUsername("superAdmin")
//                                .password("superAdmin")
//                                .roles("superAdmin")
//                )
//                .withUser(
//                        User.withUsername("admin")
//                                .password("admin")
//                                .roles("admin")
//                )
//                .withUser(
//                        User.withUsername("user")
//                                .password("user")
//                                .roles("user")
//                );
    }

//                In memory authentication
//        auth.inMemoryAuthentication()
//                .withUser("superAdmin")
//                .password("superAdmin")
//                .roles("superAdmin")
////                .and to specify additional roles and authentication
//                .and()
//                .withUser("admin")
//                .password("admin")
//                .roles("admin")
//                .and()
//                .withUser("user")
//                .password("user")
//                .roles("user");
//
//    }
//
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                from most restrictive to the least restrictive
                .antMatchers("/superadmin").hasAuthority("SUPERADMIN")

//                .has role specifies who can access data, .hasAnyRole to specifies multiple roles
//                .antMatchers specifies path
//                .formLogin default configuration when adding spring security
                .antMatchers("/admin").hasAnyAuthority("SUPERADMIN", "ADMIN")
                .antMatchers("/user").hasAnyAuthority("ADMIN", "SUPERADMIN","USER")

                .and()
                .formLogin();

    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .logout().permitAll();
//    }



}


