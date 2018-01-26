package ru.isct.bean;

import lombok.Getter;
import lombok.Setter;
import ru.isct.data.User;
import ru.isct.scope.ScopeName;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by ppetrovt on 18.01.2018.
 */
@Controller
@Scope(ScopeName.SESSION)
@ManagedBean
public class UserBean implements Serializable {

    @Getter
    @Setter
    private User user;

    @Getter
    @Setter
    private boolean userAuthenticated;

}
