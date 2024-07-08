package kr.co.kfm.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kfm.beans.InventoryNotification;
import kr.co.kfm.beans.SafetyBean;
import kr.co.kfm.beans.UserBean;
import kr.co.kfm.dao.SafetyDao;
import kr.co.kfm.mapper.SafetyMapper;

@Service
public class SafetyService {

	@Autowired
	private SafetyDao safetyDao;

	@Autowired
	private SafetyMapper safetyMapper;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	public List<SafetyBean> getProductsWithZeroSafeStock() {
		System.out.println("Company ID: " + loginUserBean.getCompanyid());

		if (loginUserBean.getCompanyid().startsWith("LC")) {
			System.out.println("Fetching products for Logistics Center");
			return safetyMapper.getZeroSafeStockCenterProducts(loginUserBean.getCompanyid());
		} else if (loginUserBean.getCompanyid().startsWith("F")) {
			System.out.println("Fetching products for Franchisee");
			return safetyMapper.getZeroSafeStockFranchiseeProducts(loginUserBean.getCompanyid());
		}
		System.out.println("No matching company ID prefix");
		return null;
	}

	public List<SafetyBean> getProductsWithmainSafeStock() {
		System.out.println("Company ID: " + loginUserBean.getCompanyid());

		if (loginUserBean.getCompanyid().startsWith("LC")) {
			System.out.println("Fetching products for Logistics Center");
			return safetyDao.getmainSafeStockCenterProducts(loginUserBean.getCompanyid());
		} else if (loginUserBean.getCompanyid().startsWith("F")) {
			System.out.println("Fetching products for Franchisee");
			return safetyDao.getmainSafeStockFranchiseeProducts(loginUserBean.getCompanyid());
		}
		System.out.println("No matching company ID prefix");
		return null;
	}

	public void getsafeQuantity(int change_safeQuantity, String productIds) {
		try {
			if (loginUserBean.getCompanyid().startsWith("LC")) {
				System.out.println("Fetching products for Logistics Center");
				safetyMapper.getFsafeQuantity(change_safeQuantity, productIds, loginUserBean.getCompanyid());
			} else if (loginUserBean.getCompanyid().startsWith("F")) {
				System.out.println("Fetching products for Franchisee");
				safetyMapper.getFsafeQuantity(change_safeQuantity, productIds, loginUserBean.getCompanyid());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error occurred while fetching safe quantity", e);
		}
	}

	public void updateSafeStockToZero(String productId) {

		System.out.println("Inside service method with product ID: " + productId);

		String companyId = loginUserBean.getCompanyid();
		try {
			if (loginUserBean.getCompanyid().startsWith("LC")) {
				System.out.println("Updating center safe stock to zero for product ID: " + productId);
				safetyDao.updateCenterSafeStockToZero(productId, companyId);
			} else if (loginUserBean.getCompanyid().startsWith("F")) {
				System.out.println("Updating franchisee safe stock to zero for product ID: " + productId);
				safetyDao.updateFranchiseeSafeStockToZero(productId, companyId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Handle exception appropriately
		}
	}

	public List<InventoryNotification> checkInventory() {
		if (loginUserBean.getCompanyid().startsWith("LC")) {
			System.out.println("Fetching products for Logistics Center");
			List<SafetyBean> products = safetyMapper.getLCAllProducts();
			return products.stream().filter(p -> p.getCurrent_stock() < p.getSafe_stock())
					.map(p -> new InventoryNotification(p.getName())).collect(Collectors.toList());
		} else if (loginUserBean.getCompanyid().startsWith("F")) {
			System.out.println("Fetching products for Franchisee");
			List<SafetyBean> products = safetyMapper.getFAllProducts();
			return products.stream().filter(p -> p.getCurrent_stock() < p.getSafe_stock())
					.map(p -> new InventoryNotification(p.getName())).collect(Collectors.toList());
		}
		return null;

	}

	// ����
	public void RequestOrder() {

		safetyMapper.RequestOrder();
	}

	public void Orderquantity() {

		if (loginUserBean.getCompanyid().startsWith("L")) {
			safetyDao.LCOrderquantity();
			safetyDao.FOrderquantity();
		}

	}

}
