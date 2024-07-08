package kr.co.kfm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.kfm.beans.AnalysisBean;
import kr.co.kfm.beans.UserBean;
import kr.co.kfm.service.AnalysisService;

@Controller
@RequestMapping("/analysis")
public class AnalysisController {

	@Autowired
	private AnalysisService analysisService;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	@GetMapping("/analysis")
	public String analysis(Model model) {
		
		List<AnalysisBean> companyProductBean =  analysisService.getCompanyProduct(loginUserBean.getCompanyid());
		
		model.addAttribute("companyProductBean", companyProductBean);
		
		return ("analysis/analysis");
	}

	@GetMapping("/setting_properties")
	public String setting_properties() {
		return ("analysis/setting_properties");
	}

	/*
	 * @GetMapping("/IOsum") public String IOsum() { return ("analysis/IOsum"); }
	 */

	@GetMapping("/formula")
	public String formula() {
		return ("analysis/formula");
	}
}
