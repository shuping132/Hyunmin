package kr.co.kfm.beans;

public class SellNBuyLogisticsCenterInventoryBean {
	
	private String logistics_center_id;
    private String product_id;
    private int current_stock;
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
	public int getCurrent_stock() {
		return current_stock;
	}
	public void setCurrent_stock(int current_stock) {
		this.current_stock = current_stock;
	}
    
    

	
}
