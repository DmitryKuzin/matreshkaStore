package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dz.labs.api.domain.Goods;
import ru.dz.labs.api.repository.GoodsRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by kuzin on 13.12.2015.
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Transactional
    public void addGood(Goods good){ goodsRepository.addGood(good);}
    @Transactional
    public List<Goods> getAllGoods(){
        return goodsRepository.getAllGoods();
    }
    @Transactional
    public void updateGoods(Goods goods) {
        goodsRepository.updateGoods(goods);
    }
    @Transactional
    public Goods getGoodsById(Long id) {
        return goodsRepository.getGoodsById(id);
    }
    @Transactional
    public void deleteGood(Goods good) {
        goodsRepository.deleteGood(good);
    }

}
