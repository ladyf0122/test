package cn.ladyf.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.ladyf.domain.Employee;

//��װ��ǰ��½�û�����������Ϣ
public class UserContext {
	
	private static final String USER_IN_SESSION = "user_in_session";

	public static HttpSession getSession() {
		return ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
	}
	
	public static void setCurrentUser(Employee current) {
		if(current == null) {
			getSession().invalidate();
		}else {
			getSession().setAttribute(USER_IN_SESSION, current);
		}
	}
	
	public static Employee getCurrentUser() {
		return (Employee) getSession().getAttribute(USER_IN_SESSION);
	}
}
