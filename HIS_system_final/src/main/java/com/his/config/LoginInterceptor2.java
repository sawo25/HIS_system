package com.his.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor2 implements HandlerInterceptor{

	//controller로 진입하기 전에 실행하는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session=request.getSession();
		if(session.getAttribute("dto")==null) {// 로그인X
			System.out.println("로그인 필요");
			response.sendRedirect("/patient/mediLogin");
			return false;
		}else {
			return true;			
		}
	}
	
	
}





