package com.pkproject.bank.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by domin on 12.04.17.
 */
@ManagedBean
@SessionScoped
public class Bank implements Serializable{
    private String nameOfTheBank = "Amber Gold";

    public String getNameOfTheBank() {
        return nameOfTheBank;
    }
    public void setNameOfTheBank(String nameOfTheBank) {
        this.nameOfTheBank = nameOfTheBank;
    }
}
