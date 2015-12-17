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
    //так как сайт узконаправленный(продаем только матрешки) то в бд всего 3 категории которые не имеют родителей
    //если понадобиться добавить на сайт что-то кроме матрешек,то не трудно будет создать категорию матрешки и добавить ее сущетвующим в родители
    @RequestMapping(value = "/createItems",method = RequestMethod.GET)
    public String create(){
        Category category=new Category("Author's works",null,"/resources/pics/20151122swe1DsOfcv8DM6Bp_DwaaA.jpeg");
        categoryService.addCategory(category);
        Category category1=new Category("Semenov's toys",null,"/resources/pics/pistacchi-design-01_%20-%20Copy.jpg");
        categoryService.addCategory(category1);
        Category category3=new Category("Khokhloma 2015",null,"/resources/pics/cat_khokhloma2015_pic.jpg");
        categoryService.addCategory(category3);
        Goods good10=new Goods("Matreshka Jostovo style",1984,"USSR",100.00,10,"large","/resources/pics/one.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","color",category1);
        Goods good9=new Goods("Matreshka Gjel style",1899,"Russian Empire",1500.00,1,"medium","/resources/pics/gjel_img_1.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","color",category1);
        Goods good8=new Goods("Storm Trooper pack",2015,"USA",29.99,150,"medium","/resources/pics/slide3 - Copy.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","white",category);
        Goods good5=new Goods("Matreshka #5",2015,"Russia",2.99,150,"small","/resources/pics/khokhloma_img_5_1.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","dark blue",category3);
        Goods good4=new Goods("Matreshka #4",2015,"Russia",15.99,150,"medium","/resources/pics/khokhloma_img_4_1.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","yellow",category3);
        Goods good3=new Goods("Matreshka #3",2015,"Russia",10.99,150,"large","/resources/pics/khokhloma_img_3_1.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","black",category3);
        Goods good2=new Goods("Matreshka #2",2015,"Russia",8.59,150,"medium","/resources/pics/khokhloma_img_2_1.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","blue",category3);
        Goods good1=new Goods("Matreshka #1",2015,"Russia",5.99,150,"small","/resources/pics/khokhloma_img_1_reworked.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","red",category3);
        goodsService.addGood(good1);
        goodsService.addGood(good2);
        goodsService.addGood(good3);
        goodsService.addGood(good4);
        goodsService.addGood(good5);
        goodsService.addGood(good8);
        goodsService.addGood(good9);
        goodsService.addGood(good10);
        return "main/catalog";
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String renderCatalogPage(Long category){
        request.setAttribute("catalog",categoryService.getAllCategories());
        request.setAttribute("allGoods",goodsService.getAllGoods());
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
