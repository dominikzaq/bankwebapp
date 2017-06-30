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

    public void searchClientByPesel() {
        user.setPesel(search);

        boolean isPesel = searchDAO.clientByPesel(user);
        if(isPesel) {
            disable = false;
        } else {
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
            user = null;
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Account exists",
                            "you have not choose any client's account"));
        }

    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
}
