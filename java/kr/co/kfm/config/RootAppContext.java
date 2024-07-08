package kr.co.kfm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.kfm.beans.UserBean;

// ������Ʈ �۾��� ����� �Ϲ� bean�� �����ϴ� Ŭ����
@Configuration
public class RootAppContext {

	// UserBean loginUserBean = new UserBean();
	@Bean("loginUserBean")
	@SessionScope
	public UserBean loginUserBean() {
		return new UserBean();
	}
}
