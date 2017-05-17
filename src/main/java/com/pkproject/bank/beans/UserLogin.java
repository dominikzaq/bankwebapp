package com.pkproject.bank.beans;

import com.pkproject.bank.dao.LoginDAO;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by domin on 12.04.17.
 */


@ManagedBean(name = "login")
@SessionScoped
public class UserLogin implements Serializable {
    private String username;
    private String password;
    private String typeAccount;

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

    public String validateUsernamePassword() {
        boolean valid = LoginDAO.validate(username, password);

        if (valid) {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("username", username);
            return "client/mainclient";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username or Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }
    }

    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "/login";
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public void changePassword() {

    }

    public void changeLogin() {

    }
}
