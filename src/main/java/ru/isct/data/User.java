package ru.isct.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ppetrovt on 18.01.2018.
 */
@Entity
@Getter
@Setter
@ToString
public class User {

    @Id
    private String login;

    private String password;

    private boolean confirmed;

}
