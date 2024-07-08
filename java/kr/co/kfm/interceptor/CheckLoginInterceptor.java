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

	// �̺�Ʈ�� �߻��Ǹ� �α��� �� ����ϼ���... �������� �̵�
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// �α����� ���� �ʾҴٸ�
		if (!loginUserBean.isUserLogin()) {
			String contextPath = request.getContextPath();

			// �α����� �Ǿ� ���� ������ ������������ not_login�� ��û�ϵ��� ������
			response.sendRedirect(contextPath + "/user/not_login");
			return false;
		}

		return true;
	}

}
