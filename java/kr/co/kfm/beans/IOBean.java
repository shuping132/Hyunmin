package kr.co.kfm.beans;

public class IOBean {
	private String img;
	private String name;
	private String classification;
	private String brand;
	private String specifications;
	private int inputQuantity;
	private int outputQuantity;
	private int IOQuantity;
	private int current_stock;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public int getInputQuantity() {
		return inputQuantity;
	}

	public void setInputQuantity(int inputQuantity) {
		this.inputQuantity = inputQuantity;
	}

	public int getOutputQuantity() {
		return outputQuantity;
	}

	public void setOutputQuantity(int outputQuantity) {
		this.outputQuantity = outputQuantity;
	}

	public int getIOQuantity() {
		return IOQuantity;
	}

	public void setIOQuantity(int iOQuantity) {
		IOQuantity = iOQuantity;
	}

	public int getCurrent_stock() {
		return current_stock;
	}

	public void setCurrent_stock(int current_stock) {
		this.current_stock = current_stock;
	}

	@Override
	public String toString() {
		return "IOBean [img=" + img + ", name=" + name + ", classification=" + classification + ", brand=" + brand
				+ ", specifications=" + specifications + ", inputQuantity=" + inputQuantity + ", outputQuantity="
				+ outputQuantity + ", IOQuantity=" + IOQuantity + ", current_stock=" + current_stock + "]";
	}

}
