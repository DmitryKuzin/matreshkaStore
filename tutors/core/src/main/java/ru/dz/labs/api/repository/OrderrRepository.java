package ru.dz.labs.api.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.Orderr;

import java.util.List;

/**
 * Created by kuzin on 13.12.2015.
 */
@Repository
@Transactional
public class OrderrRepository {//�� ��� ������ � �������� orders_goods

    @Autowired
    private SessionFactory sessionFactory;

    public void addOrder(Orderr order){
        sessionFactory.getCurrentSession().save(order);
    }
    public List<Orderr> getAllOrderrs(){
        return sessionFactory.getCurrentSession().createCriteria(Orderr.class).list();
    }
    public Orderr getOrderrById(Long id){
        return (Orderr)sessionFactory.getCurrentSession().load(Orderr.class,id);
    }
    public void updateOrderr(Orderr order){
        sessionFactory.getCurrentSession().update(order);
    }
    public void deleteOrderr(Orderr orderr){
        sessionFactory.getCurrentSession().delete(orderr);
    }
}
