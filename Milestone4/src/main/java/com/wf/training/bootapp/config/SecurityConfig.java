package com.wf.training.bootapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// 3 configuration method
	
	// define the credentials
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder builder = User.withDefaultPasswordEncoder(); 
		auth.inMemoryAuthentication()
			.withUser(builder.username("admin").password("admin").roles("ADMIN"))
			.withUser(builder.username("back1").password("back1").roles("BACK"))
			.withUser(builder.username("inv1").password("inv1").roles("INVESTOR"));
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/backofficerep/**").hasRole("BACK")
			.antMatchers("/investor/**").hasRole("INVESTOR")
			//.anyRequest()
			//.authenticated()
		.and()
			.formLogin()
			.loginPage("/security-login")
			.loginProcessingUrl("/validate")
			.permitAll()
		.and()
			.logout().permitAll()
		.and()
			.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}
}
