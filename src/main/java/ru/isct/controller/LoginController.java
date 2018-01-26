package ru.isct.controller;

import lombok.Getter;
import lombok.Setter;
import ru.isct.bean.UserBean;
import ru.isct.model.LoginModel;
import ru.isct.scope.ScopeName;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by ppetrovt on 18.01.2018.
 */
@Controller
@Scope(ScopeName.VIEW)
@ManagedBean
public class LoginController extends AbstarctController {

    @Autowired
    private UserBean userBean;

    @Autowired
    private LoginModel loginModel;

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String password;

    public void login() {
        try {
            userBean.setUserAuthenticated(loginModel.login(login, password));
            userBean.setUser(loginModel.getUser(login));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void registration() {
        try {
            loginModel.registration(login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String logout() {
        userBean.setUserAuthenticated(false);
        return "admin";
    }
}
