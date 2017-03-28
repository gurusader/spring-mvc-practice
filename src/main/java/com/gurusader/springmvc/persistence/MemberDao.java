package com.gurusader.springmvc.persistence;

import com.gurusader.springmvc.domain.LoginDto;
import com.gurusader.springmvc.domain.MemberVo;

public interface MemberDao {
	MemberVo login(LoginDto loginDto);
}
