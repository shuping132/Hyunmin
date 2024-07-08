package kr.co.kfm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kfm.beans.OrderData;
import kr.co.kfm.beans.OrderDetail;
import kr.co.kfm.beans.SellNBuyBuyBean;
import kr.co.kfm.beans.SellNBuyContentbean;
import kr.co.kfm.beans.SellNBuyIOBean;
import kr.co.kfm.beans.UserBean;
import kr.co.kfm.service.SellNBuyService;
import kr.co.kfm.service.UserService;

@Controller
@RequestMapping("/sellNbuy")
public class SellNBuyController {
	@Autowired
	private SellNBuyService sellNBuyService;
	@Autowired
	private UserService userService;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@GetMapping("/buyList")
	public String buyList(Model model) {
		List<SellNBuyBuyBean> buyList = sellNBuyService.getOrderInfo(loginUserBean.getCompanyid());
		List<SellNBuyBuyBean> storeBuyList = sellNBuyService.getOrderStateInfo(loginUserBean.getCompanyid(), "발주 요청");
		List<SellNBuyBuyBean> waitBuyList = sellNBuyService.getOrderStateInfo(loginUserBean.getCompanyid(), "승인");
		List<SellNBuyBuyBean> partBuyList = sellNBuyService.getOrderStateInfo(loginUserBean.getCompanyid(), "부분 입고");
		List<SellNBuyBuyBean> completeBuyList = sellNBuyService.getOrderStateInfo(loginUserBean.getCompanyid(),
				"입고 완료");
		List<SellNBuyBuyBean> cancleBuyList = sellNBuyService.getOrderStateInfo(loginUserBean.getCompanyid(),
				"반려");

		System.out.println("cancleBuyList" + cancleBuyList);
		
		model.addAttribute("buyList", buyList);
		model.addAttribute("storeBuyList", storeBuyList);
		model.addAttribute("waitBuyList", waitBuyList);
		model.addAttribute("partBuyList", partBuyList);
		model.addAttribute("completeBuyList", completeBuyList);
		model.addAttribute("cancleBuyList", cancleBuyList);
		return "/sellNbuy/buyList";
	}

	@GetMapping("/sellList")
	public String sellList(Model model) {
		List<SellNBuyContentbean> sellList = sellNBuyService.getSellList();
		model.addAttribute("sellList", sellList);
		return "/sellNbuy/sellList";
	}

	@GetMapping("/createOrderForm")
	public String createOrderForm(@ModelAttribute("orderform") SellNBuyBuyBean orderform, Model model) {
		model.addAttribute("orderform", new SellNBuyBuyBean());

		// 占쏙옙占쏙옙 占싸깍옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占� user_idx占쏙옙 占쏙옙占쏙옙
		orderform.setUser_idx(loginUserBean.getUser_idx());
		orderform.setCompany_id(loginUserBean.getCompanyid());

		// 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占� 占쌩곤옙
		List<SellNBuyBuyBean> getAccountList = sellNBuyService.getAccountList();
		System.out.println("getAccountList" + getAccountList);
		model.addAttribute("getAccountList", getAccountList);

		// Order_state 占썩본 占쏙옙占쏙옙
		if (orderform.getOrder_state() == null || orderform.getOrder_state().isEmpty()) {
			orderform.setOrder_state("발주 요청");
		}

		// order_date占쏙옙 Date 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙환
		if (orderform.getOrder_date() != null && !orderform.getOrder_date().isEmpty()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date parsedDate = null;

			try {
				parsedDate = sdf.parse(orderform.getOrder_date());
			} catch (ParseException e) {
				e.printStackTrace();
			}

			if (parsedDate != null) {
				java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
				orderform.setOrder_date(sqlDate.toString()); // Set SQL Date
			}
		}

		// due_date占쏙옙 Date 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙환
		if (orderform.getDue_date() != null && !orderform.getDue_date().isEmpty()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date parsedDate = null;

			try {
				parsedDate = sdf.parse(orderform.getDue_date());
			} catch (ParseException e) {
				e.printStackTrace();
			}

			if (parsedDate != null) {
				java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
				orderform.setDue_date(sqlDate.toString()); // Set SQL Date
			}
		}

		return "sellNbuy/createOrderForm"; // JSP 占쏙옙占쏙옙占쏙옙 占싱몌옙占쏙옙 占쏙옙환
	}

