package com.pkproject.bank.beans;

import com.pkproject.bank.dao.AccountDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by domin on 5/14/17.
 */
@ManagedBean(name = "search")
@SessionScoped
public class SearchBean implements Serializable {
    private String search;
    private AccountDAO accountDAO;
    private User user;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void searchClientByPesel() {
        accountDAO = new AccountDAO();
        user = new User();
        user.setPesel(search);

        if(accountDAO.userByPesel(user)) {

        }
    }
}
