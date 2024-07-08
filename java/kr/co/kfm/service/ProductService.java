package kr.co.kfm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kfm.beans.ProductBean;
import kr.co.kfm.dao.ProductDao;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public void addProInfo(ProductBean writeProBean) {
		productDao.addProInfo(writeProBean);
	}

	/*
	 * public void addProInfo2(ProductBean writeProBean) {
	 * productDao.addProInfo2(writeProBean); }
	 */

	/*
	 * public void addProInfo3(ProductBean writeProBean) {
	 * productDao.addProInfo3(writeProBean); }
	 */

	public List<ProductBean> getProductInfo(String company_id) {
		if (company_id.startsWith("F")) {
			return productDao.getProductInfo(company_id);
		}else {
			return productDao.getProductInfo2(company_id);
		}
		
	}

	public List<ProductBean> getProductInfo2(String company_id) {
		return productDao.getProductInfo2(company_id);
	}

	public void modifyProInfo(ProductBean modifyProBean) {
		productDao.modifyProInfo(modifyProBean);
	}

	/*
	 * public void modifyProInfo2(ProductBean modifyProBean) {
	 * productDao.modifyProInfo2(modifyProBean); }
	 */

	public void modifyProInfo3(ProductBean modifyProBean) {
		productDao.modifyProInfo3(modifyProBean);
	}

	public void deleteProInfo(String product_id) {
		productDao.deleteProInfo(product_id);
	}

}
