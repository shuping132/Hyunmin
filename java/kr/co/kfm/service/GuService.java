package kr.co.kfm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kfm.beans.GuBean;
import kr.co.kfm.beans.Logistics_centerBean;
import kr.co.kfm.beans.Logistics_center_productBean;
import kr.co.kfm.dao.GuDao;

@Service
public class GuService {
	
	@Autowired
	private GuDao guDao;

	public List<GuBean> getAccountInfo(String company_id){
		return guDao.getAccountInfo(company_id);
	}
	
	public List<GuBean> getAccount2Info(String company_id){
		return guDao.getAccount2Info(company_id);
	}
	
	public List<GuBean> getAccount3Info(String company_id){
		return guDao.getAccount3Info(company_id);
	}
	
	public List<GuBean> getAccount4Info(String company_id){
		return guDao.getAccount4Info(company_id);
	}


	
}
