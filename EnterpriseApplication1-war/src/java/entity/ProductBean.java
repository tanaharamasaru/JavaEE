/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author BBC300198
 */
public class ProductBean {

    private String productId;
    private String productName;
    private int price;
    private String detail;
    private String path;
    private int stock;
    private Category categoryCd;
    private int amount;
    
    ProductBean(){}

    public ProductBean(String productId, String productName, int price, String detail, String path, int stock, Category categoryCd, int amount) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.detail = detail;
        this.path = path;
        this.stock = stock;
        this.categoryCd = categoryCd;
        this.amount = amount;
    }
    
    /**
     * @return the productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @return the categoryCd
     */
    public Category getCategoryCd() {
        return categoryCd;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @param categoryCd the categoryCd to set
     */
    public void setCategoryCd(Category categoryCd) {
        this.categoryCd = categoryCd;
    }
    
    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
