package ru.dz.labs.api.domain;


import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by kuzin on 01.12.2015.
 */
@Entity
@Table(name = "Cart")
public class Cart implements Serializable {
    public Cart(){}
    public Cart(Goods good_id,Users user,int count){
        this.good_id=good_id;
        this.user=user;
        this.count=count;
    }
    @Id
    @ManyToOne(cascade = {CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private Goods good_id;
    @Id
    @ManyToOne(cascade = {CascadeType.REFRESH},
    fetch = FetchType.LAZY)
    private Users user;
    private int count;

    public Users getUser_id() {
        return user;
    }

    public Goods getGood_id() {
        return good_id;
    }

    public int getCount() {
        return count;
    }

    public void setUser_id(Users user_id) {
        this.user = user_id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setGood_id(Goods good_id) {
        this.good_id = good_id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode()==hashCode();
    }

    @Override
    public int hashCode() {
        return (user.getName()+good_id.getName()).hashCode();
    }
}
