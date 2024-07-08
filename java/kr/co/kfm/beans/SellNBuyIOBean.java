package kr.co.kfm.beans;

public class SellNBuyIOBean {

	private String io_id;
	private String product_id;
	private String io_date;
	private int quantity;
	private String division;
	private String order_id;
	private String memo;
	private String user_idx;

	public String getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(String user_idx) {
		this.user_idx = user_idx;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getIo_id() {
		return io_id;
	}

	public void setIo_id(String io_id) {
		this.io_id = io_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getIo_date() {
		return io_date;
	}

	public void setIo_date(String io_date) {
		this.io_date = io_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	@Override
	public String toString() {
		return "SellNBuyIOBean [io_id=" + io_id + ", product_id=" + product_id + ", io_date=" + io_date + ", quantity="
				+ quantity + ", division=" + division + ", order_id=" + order_id + ", memo=" + memo + ", user_idx="
				+ user_idx + "]";
	}

}
