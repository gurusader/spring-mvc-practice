package com.gurusader.springmvc.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gurusader.springmvc.domain.LoginDto;
import com.gurusader.springmvc.domain.MemberVo;
import com.gurusader.springmvc.persistence.MemberDao;

@Service
public class MemberServiceImplement implements MemberService {
	@Inject
	private MemberDao memberDao;

	@Override
	public MemberVo login(LoginDto loginDto) {
		return memberDao.login(loginDto);
	}
}
