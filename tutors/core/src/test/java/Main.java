import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dz.labs.api.domain.Category;
import ru.dz.labs.api.domain.Goods;
import ru.dz.labs.api.service.CategoryService;
import ru.dz.labs.api.service.GoodsService;

import java.util.List;

/**
 * Created by kuzin on 15.12.2015.
 */
public class Main {
//    http://storage2.static.itmages.ru/i/15/1214/h_1450136426_6458357_61235ac514.jpg
public static void main(String[] args) {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "tutor-core.xml" }, true);


    Category category=new Category("khokhloma 2015","Russia,Moscow");
    CategoryService categoryService= (CategoryService) context.getBean("categoryService");
    categoryService.addCategory(category);
    Goods good=new Goods("Matreshka No.12",2015,"Russia",3.99,150,"medium",
            "http://storage2.static.itmages.ru/i/15/1214/h_1450136426_6458357_61235ac514.jpg",
            "Some description","red",category);
    GoodsService goodsService= (GoodsService) context.getBean("goodsService");
    goodsService.addGood(good);
    List<Goods> goodsList=goodsService.getAllGoods();
    for(Goods goodItem:goodsList){
        System.out.println("Name" + goodItem.getName()+" link:"+good.getImage());
    }
}
}
