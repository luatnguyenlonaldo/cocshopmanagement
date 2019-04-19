/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.struts;

import com.opensymphony.xwork2.ActionSupport;
import luatnt.daos.UserDAO;

/**
 *
 * @author Lonaldo
 */
public class RegisterNewAccountAction extends ActionSupport {
    private String username;
    private String password;
    private String confirmPassword;
    private String fullName;
    private String address;
    private String phone;
    
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public RegisterNewAccountAction() {
    }
    
    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        String url = FAIL;
        boolean result = dao.registerNewAccount(username, password, fullName, address, phone);
        if (result) {
            url = SUCCESS;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
