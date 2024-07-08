package kr.co.kfm.beans;

public class SafetyBean {
	private String product_id;
	private String name;
	private String img;
	private int current_stock;
	private int safe_stock;
	private int logistics_center_id;
	private int franchisee_id;
	private String order_id;

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getCurrent_stock() {
		return current_stock;
	}

	public void setCurrent_stock(int current_stock) {
		this.current_stock = current_stock;
	}

	public int getSafe_stock() {
		return safe_stock;
	}

	public void setSafe_stock(int safe_stock) {
		this.safe_stock = safe_stock;
	}

	public int getLogistics_center_id() {
		return logistics_center_id;
	}

	public void setLogistics_center_id(int logistics_center_id) {
		this.logistics_center_id = logistics_center_id;
	}

	public int getFranchisee_id() {
		return franchisee_id;
	}

	public void setFranchisee_id(int franchisee_id) {
		this.franchisee_id = franchisee_id;
	}

	@Override
	public String toString() {
		return "SafetyBean [product_id=" + product_id + ", name=" + name + ", img=" + img + ", current_stock="
				+ current_stock + ", safe_stock=" + safe_stock + ", logistics_center_id=" + logistics_center_id
				+ ", franchisee_id=" + franchisee_id + "]";
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

}
