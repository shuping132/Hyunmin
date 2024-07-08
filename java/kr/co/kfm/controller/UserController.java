package kr.co.kfm.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kfm.beans.UserBean;
import kr.co.kfm.dao.UserDao;
import kr.co.kfm.service.UserService;
import kr.co.kfm.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDao;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	private String company = "°¡¸ÍÁ¡";

	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join";
	}
	
	@PostMapping("/join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {
		if (result.hasErrors()) {
			return "user/join";
		}
		userDao.addUserInfo(joinUserBean); // insert into
		return "user/join_success";
	}

	@GetMapping("/login")
	public String login(@ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean, Model model,
			@RequestParam(value = "fail", defaultValue = "false") boolean fail) {
		if (fail) {
			company = "°¡¸ÍÁ¡";
		}
		return "/user/login";
	}

	@PostMapping("/login_pro")
	public String login_pro(@Valid @ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "user/login";
		}

		userService.getLoginUserInfo(tempLoginUserBean);
		model.addAttribute("loginUserBean", loginUserBean);

		if (company.equals("°¡¸ÍÁ¡")) {
			loginUserBean.setCompanyid(userDao.getFranchiseeId(loginUserBean.getUser_idx()));
			System.out.println("°¡¸ÍÁ¡°¨");
		} else if (company.equals("¹°·ù¼¾ÅÍ")) {
			loginUserBean.setCompanyid(userDao.getLogisticsId(loginUserBean.getUser_idx()));
			System.out.println("¹°·ù¼¾ÅÍ°¨");
		} else {
			loginUserBean.setCompanyid(userDao.getSupplierId(loginUserBean.getUser_idx()));
			System.out.println("°ø±Þ¾÷Ã¼°¨");
		}

		if (loginUserBean.isUserLogin() && loginUserBean.getCompanyid() != null) {
			return "user/login_success";
		} else {
			return "user/login_fail";
		}
	}

	@PostMapping("/buttonClick")
	@ResponseBody
	public void handleButtonClick(@RequestBody ButtonClickRequest request, Model model) {
		company = request.getButton();
	}

	static class ButtonClickRequest {
		private String button;

		public String getButton() {
			return button;
		}

		public void setButton(String button) {
			this.button = button;
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		if (binder.getTarget() instanceof ButtonClickRequest) {
			binder.setValidator(null); // ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½È°ï¿½ï¿½È­
		} else {
			binder.addValidators(new UserValidator());
		}
	}
	
	@GetMapping("/logout")
	public String logout(@ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean) {
		loginUserBean.setCompanyid("");
		loginUserBean.setUser_pw("");
		loginUserBean.setUserLogin(false);
		
		return "user/login";
	}

	@GetMapping("/not_login")
	public String not_login() {
		return "user/not_login";
	}
	
}
