package kr.co.kfm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.kfm.beans.InventoryNotification;
import kr.co.kfm.beans.SafetyBean;
import kr.co.kfm.service.SafetyService;

@Controller
@RequestMapping("/hyeonmin")
public class SafetyController {
	
	@Autowired
	private SafetyService safetyService;
	
	// 占쏙옙占� 占쏙옙占쏙옙트
	@GetMapping("/Safety_inventory")
	public String RegistrationSafety_inventory(@RequestParam(value = "asd", defaultValue = "0") int asd,Model model) {
		List<SafetyBean> safeproducts = safetyService.getProductsWithZeroSafeStock();
		model.addAttribute("safeproducts", safeproducts);
		model.addAttribute("registration", new SafetyBean());
		List<SafetyBean> mainsafeproducts = safetyService.getProductsWithmainSafeStock();
		System.out.println("mainsafeproducts" + mainsafeproducts);
		model.addAttribute("mainsafeproducts", mainsafeproducts);
		model.addAttribute("asd", asd);
		return "/hyeonmin/Safety_inventory";
	}

	@PostMapping("/safeQuantityinfo")
	public String safeQuantityinfo(@ModelAttribute("registration") SafetyBean registration) {
		String Product_ID=registration.getProduct_id();
		int Safe_Stock=registration.getSafe_stock();
		
		if (Safe_Stock <= 0) {
			return "redirect:/hyeonmin/Safety_inventory"; // 占쏙옙占쏙옙占싱뤄옙트 占쏙옙占� 占쏙옙占쏙옙
		}

		try {
			System.out.println("Safe Stock: " + Safe_Stock);
			System.out.println("Product ID: " + Product_ID);
			safetyService.getsafeQuantity(Safe_Stock, Product_ID);
			System.out.println("占쏙옙占쏙옙占쏙옙트 占싹뤄옙");
			
			return "redirect:/hyeonmin/Safety_inventory"; // 占쏙옙占쏙옙占싱뤄옙트 占쏙옙占� 占쏙옙占쏙옙
		} catch (Exception e) {
			e.printStackTrace(); // 占쏙옙占쌤몌옙 占쏙옙占쏙옙 占싸그울옙 占쏙옙占�
			return "redirect:/hyeonmin/Safety_inventory"; // 占쏙옙占쏙옙占싱뤄옙트 占쏙옙占� 占쏙옙占쏙옙
		}
	}

	// 占쏙옙占쏙옙占쏙옙占� 0占쏙옙占쏙옙
	@PostMapping("/updateToZero")
	public String updateToZero(@RequestParam("productIds") String productIds) {

		// 占쌨몌옙占쏙옙 占쏙옙占싻듸옙 占쏙옙占쌘울옙占쏙옙 占썼열占쏙옙 占쏙옙환
		String[] productIdArray = productIds.split(",");

		for (String productId : productIdArray) {
			System.out.println("Received product ID: " + productId);
			safetyService.updateSafeStockToZero(productId);
		}

		return "/hyeonmin/Safety_inventory_Update";
	}



	@GetMapping("/checkInventory")
	public List<InventoryNotification> checkInventory() {
		return safetyService.checkInventory();
	}
	

	// 占쏙옙占쏙옙
	@PostMapping("/RequestOrder")
	public String RequestOrder(@RequestParam("asd") int asd, Model model) {
		
		asd++;
		model.addAttribute("asd", asd);
		safetyService.RequestOrder();
		
		safetyService.Orderquantity();
		
		return "/hyeonmin/Ordersuccess";
	}


}
