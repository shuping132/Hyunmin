package kr.co.kfm.beans;

public class product_HistoryBean {
	private int history_id;
	private String logistics_center_id;
	private String franchisee_id;
	private String product_id;
	private String product_name;
	private int changed_stock;
	private int past_stock;
	private int current_stock;
	
	public int getHistory_id() {
		return history_id;
	}
	public void setHistory_id(int history_id) {
		this.history_id = history_id;
	}
	public String getLogistics_center_id() {
		return logistics_center_id;
	}
	public void setLogistics_center_id(String logistics_center_id) {
		this.logistics_center_id = logistics_center_id;
	}
	public String getFranchisee_id() {
		return franchisee_id;
	}
	public void setFranchisee_id(String franchisee_id) {
		this.franchisee_id = franchisee_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getChanged_stock() {
		return changed_stock;
	}
	public void setChanged_stock(int changed_stock) {
		this.changed_stock = changed_stock;
	}
	public int getPast_stock() {
		return past_stock;
	}
	public void setPast_stock(int past_stock) {
		this.past_stock = past_stock;
	}
	public int getCurrent_stock() {
		return current_stock;
	}
	public void setCurrent_stock(int current_stock) {
		this.current_stock = current_stock;
	}
	
	

}
