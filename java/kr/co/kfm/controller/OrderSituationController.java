package kr.co.kfm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kfm.beans.OrderData;
import kr.co.kfm.beans.OrderSituationBean;
import kr.co.kfm.beans.UserBean;
import kr.co.kfm.dao.OrderSituationDao;
import kr.co.kfm.service.OrderSituationService;

@Controller
@RequestMapping("/orderSituation")
public class OrderSituationController {

	@Autowired
	private OrderSituationService orderSituationService;

	@Autowired
	private OrderSituationDao orderSituationDao;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@GetMapping("/accountOrder")
	public String accountOrder(Model model) {
		String orderCancle = "반려";
		String orderRequest = "발주 요청";
		String orderComplete = "입고 완료";
		String company_id = loginUserBean.getCompanyid();

		List<OrderSituationBean> orderCompleteBean = orderSituationService.getOrderData(orderComplete, company_id);
		List<OrderSituationBean> orderCancleBean = orderSituationService.getOrderData(orderCancle, company_id);
		List<OrderSituationBean> orderRequestBean = orderSituationService.getOrderData(orderRequest, company_id);
		List<OrderSituationBean> orderConfirmBean = orderSituationService.getOrderWaitData(company_id);
		List<OrderSituationBean> Orderstatus = orderSituationService.getRecentOrders();
		
		System.out.println("orderCompleteBean" + orderCompleteBean);
		System.out.println("orderCancleBean" + orderCancleBean);
		System.out.println("orderRequestBean" + orderRequestBean);
		System.out.println("orderConfirmBean" + orderConfirmBean);
		System.out.println("Orderstatus" + Orderstatus);

		model.addAttribute("orderCompleteBean", orderCompleteBean);
		model.addAttribute("orderCancleBean", orderCancleBean);
		model.addAttribute("orderRequestBean", orderRequestBean);
		model.addAttribute("orderConfirmBean", orderConfirmBean);
		model.addAttribute("Orderstatus", Orderstatus);
		
		return "orderSituation/accountOrder";
	}

	@GetMapping("/arderDetail")
	public String arderDetail(@RequestParam("order_id") String order_id, Model model) {
		String company_id = loginUserBean.getCompanyid();

		OrderSituationBean orderInfo = orderSituationService.getOrderInfo(order_id, company_id);
		List<OrderSituationBean> orderProductInfo = orderSituationService.getOrderProductInfo(order_id, company_id);
		List<OrderSituationBean> orderIOInfo = orderSituationDao.getIOdata(order_id);
		List<OrderSituationBean> orderIOCurrentInfo = orderSituationService.getIOCurrent(order_id, company_id);

		System.out.println("orderIOInfo" + orderIOInfo);
		System.out.println("orderInfo" + orderInfo);
		System.out.println("orderProductInfo" + orderProductInfo);
		System.out.println("orderIOCurrentInfo" + orderIOCurrentInfo);

		model.addAttribute("orderIOInfo", orderIOInfo);
		model.addAttribute("orderInfo", orderInfo);
		model.addAttribute("orderProductInfo", orderProductInfo);
		model.addAttribute("orderIOCurrentInfo", orderIOCurrentInfo);

		return "orderSituation/arderDetail";
	}

	@PostMapping("/orderStateUpdate")
	@ResponseBody
	public String orderStateUpdate(@RequestBody OrderData orderData) {
		System.out.println(orderData.getReject_memo());
		orderSituationService.updateOrdersState(orderData);

		return "orderSituation/arderDetail?order_id=" + orderData.getOrder_id();
	}

}
