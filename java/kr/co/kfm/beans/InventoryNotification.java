package kr.co.kfm.beans;

public class InventoryNotification {
    private String productName;

    public InventoryNotification(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
