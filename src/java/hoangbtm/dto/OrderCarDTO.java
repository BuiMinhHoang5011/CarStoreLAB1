/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.dto;

import java.sql.Date;

/**
 *
 * @author Hoang
 */
public class OrderCarDTO {
    private int orderId;
    private int accountId;
    private Date createDate;
    private double totalPrice;
    private String discount;
    private int shipping_id;

    public OrderCarDTO() {
    }

    public OrderCarDTO(int orderId, int accountId, Date createDate, double totalPrice, String discount, int shipping_id) {
        this.orderId = orderId;
        this.accountId = accountId;
        this.createDate = createDate;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.shipping_id = shipping_id;
    }

    public OrderCarDTO(int orderId, int accountId, Date createDate, double totalPrice) {
        this.orderId = orderId;
        this.accountId = accountId;
        this.createDate = createDate;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getShipping_id() {
        return shipping_id;
    }

    public void setShipping_id(int shipping_id) {
        this.shipping_id = shipping_id;
    }

    @Override
    public String toString() {
        return "OrderBook{" + "orderId=" + orderId + ", accountId=" + accountId + ", createDate=" + createDate + ", totalPrice=" + totalPrice + ", discount=" + discount + ", shipping_id=" + shipping_id + '}';
    }

    
    
    
    
    
    
}
