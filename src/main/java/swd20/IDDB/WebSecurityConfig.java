package swd20.IDDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import swd20.IDDB.web.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Bean
	public UserDetailsService userDetaiService() {
		return super.userDetailsService();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().antMatchers("/index","/disclist", "/discs", /*"/h2-console/**",*/ "/css/**").permitAll() //Does not need login
//			.and()
//			.csrf().ignoringAntMatchers("/h2-console/**")
//			.and()
//			.headers().frameOptions().sameOrigin()
			.and()
			.authorizeRequests().anyRequest().authenticated() //kaikki muut endpointit vaativat sisäänkirjautumisen
			.and()
		.formLogin()
			.loginPage("/login") //login page endpoint
			.defaultSuccessUrl("/index", true) //ohjaus jos login onnistunut
			.permitAll()
			.and()
		.logout()
			.logoutSuccessUrl("/index")
			.permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService).passwordEncoder(new
	BCryptPasswordEncoder());
	}
}
