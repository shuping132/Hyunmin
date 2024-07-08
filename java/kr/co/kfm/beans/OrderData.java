package kr.co.kfm.beans;

import java.util.List;

public class OrderData {

	private String order_id;
	private String user_idx;
	private String order_date;
	private String memo;
	private String order_state;
	private String buy_price;

	private String product_id;
	private String due_date;
	private int quantity;
	private String franchisee_id;
	private String supplier_id;
	private String logistics_center_id;
	private String company_id;
	private String recipient_id;

	private int total_price;
	private String name;
	private int initial_quantity;

	private String startDate;
	private String endDate;
	
	private String reject_memo;

	private List<OrderDetail> orderDetails;

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLogistics_center_id() {
		return logistics_center_id;
	}

	public void setLogistics_center_id(String logistics_center_id) {
		this.logistics_center_id = logistics_center_id;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInitial_quantity() {
		return initial_quantity;
	}

	public void setInitial_quantity(int initial_quantity) {
		this.initial_quantity = initial_quantity;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(String buy_price) {
		this.buy_price = buy_price;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(String user_idx) {
		this.user_idx = user_idx;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOrder_state() {
		return order_state;
	}

	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getFranchisee_id() {
		return franchisee_id;
	}

	public void setFranchisee_id(String franchisee_id) {
		this.franchisee_id = franchisee_id;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	public String getRecipient_id() {
		return recipient_id;
	}

	public void setRecipient_id(String recipient_id) {
		this.recipient_id = recipient_id;
	}

	public String getReject_memo() {
		return reject_memo;
	}

	public void setReject_memo(String reject_memo) {
		this.reject_memo = reject_memo;
	}

	@Override
	public String toString() {
		return "OrderData [order_id=" + order_id + ", user_idx=" + user_idx + ", order_date=" + order_date + ", memo="
				+ memo + ", order_state=" + order_state + ", buy_price=" + buy_price + ", product_id=" + product_id
				+ ", due_date=" + due_date + ", quantity=" + quantity + ", franchisee_id=" + franchisee_id
				+ ", supplier_id=" + supplier_id + ", logistics_center_id=" + logistics_center_id + ", company_id="
				+ company_id + ", total_price=" + total_price + ", name=" + name + ", initial_quantity="
				+ initial_quantity + ", startDate=" + startDate + ", endDate=" + endDate + ", orderDetails="
				+ orderDetails + "]";
	}

}
