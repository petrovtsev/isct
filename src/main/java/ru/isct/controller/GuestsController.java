package ru.isct.controller;

import lombok.Getter;
import lombok.Setter;
import ru.isct.data.Guest;
import ru.isct.model.GuestsModel;
import ru.isct.scope.ScopeName;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


/**
 * Created by ppetrovt on 18.01.2018.
 */

@Controller
@Scope(ScopeName.SESSION)
@ManagedBean
@Getter
@Setter
public class GuestsController extends AbstarctController {

    private List<Guest> guestList;


    @Autowired
    private GuestsModel guestModel;

    @PostConstruct
    public void init() {
        guestList = guestModel.getAll();
    }

    public void addCommitteeMember() {

    }

    public void addSpeaker() {

    }

    public String getSize() {
        return String.valueOf(getGuestList().size());
    }

}
