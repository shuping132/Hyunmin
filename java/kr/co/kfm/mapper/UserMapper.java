package kr.co.kfm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.kfm.beans.UserBean;

public interface UserMapper {

	@Insert("insert into User_info (user_name, user_id, user_pw) "
			+ "values (#{user_name}, #{user_id}, #{user_pw})")
	void addUserInfo(UserBean joinUserBean);
	
	@Select("select name from User_info where user_id=#{user_id}")
	String checkUserIdExist(String user_id);
	
	@Select("select user_idx, name from User_info where user_id=#{user_id} and user_pw=#{user_pw}")
	UserBean getLoginUserInfo(UserBean tempUserLoginBean);
	
	@Select("select franchisee_id from Franchisee where user_idx=#{user_idx}")
	String getFranchiseeId(String user_idx);
	
	@Select("select logistics_center_id from Logistics_center where user_idx=#{user_idx, jdbcType=VARCHAR}")
	String getLogisticsId(String user_idx);
	
	@Select("select supplier_id from Supplier where user_idx=#{user_idx}")
	String getSupplierId(String user_idx);
	
	
	
}
