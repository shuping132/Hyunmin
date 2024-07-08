package kr.co.kfm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kfm.beans.ProductBean;
import kr.co.kfm.mapper.ProductMapper;

@Repository
public class ProductDao {

	@Autowired
	private ProductMapper productMapper;

	public void addProInfo(ProductBean writeProBean) {
		productMapper.addProInfo(writeProBean);
	}
	
	/*
	 * public void addProInfo2(ProductBean writeProBean) {
	 * productMapper.addProInfo2(writeProBean); }
	 */
	
	/*
	 * public void addProInfo3(ProductBean writeProBean) {
	 * productMapper.addProInfo3(writeProBean); }
	 */
	
	public List<ProductBean> getProductInfo(String company_id){
		return productMapper.getProductInfo(company_id);
	}
	
	public List<ProductBean> getProductInfo2(String company_id){
		return productMapper.getProductInfo2(company_id);
	}

	public void modifyProInfo(ProductBean modifyProBean) {
		productMapper.modifyProInfo(modifyProBean);
	}
	
	/*
	 * public void modifyProInfo2(ProductBean modifyProBean) {
	 * productMapper.modifyProInfo2(modifyProBean); }
	 */
	
	public void modifyProInfo3(ProductBean modifyProBean) {
		productMapper.modifyProInfo3(modifyProBean);
	}

	public void deleteProInfo(String product_id) {
		productMapper.deleteProInfo(product_id);
	}
	
	
	
}
