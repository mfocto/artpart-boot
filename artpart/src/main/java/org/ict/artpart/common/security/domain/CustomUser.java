package org.ict.artpart.common.security.domain;


import org.ict.artpart.member.entity.MemberEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Collections;

public class CustomUser extends User {

	private static final long serialVersionUID = 1L;
	private MemberEntity member;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(MemberEntity member) {
		super(member.getMemberId(), member.getMemberPassword(), Collections.singletonList(new SimpleGrantedAuthority(member.getMemberAuth())));
		this.member = member;
	}

	public CustomUser(MemberEntity member, Collection<? extends GrantedAuthority> authorities) {
		super(member.getMemberId(), member.getMemberPassword(), Collections.singletonList(new SimpleGrantedAuthority(member.getMemberAuth())));
		this.member = member;
	}

	public long getMemberIdx() {
		return member.getMemberIdx();
	}

	public String getMemberId() {
		return member.getMemberId();
	}

}
