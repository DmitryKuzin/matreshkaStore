package ru.dz.labs.api.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.Category;

import java.util.List;

/**
 * Created by kuzin on 13.12.2015.
 */
@Repository
@Transactional
public class CategoryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCategory(Category category){ sessionFactory.getCurrentSession().save(category);}

    public List<Category> getAllCategories(){
        return sessionFactory.getCurrentSession().createCriteria(Category.class).list();
    }

    public void updateCategory(Category category) {
        sessionFactory.getCurrentSession().update(category);
    }

    public Category getCategoryById(Long id) {
        return (Category) sessionFactory.getCurrentSession().load(Category.class, id);
    }

    public void deleteCategory(Category category) {
        sessionFactory.getCurrentSession().delete(category);
    }


}
