package kr.co.kfm.beans;

public class SellNBuyContentbean {

	//πﬂ¡÷
	private String order_state;
	private String order_date;
	private String order_id;
	private String logistics_center_id;
	private String product_id;
	private int quantity;
	private int actual_selling_price;
	private String memo;
	private String user_idx;
	
	private String supplier_id;
	
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getLogistics_center_id() {
		return logistics_center_id;
	}
	public void setLogistics_center_id(String logistics_center_id) {
		this.logistics_center_id = logistics_center_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getActual_selling_price() {
		return actual_selling_price;
	}
	public void setActual_selling_price(int actual_selling_price) {
		this.actual_selling_price = actual_selling_price;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(String user_idx) {
		this.user_idx = user_idx;
	}
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	
	
	
}
