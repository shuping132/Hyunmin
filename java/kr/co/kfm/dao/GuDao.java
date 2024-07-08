package kr.co.kfm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kfm.beans.GuBean;
import kr.co.kfm.mapper.GuMapper;

@Repository
public class GuDao {

	@Autowired
	private GuMapper guMapper;
	
	public List<GuBean> getAccountInfo(String company_id){
		return guMapper.getAccountInfo(company_id);
	}
	
	public List<GuBean> getAccount2Info(String company_id){
		return guMapper.getAccount2Info(company_id);
	}
	
	public List<GuBean> getAccount3Info(String company_id){
		return guMapper.getAccount3Info(company_id);
	}
	
	public List<GuBean> getAccount4Info(String company_id){
		return guMapper.getAccount4Info(company_id);
	}
	
	
	
}
