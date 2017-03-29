package com.gurusader.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorityInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean goNext = true;

		HttpSession session = request.getSession();

		if (session.getAttribute("loginMember") == null) {
			response.sendRedirect(request.getContextPath() + "/member/showLoginForm");
			goNext = false;
		}

		return goNext;
	}
}
