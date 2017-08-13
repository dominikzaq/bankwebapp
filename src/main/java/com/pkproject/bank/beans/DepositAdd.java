package com.pkproject.bank.beans;

import com.pkproject.bank.dao.DepositDAO;
import com.pkproject.bank.model.Deposit;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by domin on 6/29/17.
 */
@ManagedBean
@ViewScoped
public class DepositAdd implements Serializable{

    @ManagedProperty(value = "#{deposit}")
    private Deposit deposit;
    private DepositDAO depositDAO = new DepositDAO();

    @ManagedProperty(value = "#{user}")
    private  User user;

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String addDeposit() {
        if(user.getMoney() < 1000) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "\n" +
                                    "Incorrect sum of money",
                            "\n" +
                                    "You do not have sufficient funds in your account"));
        } else if(deposit.getAmount() > 1000 && deposit.getAmount() < user.getMoney()) {
            depositDAO.createDeposit(user,deposit);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "\n" +
                                    "Correct sum of money, you created of deposit",
                            "Please enter correct sum between 1000 and your current money"));
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "\n" +
                                    "Incorrect sum of money",
                            "Please enter correct sum between 1000 and your current money"));
        }

        deposit = new Deposit();
        return "/client/saving/createDeposit";
    }
}
