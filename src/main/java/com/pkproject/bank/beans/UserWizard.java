package com.pkproject.bank.beans;


import com.pkproject.bank.dao.AccountDAO;
import com.pkproject.bank.dao.TransferDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by domin on 5/11/17.
 */
@ManagedBean
@SessionScoped
public class UserWizard implements Serializable {
    private  AccountDAO accountDAO;

    @ManagedProperty(value = "#{user}")
    private User user;

    @PostConstruct
    public void init() {
        accountDAO = new AccountDAO();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String saveUser() throws SQLException {
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getFirstname());
        FacesContext.getCurrentInstance().addMessage(null, msg);

        accountDAO.createUser(user);
        user = new User();
        return "/employee/mainemployee";
    }
}
