package br.com.casadocodigo.loja.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.casadocodigo.loja.daos.UserDao;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDao userDao;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/products/form**")
					.hasRole("ADMIN")
				.antMatchers("/shopping/**")
					.permitAll()
				.antMatchers(HttpMethod.POST, "/products**")
					.hasRole("ADMIN")
				.antMatchers("/products/**")
					.permitAll()
				.anyRequest()
					.authenticated()
			.and()
			.formLogin();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
				.antMatchers("/resources/**");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDao).passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
