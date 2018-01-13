package ru.isct.model;

import ru.isct.data.Guest;
import ru.isct.service.GuestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ppetrovt on 12.01.2018.
 */
@Service
public class RegistrationModel {

    @Autowired
    private GuestService guestService;

    public Guest addGuest (Guest guest){
        return guestService.save(guest);
    }
}
