package org.ict.artpartM.common.security;


import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.security.domain.CustomUser;
import org.ict.artpartM.emp.entity.EmpEntity;
import org.ict.artpartM.emp.entity.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private EmpRepository repository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		EmpEntity emp = repository.findByEmpId(userName.trim());

		return emp == null ? null : new CustomUser(emp);
	}
	
}
