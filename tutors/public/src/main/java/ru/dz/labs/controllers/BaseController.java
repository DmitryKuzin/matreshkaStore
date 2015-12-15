package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gataullin Kamil
 *         12.10.2014 22:34
 */
@Controller
public class BaseController {

    @Autowired
    protected HttpServletRequest request;

    public static String redirectToMain() {
        return "redirect:/";
    }

}
