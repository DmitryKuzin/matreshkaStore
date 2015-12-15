package ru.dz.labs.api.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.Goods;

import java.util.List;

/**
 * Created by kuzin on 13.12.2015.
 */
@Repository
@Transactional
public class GoodsRepository {

    @Autowired
    private SessionFactory sessionFactory;


//�� ����� �� ��� ���������� ������ ��� ������ � ������� ��� ��������� �����
    public void addGood(Goods good){ sessionFactory.getCurrentSession().save(good);}//�� ���� ���� ������ ��� �� ��������� ����� � ������������

    public List<Goods> getAllGoods(){
        return sessionFactory.getCurrentSession().createCriteria(Goods.class).list();
    }

    public void updateGoods(Goods goods) {
        sessionFactory.getCurrentSession().update(goods);
    }

    public Goods getGoodsById(Long id) {
        return (Goods)sessionFactory.getCurrentSession().load(Goods.class, id);
    }

    public void deleteGood(Goods good) {
        sessionFactory.getCurrentSession().delete(good);
    }

}
