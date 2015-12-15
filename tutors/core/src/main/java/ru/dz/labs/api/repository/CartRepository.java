package ru.dz.labs.api.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.Cart;

import java.util.List;

/**
 * Created by kuzin on 13.12.2015.
 */
@Repository
@Transactional
public class CartRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCart(Cart cart){
        sessionFactory.getCurrentSession().save(cart);
    }
    public List<Cart> getAllCarts(){
        return sessionFactory.getCurrentSession().createCriteria(Cart.class).list();
    }
    public Cart getCartById(Long id){
        return (Cart) sessionFactory.getCurrentSession().load(Cart.class,id);
    }
    public void deleteCart(Cart cart){
        sessionFactory.getCurrentSession().delete(cart);
    }
    public void updateCart(Cart cart){
        sessionFactory.getCurrentSession().update(cart);
    }
}
