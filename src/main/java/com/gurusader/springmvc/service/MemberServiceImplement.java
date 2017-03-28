package com.gurusader.springmvc.service;

import javax.inject.Inject;

import com.gurusader.springmvc.domain.LoginDto;
import com.gurusader.springmvc.domain.MemberVo;
import com.gurusader.springmvc.persistence.MemberDao;

public class MemberServiceImplement implements MemberService {
	@Inject
	private MemberDao memberDao;

	@Override
	public MemberVo login(LoginDto loginDto) {
		return memberDao.login(loginDto);
	}

}
