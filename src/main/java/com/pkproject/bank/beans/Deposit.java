package com.pkproject.bank.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by domin on 5/12/17.
 */
@ManagedBean
@SessionScoped
public class Deposit implements Serializable {
    private int idDeposit;
    private String nameOfDeposit;
    private int accountDeposit;
    private String duration;
    private Double amount;
    private Double interestRate = 0.03;
    private String openingDate;
    private String expiration;
    private int minimumOfDepositAmount = 1000;

    public int getIdDeposit() {
        return idDeposit;
    }

    public void setIdDeposit(int idDeposit) {
        this.idDeposit = idDeposit;
    }

    public String getNameOfDeposit() {
        return nameOfDeposit;
    }

    public void setNameOfDeposit(String nameOfDeposit) {
        this.nameOfDeposit = nameOfDeposit;
    }

    public int getAccountDeposit() {
        return accountDeposit;
    }

    public void setAccountDeposit(int accountDeposit) {
        this.accountDeposit = accountDeposit;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public void setMinimumOfDepositAmount(int minimumOfDepositAmount) {
        this.minimumOfDepositAmount = minimumOfDepositAmount;
    }

}
