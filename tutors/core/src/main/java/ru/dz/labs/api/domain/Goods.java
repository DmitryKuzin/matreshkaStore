package ru.dz.labs.api.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kuzin on 01.12.2015.
 */
@Entity
@Table(name = "GOODS")
public class Goods {
    public Goods(){}
    public Goods(String name,int year,String country,double price,int count,String size,String image,String description,String color,Category category_id){
        this.name=name;
        this.year=year;
        this.country=country;
        this.price=price;
        this.count=count;
        this.size=size;
        this.image=image;
        this.description=description;
        this.color=color;
        this.category_id=category_id;
    }
    public Goods(String name,int year,String country,double price,int count,String size,String image,String description,String color, List<Order_Goods> order_goods,List<Cart> carts,Category category_id){
        this.name=name;
        this.year=year;
        this.country=country;
        this.price=price;
        this.count=count;
        this.size=size;
        this.image=image;
        this.description=description;
        this.color=color;
        this.category_id=category_id;
        this.order_goods=order_goods;
        this.carts=carts;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int year;
    private String country;
    private double price;
    private int count;
    private String size;
    private String image;
    private String description;
    private String color;
    @ManyToOne(cascade = CascadeType.REFRESH,
    fetch = FetchType.LAZY)
    private Category category_id;

    @OneToMany(cascade = CascadeType.REFRESH,
    fetch = FetchType.LAZY,
    mappedBy = "good_id")
    private List<Cart> carts;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="good_id")
    private List<Order_Goods> order_goods;

    public List<Order_Goods> getOrder_goods() {
        return order_goods;
    }

    public void setOrder_goods(List<Order_Goods> order_goods) {
        this.order_goods = order_goods;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public String getColor() {
        return color;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getSize() {
        return size;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
