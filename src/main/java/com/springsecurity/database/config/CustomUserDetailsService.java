package com.springsecurity.database.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.springsecurity.database.entity.Employee;
import com.springsecurity.database.repository.EmpRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private EmpRepository empRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Employee emp = empRepo.findByEmail(email);
		
		if(emp == null) {
			
			throw new UsernameNotFoundException("user not found") ;
		}else {
			
			return new CustomUser(emp);
		}
	}
}
