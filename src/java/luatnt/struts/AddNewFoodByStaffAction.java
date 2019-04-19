/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.struts;

import com.opensymphony.xwork2.ActionSupport;
import luatnt.daos.FoodDAO;

/**
 *
 * @author Lonaldo
 */
public class AddNewFoodByStaffAction extends ActionSupport {
    public String foodID;
    private String foodName;
    private float price;
    private String type;
    
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public AddNewFoodByStaffAction() {
    }
    
    public String execute() throws Exception {
        FoodDAO dao = new FoodDAO();
        boolean result = dao.addNewFoodByStaff(foodID, foodName, price, type);
        String url = FAIL;
        if (result) {
            url = SUCCESS;
        }
        return url;
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
    
    
}
