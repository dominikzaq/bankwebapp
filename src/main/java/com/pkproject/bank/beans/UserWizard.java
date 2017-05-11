package com.pkproject.bank.beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by domin on 5/11/17.
 */
@ManagedBean
@SessionScoped
public class UserWizard {

    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
