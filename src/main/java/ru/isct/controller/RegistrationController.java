package ru.isct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ru.isct.data.Guest;
import ru.isct.data.GuestType;
import ru.isct.data.Title;
import ru.isct.model.RegistrationModel;
import ru.isct.scope.ScopeName;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ppetrovt on 09.01.2018.
 */

@Controller
@Scope(ScopeName.VIEW)
@ManagedBean
public class RegistrationController extends AbstarctController implements Serializable {

    @Autowired
    private RegistrationModel registrationModel;
    private Guest guest;

    private Integer typeId;

    @PostConstruct
    public void init() {
        guest = new Guest();
        guest.setRegistrationDate(new Date());
        guest.setGuestType(getType(2));
        typeId = 2;
    }

    public void registration(String locale) {
        try {
            guest.setLocale(locale);
            FacesContext.getCurrentInstance().getExternalContext().redirect(registrationModel.registration(guest));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void changeTypeListener() {
        guest.setGuestType(getType(typeId));
    }

    public List<GuestType> getAllGuestTypes() {
        List<GuestType> guestTypes = new ArrayList<>();
        guestTypes.add(new GuestType(1, "IEEE Member/CE  Society Member", 300, 3000, true));
        guestTypes.add(new GuestType(2, "Non-Member", 400, 4000, false));
        guestTypes.add(new GuestType(3, "IEEE Life Member", 150, 1500, true));
        guestTypes.add(new GuestType(4, "Student IEEE Member/CE Society Member", 150, 1500, true));
        guestTypes.add(new GuestType(5, "Student Non-Member", 200, 2000, false));
        guestTypes.add(new GuestType(6, "ONE-DAY IEEE Member/CE Society Member", 150, 1500, true));
        guestTypes.add(new GuestType(7, "ONE-DAY Non-Member", 200, 2000, false));
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
