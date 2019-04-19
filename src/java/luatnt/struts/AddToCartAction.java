/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.struts;

import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
import luatnt.cart.CartObj;
import luatnt.daos.ProductDAO;
import luatnt.dtos.ProductDTO;

/**
 *
 * @author Lonaldo
 */
public class AddToCartAction {
    private String foodID;
    private List<ProductDTO> productList;
    private String lastSearchValue;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public AddToCartAction() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        CartObj cart = (CartObj) session.get("CART");
        if (cart == null) {
            cart = new CartObj();
        }
        ProductDAO dao = new ProductDAO();
        ProductDTO dto = dao.getProduct(foodID);
        cart.addProductToCart(dto);
        session.put("CART", cart);
        dao.getAllProduct();
        productList = dao.getFoodList();
        return SUCCESS;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
    
}
