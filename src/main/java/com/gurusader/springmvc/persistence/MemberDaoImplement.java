package com.gurusader.springmvc.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.gurusader.springmvc.domain.LoginDto;
import com.gurusader.springmvc.domain.MemberVo;

@Repository
public class MemberDaoImplement implements MemberDao {
	@Value("#{mybatis['namespace.base']}" + "#{mybatis['namespace.member']}")
	private String namespace;

	@Inject
	private SqlSession sqlSession;

	@Override
	public MemberVo login(LoginDto loginDto) {
		return sqlSession.selectOne(namespace + ".login", loginDto);
	}
}
