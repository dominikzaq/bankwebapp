package com.pkproject.bank.beans;

import com.pkproject.bank.dao.DepositDAO;
import com.pkproject.bank.model.Deposit;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by domin on 5/12/17.
 */
@ManagedBean(name = "depositView")
@SessionScoped
public class DepositView implements Serializable {
    private List<Deposit> deposits = new ArrayList<>();
    public List<Deposit> getDeposits() {
        return deposits;
    }
    private DepositDAO depositDAO = new DepositDAO();
    private User user = new User();
    private Deposit deposit = new Deposit();

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }

    public void deleteDepositById() {
        depositDAO.deleteDepositById(user, deposit);
    }
}
