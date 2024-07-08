package kr.co.kfm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.kfm.beans.product_HistoryBean;
import kr.co.kfm.service.HistoryService;

@Controller
@RequestMapping("/hyeonmin")
public class HistoryController {

	@Autowired
	private HistoryService historyService;

	@GetMapping("/date_pro")
	public String date_pro(@RequestParam(value = "date", defaultValue = "") String change_date, Model model) {

		
		System.out.println(change_date);
		List<product_HistoryBean> historyList = historyService.getHistoryByDate(change_date);
		model.addAttribute("historyList", historyList);
		model.addAttribute("change_date", change_date);
		int totalQuantity = historyList.stream().mapToInt(product_HistoryBean::getChanged_stock).sum();
		model.addAttribute("totalQuantity", totalQuantity);
		
		return "hyeonmin/Past_quantity";
	}

	@GetMapping("/Past_quantity")
	public String getHistoryByDatePage(@RequestParam(value = "date", defaultValue = "") String change_date, Model model) {	


		
		return "hyeonmin/Past_quantity";
	}

}
