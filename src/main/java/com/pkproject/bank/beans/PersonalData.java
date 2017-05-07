package com.pkproject.bank.beans;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

/**
 * Created by domin on 18.04.17.
 */
@ManagedBean
@SessionScoped
public class PersonalData implements Serializable{
    private String fullname;
    private int numberAccount;
    private int Pesel;
    private String address;
    private String postcode;
    private int money;
    private String login;
    private String password;
    private String reTypePasword;
    private int phoneNumber;
    private String email;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }

    public int getPesel() {
        return Pesel;
    }

    public void setPesel(int pesel) {
        Pesel = pesel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReTypePasword() {
        return reTypePasword;
    }

    public void setReTypePasword(String reTypePasword) {
        this.reTypePasword = reTypePasword;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
