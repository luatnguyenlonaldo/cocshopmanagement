/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.cart;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.naming.NamingException;
import luatnt.daos.ProductDAO;
import luatnt.dtos.ProductDTO;

/**
 *
 * @author Lonaldo
 */
public class CartObj implements Serializable {
    private String customerID;
    private String orderID;
    private Map<ProductDTO, Integer> products;

    public CartObj() {
        this.orderID = genOrderID();
    }
    
    public int size() {
        return products.size();
    }
    
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Map<ProductDTO, Integer> getProducts() {
        return products;
    }
 
    public void setProducts(Map<ProductDTO, Integer> products) {
        this.products = products;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    
    private String genOrderID() {
        return String.format("FU_CS%08d", System.currentTimeMillis() % 100000000);
    }
    
    public void addProductToCart(ProductDTO product) {
        if (products == null) {
            products = new HashMap<>();
        }
        int quantity = 1;
        if (products.containsKey(product)) {
            quantity = products.get(product) + 1;
        }
        products.put(product, quantity);
    }
    
    public void removeProductFromCart(ProductDTO product) {
        if (products == null) {
            return;
        }
        
        if (products.containsKey(product)) {
            products.remove(product);
            if (products.isEmpty()) {
                products = null;
            }
        }
    }
    
    public void removeProductFromCart(String id) throws SQLException, NamingException {
        if (products == null) {
            return;
        }
        ProductDAO dao = new ProductDAO();
        ProductDTO dto = dao.getProduct(id);
        
        if (products.containsKey(dto)) {
            products.remove(dto);
            if (products.isEmpty()) {
                products = null;
            }
        }
    }
    
    public float getTotal() {
        float total = 0;
        for (Map.Entry<ProductDTO, Integer> element : products.entrySet()) {
            total += element.getValue() * element.getKey().getPrice();
        }
        return total;
    }
 }
