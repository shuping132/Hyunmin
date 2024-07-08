package kr.co.kfm.beans;

public class OrderDetail {

	private String product_id;
	private int quantity;
	private int buy_price;
	private String name;
	private String order_id;

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

	public int getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(int buy_price) {
		this.buy_price = buy_price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	@Override
	public String toString() {
		return "OrderDetail [product_id=" + product_id + ", quantity=" + quantity + ", buy_price=" + buy_price
				+ ", name=" + name + ", order_id=" + order_id + "]";
	}

}
