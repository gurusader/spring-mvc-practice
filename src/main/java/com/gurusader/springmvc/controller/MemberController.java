package com.gurusader.springmvc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gurusader.springmvc.domain.LoginDto;
import com.gurusader.springmvc.domain.MemberVo;
import com.gurusader.springmvc.service.MemberService;

@Controller
@RequestMapping(value = "member/")
public class MemberController {
	@Inject
	private MemberService memberService;

	@RequestMapping(value = "showLoginForm", method = RequestMethod.GET)
	public String showLoginForm() {
		return "member/login-form";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public void login(LoginDto loginDto, Model model) {
		MemberVo memberVo = memberService.login(loginDto);

		if (memberVo != null) {
			model.addAttribute("memberVo", memberVo);
		}
	}
}
