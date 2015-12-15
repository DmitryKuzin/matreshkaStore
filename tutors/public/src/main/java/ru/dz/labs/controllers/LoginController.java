package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.api.domain.Users;
import ru.dz.labs.api.service.UsersService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by kuzin on 15.12.2015.
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(name = "/login",method = RequestMethod.GET)
    public String login(){
        request.getSession().setAttribute("user",null);
        request.getSession().setAttribute("userName",null);
        return "main/index";
    }
}
