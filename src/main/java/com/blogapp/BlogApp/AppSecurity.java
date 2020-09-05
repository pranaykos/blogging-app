package com.blogapp.BlogApp;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.blogapp.BlogApp.authService.AuthorizeUserService;
import com.blogapp.BlogApp.authority.Role;




@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthorizeUserService authUserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/user/register").permitAll()
//				.antMatchers(HttpMethod.POST, "/register").permitAll()
				.antMatchers("/", "index", "/css/*", "/js/*").permitAll()
				.antMatchers("/user/**").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
				.anyRequest()
				.authenticated()
				.and()
					.formLogin()
						.loginPage("/loginForm").permitAll()
						.loginProcessingUrl("/login")
						.defaultSuccessUrl("/", true)
					.and()
						.logout()
						.logoutUrl("/logout")
        				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
        				.clearAuthentication(true)
        				.invalidateHttpSession(false)
        				.deleteCookies("JSESSIONID")
        				.logoutSuccessUrl("/");
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = 
				new DaoAuthenticationProvider();
		provider.setUserDetailsService(authUserService);
		provider.setPasswordEncoder(getPasswordEncoder());
		return provider;
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
