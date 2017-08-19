package com.pkproject.bank.beans;

import com.pkproject.bank.dao.DepositDAO;
import com.pkproject.bank.model.Deposit;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by domin on 5/12/17.
 */
@ManagedBean(name = "depositView")
@ViewScoped
public class DepositView implements Serializable {
    private List<Deposit> deposits;
    private DepositDAO depositDAO;
    private int idDelete;

    @ManagedProperty(value = "#{user}")
    private User user;
    
    @PostConstruct
    public void init() {
        depositDAO = new DepositDAO();
        deposits = new ArrayList<>();
        depositDAO.getAllDeposit(deposits, user);

    }

    public int getIdDelete() {
        return idDelete;
    }

    public void setIdDelete(int idDelete) {
        this.idDelete = idDelete;
    }

    public String deleteDepositById() {
        Deposit deposit = deposits.stream().filter(d -> d.getIdDeposit() == idDelete).findFirst().orElse(null);

        if(deposit != null) {
            depositDAO.deleteDepositById(user, deposit);
            deposits.remove(deposit);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "you deleted deposit",
                            "Please enter correct id of deposit"));
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect id of deposit",
                            "Please enter correct id of deposit"));
        }
        return "client/saving/checkDeposit";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<Deposit> getDeposits() {
        return deposits;
    }
}