	@RequestMapping(value = "/getProductDetails", method = RequestMethod.GET)
	@ResponseBody
	public SellNBuyBuyBean getProductDetails(@RequestParam("product_id") String product_id) {
		List<SellNBuyBuyBean> sellBean = sellNBuyService.searchProduct(product_id);
		if (sellBean.isEmpty()) {
			return null;
		}
		return sellBean.get(0);
	}

	@RequestMapping(value = "/getProductList", method = RequestMethod.GET)
	@ResponseBody
	public List<SellNBuyBuyBean> getProductList() {
		List<SellNBuyBuyBean> productList = sellNBuyService.getProductname(loginUserBean.getCompanyid());
		System.out.println("loginUserBean.getCompanyid()" + loginUserBean.getCompanyid());
		System.out.println("productList" + productList);
		return productList;
	}

	@PostMapping("/createOrderFormPro")
	public String createOrderFormPro(@Valid @ModelAttribute("orderform") SellNBuyBuyBean orderform,
			BindingResult result) {
		if (result.hasErrors())
			return "sellNbuy/createOrderForm";// 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쌕쏙옙 占쏙옙占쏙옙占쏙옙 占싱듸옙

		// 占쏙옙占쏙옙 占싸깍옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占� user_idx占쏙옙 占쏙옙占쏙옙
		String logisticsCenterId = userService.getLogisticsId(loginUserBean.getUser_idx());
		orderform.setUser_idx(loginUserBean.getUser_idx());
		orderform.setLogistics_center_id(logisticsCenterId);

		// order_state 占쏙옙 占쏙옙占쏙옙
		if (orderform.getOrder_state() == null || orderform.getOrder_state().isEmpty()) {
			orderform.setOrder_state("발주 요청");
		}

		// 占쏙옙占쏙옙 占쏙옙占쏙옙
		OrderData orderData = new OrderData();
		orderData.setOrder_id(orderform.getOrder_id());
		orderData.setUser_idx(orderform.getUser_idx());
		orderData.setOrder_date(orderform.getOrder_date());
		orderData.setDue_date(orderform.getDue_date());
		orderData.setMemo(orderform.getMemo());
		orderData.setOrder_state(orderform.getOrder_state());
		orderData.setSupplier_id(orderform.getSupplier_id());
		orderData.setOrderDetails(orderform.getOrderDetails());

		sellNBuyService.insertOrder(orderData);
		System.out.println("createOrderFormPro");
		return "sellNbuy/createOrderFormSuccess";
	}

	@GetMapping("/buyDetails")
	public String getOrderDetails(@RequestParam("order_id") String order_id, Model model) {
		System.out.println("order_id" + order_id);
		String company_id = loginUserBean.getCompanyid();
		System.out.println("company_id" + company_id);
		SellNBuyBuyBean orderData = sellNBuyService.getOrdersInfo(order_id, company_id);
		List<SellNBuyBuyBean> orderDetails = sellNBuyService.getOrderProductInfo(order_id, company_id);
		List<SellNBuyBuyBean> IODetails = sellNBuyService.getIOCurrent(order_id, company_id);
		List<SellNBuyBuyBean> IOList = sellNBuyService.getIOdata(order_id);
		System.out.println("IODetails" + IODetails);
		model.addAttribute("orderData", orderData);
		model.addAttribute("orderDetails", orderDetails);
		model.addAttribute("IODetails", IODetails);
		model.addAttribute("IOList", IOList);
		return "/sellNbuy/buyDetails";
	}

	@GetMapping("/salesAnalysis")
	public String salesAnalysis() {
		return ("/sellNbuy/salesAnalysis");
	}

