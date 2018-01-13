package ru.isct.controller;

import ru.isct.data.Guest;
import ru.isct.data.GuestType;
import ru.isct.data.Title;
import ru.isct.model.RegistrationModel;
import ru.isct.scope.ScopeName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by ppetrovt on 09.01.2018.
 */

@Controller
@Scope(ScopeName.VIEW)
@ManagedBean
public class RegistrationController implements Serializable {

    @Autowired
    private RegistrationModel registrationModel;

    private Guest guest;

    private Integer typeId;

    @PostConstruct
    public void init() {
        guest = new Guest();
        guest.setRegistrationDate(new Date());
        guest.setGuestType(getType(2));
        typeId = 1;
    }

    public void registration() {
        registrationModel.addGuest(guest);
    }

    public void changeTypeListener() {
        guest.setGuestType(getType(typeId));
    }

    public List<GuestType> getAllGuestTypes() {
        List<GuestType> guestTypes = new ArrayList<>();
        guestTypes.add(new GuestType(1, "IEEE Member/CE  Society Member", 200, 2000, true));
        guestTypes.add(new GuestType(2, "Non-Member", 300, 3000, false));
        guestTypes.add(new GuestType(3, "IEEE Life Member", 100, 1000, true));
        guestTypes.add(new GuestType(4, "Student IEEE Member/CE Society Member", 100, 1000, true));
        guestTypes.add(new GuestType(5, "Student Non-Member", 150, 1500, false));
        guestTypes.add(new GuestType(6, "ONE-DAY IEEE Member/CE Society Member", 100, 1000, true));
        guestTypes.add(new GuestType(7, "ONE-DAY Non-Member", 150, 1500, false));
        return guestTypes;
    }

    private GuestType getType(Integer id) {
        return getAllGuestTypes().stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public Title[] getTitles() {
        return Title.values();
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
