package ru.isct.model;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isct.data.Guest;
import ru.isct.service.GuestService;
import ru.isct.service.MailService;

import java.io.IOException;

/**
 * Created by ppetrovt on 21.01.2018.
 */
@Service
public class SuccessModel {

    @Autowired
    private GuestService guestService;

    public void proofOfPayment(Integer id, String hash) throws Exception {
        Guest guest = guestService.findOne(id);
        if (guest.getHash().equals(hash)) {
            guest.setConfirmedPayment(true);
            guestService.save(guest);
            sendEmail(guest);
        } else {
            throw new Exception();
        }
    }

    private void sendEmail(Guest guest){
        String recipient = guest.getEmail();
        String subject = "Регистрация пройдена успешно!";
        String body = guest.getFirstName() + " " + guest.getLastName() + ", регистрация пройдена успешно!";
        try {
            new MailService().send(recipient, subject, body);
        } catch (EmailException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
