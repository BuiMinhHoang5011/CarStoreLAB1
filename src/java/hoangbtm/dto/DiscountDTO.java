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
public class DiscountDTO {
    private int d_id;
    private String d_name;
    private double d_percent;
    private Date d_day;

    public DiscountDTO() {
    }

    public DiscountDTO(int d_id, String d_name, double d_percent, Date d_day) {
        this.d_id = d_id;
        this.d_name = d_name;
        this.d_percent = d_percent;
        this.d_day = d_day;
    }
    
    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public double getD_percent() {
        return d_percent;
    }

    public void setD_percent(double d_percent) {
        this.d_percent = d_percent;
    }

    public Date getD_day() {
        return d_day;
    }

    public void setD_day(Date d_day) {
        this.d_day = d_day;
    }

    @Override
    public String toString() {
        return "Discount{" + "d_id=" + d_id + ", d_name=" + d_name + ", d_percent=" + d_percent + ", d_day=" + d_day + '}';
    }


    }

    
    
    
