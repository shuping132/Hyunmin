package kr.co.kfm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.kfm.beans.UserBean;

public class MenuInterceptor implements HandlerInterceptor{

	private UserBean loginUserBean;
	
	public MenuInterceptor(UserBean loginUserBean) {
		this.loginUserBean = loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception{
		request.setAttribute("loginUserBean", loginUserBean);
		return true;
		
		
	}
	
}
	
