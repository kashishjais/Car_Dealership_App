package com.springproj.carapp1.entity;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private int year_of_mfg;
    private int price;

    private String image_url;

    public Car(){

    }
    public Car(int id, String brand, String model, int year_of_mfg, int price,String image_url) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year_of_mfg = year_of_mfg;
        this.price = price;
        this.image_url=image_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year_of_mfg;
    }

    public void setYear(int year_of_mfg) {
        this.year_of_mfg = year_of_mfg;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year_of_mfg=" + year_of_mfg +
                ", price=" + price +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
