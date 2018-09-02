package com.sabbirtech.foodvilla.Model;

/**
 * Created by SABBIR TECH on 15-Aug-18.
 */

public class order {

    private String ProductId,ProductNamne,Quantity,Price,Discount;

    public order() {
    }

    public order(String productId, String productNamne, String quantity, String price, String discount) {
        ProductId = productId;
        ProductNamne = productNamne;
        Quantity = quantity;
        Price = price;
        Discount = discount;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductNamne() {
        return ProductNamne;
    }

    public void setProductNamne(String productNamne) {
        ProductNamne = productNamne;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }
}
