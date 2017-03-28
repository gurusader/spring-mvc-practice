package com.gurusader.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();

		if (session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		Object memberVo = modelAndView.getModel().get("memberVo");

		if (memberVo != null) {
			request.getSession().setAttribute("login", memberVo);
			modelAndView.setViewName("redirect:/");
		} else {
			modelAndView.setViewName("redirect:/member/showLoginForm");
		}
	}
}
