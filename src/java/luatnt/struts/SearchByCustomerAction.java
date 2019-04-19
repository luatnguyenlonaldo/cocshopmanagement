/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.struts;

import java.util.List;
import luatnt.daos.FoodDAO;
import luatnt.dtos.FoodDTO;

/**
 *
 * @author Lonaldo
 */
public class SearchByCustomerAction {
    private String keyword;
    private final String SUCCESS = "success";
    private List<FoodDTO> searchResult = null;
    
    public SearchByCustomerAction() {
    }
    
    public String execute() throws Exception {
        FoodDAO dao = new FoodDAO();
        List<FoodDTO> list = dao.searchFood(keyword);
        if (list != null && !list.isEmpty()) {
            this.searchResult = list;
        }
        return SUCCESS;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<FoodDTO> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<FoodDTO> searchResult) {
        this.searchResult = searchResult;
    }
    
}
