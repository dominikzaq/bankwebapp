package com.pkproject.bank.beans;

import com.pkproject.bank.dao.DepositDAO;
import com.pkproject.bank.model.Deposit;

import javax.faces.bean.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by domin on 5/12/17.
 */
@ManagedBean(name = "depositView")
@ViewScoped
public class DepositView implements Serializable {
    private List<Deposit> deposits = new ArrayList<>();
    private DepositDAO depositDAO = new DepositDAO();

    @ManagedProperty(value = "#{user}")
    private User user;

/*
    public void deleteDepositById() {
        depositDAO.deleteDepositById(user, deposit);
    }
*/

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<Deposit> getDeposits() {
        depositDAO.getAllDeposit(deposits, user);
        return deposits;
    }
}
