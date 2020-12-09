/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author bsawadog
 */
public class Category {
    
    private int id;
    private String name;
    private String description;
    private int order;

    

    public Category(int id, String name, String description, int order) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.order = order;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
    
    
 
    
}
