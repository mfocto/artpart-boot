package org.ict.artpart.common.security;


import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.member.entity.MemberEntity;
import org.ict.artpart.member.entity.MemberRepository;
import org.ict.artpart.common.security.domain.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberRepository repository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		MemberEntity member = repository.findByMemberId(userName.trim());

		return member == null ? null :(member.getMemberLoginOK().equals("N") ? null : new CustomUser(member));
	}
	
}
