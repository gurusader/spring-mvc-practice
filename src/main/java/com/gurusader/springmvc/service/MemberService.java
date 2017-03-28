package com.gurusader.springmvc.service;

import com.gurusader.springmvc.domain.LoginDto;
import com.gurusader.springmvc.domain.MemberVo;

public interface MemberService {
	MemberVo login(LoginDto loginDto);
}
