package com.pkproject.bank.beans;

import com.pkproject.bank.dao.AccountDAO;
import com.pkproject.bank.dao.SearchDAO;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
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
    private User user = new User();
    private User tempUser = new User();
    private boolean disable = true;

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

    public void searchClientByPesel() {
        user.setPesel(search);

        boolean isPesel = searchDAO.clientByPesel(user);
        if(isPesel) {
            disable = false;
            tempUser = user;
        } else {
            search = "";
            user = new User();
            tempUser = new User();
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
        user = tempUser;
    }

    public void changeAddressDetails() {
        accountDAO.changeAddressDetails(tempUser);
        user = tempUser;
    }

    public void changeContactInformation() {
        accountDAO.changeContactInformation(tempUser);
        user = tempUser;
    }

    public void addMoney() {
        accountDAO.moneyOperation(tempUser);
        user = tempUser;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public void changePassword() {

    }
}
