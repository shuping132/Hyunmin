package kr.co.kfm.beans;

public class OrderSituationBean {

	private String order_id;
	private String name;
	private String company_name;
	private String order_state;
	private String order_date;
	private String due_date;
	private int counting;
	private int sell_price;
	private String format_sell_price;
	private int total_price;
	private String format_total_price;
	private String address;
	private String brand;
	private String img;
	private String specifications;
	private String classification;
	private int quantity;
	private String io_id;
	private String io_date;
	private int product_quantity;
	private int total_quantity;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

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

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public int getCounting() {
		return counting;
	}

	public void setCounting(int counting) {
		this.counting = counting;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSell_price() {
		return sell_price;
	}

	public void setSell_price(int sell_price) {
		this.sell_price = sell_price;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getFormat_sell_price() {
		return format_sell_price;
	}

	public void setFormat_sell_price(String format_sell_price) {
		this.format_sell_price = format_sell_price;
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

	@Override
	public String toString() {
		return "OrderSituationBean [order_id=" + order_id + ", name=" + name + ", company_name=" + company_name
				+ ", order_state=" + order_state + ", order_date=" + order_date + ", due_date=" + due_date
				+ ", counting=" + counting + ", sell_price=" + sell_price + ", total_price=" + total_price
				+ ", format_total_price=" + format_total_price + ", address=" + address + ", brand=" + brand + ", img="
				+ img + ", specifications=" + specifications + ", classification=" + classification + ", quantity="
				+ quantity + "]";
	}

}
