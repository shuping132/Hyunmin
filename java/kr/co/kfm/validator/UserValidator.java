package kr.co.kfm.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.kfm.beans.UserBean;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserBean userBean = (UserBean) target; // Casting
		// 어떤 객체가 유효성 검사인지 반환해주는 메서드
		String beanName = errors.getObjectName();
		System.out.println(beanName); // joinUserBean

		if (beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) {
			if (userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
				errors.rejectValue("user_pw", "NotEquals");
				errors.rejectValue("user_pw2", "NotEquals");
			}
			if (beanName.equals("joinUserBean")) {
				// 중복성 체크
				if (!userBean.isUserIdExist()) {
					errors.rejectValue("user_id", "DontCheckUserIdExist");
				}
			}
		}
	}
}
