package cn.ladyf.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import cn.ladyf.util.UserContext;

//��½������
public class CheckLoginInterceptor implements HandlerInterceptor{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//û�е�½�����
		if(UserContext.getCurrentUser() == null) {
			response.sendRedirect("/login.jsp");
			return false;
		}
		return true;
	}
}
