package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class Patient implements Comparable<Patient> {
    private int cardId;
    private String firstname;
    private String secondname;
    private String thirdname;
    private String dateOfBirth;
    private String gender;

    public Patient() {
        gender = null;
    }

    public Patient(int cardId, String firstname, String secondname, String thirdname, String dateOfBirth, String gender) {
        this.cardId = cardId;
        this.firstname = firstname;
        this.secondname = secondname;
        this.thirdname = thirdname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public int getCardId() {
        return this.cardId;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public  String getSecondname() {
        return this.secondname;
    }

    public String getThirdname() {
        return this.thirdname;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public void setCardId(int card) {
        this.cardId = card;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int compareTo(Patient o) {
        return getSecondname().compareTo(o.getSecondname());
    }
}
