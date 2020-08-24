/*
 * package com.magichour.configuration;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import
 * org.springframework.security.config.annotation.web.builders.WebSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.web.util.matcher.AntPathRequestMatcher;
 * 
 * import com.magichour.service.LoginService;
 * 
 * import io.jsonwebtoken.Jwts; import lombok.AllArgsConstructor;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity
 * 
 * @AllArgsConstructor public class SecurityConfig extends
 * WebSecurityConfigurerAdapter{
 * 
 * private LoginService loginService;
 * 
 * @Bean public PasswordEncoder passwordEncoder() throws Exception{ return new
 * BCryptPasswordEncoder(); }
 * 
 * @Override public void configure(WebSecurity web) throws Exception {
 * web.ignoring().antMatchers("/css/**","/img/**","/js/**"); }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.authorizeRequests() .antMatchers("/api/calendar/**").hasRole("MEMBER")
 * .antMatchers("/api/board/**").hasRole("MEMEBER")
 * .antMatchers("/**").permitAll() .and() .formLogin() .loginPage("/login")
 * .loginProcessingUrl("/api/user/login")
 * .defaultSuccessUrl("/api/user/login/result") .permitAll() .and() .logout()
 * .logoutRequestMatcher(new AntPathRequestMatcher("/api/user/logout"))
 * .logoutSuccessUrl("/") .invalidateHttpSession(true) .and()
 * .exceptionHandling().accessDeniedPage("/"); }
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception {
 * auth.userDetailsService(loginService).passwordEncoder(passwordEncoder()); }
 * 
 * }
 */