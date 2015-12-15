package ru.dz.labs.api.domain;

import javax.persistence.*;

/**
 * Created by kuzin on 01.12.2015.
 */
@Entity
@Table(name = "order_goods")
public class Order_Goods {
    public Order_Goods(){}
    public Order_Goods(Orderr orderr_id,Goods good_id,int count){
        this.orderr_id=orderr_id;
        this.good_id=good_id;
        this.count=count;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = {CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private Orderr orderr_id;

    @ManyToOne(cascade = {CascadeType.REFRESH},
    fetch = FetchType.LAZY)
    Goods good_id;
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Goods getGood_id() {
        return good_id;
    }

    public int getCount() {
        return count;
    }

    public Orderr getOrderr_id() {
        return orderr_id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setGood_id(Goods good_id) {
        this.good_id = good_id;
    }

    public void setOrderr_id(Orderr orderr_id) {
        this.orderr_id = orderr_id;
    }
}
