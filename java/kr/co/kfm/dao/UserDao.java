package kr.co.kfm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kfm.beans.UserBean;
import kr.co.kfm.mapper.UserMapper;

@Repository
public class UserDao {

	@Autowired
	private UserMapper userMapper;
	
	public void addUserInfo(UserBean joinUserBean) {
		userMapper.addUserInfo(joinUserBean);
	}
	
	public String checkUserExist(String user_id) {
		return userMapper.checkUserIdExist(user_id);
	}
	
	public UserBean getLoginUserInfo(UserBean tempLoginUserBean) {
		return userMapper.getLoginUserInfo(tempLoginUserBean);
	}
	
	public String getFranchiseeId(String user_idx) {
		return userMapper.getFranchiseeId(user_idx);
	}
	
	public String getLogisticsId(String user_idx) {
		return userMapper.getLogisticsId(user_idx);
	}
	
	public String getSupplierId(String user_idx) {
		return userMapper.getSupplierId(user_idx);
	}
	
}
