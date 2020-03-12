package edu.miu.carRental.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import edu.miu.carRental.repository.UserRepository;
import edu.miu.carRental.serviceImp.CarRentalUserDetailsService;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class CarRentalWebSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private CarRentalUserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder()) ;
	}

	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
			.csrf().disable()//disable the default login page
			.authorizeRequests()
			.antMatchers("/home/*","/","/js/*","/css/*").permitAll()//such request is public
			.antMatchers("/admin/**","/employee/**").authenticated()//such request must be authenticated
			.anyRequest().permitAll()
		.and()
			.formLogin()
			//.loginPage("/login")//your login page url
			.permitAll()
		.and()
			.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/logout-success")//url after logout successfully
			.permitAll();
	
	
	
	}

	
	private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
//	private PasswordEncoder passwordEncoder() {
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return charSequence.toString();
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                return true;
//            }
//        };
//    }

}
