package ru.dz.labs.model;

import com.fasterxml.jackson.annotation.JsonView;
import ru.dz.labs.jsonview.Views;

import java.util.List;

/**
 * Created by kuzin on 15.12.2015.
 */
public class AjaxResponseBody {

    @JsonView(Views.Public.class)
    String msg;

    @JsonView(Views.Public.class)
    String code;

    @JsonView(Views.Public.class)
    AjaxUser result;

    public AjaxUser getResult() {
        return result;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(AjaxUser result) {
        this.result = result;
    }

    //getters and setters
}
