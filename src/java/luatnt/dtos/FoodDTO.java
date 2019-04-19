/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.dtos;

/**
 *
 * @author Lonaldo
 */
public class FoodDTO {
    private String foodID;
    private String foodName;
    private float price;
    private String type;
    private boolean status;

    public FoodDTO() {
    }

    public FoodDTO(String foodID, String foodName, float price, String type, boolean status) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.price = price;
        this.type = type;
        this.status = status;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
}