	@GetMapping("/createSalesForm")
	public String createSalesForm() {
		return ("/sellNbuy/createSalesForm");
	}

	@GetMapping("/sellDetails")
	public String sellDetails() {
		return ("/sellNbuy/sellDetails");
	}

	@PostMapping("/processOrder")
	@ResponseBody
	public String processOrder(@RequestBody OrderData orderData, HttpSession session) {
		orderData.setUser_idx(loginUserBean.getUser_idx());
		orderData.setCompany_id(loginUserBean.getCompanyid());

		sellNBuyService.insertOrder(orderData);
		return "/sellNbuy/buyDetails?order_id=" + orderData.getOrder_id();
	}

	@GetMapping("/receive")
	public String receive(@RequestParam("order_id") String order_id,
			@RequestParam(value = "product_id", required = false) String product_id, Model model, HttpSession session) {
		List<OrderDetail> orderDetails = sellNBuyService.getOrderDetails(order_id);
		OrderData orderData = sellNBuyService.getOrderData(order_id);
		
		System.out.println("orderDetails" + orderDetails);
		System.out.println("orderData" + orderData);

		model.addAttribute("order_id", order_id);
		model.addAttribute("product_id", product_id);
		model.addAttribute("orderDetails", orderDetails);
		model.addAttribute("orderData", orderData);

		UserBean loginUserBean = (UserBean) session.getAttribute("loginUserBean");
		if (loginUserBean != null) {
			model.addAttribute("user_idx", loginUserBean.getUser_idx());
		}

		return "sellNbuy/receive";
	}

	@PostMapping("/bulkReceive")
	@ResponseBody
	public String bulkReceive(@RequestBody Map<String, Object> data, HttpSession session) {
		String order_id = (String) data.get("order_id");
		String memo = (String) data.get("memo");
		String user_idx = loginUserBean.getUser_idx();
		List<OrderDetail> orderDetails = sellNBuyService.getOrderDetails(order_id);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sdf.format(new Date());

		for (OrderDetail detail : orderDetails) {
			SellNBuyIOBean io = new SellNBuyIOBean();
			io.setIo_id(generateRandomId());
			io.setProduct_id(detail.getProduct_id());
			io.setIo_date(currentDate);
			io.setQuantity(detail.getQuantity());
			io.setDivision("입고");
			io.setOrder_id(order_id);
			io.setUser_idx(user_idx); // user_idx 占쏙옙占쏙옙
			io.setMemo(memo); // memo 占쏙옙占쏙옙
			sellNBuyService.insertIO(io);
			
			System.out.println("user_idx" + user_idx);
			System.out.println("io" + io);

			sellNBuyService.updateInventory(loginUserBean.getCompanyid(), detail.getProduct_id(),
					detail.getQuantity());
		}
		sellNBuyService.updateBulk(order_id);

		return "/sellNbuy/receive";
	}

	@PostMapping("/partialReceive")
	@ResponseBody
	public String partialReceive(@RequestBody Map<String, Object> data, HttpSession session) {
		int quantity = (Integer) data.get("quantity");
		String memo = (String) data.get("memo");
		String order_id = (String) data.get("order_id");
		String product_id = (String) data.get("product_id");
		String user_idx = loginUserBean.getUser_idx();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sdf.format(new Date());

		SellNBuyIOBean io = new SellNBuyIOBean();
		io.setIo_id(generateRandomId());
		io.setProduct_id(product_id);
		io.setIo_date(currentDate);
		io.setQuantity(quantity);
		io.setDivision("입고");
		io.setOrder_id(order_id);
		io.setUser_idx(user_idx); // user_idx 占쏙옙占쏙옙
		io.setMemo(memo); // memo 占쏙옙占쏙옙

		System.out.println("user_idx" + user_idx);
		System.out.println("io" + io);

		sellNBuyService.insertIO(io);

		sellNBuyService.updateInventory(loginUserBean.getCompanyid(), product_id, quantity);

		return "/sellNbuy/receive";
	}

	private String generateRandomId() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
