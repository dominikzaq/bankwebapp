package com.pkproject.bank.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by domin on 5/12/17.
 */
@ManagedBean
@ViewScoped
public class Deposit implements Serializable {
    private Integer idDeposit;
    private String nameOfDeposit;
    private Integer accountDeposit;
    private Double amount;
    private Double interestRate = 0.03;
    private Integer minimumOfDepositAmount = 1000;
    private Date closingDate;

    public Integer getIdDeposit() {
        return idDeposit;
    }

    public void setIdDeposit(Integer idDeposit) {
        this.idDeposit = idDeposit;
    }

    public String getNameOfDeposit() {
        return nameOfDeposit;
    }

    public void setNameOfDeposit(String nameOfDeposit) {
        this.nameOfDeposit = nameOfDeposit;
    }

    public Integer getAccountDeposit() {
        return accountDeposit;
    }

    public void setAccountDeposit(Integer accountDeposit) {
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


    public Integer getMinimumOfDepositAmount() {
        return minimumOfDepositAmount;
    }

    public void setMinimumOfDepositAmount(Integer minimumOfDepositAmount) {
        this.minimumOfDepositAmount = minimumOfDepositAmount;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }
}
