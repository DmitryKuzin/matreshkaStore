package ru.dz.labs.api.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kuzin on 01.12.2015.
 */
@Entity
@Table(name = "Userss")
public class Users {
    public Users(){}
    public Users(String login,String hash_pass,String avatar,String name,String key){
        this.login=login;
        this.hash_pass=hash_pass;
        this.avatar=avatar;
        this.name=name;
        this.key=key;
    }
    public Users(String login,String hash_pass,String avatar,String name,String key,List<Cart> carts,List<Orderr> orderrs,List<Addres> addres){
        this.login=login;
        this.hash_pass=hash_pass;
        this.avatar=avatar;
        this.name=name;
        this.key=key;
        this.carts=carts;
        this.orderrs=orderrs;
        this.addres=addres;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;
    private String hash_pass;
    private String avatar;
    private String name;
//    private boolean check=false;
//    public boolean getCheck() {
//    return check;
//}
//    public void setCheck(boolean check) {
//        this.check = check;
//    }
    private String key;
    @OneToMany(cascade={CascadeType.REFRESH},
            fetch = FetchType.LAZY,
    mappedBy = "user")
    private List<Cart> carts;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="user")
    private List<Orderr> orderrs;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="user")
    private List<Addres> addres;

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public List<Addres> getAddres() {
        return addres;
    }

    public List<Orderr> getOrderrs() {
        return orderrs;
    }

    public String getKey() {
        return key;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getHash_pass() {
        return hash_pass;
    }

    public String getLogin() {
        return login;
    }

    public void setAddres(List<Addres> addres) {
        this.addres = addres;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setHash_pass(String hash_pass) {
        this.hash_pass = hash_pass;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrderrs(List<Orderr> orderrs) {
        this.orderrs = orderrs;
    }

}
