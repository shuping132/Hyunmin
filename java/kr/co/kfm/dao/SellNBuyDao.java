package kr.co.kfm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kfm.beans.OrderData;
import kr.co.kfm.beans.OrderDetail;
import kr.co.kfm.beans.OrderSituationBean;
import kr.co.kfm.beans.SellNBuyBuyBean;
import kr.co.kfm.beans.SellNBuyContentbean;
import kr.co.kfm.beans.SellNBuyIOBean;
import kr.co.kfm.mapper.SellNBuyMapper;

@Repository
public class SellNBuyDao {

	@Autowired
	private SellNBuyMapper sellNBuyMapper;

	// ���� ���
	public List<SellNBuyContentbean> getBuyList() {
		return sellNBuyMapper.getBuyList();
	}

	// �Ǹ� ���
	public List<SellNBuyContentbean> getSellList() {
		return sellNBuyMapper.getSellList();
	}

	// ���ּ� �ۼ�
	/*
	 * public void insertOrderform(SellNBuyBuyBean orderform) {
	 * sellNBuyMapper.insertOrder(orderform);
	 * sellNBuyMapper.insertLogisticsOrder(orderform);
	 * sellNBuyMapper.insertLogisticsOrderProduct(orderform); }
	 */

	public void insertOrder(OrderData orderData) {
		sellNBuyMapper.insertOrder(orderData);
	}

	public void insertLogisticsOrder(OrderData orderData) {
		sellNBuyMapper.insertLogisticsOrder(orderData);
	}

	public void insertSupplierOrder(OrderData orderData) {
		sellNBuyMapper.insertSupplierOrder(orderData);
	}

	public void insertLogisticsOrderProduct(OrderDetail orderDetail) {
		sellNBuyMapper.insertLogisticsOrderProduct(orderDetail);
	}

	public void insertSupplierOrderProduct(OrderDetail orderDetail) {
		sellNBuyMapper.insertSupplierOrderProduct(orderDetail);
	}

	/*
	 * public List<OrderDetail> getOrderDetail(String order_id) { return
	 * sellNBuyMapper.getOrderDetails(order_id); }
	 */

	// ���ּ����� �ŷ�ó ���
	public List<SellNBuyBuyBean> getSupplierList(String company_id) {
		return sellNBuyMapper.getSupplierList(company_id);
	}

	public List<SellNBuyBuyBean> getLogisticsList(String company_id) {
		return sellNBuyMapper.getLogisticsList(company_id);
	}

	// ��Ӵٿ�� ������ ��ǰ�� ��� ���� Ƽ�ٵ� ���
	public List<SellNBuyBuyBean> searchProduct(String product_id) {
		List<SellNBuyBuyBean> products = sellNBuyMapper.searchProduct(product_id);
		return products;
	}

	// ��Ӵٿ� �޴��� name�� ���
	public List<SellNBuyBuyBean> getProductname(String company_id) {
		List<SellNBuyBuyBean> productNames = sellNBuyMapper.getProductname(company_id);
		return productNames;
	}

	// ���� �ֹ� ����
	public OrderData getFranchiseeOrderData(String order_id) {
		return sellNBuyMapper.getLogisticsOrderData(order_id);
	}

	public OrderData getLogisticsOrderData(String order_id) {
		return sellNBuyMapper.getLogisticsOrderData(order_id);
	}

	// ���� �� ����
	public List<OrderDetail> getFranchiseeOrderDetails(String order_id) {
		return sellNBuyMapper.getFranchiseeOrderDetails(order_id);
	}

	public List<OrderDetail> getLogisticsOrderDetails(String order_id) {
		return sellNBuyMapper.getLogisticsOrderDetails(order_id);
	}

	// ���ּ� �󼼿��� �԰��ϱ�
	public void insertIO(SellNBuyIOBean io) {
		sellNBuyMapper.insertIO(io);
	}

	public void updateFranchiseeInventory(String company_id, String product_id, int quantity) {
		sellNBuyMapper.updateLogisticsCenterInventory(company_id, product_id, quantity);
	}

	public void updateLogisticsCenterInventory(String company_id, String product_id, int quantity) {
		sellNBuyMapper.updateLogisticsCenterInventory(company_id, product_id, quantity);
	}

	public List<OrderDetail> getDetails(String orderId) {
		return sellNBuyMapper.getDetails(orderId);
	}

	public List<SellNBuyBuyBean> getFranchiseeOrderInfo(String company_id) {
		return sellNBuyMapper.getFranchiseeOrderInfo(company_id);
	}

	public List<SellNBuyBuyBean> getLogisticsOrderInfo(String company_id) {
		return sellNBuyMapper.getLogisticsOrderInfo(company_id);
	}

	public List<SellNBuyBuyBean> getFranchiseeOrderStateInfo(String company_id, String order_state) {
		return sellNBuyMapper.getFranchiseeOrderStateInfo(company_id, order_state);
	}

	public List<SellNBuyBuyBean> getLogisticsOrderStateInfo(String company_id, String order_state) {
		return sellNBuyMapper.getLogisticsOrderStateInfo(company_id, order_state);
	}

	public SellNBuyBuyBean getLogisticsOrdersInfo(String order_id) {
		return sellNBuyMapper.getLogisticsOrdersInfo(order_id);
	}

	public List<SellNBuyBuyBean> getLogisticsOrdersProductInfo(String order_id) {
		return sellNBuyMapper.getLogisticsOrdersProductInfo(order_id);
	}

	public SellNBuyBuyBean getSupplierOrdersInfo(String order_id) {
		return sellNBuyMapper.getSupplierOrdersInfo(order_id);
	}

	public List<SellNBuyBuyBean> getSupplierOrdersProductInfo(String order_id) {
		return sellNBuyMapper.getSupplierOrdersProductInfo(order_id);
	}

	public List<SellNBuyBuyBean> getIOdata(String order_id) {
		return sellNBuyMapper.getIOdata(order_id);
	}

	public List<SellNBuyBuyBean> getIOLogisticsCurrent(String order_id) {
		return sellNBuyMapper.getIOLogisticsCurrent(order_id);
	}

	public List<SellNBuyBuyBean> getIOSupplierCurrent(String order_id) {
		return sellNBuyMapper.getIOSupplierCurrent(order_id);
	}

	public void updateBulk(String order_id) {
		sellNBuyMapper.updateBulk(order_id);
	}

}
