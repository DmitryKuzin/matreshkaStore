package ru.dz.labs.api.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by kuzin on 01.12.2015.
 */
@Entity
@Table(name = "Orderr")
public class Orderr {
    public Orderr(){}
    public Orderr(Date create_time,double total_sum,int total_count,String status,String pay_type){
        this.create_time=create_time;
        this.total_sum=total_sum;
        this.total_count=total_count;
        this.status=status;
        this.pay_type=pay_type;
    }
    public Orderr(Date create_time,double total_sum,int total_count,String status,String pay_type,Users user,Addres addres_id,List<Order_Goods> order_goods){
        this.create_time=create_time;
        this.total_sum=total_sum;
        this.total_count=total_count;
        this.status=status;
        this.pay_type=pay_type;
        this.user=user;
        this.addres_id=addres_id;
        this.order_goods=order_goods;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne                                  // определяет отношение многие к одному
            (cascade = {CascadeType.REFRESH},
    fetch = FetchType.LAZY)
    private Users user;
    @ManyToOne                                  // определяет отношение многие к одному
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)    // подгрузка объектов списка сразу
    Addres addres_id;//может не хватать @JoinToColummn
    private Date create_time;
    private double total_sum;
    private int total_count;
    private String status;
    private String pay_type;
    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="orderr_id")
    private List<Order_Goods> order_goods;

    public List<Order_Goods> getOrder_goods() {
        return order_goods;
    }

    public void setOrder_goods(List<Order_Goods> order_goods) {
        this.order_goods = order_goods;
    }

    public Long getId() {
        return id;
    }

    public Users getUser_id() {
        return user;
    }

    public Addres getAddres_id() {
        return addres_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public double getTotal_sum() {
        return total_sum;
    }

    public int getTotal_count() {
        return total_count;
    }

    public String getPay_type() {
        return pay_type;
    }

    public String getStatus() {
        return status;
    }

    public void setAddres_id(Addres addres_id) {
        this.addres_id = addres_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public void setTotal_sum(double total_sum) {
        this.total_sum = total_sum;
    }

    public void setUser_id(Users user_id) {
        this.user = user_id;
    }

}
