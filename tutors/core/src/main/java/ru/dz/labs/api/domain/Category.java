package ru.dz.labs.api.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "CategoryService")
public class Category {
    public Category(){}
    public Category(String name,String alias){
        this.name=name;
        this.alias=alias;
        parent_id=null;
    }
    public Category(String name,Category parent_id,String alias){
        this.name=name;
        this.parent_id=parent_id;
        this.alias=alias;
    }
    public Category(String name,String alias,List<Goods> goods){
        this.name=name;
        this.alias=alias;
        this.goods=goods;
        parent_id=null;
    }
    public Category(String name,Category parent_id,String alias,List<Goods> goods){
        this.name=name;
        this.parent_id=parent_id;
        this.alias=alias;
        this.goods=goods;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category parent_id;
    private String alias;//will be used as image link

    @OneToMany(cascade = CascadeType.REFRESH,
    fetch = FetchType.LAZY,
    mappedBy = "category_id")
    private List<Goods> goods;

    public Category getParent_id() {
        return parent_id;
    }

    public Long getId() {
        return id;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public String getAlias() {
        return alias;
    }

    public String getName() {
        return name;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent_id(Category parent_id) {
        this.parent_id = parent_id;
    }

}
