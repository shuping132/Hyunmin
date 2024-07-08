package kr.co.kfm.beans;

public class Logistics_center_productBean {
	private String logisticsCenterId;
	private String productId;
	private String expirationDate;
	private int currentStock;
	private int warehouseNumber;
	private int safeStock;
	
	public String getLogisticsCenterId() {
		return logisticsCenterId;
	}
	public void setLogisticsCenterId(String logisticsCenterId) {
		this.logisticsCenterId = logisticsCenterId;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public int getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}
	public int getWarehouseNumber() {
		return warehouseNumber;
	}
	public void setWarehouseNumber(int warehouseNumber) {
		this.warehouseNumber = warehouseNumber;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getSafeStock() {
		return safeStock;
	}
	public void setSafeStock(int safeStock) {
		this.safeStock = safeStock;
	}
}
