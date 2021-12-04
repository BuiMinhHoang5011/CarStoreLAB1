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
public class DiscountCheckDTO {
    private int id;
    private int d_id;
    private int accountId;

    public DiscountCheckDTO() {
    }

    public DiscountCheckDTO(int id, int d_id, int accountId) {
        this.id = id;
        this.d_id = d_id;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "discountCheck{" + "id=" + id + ", d_id=" + d_id + ", accountId=" + accountId + '}';
    }
    
    
}
