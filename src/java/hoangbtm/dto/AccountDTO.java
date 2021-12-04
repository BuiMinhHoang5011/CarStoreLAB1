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
public class AccountDTO {
    private int userId;
    private String userName;
    private String password;
    private String displayName;
    private String address;
    private String phone;
    private int roll_id;
    private int status;
    private Date create_date;

    public AccountDTO() {
    }

    public AccountDTO(int userId, String userName, String password, String displayName, String address, String phone, int roll_id, int status, Date create_date) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.displayName = displayName;
        this.address = address;
        this.phone = phone;
        this.roll_id = roll_id;
        this.status = status;
        this.create_date = create_date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoll_id() {
        return roll_id;
    }

    public void setRoll_id(int roll_id) {
        this.roll_id = roll_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "Account{" + "userId=" + userId + ", userName=" + userName + ", password=" + password + ", displayName=" + displayName + ", address=" + address + ", phone=" + phone + ", roll_id=" + roll_id + ", status=" + status + ", create_date=" + create_date + '}';
    }
    
    
}
