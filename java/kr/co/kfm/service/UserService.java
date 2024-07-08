package kr.co.kfm.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kfm.beans.UserBean;
import kr.co.kfm.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	public boolean checkUserExist(String user_id) {
		String user_name = userDao.checkUserExist(user_id);
		if (user_name == null) {
			return true; // 사용가능
		}
		return false; // 이미 존재하는 user_name
	}
	
	public void getLoginUserInfo(UserBean tempLoginUserBean) {
		UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);
		// 가져온 데이터가 있다면
		if (tempLoginUserBean2 != null) {
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
			loginUserBean.setName(tempLoginUserBean2.getName());
			loginUserBean.setUserLogin(true); // 로그인 상태
		}
	}
	
	public String getLogisticsId(String user_idx) {
		return userDao.getLogisticsId(user_idx);
	}

}
