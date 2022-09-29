package com.amir.system.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled from users WHERE username= ?")
                .authoritiesByUsernameQuery("SELECT username, authorityType from authorities where username = ?")
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/user/register" , "/loginProcess" );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/**").access("hasRole('USER')")
//                .antMatchers("/customer/**").access("hasRole('USER')")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
                .formLogin().loginPage("/showMyLoginPage")
                .successHandler(savedRequestAwareAuthenticationSuccessHandler())
                .loginProcessingUrl("/authenticateTheUser")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/suc")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied")
               .and()
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .rememberMe().key("remember-me").rememberMeParameter("remember-me").rememberMeCookieName("remember-me").tokenRepository(persistentTokenRepository()).tokenValiditySeconds(1209600);


    }

    public PersistentTokenRepository persistentTokenRepository(){

        JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl=new JdbcTokenRepositoryImpl();
        jdbcTokenRepositoryImpl.setDataSource(dataSource);
        return jdbcTokenRepositoryImpl;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler() {
        return new SavedRequestAwareAuthenticationSuccessHandler();
    }



//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("SELECT username, password, enabled from users WHERE username= ?")
//                .authoritiesByUsernameQuery("SELECT username, authorityType from authorities where username = ?")
//                .passwordEncoder(passwordEncoder());
//    }
//
////    @Override
////    public void configure(WebSecurity web) throws Exception {
////        web.ignoring().antMatchers("/**");
////    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
////                .antMatchers("/admin/**").access("hasRole('ADMIN')")
////                .antMatchers("/customer/**").access("hasRole('USER')")
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .logout().logoutSuccessUrl("/showMyLoginPage?logout").permitAll()
//                .and()
//                .formLogin().loginPage("/showMyLoginPage")
//                .successHandler(savedRequestAwareAuthenticationSuccessHandler())
//                .loginProcessingUrl("/authenticateTheUser")
//                .failureUrl("/login?error")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/").permitAll()
//                .and()
//                .exceptionHandling().accessDeniedPage("/access-denied")
//                .and()
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
//                .rememberMe()
//                .key("remember-me").rememberMeParameter("remember-me").rememberMeCookieName("remember-me")
//                .tokenRepository(persistentTokenRepository()).tokenValiditySeconds(1209600);
//
////        http.authorizeRequests()
////
////
////                //if you use this line any request can access every thing:
////                .anyRequest().authenticated()
////
////                //if you use this , you can give access to each role:
//////                .antMatchers("/").hasRole("EMPLOYEE")
//////                .antMatchers("/leaders/**").hasRole("MANAGER")
//////                .antMatchers("/systems/**").hasRole("ADMIN")
////                .and()
////                .formLogin()
////                .loginPage("/showMyLoginPage")
////                .loginProcessingUrl("/authenticateTheUser")
////                .permitAll()
////                .and()
////                .logout()
////                .permitAll()
////
////                //add exception handling for access denied :
////                .and()
////                .exceptionHandling().accessDeniedPage("/access-denied");
//    }
//
//    public PersistentTokenRepository persistentTokenRepository() {
//
//        JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl = new JdbcTokenRepositoryImpl();
//        jdbcTokenRepositoryImpl.setDataSource(dataSource);
//        return jdbcTokenRepositoryImpl;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Bean
//    public SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler() {
//        return new SavedRequestAwareAuthenticationSuccessHandler();
//    }
//
//



}
