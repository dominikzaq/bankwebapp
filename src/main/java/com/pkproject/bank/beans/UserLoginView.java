package com.pkproject.bank.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by domin on 12.04.17.
 */


@ManagedBean
@SessionScoped
public class UserLoginView {
    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String isValidPassword() {
        if(username.equals("root") && password.equals("root")) {
            return "home";
        } else {
            return "failure";
        }
    }
}
