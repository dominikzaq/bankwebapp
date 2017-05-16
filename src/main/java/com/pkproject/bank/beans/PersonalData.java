package com.pkproject.bank.beans;

import org.springframework.stereotype.Component;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by domin on 5/16/17.
 */
@Component
@ManagedBean
@SessionScoped
public class PersonalData {
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
