package org.ict.artpartM.common.security.domain;


import org.ict.artpartM.emp.entity.EmpEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Collections;

public class CustomUser extends User {

	private static final long serialVersionUID = 1L;
	private EmpEntity emp;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(EmpEntity emp) {
		super(emp.getEmpId(), emp.getEmpPwd(), Collections.singletonList(new SimpleGrantedAuthority(emp.getEmpAuth())));
		this.emp = emp;
	}

	public CustomUser(EmpEntity emp, Collection<? extends GrantedAuthority> authorities) {
		super(emp.getEmpId(), emp.getEmpPwd(), Collections.singletonList(new SimpleGrantedAuthority(emp.getEmpAuth())));
		this.emp = emp;
	}

	public long getEmpIdx() {
		return emp.getEmpIdx();
	}

	public String getEmpId() {
		return emp.getEmpId();
	}

}
