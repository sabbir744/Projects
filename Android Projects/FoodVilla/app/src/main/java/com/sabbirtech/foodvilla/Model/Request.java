package com.sabbirtech.foodvilla.Model;

import java.util.List;

/**
 * Created by SABBIR TECH on 16-Aug-18.
 */

public class Request {
    private String phone,name,address,total;
    private List<order> foods;

    public Request() {
    }

    public Request(String phone, String name, String address, String total, List<order> foods) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.total = total;
        this.foods = foods;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<order> getFoods() {
        return foods;
    }

    public void setFoods(List<order> foods) {
        this.foods = foods;
    }
}
