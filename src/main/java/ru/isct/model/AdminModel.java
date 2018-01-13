package ru.isct.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isct.data.Guest;
import ru.isct.service.GuestService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ppetrovt on 13.01.2018.
 */

@Service
public class AdminModel {


    @Autowired
    private GuestService guestService;

    public List<Guest> getAll() {
        List<Guest> guestList = new ArrayList<>();
        guestService.findAll().forEach(guestList::add);
        return guestList;
    }
}
