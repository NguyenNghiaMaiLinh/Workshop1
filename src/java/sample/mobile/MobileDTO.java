/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.mobile;

/**
 *
 * @author Mai Linh
 */
public class MobileDTO {

    private String mobileId;
    private String description;
    private Float price;
    private String mobileName;
    private int yearOfProduction;
    private int quantity;
    private boolean notSale;

    public MobileDTO(String mobileId, String description, Float price, String mobileName, int yearOfProduction, int quantity, boolean notSale) {
        this.mobileId = mobileId;
        this.description = description;
        this.price = price;
        this.mobileName = mobileName;
        this.yearOfProduction = yearOfProduction;
        this.quantity = quantity;
        this.notSale = notSale;
    }

    public MobileDTO() {
    }

    /**
     * @return the mobileId
     */
    public String getMobileId() {
        return mobileId;
    }

    /**
     * @param mobileId the mobileId to set
     */
    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * @return the mobileName
     */
    public String getMobileName() {
        return mobileName;
    }

    /**
     * @param mobileName the mobileName to set
     */
    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    /**
     * @return the yearOfProduction
     */
    public int getYearOfProduction() {
        return yearOfProduction;
    }

    /**
     * @param yearOfProduction the yearOfProduction to set
     */
    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the notSale
     */
    public boolean isNotSale() {
        return notSale;
    }

    /**
     * @param notSale the notSale to set
     */
    public void setNotSale(boolean notSale) {
        this.notSale = notSale;
    }

}
