/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.dtos;

import java.util.Date;

/**
 *
 * @author Lonaldo
 */
public class OrderDTO {
    private String orderID;
    private String orderDate;
    private String customer;
    private String phone;
    private String address;
    private String receiver;
    private String receiverPhone;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String orderDate, String customer, String phone, String address, String receiver, String receiverPhone) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.customer = customer;
        this.phone = phone;
        this.address = address;
        this.receiver = receiver;
        this.receiverPhone = receiverPhone;
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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
    
    
}
