package ru.dz.labs.api.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kuzin on 01.12.2015.
 */
@Entity
@Table(name = "Addres")
public class Addres {
    public Addres(){}

    public Addres(String city,String street,int house,int flat,int index,String area,Users user){
        this.city=city;
        this.street=street;
        this.house=house;
        this.flat=flat;
        this.index=index;
        this.area=area;
        this.user=user;
    }
    public Addres(String city,String street,int house,int flat,int index,String area,Users user,List<Orderr> orderrs){
        this.city=city;
        this.street=street;
        this.house=house;
        this.flat=flat;
        this.index=index;
        this.area=area;
        this.user=user;
        this.orderrs=orderrs;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String city;

    private String street;
    private int house;
    private int flat;
    private int index;
    private String area;

    @ManyToOne(cascade = {CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    Users user;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="addres_id")
    private List<Orderr> orderrs;



    public int getFlat() {
        return flat;
    }

    public int getHouse() {
        return house;
    }

    public Long getId() {
        return id;
    }

    public int getIndex() {
        return index;
    }

    public List<Orderr> getOrderrs() {
        return orderrs;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Users getUser_id() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setOrderrs(List<Orderr> orderrs) {
        this.orderrs = orderrs;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setUser_id(Users user_id) {
        this.user = user_id;
    }

}
