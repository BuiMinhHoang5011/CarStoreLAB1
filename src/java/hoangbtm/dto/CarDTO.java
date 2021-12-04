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
public class CarDTO {

    private int carId;
    private int category_id;
    private String car_name;
    private int quantity;
    private double price;
    private String description;
    private String color;
    private String image;
    private Date create_date;
    private int status;

    public CarDTO() {
    }

    public CarDTO(int carId, int category_id, String car_name, int quantity, double price, String description, String color, String image, Date create_date, int status) {
        this.carId = carId;
        this.category_id = category_id;
        this.car_name = car_name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.color = color;
        this.image = image;
        this.create_date = create_date;
        this.status = status;
    }

    public CarDTO(int category_id, String car_name, int quantity, double price, String description, String color, String image, int status) {
        this.category_id = category_id;
        this.car_name = car_name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.color = color;
        this.image = image;
        this.status = status;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CarDTO{" + "carId=" + carId + ", category_id=" + category_id + ", car_name=" + car_name + ", quantity=" + quantity + ", price=" + price + ", description=" + description + ", color=" + color + ", image=" + image + ", create_date=" + create_date + ", status=" + status + '}';
    }
}
