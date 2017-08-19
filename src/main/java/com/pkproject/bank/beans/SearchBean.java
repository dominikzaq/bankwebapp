package com.pkproject.bank.beans;

import com.pkproject.bank.dao.AccountDAO;
import com.pkproject.bank.dao.SearchDAO;
import com.pkproject.bank.dao.TransferDAO;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by domin on 5/14/17.
 */
@ManagedBean(name = "search")
@ViewScoped
public class SearchBean implements Serializable {
    private String search;
    private SearchDAO searchDAO = new SearchDAO();
    private AccountDAO accountDAO = new AccountDAO();
    private Double money;

    @ManagedProperty(value = "#{user}")
    private User user;

    private User tempUser;
    private boolean disable = true;

    @PostConstruct
    public void init() {
        tempUser = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public User getTempUser() {
        return tempUser;
    }

    public void setTempUser(User tempUser) {
        this.tempUser = tempUser;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public void searchClientByPesel() {
        user.setPesel(search);

        boolean isPesel = searchDAO.clientByPesel(user);
        if(isPesel) {
            disable = false;
            tempUser = user;
        } else {
            search = "";
            user = new User();
            tempUser = (User) user.clone();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Account doesn't exists",
                            "Please enter correct pesel"));
        }
    }

    public void deleteAccount() {
        if(user.getIdAccount() != null) {
            accountDAO = new AccountDAO();
            accountDAO.deleteUser(user);
            user = new User();
            disable = true;
            search = "";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Account exists",
                            "you have not choose any client's account"));
        }

    }

    public void changePersonalDetails() {
        accountDAO.changePersonalDetails(tempUser);
        user = (User) tempUser.clone();
    }

    public void changeAddressDetails() {
        accountDAO.changeAddressDetails(tempUser);
        user = (User) tempUser.clone();
    }

    public void changeContactInformation() {
        accountDAO.changeContactInformation(tempUser);
        user = (User) tempUser.clone();
    }

    public void addMoney() {
        user.addMoney(money);
        accountDAO.moneyOperation(tempUser);
        money = 0.;
    }


    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public void changePassword() {
        accountDAO.changePassword(tempUser);
    }
}
