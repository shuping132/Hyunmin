package kr.co.kfm.service;

import java.text.NumberFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kfm.beans.OrderData;
import kr.co.kfm.beans.OrderSituationBean;
import kr.co.kfm.beans.UserBean;
import kr.co.kfm.dao.OrderSituationDao;

@Service
public class OrderSituationService {

	@Autowired
	private OrderSituationDao orderSituationDao;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	public List<OrderSituationBean> getOrderData(String order_state, String company_id) {
		List<OrderSituationBean> orderData;
		if (company_id.substring(0, 2).equals("LC")) {
			orderData = orderSituationDao.getLogisticsOrderData(order_state, company_id);
			System.out.println("LC" + orderData);
		} else {
			orderData = orderSituationDao.getSupplierOrderData(order_state, company_id);
			System.out.println("SP" + orderData);
		}

		NumberFormat numberFormat = NumberFormat.getInstance();
		orderData.forEach(item -> item.setFormat_total_price(numberFormat.format(item.getTotal_price())));
		return orderData;
	}

	public List<OrderSituationBean> getOrderWaitData(String company_id) {
		List<OrderSituationBean> orderData;
		System.out.println(company_id);
		System.out.println("���̵�" + company_id.substring(0, 2));
		if (company_id.substring(0, 2).equals("LC")) {
			orderData = orderSituationDao.getLogisticsOrderWaitData(company_id);
			System.out.println("LCwait" + orderData);
		} else {
			orderData = orderSituationDao.getSupplierOrderWaitData(company_id);
			System.out.println("SPwait" + orderData);
		}

		NumberFormat numberFormat = NumberFormat.getInstance();
		orderData.forEach(item -> item.setFormat_total_price(numberFormat.format(item.getTotal_price())));
		return orderData;
	}

	public OrderSituationBean getOrderInfo(String order_id, String company_id) {
		OrderSituationBean orderInfo;
		if (company_id.substring(0, 2).equals("LC")) {
			orderInfo = orderSituationDao.getLogisticsOrderInfo(order_id);
		} else {
			orderInfo = orderSituationDao.getSupplierOrderInfo(order_id);
		}

		return orderInfo;
	}

	public List<OrderSituationBean> getOrderProductInfo(String order_id, String company_id) {
		List<OrderSituationBean> orderProductInfo;
		if (company_id.substring(0, 2).equals("LC")) {
			orderProductInfo = orderSituationDao.getLogisticsOrderProductInfo(order_id);
		} else {
			orderProductInfo = orderSituationDao.getSupplierOrderProductInfo(order_id);
		}
		NumberFormat numberFormat = NumberFormat.getInstance();
		orderProductInfo.forEach(item -> {
			item.setFormat_total_price(numberFormat.format(item.getSell_price() * item.getQuantity()));
			item.setFormat_sell_price(numberFormat.format(item.getSell_price()));
			item.setTotal_price(item.getSell_price() * item.getQuantity());
		});
		return orderProductInfo;
	}

	public List<OrderSituationBean> getIOCurrent(String order_id, String company_id) {
		List<OrderSituationBean> orderIOCurrentInfo;
		if (company_id.substring(0, 2).equals("LC")) {
			orderIOCurrentInfo = orderSituationDao.getIOLogisticsCurrent(order_id);
		} else {
			orderIOCurrentInfo = orderSituationDao.getIOSupplierCurrent(order_id);
		}

		return orderIOCurrentInfo;
	}

	public void updateOrdersState(OrderData orderData) {
		System.out.println("orderData.getReject_memo()" + orderData.getOrder_state());
		if (orderData.getOrder_state().toString().equals("반려")) {
			orderSituationDao.updateRejectOrdersState(orderData);
		} else {
			orderSituationDao.updateOrdersState(orderData);
		}
	}
	
	public List<OrderSituationBean> getRecentOrders(){
		if (loginUserBean.getCompanyid().startsWith("F")) {
			return orderSituationDao.getRecentFranchiseeOrders(loginUserBean.getCompanyid());
		} else if (loginUserBean.getCompanyid().startsWith("L")) {
			return orderSituationDao.getRecentLogisticsOrders(loginUserBean.getCompanyid());
		}
		return null;
	}

}
