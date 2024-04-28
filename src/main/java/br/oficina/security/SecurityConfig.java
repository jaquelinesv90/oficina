package br.oficina.security;

import org.springframework.context.annotation.Configuration;


//@EnableWebSecurity
@Configuration
public class SecurityConfig {
	/**
	@Bean
	public InMemoryUserDetailsManager configure() throws Exception{
		UserDetails leonildo = User.withUsername("leonildo")
								.password(cifrador().encode("test123"))
								.roles("user")
								.build();
		
		UserDetails jeferson = User.withUsername("jeferson")
								.password(cifrador().encode("test123"))
								.roles("user")
								.build();
		
		UserDetails admin = User.withUsername("administrador")
								.password(cifrador().encode("test123"))
								.roles("admin")
								.build(); 
		
		return new InMemoryUserDetailsManager(leonildo,jeferson, admin);
	}
	
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception{
		http.csrf()
        .disable()
        .authorizeRequests()
        .requestMatchers("/**")
        .hasRole("ADMIN")
        .requestMatchers("/anonymous*")
        .anonymous()
        .requestMatchers("/login*")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/login")
        .defaultSuccessUrl("/index", true)
        .and()
        .logout()
        .deleteCookies("JSESSIONID");
        return http.build();
	}
	
	@Bean
	public PasswordEncoder cifrador() {
		return new BCryptPasswordEncoder();
	} **/
}
