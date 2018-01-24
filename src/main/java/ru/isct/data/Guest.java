package ru.isct.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import javax.persistence.*;

/**
 * Created by ppetrovt on 09.01.2018.
 */
@Entity
@Getter
@Setter
@ToString
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    @Transient
    private GuestType guestType;

    private String city;

    private String country;

    private String organization;

    private Date registrationDate;

    private String email;

    private String phone;

    private Boolean visaSupport;

    private String memberNumber;

    private Title title;

    private String otherSupport;

    private Integer paid;

    private Integer price;

    private String locale;

    private String hash;

    private boolean confirmedPayment;

}
