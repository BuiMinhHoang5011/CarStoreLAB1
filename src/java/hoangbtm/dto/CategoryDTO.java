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
public class CategoryDTO {
    private int category_id;
    private String categoryName;
    private int status;

    public CategoryDTO() {
    }

    public CategoryDTO(int category_id, String categoryName, int status) {
        this.category_id = category_id;
        this.categoryName = categoryName;
        this.status = status;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Category{" + "category_id=" + category_id + ", categoryName=" + categoryName + ", status=" + status + '}';
    }
    
    
}
