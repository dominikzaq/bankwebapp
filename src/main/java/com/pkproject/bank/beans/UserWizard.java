package com.pkproject.bank.beans;


import com.pkproject.bank.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by domin on 5/11/17.
 */
@Component
@ManagedBean
@SessionScoped
public class UserWizard implements Serializable {
    private  AccountDAO accountDAO;

    @Autowired
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String saveUser() throws SQLException {
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getFirstname());
        FacesContext.getCurrentInstance().addMessage(null, msg);

        accountDAO = new AccountDAO();
        accountDAO.createUser(user);
        return "/login";
    }
}
