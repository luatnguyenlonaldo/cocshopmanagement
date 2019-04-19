/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import luatnt.dtos.ProductDTO;
import luatnt.utils.DBUtils;

/**
 *
 * @author Lonaldo
 */
public class ProductDAO implements Serializable {
    private List<ProductDTO> foodList;

    public List<ProductDTO> getFoodList() {
        return foodList;
    }

    public void getAllProduct() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT foodID, foodName, price, type FROM tbl_Food";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String foodID = rs.getString("foodID");
                    String foodName = rs.getString("foodName");
                    float price = rs.getFloat("price");
                    String type = rs.getString("type");
                    ProductDTO dto = new ProductDTO(foodID, foodName, price, type);
                    
                    if (foodList == null) {
                        foodList = new ArrayList<>();
                    }
                    foodList.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public ProductDTO getProduct(String id) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT foodName, price, type FROM tbl_Food WHERE foodID=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String foodName = rs.getString("foodName");
                    float price = rs.getFloat("price");
                    String type = rs.getString("type");
                    
                    ProductDTO dto = new ProductDTO(id, foodName, price, type);
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
}
