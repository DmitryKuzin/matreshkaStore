package ru.dz.labs.api.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.Addres;

import java.util.List;

/**
 * Created by kuzin on 13.12.2015.
 */
@Repository
@Transactional
public class AddressRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addAddres(Addres addres){
        sessionFactory.getCurrentSession().save(addres);
    }
    public void deleteAddres(Addres addres){
        sessionFactory.getCurrentSession().delete(addres);
    }
    public void updateAddres(Addres addres){
        sessionFactory.getCurrentSession().update(addres);
    }
    public Addres getAddresById(Long id){
        return (Addres)sessionFactory.getCurrentSession().load(Addres.class,id);
    }
    public List<Addres> getAllAddresses(){
        return sessionFactory.getCurrentSession().createCriteria(Addres.class).list();
    }
}
