/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.struts;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import luatnt.daos.UserDAO;
import luatnt.dtos.UserDTO;

/**
 *
 * @author Lonaldo
 */
public class LoginAction {
    private String username;
    private String password;
    
    private final String STAFF_SEARCH = "staffSearch";
    private final String CUSTOMER_SEARCH = "customerSearch";
    private final String FAIL = "fail";
    
    public LoginAction() {
    }
    
    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        UserDTO result = dao.checkLogin(username, password);
        String url = FAIL;
        if (result != null) {
            if (result.isIsAdmin()) {
                url = STAFF_SEARCH;
            }
            if (!result.isIsAdmin()) {
                url = CUSTOMER_SEARCH;
            }
            Map session = ActionContext.getContext().getSession();
            session.put("USERR", result);
        }
        return url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
