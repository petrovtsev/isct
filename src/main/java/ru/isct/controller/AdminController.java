package ru.isct.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ru.isct.data.Guest;
import ru.isct.model.AdminModel;
import ru.isct.scope.ScopeName;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by ppetrovt on 13.01.2018.
 */
@Controller
@Scope(ScopeName.VIEW)
@ManagedBean
public class AdminController {

    @Getter
    @Setter
    private List<Guest> guestList;

    @Autowired
    private AdminModel adminModel;

    @PostConstruct
    public void init() {
        guestList = adminModel.getAll();
    }

}
