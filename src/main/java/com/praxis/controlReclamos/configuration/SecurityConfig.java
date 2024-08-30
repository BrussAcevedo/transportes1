package com.praxis.controlReclamos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.praxis.controlReclamos.entity.RolEnum;

import jakarta.annotation.security.PermitAll;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		
		return httpSecurity
		        .formLogin(form -> form
		                .loginPage("/login")
		                .defaultSuccessUrl("/", true)
		                .permitAll()
		            )
		            .authorizeHttpRequests(authorize -> authorize
		                .requestMatchers("/").permitAll() 
		                .requestMatchers("/loginRegister").anonymous()
		                .requestMatchers("/register").anonymous()  
		                .requestMatchers("/perfil").hasAnyAuthority("READ", "ADMIN")
		                .requestMatchers("/adminView").hasAnyAuthority("CREATE") 
		                .anyRequest().authenticated()
		            )
		            .logout(logout -> logout
		            		.logoutSuccessUrl("/")
		                .permitAll()
		            )
		            .build();
	}


    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration anthenticationConfiguration) throws Exception{   	
    	
		return anthenticationConfiguration.getAuthenticationManager();
		
	}	
	
	
	@Bean
	AuthenticationProvider authenticationProvider(UserDetailsServiceImp userDetailsService) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		
		return provider;
	}
	
	
	
	@Bean
	PasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
}
