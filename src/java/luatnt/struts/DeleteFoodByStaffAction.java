/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.struts;

import luatnt.daos.FoodDAO;

/**
 *
 * @author Lonaldo
 */
public class DeleteFoodByStaffAction {
    private String delFoodID;
    private String lastSearchValue;
    
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public DeleteFoodByStaffAction() {
    }
    
    public String execute() throws Exception {
        FoodDAO dao = new FoodDAO();
        boolean result = dao.deleteFoodByStaff(delFoodID);
        String url = FAIL;
        if (result) {
            url = SUCCESS;
        }
        return url;
    }

    public String getDelFoodID() {
        return delFoodID;
    }

    public void setDelFoodID(String delFoodID) {
        this.delFoodID = delFoodID;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
}
