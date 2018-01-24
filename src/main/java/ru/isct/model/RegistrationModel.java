package ru.isct.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isct.data.Guest;
import ru.isct.service.CbrService;
import ru.isct.service.GuestService;
import ru.isct.service.HashGenerator;
import ru.isct.service.SberbankService;

import java.io.IOException;
import java.util.Date;

/**
 * Created by ppetrovt on 12.01.2018.
 */
@Service
public class RegistrationModel {

    @Autowired
    private GuestService guestService;

    @Autowired
    private SberbankService sberbankService;

    @Autowired
    private CbrService cbrService;

    public String registration(Guest guest) throws IOException {
        try {
            if (guest.getLocale().equals("en")){
                guest.setPrice(guest.getGuestType().getPrice() * cbrService.getRate());
            } else {
                guest.setPrice(guest.getGuestType().getPriceRu());
            }
            guest.setHash(HashGenerator.getSha256(guest.toString() + new Date().toString()));
            guestService.save(guest);
            return sberbankService.payment(guest);
        } catch (IOException e) {
            guestService.delete(guest);
            throw new IOException(e.getMessage());
        }
    }

    public void deleteGuest(Guest guest) {
        guestService.delete(guest);
    }
}
