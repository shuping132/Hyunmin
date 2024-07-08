package kr.co.kfm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kfm.beans.OrderData;
import kr.co.kfm.beans.OrderSituationBean;
import kr.co.kfm.mapper.OrderSituationMapper;

@Repository
public class OrderSituationDao {

	@Autowired
	private OrderSituationMapper orderSituationMapper;
	
	public List<OrderSituationBean> getLogisticsOrderData(String order_state, String company_id){
		return orderSituationMapper.getLogisticsOrderData(order_state, company_id);
	}
	
	public List<OrderSituationBean> getLogisticsOrderWaitData(String company_id){
		return orderSituationMapper.getLogisticsOrderWaitData(company_id);
	}
	
	public List<OrderSituationBean> getSupplierOrderData(String order_state, String company_id){
		return orderSituationMapper.getSupplierOrderData(order_state, company_id);
	}
	
	public List<OrderSituationBean> getSupplierOrderWaitData(String company_id){
		return orderSituationMapper.getSupplierOrderWaitData(company_id);
	}
	
	public OrderSituationBean getLogisticsOrderInfo(String order_id) {
		return orderSituationMapper.getLogisticsOrderInfo(order_id);
	}
	
	public List<OrderSituationBean> getLogisticsOrderProductInfo(String order_id){
		return orderSituationMapper.getLogisticsOrderProductInfo(order_id);
	}
	
	public OrderSituationBean getSupplierOrderInfo(String order_id) {
		return orderSituationMapper.getSupplierOrderInfo(order_id);
	}
	
	public List<OrderSituationBean> getSupplierOrderProductInfo(String order_id){
		return orderSituationMapper.getSupplierOrderProductInfo(order_id);
	}
	
	public List<OrderSituationBean> getIOdata(@Param("order_id")String order_id){
		return orderSituationMapper.getIOdata(order_id);
	}
	
	public List<OrderSituationBean> getIOLogisticsCurrent(@Param("order_id") String order_id){
		return orderSituationMapper.getIOLogisticsCurrent(order_id);
	}
	
	public List<OrderSituationBean> getIOSupplierCurrent(@Param("order_id") String order_id){
		return orderSituationMapper.getIOSupplierCurrent(order_id);
	}
	
	public void updateOrdersState(OrderData orderData) {
		orderSituationMapper.updateOrdersState(orderData);
	}
	
	public void updateRejectOrdersState(OrderData orderData) {
		orderSituationMapper.updateRejectOrdersState(orderData);
	}
	
	public List<OrderSituationBean> getRecentFranchiseeOrders(String company_id){
		return orderSituationMapper.getRecentFranchiseeOrders(company_id);
	}
	
	public List<OrderSituationBean> getRecentLogisticsOrders(String company_id){
		return orderSituationMapper.getRecentLogisticsOrders(company_id);
	}
	
}
