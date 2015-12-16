package ru.dz.labs.controllers;

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
public class CatalogController extends BaseController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private GoodsService goodsService;
    @RequestMapping(value = "/createItems",method = RequestMethod.GET)
    public String create(){
        Category category=new Category("matreshka's",null,"some alias");
        categoryService.addCategory(category);
        Category category1=new Category("Semenov's toys",category,"some another alias");
        categoryService.addCategory(category1);
        Category category3=new Category("Khokhloma 2015",category1,"alias a");
        categoryService.addCategory(category3);
        Category category2=new Category("Designer's works",category,"cool alias");
        categoryService.addCategory(category2);
        Goods good10=new Goods("Matreshka Jostovo style",1984,"country",100.00,10,"large","image","description","color",category1);
        Goods good9=new Goods("Matreshka Gjel style",1899,"Russian Empire",1500.00,1,"medium","image","description","color",category1);
        Goods good8=new Goods("Dart Veider",2015,"USA",10.99,150,"medium","image","description","black",category2);
        Goods good7=new Goods("Chewbaka",2015,"USA",10.99,150,"large","image","description","brown",category2);
        Goods good6=new Goods("R2D2",2015,"USA",10.99,150,"small","image","description","white",category2);
        Goods good5=new Goods("Matreshka #5",2015,"Russia",2.99,150,"small","image","description","dark blue",category3);
        Goods good4=new Goods("Matreshka #4",2015,"Russia",15.99,150,"medium","image","description","yellow",category3);
        Goods good3=new Goods("Matreshka #3",2015,"Russia",10.99,150,"large","image","description","black",category3);
        Goods good2=new Goods("Matreshka #2",2015,"Russia",8.59,150,"medium","image","description","blue",category3);
        Goods good1=new Goods("Matreshka #1",2015,"Russia",5.99,150,"small","/resources/pics/one.jpg","Lorem ipsum","red",category3);
        goodsService.addGood(good1);
        goodsService.addGood(good2);
        goodsService.addGood(good3);
        goodsService.addGood(good4);
        goodsService.addGood(good5);
        goodsService.addGood(good6);
        goodsService.addGood(good7);
        goodsService.addGood(good8);
        goodsService.addGood(good9);
        goodsService.addGood(good10);
        return "main/catalog";
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String renderCatalogPage(Long category){
        request.setAttribute("catalog",categoryService.getAllCategories());
        if(category==null) return "main/catalog";
        request.setAttribute("selected",categoryService.getCategoryById(category));
        List<Category> allCats=categoryService.getAllCategories();
        List<Category> children=new ArrayList<>();
        for(Category cat:allCats){
            if(cat.getParent_id()!=null) {
                if (cat.getParent_id().equals(categoryService.getCategoryById(category))) {
                    children.add(cat);
                }
            }
        }
        request.setAttribute("childrenList",children);
        return "main/catalog";
    }
}
