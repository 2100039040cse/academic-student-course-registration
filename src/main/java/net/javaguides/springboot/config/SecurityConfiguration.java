//package net.javaguides.springboot.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//
//
//import net.javaguides.springboot.service.UserService;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private UserService userService;
//	
//	@Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//	
//	@Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService(userService);
//        auth.setPasswordEncoder(passwordEncoder());
//        return auth;
//    }
//	
//	@Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers(
//				 "/registration**",
//	                "/js/**",
//	                "/css/**",
//	                "/img/**",
//	                "/change_password"
//	                ).permitAll()
//		.antMatchers("/admin_home", "/admin_course/delete").hasRole("ADMIN")
//		 
//		.anyRequest().authenticated()
//		.and()
//		.formLogin()
//		.loginPage("/login")
//		.successHandler(loginSuccessHandler())
//		.permitAll()
//		.and()
//		.logout()
//		.invalidateHttpSession(true)
//		.clearAuthentication(true)
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//		.logoutSuccessUrl("/login?logout")
//		.permitAll();
//	}
//	@Bean
//    public AuthenticationSuccessHandler loginSuccessHandler() {
//		return new SimpleUrlAuthenticationSuccessHandler() {
//	        @Override
//	        protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
//	            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//	            if (userDetails.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"))) {
//	                return "/admin_home";
//	            } else {
//	                return "/student_home";
//	            }
//	        }
//	    };
//    }
//
//}
package net.javaguides.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;


import net.javaguides.springboot.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
				 "/registration**",
	                "/js/**",
	                "/css/**",
	                "/img/**",
	                "/change_password",
	                "/student_request"
	   ).permitAll()
		.antMatchers("/admin_home", "/admin_course/delete").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.successHandler(loginSuccessHandler())
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll();
	}
	@Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
		return new SimpleUrlAuthenticationSuccessHandler() {
	        @Override
	        protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
	            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	            if (userDetails.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"))) {
	                return "/admin_home";
	            } else {
	                return "/student_home";
	            }
	        }
	    };
    }

}
