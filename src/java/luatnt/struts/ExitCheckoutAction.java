/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.struts;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

/**
 *
 * @author Lonaldo
 */
public class ExitCheckoutAction {
    
    private final String SUCCESS = "success";
    
    public ExitCheckoutAction() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        session.remove("CART");
        session.remove("ORDER");
        return SUCCESS;
    }
    
}
