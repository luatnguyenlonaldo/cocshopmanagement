/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.dtos;

import java.io.Serializable;

/**
 *
 * @author Lonaldo
 */
public class ProductDTO implements Serializable {
    private String productID;
    private String productName;
    private float price;
    private String type;

    public ProductDTO() {
    }

    public ProductDTO(String productID, String productName, float price, String type) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.type = type;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ProductDTO)) {
            return false;
        }
        ProductDTO other = (ProductDTO) obj;
        
        if ((this.productID == null && other.productID != null) 
                || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }    
    
}
