package com.example.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth ) throws Exception {
		auth.jdbcAuthentication()
		.usersByUsernameQuery("select username, password, enabled "+
					"from user_accounts where username = ?" )
		.authoritiesByUsernameQuery("select username, role "+
					"from user_accounts where username = ?")
		.dataSource(dataSource)
		.passwordEncoder(bCryptEncoder);
			
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.authorizeRequests()
//			.antMatchers("/projects/new").hasRole("ADMIN")
//			.antMatchers("/projects/save").hasRole("ADMIN")
//			.antMatchers("/employees/new").hasRole("ADMIN")
//			.antMatchers("/employees/save").hasRole("ADMIN")
			.antMatchers("/", "/**").permitAll()
			.and()
			.formLogin();
		
		http.csrf().disable();
		
	}
//	public InMemoryUserDetailsManager userDetailManager() {
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.build();
//		
//		
//		UserDetails admin = User.withDefaultPasswordEncoder()
//				.username("admin")
//				.password("password")
//				.roles("ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user,admin);
//	}
//	
//	@Bean
//	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//		
//		return http
//				.csrf(csrf -> csrf.disable())
//				.authorizeRequests(auth -> {
//					auth.requestMatchers("/").permitAll();
//					auth.requestMatchers("/user").hasRole("USER");
//					auth.requestMatchers("admin").hasRole("ADMIN");
//				})
//				.httpBasic(Customizer.withDefaults())
//				.build();
//		
//	}
}
