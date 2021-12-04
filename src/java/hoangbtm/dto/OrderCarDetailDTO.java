/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.dto;

/**
 *
 * @author Hoang
 */
public class OrderCarDetailDTO {
    private int orderDetailId;
    private int orderId;
    private int product_id;
    private String product_name;
    private double product_price;
    private int quantity;
    private String product_image;

    public OrderCarDetailDTO(int orderDetailId, int orderId, int product_id, String product_name, double product_price, int quantity, String product_image) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.quantity = quantity;
        this.product_image = product_image;
    }

    public OrderCarDetailDTO() {
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    @Override
    public String toString() {
        return "OrderBookDetail{" + "orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", product_id=" + product_id + ", product_name=" + product_name + ", product_price=" + product_price + ", quantity=" + quantity + ", product_image=" + product_image + '}';
    }
    
    
}
