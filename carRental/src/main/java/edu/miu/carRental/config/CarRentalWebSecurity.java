package edu.miu.carRental.config;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class CarRentalWebSecurity extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()//disable the default login page
//		.authorizeRequests()
//		.antMatchers("/login")//permitting unauthenticated access to /login
//		.permitAll()//any request must login
//		.anyRequest().authenticated()//any request must authenticated
//		.and()
//		.formLogin()
//		.loginPage("/login")//your login page url
//		.permitAll()
//		.and()
//		.logout()
//		.invalidateHttpSession(true)
//		.clearAuthentication(true)
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//		.logoutSuccessUrl("/logout-success")//url after logout successfully
//		.deleteCookies("JSESSIONID")
//		.permitAll()
//		.and()
//		.exceptionHandling();
//	}

	// @Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		List<UserDetails> users=new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder()
//				.username("admin")
//				.password("123")
//				.roles("Admin")
//				.build());
//		users.add(User.withDefaultPasswordEncoder()
//				.username("emp")
//				.password("123")
//				.roles("Employee")
//				.build());
//		return new InMemoryUserDetailsManager(users);
//	}
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		// to fetch data from DB
		provider.setUserDetailsService(userDetailsService);
		// passwordEncoder
		// NoOpPasswordEncoder.getInstance()--for plain text
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
