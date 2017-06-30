package com.pkproject.bank.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by domin on 5/12/17.
 */
@ManagedBean
@SessionScoped
public class Deposit implements Serializable {
    private int idDeposit;
    private String nameOfDeposit;
    private int accountDeposit;
    private Double amount;
    private Double interestRate = 0.03;
    private int minimumOfDepositAmount = 1000;
    private Date closingDate;

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


    public void setMinimumOfDepositAmount(int minimumOfDepositAmount) {
        this.minimumOfDepositAmount = minimumOfDepositAmount;
    }

    public int getMinimumOfDepositAmount() {
        return minimumOfDepositAmount;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }
}
