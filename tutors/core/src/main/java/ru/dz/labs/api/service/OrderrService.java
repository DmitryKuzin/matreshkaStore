package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dz.labs.api.domain.Orderr;
import ru.dz.labs.api.repository.OrderrRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by kuzin on 13.12.2015.
 */
@Service
public class OrderrService {
    @Autowired
    private OrderrRepository orderrRepository;

    @Transactional
    public void addOrder(Orderr order){
        orderrRepository.addOrder(order);
    }
    @Transactional
    public List<Orderr> getAllOrderrs(){
        return orderrRepository.getAllOrderrs();
    }
    @Transactional
    public Orderr getOrderrById(Long id){
        return orderrRepository.getOrderrById(id);
    }
    @Transactional
    public void updateOrderr(Orderr order){
        orderrRepository.updateOrderr(order);
    }
    @Transactional
    public void deleteOrderr(Orderr orderr){
        orderrRepository.deleteOrderr(orderr);
    }
}
