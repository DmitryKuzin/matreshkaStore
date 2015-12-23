package ru.dz.labs.controllers;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.api.domain.Category;
import ru.dz.labs.api.domain.Goods;
import ru.dz.labs.api.service.CategoryService;
import ru.dz.labs.api.service.GoodsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuzin on 14.12.2015.
 */
@Controller
public class ItemController extends BaseController{

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public String renderItemPage(Long id){
        Goods goods=null;
        List<Goods> goodsList=goodsService.getAllGoods();
        //Goods g=goodsService.getGoodsId(); <- don't work
        for(Goods g:goodsList){
            if(g.getId().equals(id)){
                goods=g;
            }
        }
//        List<Category> breadcrumbsTmp=new ArrayList<>();
//        List<Category> categs=categoryService.getAllCategories();
//        Category c=null;
//        for(Category category:categs){
//            List<Goods> gs=category.getGoods();
//            for(Goods goods1:gs){
//                if(goods.getId().equals(goods1.getId())){
//                    c=category;
//                }
//            }
//        }
////        if (goods != null) {
////            c = goods.getCategory_id();
////        }
//        breadcrumbsTmp.add(c);
//        //c.getParentId(); <- don't work
//        while(true){
//            try {
//                c = c.getParent_id();
//                breadcrumbsTmp.add(c);
//            }catch (NullPointerException exception){
//                break;
//            }
//        }
//        List<Category> cats=Lists.reverse(breadcrumbsTmp);
        request.setAttribute("item",goods);
//        request.setAttribute("breadCrumb", Lists.reverse(breadcrumbsTmp));
        return "main/item";
    }
}
