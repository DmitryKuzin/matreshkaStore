package ru.dz.labs.model;

import com.fasterxml.jackson.annotation.JsonView;
import ru.dz.labs.jsonview.Views;

/**
 * Created by kuzin on 15.12.2015.
 */
public class AjaxUser {

    public AjaxUser(){}

    @JsonView(Views.Public.class)
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
