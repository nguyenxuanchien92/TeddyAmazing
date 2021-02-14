package com.cg.teddyamazing.model.product;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    private String id;

    @Column(unique = true)
    private String name;

    private double price;
    private String desv;
    private String img;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    public Product() {
    }

    public Product(String id, String name, double price, String desv, String img, Category category, Size size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desv = desv;
        this.img = img;
        this.category = category;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesv() {
        return desv;
    }

    public void setDesv(String desv) {
        this.desv = desv;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}