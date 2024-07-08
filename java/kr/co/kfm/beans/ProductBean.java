package kr.co.kfm.beans;

import java.sql.Date;

public class ProductBean {
	private String product_id;
	private String name;
	private String img;
	private double buy_price;
	private double sell_price;
	private int initial_quantity;
	private String specifications;
	private String classification;
	private String brand;
	private int safe_stock;
	private String franchisee_id;
	
	private Date expiration_date;
	private int current_stock;
	private int warehouse_number;
	
	private Date date;	
	private String quantity;	
	private String division;
	

	
	public String getFranchisee_id() {
		return franchisee_id;
	}

	public void setFranchisee_id(String franchisee_id) {
		this.franchisee_id = franchisee_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public int getCurrent_stock() {
		return current_stock;
	}

	public void setCurrent_stock(int current_stock) {
		this.current_stock = current_stock;
	}

	public int getWarehouse_number() {
		return warehouse_number;
	}

	public void setWarehouse_number(int warehouse_number) {
		this.warehouse_number = warehouse_number;
	}

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

	public double getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(double buy_price) {
		this.buy_price = buy_price;
	}

	public double getSell_price() {
		return sell_price;
	}

	public void setSell_price(double sell_price) {
		this.sell_price = sell_price;
	}

	public int getInitial_quantity() {
		return initial_quantity;
	}

	public void setInitial_quantity(int initial_quantity) {
		this.initial_quantity = initial_quantity;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getSafe_stock() {
		return safe_stock;
	}

	public void setSafe_stock(int safe_stock) {
		this.safe_stock = safe_stock;
	}

}
