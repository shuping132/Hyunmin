package kr.co.kfm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.kfm.beans.OrderSituationBean;
import kr.co.kfm.beans.PostBean;
import kr.co.kfm.beans.UserBean;
import kr.co.kfm.service.BoardService;
import kr.co.kfm.service.OrderSituationService;

@Controller
public class MainController {

	@Autowired
	private BoardService boardService;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	@Autowired
	private OrderSituationService orderSituationService;
	
	@GetMapping("/main")
	public String main(@RequestParam(value = "post_type1", defaultValue = "notice") String post_type1,
			@RequestParam(value = "post_type2", defaultValue = "QnA") String post_type2,
			@RequestParam(value = "order_id", defaultValue = "202406256719") String order_id,
			@RequestParam(value = "page", defaultValue = "1") int page,Model model) {
		String company = loginUserBean.getCompanyid().substring(0, 1);
		
		model.addAttribute("post_type1",post_type1);
		model.addAttribute("post_type2",post_type2);
		model.addAttribute("order_id",order_id);
		
		List<OrderSituationBean> Orderstatus=orderSituationService.getRecentOrders();
		model.addAttribute("Orderstatus",Orderstatus);
		System.out.println("Orderstatus" + Orderstatus);
		List<PostBean>Notice=boardService.getNoticeContentList("notice",page);
		model.addAttribute("Notice",Notice);
		
		System.out.println("company" + company);
		model.addAttribute("company",company);
		return "/main";
	}
	
}
