package com.gurusader.springmvc.persistence;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gurusader.springmvc.domain.LoginDto;
import com.gurusader.springmvc.domain.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MemberDaoTest {
	@Inject
	private MemberDao memberDao;

	@Test
	public void testLogin() {
		LoginDto loginDto = new LoginDto();
		loginDto.setMemberId("a");
		loginDto.setMemberPassword("a");

		MemberVo memberVo = memberDao.login(loginDto);
		System.out.println(memberVo);
	}
}
