package kr.co.kfm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.kfm.beans.IOBean;
import kr.co.kfm.service.IOService;

@Controller
@RequestMapping("/analysis")
public class IOController {

	@Autowired
	private IOService iOService;
	
	@GetMapping("/IOsum")
	public String IOsum(Model model) {	

		List<IOBean> in_out_Summary = iOService.incoming_and_outgoing();
		model.addAttribute("in_out_Summary", in_out_Summary);
		
		return "analysis/IOsum";
	}
	
	
}
