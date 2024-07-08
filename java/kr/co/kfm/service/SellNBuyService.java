package kr.co.kfm.service;

import java.text.NumberFormat;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kfm.beans.OrderData;
import kr.co.kfm.beans.OrderDetail;
import kr.co.kfm.beans.SellNBuyBuyBean;
import kr.co.kfm.beans.SellNBuyContentbean;
import kr.co.kfm.beans.SellNBuyIOBean;
import kr.co.kfm.beans.UserBean;
import kr.co.kfm.dao.SellNBuyDao;

@Service
public class SellNBuyService {

	@Autowired
	private SellNBuyDao sellNBuyDao;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	public List<SellNBuyContentbean> getBuyList() {
		return sellNBuyDao.getBuyList();
	}

	public List<SellNBuyContentbean> getSellList() {
		return sellNBuyDao.getSellList();
	}

	/*
	 * public void insertOrderform(SellNBuyBuyBean orderform) {
	 * sellNBuyDao.insertOrderform(orderform); }
	 */

	public void insertOrder(OrderData orderData) {
		System.out.println("orderData" + orderData);
		sellNBuyDao.insertOrder(orderData);
		if (loginUserBean.getCompanyid().startsWith("F")) {
			sellNBuyDao.insertLogisticsOrder(orderData);
		} else {
			sellNBuyDao.insertSupplierOrder(orderData);
		}
		for (OrderDetail detail : orderData.getOrderDetails()) {
			detail.setOrder_id(orderData.getOrder_id());
			System.out.println("detail" + detail.getProduct_id());
			sellNBuyDao.insertLogisticsOrderProduct(detail);
		}
	}

	public List<SellNBuyBuyBean> getAccountList() {

		if (loginUserBean.getCompanyid().startsWith("F")) {
			System.out.println("Franchisee" + loginUserBean.getCompanyid());
			return sellNBuyDao.getLogisticsList(loginUserBean.getCompanyid());
		} else {
			System.out.println("Logistics" + loginUserBean.getCompanyid());
			return sellNBuyDao.getSupplierList(loginUserBean.getCompanyid());
		}

	}

	/*
	 * public SellNBuyBuyBean sellBean(String productId) { return
	 * sellNBuyDao.searchProduct(productId); }
	 */
	public List<SellNBuyBuyBean> searchProduct(String product_id) {
		List<SellNBuyBuyBean> products = sellNBuyDao.searchProduct(product_id);
		return products;
	}

	public List<SellNBuyBuyBean> getProductname(String company_id) {
		List<SellNBuyBuyBean> productNames = sellNBuyDao.getProductname(company_id);
		return productNames;
	}

	public OrderData getOrderData(String order_id) {
		if(loginUserBean.getCompanyid().startsWith("F")) {
			return sellNBuyDao.getFranchiseeOrderData(order_id);
		}else {
			return sellNBuyDao.getLogisticsOrderData(order_id);
		}
			
	}

	public List<OrderDetail> getOrderDetails(String order_id) {
		if(loginUserBean.getCompanyid().startsWith("F")) {
			return sellNBuyDao.getFranchiseeOrderDetails(order_id);
		}else {
			return sellNBuyDao.getLogisticsOrderDetails(order_id);
		}
	}

	public void insertIO(SellNBuyIOBean io) {
		sellNBuyDao.insertIO(io);
	}

	public void updateInventory(String company_id, String product_id, int quantity) {
		if(loginUserBean.getCompanyid().startsWith("F")) {
			sellNBuyDao.updateFranchiseeInventory(company_id, product_id, quantity);
		}else {
			sellNBuyDao.updateLogisticsCenterInventory(company_id, product_id, quantity);
		}
	}

	public List<OrderDetail> getDetails(String orderId) {
		return sellNBuyDao.getDetails(orderId);
	}

	private String generateRandomId() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	// ���� ����(�������α���)
	public List<SellNBuyBuyBean> getOrderInfo(String company_id) {
		if (company_id.substring(0, 1).equals("F")) {
			return sellNBuyDao.getFranchiseeOrderInfo(company_id);
		} else {
			return sellNBuyDao.getLogisticsOrderInfo(company_id);
		}
	}

	public List<SellNBuyBuyBean> getOrderStateInfo(String company_id, String order_state) {
		if (company_id.substring(0, 1).equals("F")) {
			return sellNBuyDao.getFranchiseeOrderStateInfo(company_id, order_state);
		} else {
			return sellNBuyDao.getLogisticsOrderStateInfo(company_id, order_state);
		}
	}

	public SellNBuyBuyBean getOrdersInfo(String order_id, String company_id) {
		SellNBuyBuyBean orderInfo;
		if (company_id.substring(0, 1).equals("F")) {
			orderInfo = sellNBuyDao.getLogisticsOrdersInfo(order_id);
		} else {
			orderInfo = sellNBuyDao.getSupplierOrdersInfo(order_id);
		}

		return orderInfo;
	}

	public List<SellNBuyBuyBean> getOrderProductInfo(String order_id, String company_id) {
		List<SellNBuyBuyBean> orderProductInfo;
		if (company_id.substring(0, 1).equals("F")) {
			orderProductInfo = sellNBuyDao.getLogisticsOrdersProductInfo(order_id);
		} else {
			orderProductInfo = sellNBuyDao.getSupplierOrdersProductInfo(order_id);
		}
		NumberFormat numberFormat = NumberFormat.getInstance();
		orderProductInfo.forEach(item -> {
			item.setFormat_total_price(numberFormat.format(item.getSell_price() * item.getQuantity()));
			item.setFormat_sell_price(numberFormat.format(item.getSell_price()));
			item.setTotal_price(item.getSell_price() * item.getQuantity());
		});
		return orderProductInfo;
	}

	public List<SellNBuyBuyBean> getIOCurrent(String order_id, String company_id) {
		List<SellNBuyBuyBean> orderIOCurrentInfo;
		if (company_id.substring(0, 1).equals("F")) {
			orderIOCurrentInfo = sellNBuyDao.getIOLogisticsCurrent(order_id);
		} else {
			orderIOCurrentInfo = sellNBuyDao.getIOSupplierCurrent(order_id);
		}

		return orderIOCurrentInfo;
	}
	
	public List<SellNBuyBuyBean> getIOdata(String order_id) {
		return sellNBuyDao.getIOdata(order_id);
	}
	
	public void updateBulk(String order_id) {
		sellNBuyDao.updateBulk(order_id);
	}

}