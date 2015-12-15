package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.api.domain.Addres;
import ru.dz.labs.api.domain.Cart;
import ru.dz.labs.api.domain.Users;
import ru.dz.labs.api.service.AddresService;
import ru.dz.labs.api.service.CartService;
import ru.dz.labs.api.service.UsersService;

import javax.servlet.http.Cookie;

/**
 * Created by kuzin on 14.12.2015.
 */
@Controller
public class RegisterController extends BaseController {
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String renderRegisterPage(){
        return "main/register";
    }

    @Autowired
    private UsersService us;

    @Autowired
    private AddresService as;

    @Autowired
    private CartService cs;

    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public String registerNewUser(){
        String login=request.getParameter("email");
        String pass=request.getParameter("pass");
        String name=request.getParameter("name");
        String avatar=request.getParameter("avatar");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "tutor-core.xml" }, true);
        Users user= new Users(login,pass,avatar,name,null);

        us.addUser(user);
//        boolean addressAdded= (boolean) request.getSession().getAttribute("addressAdded");
        boolean addressAdded=true;
        if(addressAdded) {
            String city=request.getParameter("city");
            String street=request.getParameter("house");
            String area=request.getParameter("area");
            int house= new Integer(request.getParameter("house"));
            int flat=new Integer(request.getParameter("flat"));
            int index=new Integer(request.getParameter("index"));
            Addres addres = new Addres(city,street,house,flat,index,area,user);
            as.addAddres(addres);
        }
        Cookie cookie=new Cookie("login",""+(login+pass).hashCode());
        //как добыть response хз
        //response.addCookie(cookie);

        return "redirect:/";
    }
}
