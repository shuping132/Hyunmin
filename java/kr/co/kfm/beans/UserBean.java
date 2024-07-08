package kr.co.kfm.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String user_idx;
	@Size(min = 2, message="ÀÌ¸§Àº 2±ÛÀÚ ÀÌ»óÀÌ¾î¾ß ÇÕ´Ï´Ù")
	@Pattern(regexp = "[°¡-ÆRa-zA-Z]*")
	private String name;
	@NotBlank
	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*") // ¿µ¾î ¶Ç´Â ¼ıÀÚ¸¸ ÀÔ·Â ÀÚÁÖ ¾²ÀÌ´Â Á¤±Ô½Ä(Regular Expression)
	private String user_id;
	@NotBlank
	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw;
	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw2;
	@Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])+[.][a-zA-Z]{2,3}$", message = "ÀÌ¸ŞÀÏ ÁÖ¼Ò ¾ç½ÄÀ» È®ÀÎÇØÁÖ¼¼¿ä")
	private String email;
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "ÈŞ´ëÆù ¹øÈ£ ¾ç½Ä¿¡ ¸ÂÁö ¾Ê½À´Ï´Ù")
	private String phone;
	@Size(min = 10, max = 10, message = "»ç¾÷ÀÚµî·Ï¹øÈ£´Â 10±ÛÀÚ¿©¾ß ÇÕ´Ï´Ù")
	@Pattern(regexp = "[0-9]")
	private String business_number;
	private String companyid;

	private boolean userIdExist;

	private boolean userLogin;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// ÃÊ±â°ª ·Î±×ÀÎÀÌ ¾È µÇ¾î ÀÖ´Â »óÅÂ
	public UserBean() {
		this.userLogin = false;
	}

	public String getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(String user_idx) {
		this.user_idx = user_idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_pw2() {
		return user_pw2;
	}

	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBusiness_number() {
		return business_number;
	}

	public void setBusiness_number(String business_number) {
		this.business_number = business_number;
	}

	public boolean isUserIdExist() {
		return userIdExist;
	}

	public void setUserIdExist(boolean userIdExist) {
		this.userIdExist = userIdExist;
	}

	public boolean isUserLogin() {
		return userLogin;
	}

	public void setUserLogin(boolean userLogin) {
		this.userLogin = userLogin;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}	
	
}
