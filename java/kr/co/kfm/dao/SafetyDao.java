package kr.co.kfm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kfm.beans.SafetyBean;
import kr.co.kfm.mapper.SafetyMapper;

@Repository
public class SafetyDao {

	@Autowired
	private SafetyMapper safetyMapper;
	
	public List<SafetyBean> getmainSafeStockFranchiseeProducts(String franchisee_id){
		return safetyMapper.getmainSafeStockFranchiseeProducts(franchisee_id);
	}
	
	public List<SafetyBean> getmainSafeStockCenterProducts(String logistics_center_id){
		return safetyMapper.getmainSafeStockCenterProducts(logistics_center_id);
	}
	
	public void updateCenterSafeStockToZero(String product_id, String companyId) {
		safetyMapper.updateCenterSafeStockToZero(product_id, companyId);
	}
	
	public void updateFranchiseeSafeStockToZero(String product_id, String companyId) {
		safetyMapper.updateFranchiseeSafeStockToZero(product_id, companyId);
	}
	
	public void RequestOrder() {
		safetyMapper.RequestOrder();
	}
	
	public void LCOrderquantity() {
		safetyMapper.LCOrderquantity();
	}
	
	public void FOrderquantity( ) {
		safetyMapper.FOrderquantity();
	}
}
