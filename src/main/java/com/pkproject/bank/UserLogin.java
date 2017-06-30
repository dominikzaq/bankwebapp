package com.pkproject.bank;

import com.pkproject.bank.beans.Account;
import com.pkproject.bank.dao.AccountDAO;
import com.pkproject.bank.model.Deposit;
import com.pkproject.bank.model.Transfer;
import com.pkproject.bank.beans.User;
import com.pkproject.bank.dao.LoginDAO;
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
    private Account account = new Account();
    private Transfer transfer = new Transfer();
    private Deposit deposit = new Deposit();
    private AccountDAO accountDAO = new AccountDAO();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
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
        boolean valid = LoginDAO.validate(user, "client", transfer, deposit);

        if (valid) {
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
        boolean valid = LoginDAO.validate(user, "employee", transfer, deposit);

        if (valid) {
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
        accountDAO.changePassword(user);
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "password is changed",
                        "password is changed"));
    }


}