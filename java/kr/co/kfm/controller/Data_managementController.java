package kr.co.kfm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.kfm.beans.GuBean;
import kr.co.kfm.beans.Logistics_centerBean;
import kr.co.kfm.beans.Logistics_center_productBean;
import kr.co.kfm.beans.ProductBean;
import kr.co.kfm.beans.UserBean;
import kr.co.kfm.service.GuService;
import kr.co.kfm.service.ProductService;

@Controller
@RequestMapping("/data_management")
public class Data_managementController {

	@Autowired
	private GuService guService;

	@Autowired
	private ProductService productService;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@GetMapping("/product")
	public String product(@ModelAttribute("writeProBean") ProductBean writeProBean, Model model) {
		String company_id = loginUserBean.getCompanyid();
		List<ProductBean> proBean = productService.getProductInfo(company_id);
		model.addAttribute("writeProBean", writeProBean);
		model.addAttribute("proBean", proBean);

		return "data_management/product";
	}

	@PostMapping("/prowrite_pro")
	public String prowrite_pro(@ModelAttribute("writeProBean") ProductBean writeProBean, Model model) {
		String company_id = loginUserBean.getCompanyid();
		productService.addProInfo(writeProBean);
		/* productService.addProInfo2(writeProBean); */
		/* productService.addProInfo3(writeProBean); */
		List<ProductBean> writeProductBean = productService.getProductInfo(company_id);
		model.addAttribute("writeProductBean", writeProductBean);

		return "data_management/writprosuc";

	}

	@GetMapping("/prosang")
	public String prosang(@RequestParam("product_id") String product_id, Model model) {
		String company_id = loginUserBean.getCompanyid();
		List<ProductBean> proBean = productService.getProductInfo(company_id);
		List<ProductBean> proBean2 = productService.getProductInfo2(company_id);
		model.addAttribute("proBean", proBean);
		model.addAttribute("product_id", product_id);
		model.addAttribute("proBean2", proBean2);

		return "data_management/prosang";
	}

	@GetMapping("/productmodify")
	public String productmodify(@RequestParam("product_id") String product_id,
			@ModelAttribute("modifyProBean") ProductBean modifyProBean, Model model) {
		String company_id = loginUserBean.getCompanyid();
		model.addAttribute("product_id", product_id);
		List<ProductBean> proBean = productService.getProductInfo(company_id);
		List<ProductBean> proBean2 = productService.getProductInfo2(company_id);
		model.addAttribute("proBean", proBean);
		model.addAttribute("proBean2", proBean2);
	
		return "data_management/productmodify";
	}

	@PostMapping("/productmodify_pro")
	public String productmodify_pro(@ModelAttribute("modifyProBean") ProductBean modifyProBean, Model model,
			@RequestParam("before_stock") int before_stock) {
		System.out.println("before_stock" + before_stock);
		System.out.println("after_stock" + modifyProBean.getCurrent_stock());
		System.out.println("quantity" + (modifyProBean.getCurrent_stock() - before_stock));
		String company_id = loginUserBean.getCompanyid();
		productService.modifyProInfo(modifyProBean);
		/* productService.modifyProInfo2(modifyProBean); */
		productService.modifyProInfo3(modifyProBean);
		List<ProductBean> proBean = productService.getProductInfo(company_id);
		List<ProductBean> proBean2 = productService.getProductInfo2(company_id);
		model.addAttribute("proBean", proBean);
		model.addAttribute("proBean2", proBean2);
		model.addAttribute("modifyProBean", modifyProBean);
		
		return "data_management/modifysuc";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("product_id") String product_id, Model model) {
		model.addAttribute("product_id", product_id);
		productService.deleteProInfo(product_id);

		return "data_management/delete";
	}
	
//=====================================================(gu)====================
	
	@GetMapping("/gu")
		public String gu(@ModelAttribute("selectGu") GuBean selectGu, Model model) {
			String company_id = loginUserBean.getCompanyid();
			List<GuBean> LogisBean = guService.getAccountInfo(company_id);
			List<GuBean> FrBean = guService.getAccount2Info(company_id);
			List<GuBean> SupBean = guService.getAccount3Info(company_id);
			List<GuBean> mulgoBean = guService.getAccount4Info(company_id);
			model.addAttribute("selectGu", selectGu);
			model.addAttribute("LogisBean", LogisBean);
			model.addAttribute("FrBean", FrBean);
			model.addAttribute("SupBean", SupBean);
			model.addAttribute("mulgoBean", mulgoBean);
			
		return "data_management/gu";
	}

}
