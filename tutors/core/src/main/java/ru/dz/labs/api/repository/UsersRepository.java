package ru.dz.labs.api.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.Users;

import java.util.List;

/**
 * Created by kuzin on 13.12.2015.
 */
@Repository
@Transactional
public class UsersRepository {

    @Autowired

    private SessionFactory sessionFactory;

    public void addUser(Users user){ sessionFactory.getCurrentSession().save(user);}

    public List<Users> getAllUsers(){
        return sessionFactory.getCurrentSession().createCriteria(Users.class).list();
    }

    public void updateUsers(Users user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public Users getUserById(Long id) {
        return (Users) sessionFactory.getCurrentSession().load(Users.class, id);
    }

    public void deleteUser(Users user) {
        sessionFactory.getCurrentSession().delete(user);
    }

}
