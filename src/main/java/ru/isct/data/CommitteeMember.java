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
public class CommitteeMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String fullName;

    private String position;

    private String organization;

    private String country;

    private boolean organizingMember;

    private boolean programMember;

    public String getFirstCol() {
        StringBuilder row = new StringBuilder();
        row.append(fullName == null || fullName.equals("") ? "" : fullName);
        row.append(position == null || position.equals("") ? "" : ", " + position);
        return row.toString();
    }

    public String getSecondCol() {
        StringBuilder row = new StringBuilder();
        row.append(organization == null || organization.equals("") ? "" : ", " + organization);
        row.append(country == null || country.equals("") ? "" : ", " + country);
        return row.toString();
    }
}
