package br.com.spot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.com.spot.security.JWTAuthenticationFilter;
import br.com.spot.security.JWTAuthorizationFilter;
import br.com.spot.security.JWTUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	UserDetailsService userDetailService;	
	
	@Autowired
	JWTUtil jwtUtil;
	
	private static final String[] ADMIN_MATCHERS = {
		"/user/teste"	
	};
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		
		http.cors().and().csrf().disable();
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET ,ADMIN_MATCHERS).hasAnyRole("ADMIN")
			.anyRequest().permitAll();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilter(new JWTAuthenticationFilter(this.authenticationManager(http.getSharedObject(AuthenticationConfiguration.class)),jwtUtil));
		http.addFilter(new JWTAuthorizationFilter(this.authenticationManager(http.getSharedObject(AuthenticationConfiguration.class)), jwtUtil, userDetailService));		
		return http.build();
	
	}
	
	@Bean // METODO DIFERENTE DO TUTORIAL. SE DER ERRO, OLHAR AQUI 
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
