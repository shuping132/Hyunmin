package kr.co.kfm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kfm.beans.AnalysisBean;
import kr.co.kfm.beans.UserBean;
import kr.co.kfm.dao.AnalysisDao;

@Service
public class AnalysisService {

	@Autowired
	private AnalysisDao analysisDao;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	public List<AnalysisBean> getCompanyProduct(String company_id){
		
		if(loginUserBean.getCompanyid().contains("F")) {			
			System.out.println("Franchisee:" + company_id);
			return analysisDao.getFranchiseeProduct(company_id);
		}else {
			System.out.println("Logistics_center:" + company_id);
			return analysisDao.getLogisticsProduct(company_id);
		}
		
	}
	

}
