package com.pkproject.bank;

import com.pkproject.bank.beans.User;
import com.pkproject.bank.dao.LoginDAO;
import com.pkproject.bank.model.Employee;
import com.pkproject.bank.util.SessionUtil;

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

    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public String validateClient() {
        user.setUsername(username);
        user.setPassword1(password);
        boolean valid = LoginDAO.validate(user, "client");

        if (valid) {
            HttpSession session = SessionUtil.getSession();

            session.setAttribute("client", user);
            return "client/mainclient";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username or Password",
                            "Please enter correct username and Password"));
            return "login";
        }
    }

    public String validateEmployee() {
        user.setUsername(username);
        user.setPassword1(password);
        boolean valid = LoginDAO.validate(user, "employee");

        if (valid) {
            HttpSession session = SessionUtil.getSession();
            session.setAttribute("employee", user);
            return "employee/mainemployee";
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
        HttpSession session = SessionUtil.getSession();
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
