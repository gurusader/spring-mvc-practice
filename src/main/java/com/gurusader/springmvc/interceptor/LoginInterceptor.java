package com.gurusader.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		Object memberVo = modelAndView.getModel().get("memberVo");

		if (memberVo != null) {
			request.getSession().setAttribute("loginMember", memberVo);
			modelAndView.setViewName("redirect:/");
		} else {
			modelAndView.setViewName("redirect:/member/showLoginForm");
		}
	}
}
