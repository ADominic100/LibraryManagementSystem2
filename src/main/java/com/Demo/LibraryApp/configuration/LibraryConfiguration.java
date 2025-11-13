/*
 * package com.Demo.LibraryApp.configuration;
 * 
 * 
 * import
 * org.springframework.boot.autoconfigure.security.SecurityProperties.User;
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.provisioning.InMemoryUserDetailsManager;
 * 
 * @Configuration public class LibraryConfiguration {
 * 
 * @Bean public InMemoryUserDetailsManager userDetailsManager() { UserDetails
 * admin =
 * org.springframework.security.core.userdetails.User.builder().username(
 * "admin") .password("{noop}admin") .roles("ADMIN").build(); return new
 * InMemoryUserDetailsManager(admin); }
 * 
 * }
 * 
 * 
 */