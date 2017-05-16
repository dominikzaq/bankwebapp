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
    private String nameOfDeposit;
    private int accountDeposit;
    private String duration;
    private Double balance;
    private Double interestRate;
    private String openingDate;
    private String expiration;
}
