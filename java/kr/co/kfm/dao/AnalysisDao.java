package kr.co.kfm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kfm.beans.AnalysisBean;
import kr.co.kfm.mapper.AnalysisMapper;

@Repository
public class AnalysisDao {

	@Autowired
	private AnalysisMapper analysisMapper;
	
	public List<AnalysisBean> getFranchiseeProduct(String franchisee_id){
		return analysisMapper.getFranchiseeProduct(franchisee_id);
	}
	
	public List<AnalysisBean> getLogisticsProduct(String logistics_center_id){
		return analysisMapper.getLogisticsProduct(logistics_center_id);
	}
	
}
