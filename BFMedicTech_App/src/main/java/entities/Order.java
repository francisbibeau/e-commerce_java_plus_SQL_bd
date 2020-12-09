/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author bsawadog
 */
public class Order extends Cart{
    int id;
    int userId;
    String date, firstName, lastName;
    Date newDate;

    public Order() {
    }
    

    public Order(int id, int userId, String date, String firstName, String lastName, Date newDate) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.firstName = firstName;
        this.lastName = lastName;
        this.newDate = newDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }
 

}