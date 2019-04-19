/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.struts;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import luatnt.dtos.OrderDTO;

/**
 *
 * @author Lonaldo
 */
public class ConfirmOrderAction {
    private String orderID;
    private String orderDate;
    private String confirmFullName;
    private String confirmPhone;
    private String confirmAddress;
    private String confirmReceiver;
    private String confirmReceiverPhone;
    
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public ConfirmOrderAction() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        OrderDTO dto = new OrderDTO(orderID, orderDate,confirmFullName, confirmPhone, confirmAddress, confirmReceiver, confirmReceiverPhone);
        session.put("ORDERR", dto);
        return SUCCESS;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    
    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    
    public String getConfirmFullName() {
        return confirmFullName;
    }

    public void setConfirmFullName(String confirmFullName) {
        this.confirmFullName = confirmFullName;
    }

    public String getConfirmPhone() {
        return confirmPhone;
    }

    public void setConfirmPhone(String confirmPhone) {
        this.confirmPhone = confirmPhone;
    }

    public String getConfirmAddress() {
        return confirmAddress;
    }

    public void setConfirmAddress(String confirmAddress) {
        this.confirmAddress = confirmAddress;
    }

    public String getConfirmReceiver() {
        return confirmReceiver;
    }

    public void setConfirmReceiver(String confirmReceiver) {
        this.confirmReceiver = confirmReceiver;
    }

    public String getConfirmReceiverPhone() {
        return confirmReceiverPhone;
    }

    public void setConfirmReceiverPhone(String confirmReceiverPhone) {
        this.confirmReceiverPhone = confirmReceiverPhone;
    }
    
    
    
}
