package com.pkproject.bank.beans;

import com.pkproject.bank.dao.DepositDAO;
import com.pkproject.bank.model.Deposit;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by domin on 6/29/17.
 */
@ManagedBean
@SessionScoped
public class DepositAdd {
    private Deposit deposit = new Deposit();
    private DepositDAO depositDAO = new DepositDAO();

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public String addDeposit() {
       /* deposit = new Deposit();
        depositDAO = new DepositDAO();*/
        return "/client/mainclient";
    }
}
