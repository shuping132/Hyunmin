package kr.co.kfm.beans;

import java.sql.Date;

public class IOsumBean {
	
	private String productId; // ��ǰ��ȣ
    private String name; // ��ǰ��
    private String img; // ��ǰ����
    private double buyPrice; // ���Ű�
    private double sellPrice; // �ǸŰ�
    private int initialQuantity; // �ʱ����
    private String specifications; // ��ǰ�԰�
    private String classification; // ��ǰ�з�
    private String brand; // �귣��
    private String ioId; // ������ȣ
    private String orderId; // ���ֹ�ȣ
    private Date data; // �������
    private int quantity; // �������
    private String division; // ����� ����
    
	public String getIoId() {
		return ioId;
	}
	public void setIoId(String ioId) {
		this.ioId = ioId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
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
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public int getInitialQuantity() {
		return initialQuantity;
	}
	public void setInitialQuantity(int initialQuantity) {
		this.initialQuantity = initialQuantity;
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
    
    
    
}
