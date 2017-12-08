package com.hs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hs.entity.SmbmsUser;

public class UserInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		String url = request.getRequestURI();
		String actionName = url.substring(url.lastIndexOf("/")+1);
		SmbmsUser user = (SmbmsUser) request.getSession().getAttribute("userSession");
		if(user == null && !"login.do".equals(actionName) && !"register.do".equals(actionName)){
			response.sendRedirect(request.getContextPath()+"/error.jsp");
			return false;
		}
		return true;
	}
}
