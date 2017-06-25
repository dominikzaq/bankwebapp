package com.pkproject.bank.beans;

import com.pkproject.bank.dao.AccountDAO;
import com.pkproject.bank.dao.SearchDAO;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by domin on 5/14/17.
 */
@ManagedBean(name = "search")
@SessionScoped
public class SearchBean implements Serializable {
    private String search;
    private SearchDAO searchDAO;
    private AccountDAO accountDAO;
    private User user;

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
        searchDAO = new SearchDAO();
        user = new User();
        user.setPesel(search);
        boolean isPesel = searchDAO.clientByPesel(user);
        if(isPesel) {

        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "this pesel doesn't exist",
                            "Please enter correct pesel"));
        }
    }

    public void deleteAccount() {
        accountDAO = new AccountDAO();
        accountDAO.deleteUser(user);
    }
}
