/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import luatnt.dtos.OrderDTO;
import luatnt.dtos.ProductDTO;
import luatnt.utils.DBUtils;

/**
 *
 * @author Lonaldo
 */
public class OrderDAO {
    public void saveToOrder(String orderID, String orderDate, String username, float total) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO tbl_order Values(?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, orderID);
                System.out.println(orderID + " " + orderDate + " " + username + " " + total);
                stm.setDate(2, Date.valueOf("2018-12-13"));
                stm.setString(3, username);
                stm.setFloat(4, total);
                int result = stm.executeUpdate();
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public void saveToOrderDetail(ProductDTO product, int quantity, OrderDTO order) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO tbl_orderDetail Values(?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, product.getProductID());
                stm.setInt(2, quantity);
                stm.setFloat(3, product.getPrice());
                stm.setFloat(4, product.getPrice() * quantity);
                stm.setString(5, order.getOrderID());
                stm.setString(6, order.getReceiver());
                stm.setString(7, order.getReceiverPhone());
                stm.setString(8, order.getAddress());
                int result = stm.executeUpdate();
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
