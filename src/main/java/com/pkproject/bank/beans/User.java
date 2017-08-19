package com.pkproject.bank.beans;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.*;

/**
 * Created by domin on 5/11/17.
 */
@ManagedBean
@Service
@SessionScoped
public class User implements Serializable, Cloneable, UserInterface {
    private Integer idClient;
    private Integer idEmployee;
    private Integer idDeposit;
    private Integer idTransfer;
    private Integer idAccount;

    //personal data
    private String firstname;
    private String lastname;
    private String sex;
    private String pesel;
    private Date dateOfBirth;
    private String placeOfBirth;
    private String citizenship;

    //address
    private String city;
    private String street;
    private Integer streetNumber;
    private String postCode;
    private String country;

    //account
    private String numberAccount;
    private Double money;
    private String username;
    private String password1;
    private String tempPassword2;
    private String tempPassword3;

    //contact
    private Integer phoneNumber;
    private String email;


    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdDeposit() {
        return idDeposit;
    }

    public void setIdDeposit(Integer idDeposit) {
        this.idDeposit = idDeposit;
    }

    public Integer getIdTransfer() {
        return idTransfer;
    }

    public void setIdTransfer(Integer idTransfer) {
        this.idTransfer = idTransfer;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTempPassword2() {
        return tempPassword2;
    }

    public void setTempPassword2(String tempPassword2) {
        this.tempPassword2 = tempPassword2;
    }

    public String getTempPassword3() {
        return tempPassword3;
    }

    public void setTempPassword3(String tempPassword3) {
        this.tempPassword3 = tempPassword3;
    }

    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

    public void addMoney(double m) {
        this.money = this.money + m;
    }

    public void deleteMoney(double m) {
        this.money = this.money - m;
    }
}
