package ru.isct.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ppetrovt on 18.01.2018.
 */
@Entity
@Getter
@Setter
@ToString
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String fullName;

    private String bio;

    private String articleTitle;

    private String article;
}
