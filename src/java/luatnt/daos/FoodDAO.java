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
import luatnt.dtos.FoodDTO;
import luatnt.utils.DBUtils;

/**
 *
 * @author Lonaldo
 */
public class FoodDAO implements Serializable {
    public List<FoodDTO> searchFood(String keyword) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        List<FoodDTO> list = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT foodID, foodName, price, type, status FROM tbl_Food WHERE foodName LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + keyword + "%");
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    String foodID = rs.getString("foodID");
                    String foodName = rs.getString("foodName");
                    float price = rs.getFloat("price");
                    String type = rs.getString("type");
                    boolean status = rs.getBoolean("status");
                    list.add(new FoodDTO(foodID, foodName, price, type, status));
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
        return list;
    }
    
    public boolean deleteFoodByStaff(String delFoodID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "DELETE FROM tbl_Food WHERE foodID=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, delFoodID);
                
                int result = stm.executeUpdate();
                if (result > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean updateFoodByStaff(String foodID, String foodName, float price, String type) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE tbl_Food SET foodName=?, price=?, type=? WHERE foodID=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, foodName);
                stm.setFloat(2, price);
                stm.setString(3, type);
                stm.setString(4, foodID);
                
                int result = stm.executeUpdate();
                if (result > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean addNewFoodByStaff(String foodID, String foodName, float price, String type) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO tbl_Food Values(?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, foodID);
                stm.setString(2, foodName);
                stm.setFloat(3, price);
                stm.setString(4, type);
                
                int result = stm.executeUpdate();
                if (result > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
