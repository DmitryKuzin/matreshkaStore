package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.api.domain.Users;
import ru.dz.labs.api.service.UsersService;

import java.util.List;

/**
 * Created by kuzin on 15.12.2015.
 */
@Controller
public class LoginController extends BaseController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(name = "/login",method = RequestMethod.POST)
    public String login(){
        String email=request.getParameter("email");
        String pass=request.getParameter("pass");
        List<Users> users=usersService.getAllUsers();
        for (Users u:users){
            if(u.getLogin().equals(email)){
                if(u.getHash_pass().equals(pass)){
                    request.getSession().setAttribute("user",u);
                    request.getSession().setAttribute("userName",u.getName());
                }
            }
        }
        return "redirect:/";
    }
}
