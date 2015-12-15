package ru.dz.labs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kuzin on 14.12.2015.
 */
@Controller
public class OrderController {
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String renderOrderPage(){
        return "main/order";
    }
}
