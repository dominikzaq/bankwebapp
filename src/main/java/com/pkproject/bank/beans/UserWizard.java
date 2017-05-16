package com.pkproject.bank.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by domin on 5/11/17.
 */
@Component
@ManagedBean
@SessionScoped
public class UserWizard implements Serializable {

    @Autowired
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
