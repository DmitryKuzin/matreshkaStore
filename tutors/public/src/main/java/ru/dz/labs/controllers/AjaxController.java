package ru.dz.labs.controllers;


import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.dz.labs.api.domain.Users;
import ru.dz.labs.api.service.UsersService;
import ru.dz.labs.jsonview.Views;
import ru.dz.labs.model.AjaxResponseBody;
import ru.dz.labs.model.AjaxUser;
import ru.dz.labs.model.SearchCriteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuzin on 15.12.2015.
 */
@RestController
public class AjaxController extends  BaseController {

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/ajax")
    public AjaxResponseBody getSearchResultViaAjax(@RequestBody SearchCriteria search) {

        AjaxResponseBody result = new AjaxResponseBody();

        if (isValidSearchCriteria(search)) {
            AjaxUser user = findByUserPassAndEmail(search.getPass(), search.getEmail());

            if (user!=null) {
                result.setCode("200");
                result.setMsg("");
                result.setResult(user);
                request.getSession().setAttribute("userlogined","true");
                request.getSession().setAttribute("userName",user.getName());
                request.getSession().setAttribute("userEmail",this.user.getLogin());
            } else {
                result.setCode("204");
                result.setMsg("No user!");
            }

        } else {
            result.setCode("400");
            result.setMsg("Search criteria is empty!");
        }

        //AjaxResponseBody will be converted into json format and send back to the request.
        return result;

    }
    @Autowired
    private UsersService usersService;
    private Users user;
    private AjaxUser findByUserPassAndEmail(String pass, String email) {

        AjaxUser result=null;
        List<Users> users=usersService.getAllUsers();
        for (Users u:users){
            if(u.getLogin().equals(email)){
                if(u.getHash_pass().equals(pass)){
                    result=new AjaxUser();
                    user=u;
                    result.setName(u.getName());
                }
            }
        }

        return result;
    }
    private boolean isValidSearchCriteria(SearchCriteria search) {

        boolean valid = true;

        if (search == null) {
            valid = false;
        }

        if ((StringUtils.isEmpty(search.getPass())) && (StringUtils.isEmpty(search.getEmail()))) {
            valid = false;
        }

        return valid;
    }
}
