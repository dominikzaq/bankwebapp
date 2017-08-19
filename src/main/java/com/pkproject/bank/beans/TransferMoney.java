package com.pkproject.bank.beans;

import com.pkproject.bank.UserLogin;
import com.pkproject.bank.model.Transfer;
import com.pkproject.bank.dao.TransferDAO;
import com.pkproject.bank.util.SessionUtil;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by domin on 6/21/17.
 */
@ManagedBean
@RequestScoped
public class TransferMoney {
    private TransferDAO transferDAO = new TransferDAO();

    @ManagedProperty(value = "#{transfer}")
    private Transfer transfer;

    @ManagedProperty(value = "#{user}")
    private User user;


    @PostConstruct
    public void init() {
        transferDAO = new TransferDAO();
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String transferMoney() {
        if(transfer.getAmount() > 0 && transfer.getAmount() <= user.getMoney()) {
            transferDAO.sendMoney(user, transfer);
            new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Correct amount",
                    "");
        } else {
            new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Incorrect amount",
                    "Please enter correct amount");
        }
        transfer = new Transfer();
        return "/client/transfer/transfer";
    }

}
