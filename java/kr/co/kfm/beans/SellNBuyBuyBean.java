package kr.co.kfm.beans;

import java.util.List;

public class SellNBuyBuyBean {

	private String order_id;
	private String product_id;
	private String supplier_id;
	private String user_idx;
	private String order_date;
	private String due_date;
	private String order_state;
	private int quantity;
	private String memo;
	private String franchisee_id;
	private String logistics_center_id;
	private String company_id;
	private int total_price;
	private String name;
	private int initial_quantity;
	private int buy_price;
	private String company_name;
	private int product_count;
	private int completeio;
	private int counting;
	private int sell_price;
	private String format_sell_price;
	private String format_total_price;
	private String address;
	private String brand;
	private String img;
	private String specifications;
	private String classification;
	private String io_id;
	private String io_date;
	private int product_quantity;
	private int total_quantity;

	private String startDate;
	private String endDate;

	private List<OrderDetail> orderDetails;

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
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

	public int getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(int buy_price) {
		this.buy_price = buy_price;
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

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getLogistics_center_id() {
		return logistics_center_id;
	}

	public void setLogistics_center_id(String logistics_center_id) {
		this.logistics_center_id = logistics_center_id;
	}

	// Getters and Setters
	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getOrder_state() {
		return order_state;
	}

	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public int getProduct_count() {
		return product_count;
	}

	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}

	public int getCompleteio() {
		return completeio;
	}

	public void setCompleteio(int completeio) {
		this.completeio = completeio;
	}

	public int getCounting() {
		return counting;
	}

	public void setCounting(int counting) {
		this.counting = counting;
	}

	public int getSell_price() {
		return sell_price;
	}

	public void setSell_price(int sell_price) {
		this.sell_price = sell_price;
	}

	public String getFormat_sell_price() {
		return format_sell_price;
	}

	public void setFormat_sell_price(String format_sell_price) {
		this.format_sell_price = format_sell_price;
	}

	public String getFormat_total_price() {
		return format_total_price;
	}

	public void setFormat_total_price(String format_total_price) {
		this.format_total_price = format_total_price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getIo_id() {
		return io_id;
	}

	public void setIo_id(String io_id) {
		this.io_id = io_id;
	}

	public String getIo_date() {
		return io_date;
	}

	public void setIo_date(String io_date) {
		this.io_date = io_date;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public int getTotal_quantity() {
		return total_quantity;
	}

	public void setTotal_quantity(int total_quantity) {
		this.total_quantity = total_quantity;
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

	@Override
	public String toString() {
		return "SellNBuyBuyBean [order_id=" + order_id + ", product_id=" + product_id + ", supplier_id=" + supplier_id
				+ ", user_idx=" + user_idx + ", order_date=" + order_date + ", due_date=" + due_date + ", order_state="
				+ order_state + ", quantity=" + quantity + ", memo=" + memo + ", franchisee_id=" + franchisee_id
				+ ", logistics_center_id=" + logistics_center_id + ", company_id=" + company_id + ", total_price="
				+ total_price + ", name=" + name + ", initial_quantity=" + initial_quantity + ", buy_price=" + buy_price
				+ ", company_name=" + company_name + ", product_count=" + product_count + ", completeio=" + completeio
				+ ", counting=" + counting + ", sell_price=" + sell_price + ", format_sell_price=" + format_sell_price
				+ ", format_total_price=" + format_total_price + ", address=" + address + ", brand=" + brand + ", img="
				+ img + ", specifications=" + specifications + ", classification=" + classification + ", io_id=" + io_id
				+ ", io_date=" + io_date + ", product_quantity=" + product_quantity + ", total_quantity="
				+ total_quantity + ", startDate=" + startDate + ", endDate=" + endDate + ", orderDetails="
				+ orderDetails + "]";
	}

}
