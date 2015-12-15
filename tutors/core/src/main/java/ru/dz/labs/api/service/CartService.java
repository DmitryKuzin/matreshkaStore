package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dz.labs.api.domain.Cart;
import ru.dz.labs.api.repository.CartRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by kuzin on 13.12.2015.
 */
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public void addCart(Cart cart){
        cartRepository.addCart(cart);
    }
    @Transactional
    public List<Cart> getAllCarts(){
        return cartRepository.getAllCarts();
    }
    @Transactional
    public Cart getCartById(Long id){
        return cartRepository.getCartById(id);
    }
    @Transactional
    public void deleteCart(Cart cart){
       cartRepository.deleteCart(cart);
    }
    @Transactional
    public void updateCart(Cart cart){
        cartRepository.updateCart(cart);
    }
}
