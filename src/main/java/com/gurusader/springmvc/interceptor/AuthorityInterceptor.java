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

		if (session.getAttribute("login") == null) {
			response.sendRedirect(request.getContextPath());
			goNext = false;
		}

		return goNext;
	}
}
