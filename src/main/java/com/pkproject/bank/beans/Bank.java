package com.pkproject.bank.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by domin on 12.04.17.
 */
@ManagedBean
@SessionScoped
public class Bank {
    private String nameOfTheBank = "Polibuda bank";

    public String getNameOfTheBank() {
        return nameOfTheBank;
    }
    public void setNameOfTheBank(String nameOfTheBank) {
        this.nameOfTheBank = nameOfTheBank;
    }
}
