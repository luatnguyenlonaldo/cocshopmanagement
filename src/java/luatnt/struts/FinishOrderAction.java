/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.struts;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import luatnt.cart.CartObj;
import luatnt.daos.OrderDAO;
import luatnt.dtos.OrderDTO;
import luatnt.dtos.ProductDTO;
import luatnt.dtos.UserDTO;

/**
 *
 * @author Lonaldo
 */
public class FinishOrderAction {
    
    private final String SUCCESS = "success";
    
    public FinishOrderAction() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        UserDTO user = (UserDTO) session.get("USERR");
        OrderDTO order = (OrderDTO) session.get("ORDERR");
        CartObj cart = (CartObj) session.get("CART");
        OrderDAO dao = new OrderDAO();
        int count = 0;
        

        dao.saveToOrder(order.getOrderID(), order.getOrderDate(), user.getUsername(), cart.getTotal());
        for (Map.Entry<ProductDTO, Integer> element : cart.getProducts().entrySet()) {
            dao.saveToOrderDetail(element.getKey(), element.getValue(), order);
        }
        session.remove("CART");
        session.remove("ORDERERR");
        return SUCCESS;
    }
    
}
