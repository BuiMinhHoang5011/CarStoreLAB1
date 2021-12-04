/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.dto;

import java.io.Serializable;

/**
 *
 * @author Hoang
 */
public class CartDTO implements Serializable{
    private int carId;
    private String carName;
    private String carImg;
    private double carPrice;
    private int carQuantity;
    private int quantity;
    private double totalPrice;

    public CartDTO() {
    }

    public CartDTO(int carId, String carName, String carImg, double carPrice, int carQuantity, int quantity, double totalPrice) {
        this.carId = carId;
        this.carName = carName;
        this.carImg = carImg;
        this.carPrice = carPrice;
        this.carQuantity = carQuantity;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public int getCarQuantity() {
        return carQuantity;
    }

    public void setCarQuantity(int carQuantity) {
        this.carQuantity = carQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartDTO{" + "carId=" + carId + ", carName=" + carName + ", carImg=" + carImg + ", carPrice=" + carPrice + ", carQuantity=" + carQuantity + ", quantity=" + quantity + ", totalPrice=" + totalPrice + '}';
    }
}
