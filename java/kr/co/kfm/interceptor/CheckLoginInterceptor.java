package kr.co.kfm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.kfm.beans.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor {

	private UserBean loginUserBean;

	// DI
	public CheckLoginInterceptor(UserBean loginUserBean) {
		this.loginUserBean = loginUserBean;
	}

	// 이벤트가 발생되면 로그인 후 사용하세요... 페이지로 이동
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 로그인을 하지 않았다면
		if (!loginUserBean.isUserLogin()) {
			String contextPath = request.getContextPath();

			// 로그인이 되어 있지 않으니 웹브라우져에게 not_login을 요청하도록 지시함
			response.sendRedirect(contextPath + "/user/not_login");
			return false;
		}

		return true;
	}

}
