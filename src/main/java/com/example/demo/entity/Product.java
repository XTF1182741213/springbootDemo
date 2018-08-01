package com.example.demo.entity;
/**
 * @Author:fly
 * @Description: product to include Foods
 * @Date:17:04 2018/8/1
 */
public class Product {
    private String name;
    private int type;
    private Foods foods;


    public Product(String name, int type, Foods foods) {
        this.name = name;
        this.type = type;
        this.foods = foods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Foods getFoods() {
        return foods;
    }

    public void setFoods(Foods foods) {
        this.foods = foods;
    }
}
