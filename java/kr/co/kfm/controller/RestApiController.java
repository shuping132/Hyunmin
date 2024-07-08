package kr.co.kfm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kfm.beans.SellNBuyBuyBean;
import kr.co.kfm.service.SellNBuyService;
import kr.co.kfm.service.UserService;

@RestController
public class RestApiController {

	@Autowired
	private UserService userService;

	@Autowired
	private SellNBuyService sellNBuyService;

	@GetMapping("/user/checkUserIdExist/{user_id}")
	public String checkUserIdExist(@PathVariable String user_id) { // @PathVariable : 주소에 데이터 붙이기
		boolean check = userService.checkUserExist(user_id);
		return check + "";
	}
	
	/*
	 * @GetMapping("/sellNbuy/getProductDetails") public List<SellNBuyBuyBean>
	 * getProductname() { List<SellNBuyBuyBean> sellBean =
	 * sellNBuyService.getProductname(); return sellBean; }
	 */
	  /*@GetMapping("/sellNbuy/getProductDetails") 
	  public List<SellNBuyBuyBean> searchProduct(String product_id) { 
		  List<SellNBuyBuyBean> sellBean = sellNBuyService.searchProduct(product_id);
		  return sellBean;}*/ 



}
