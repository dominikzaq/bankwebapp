package com.pkproject.bank.beans;

import com.pkproject.bank.UserLogin;
import com.pkproject.bank.dao.TransferDAO;
import com.pkproject.bank.model.Transfer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by domin on 12.04.17.
 */
@ManagedBean
@ViewScoped
public class TransferView implements Serializable{

    @ManagedProperty(value = "#{user}")
    private User user;

    private List<Transfer> transfers;
    private TransferDAO transferDAO;

    @PostConstruct
    public void init() {
        transfers = new ArrayList<>();
        transferDAO = new TransferDAO();
/*
        transferDAO.getAllTransfersById(user, transfers);
*/
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
