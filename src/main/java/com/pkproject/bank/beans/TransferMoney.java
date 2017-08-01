package com.pkproject.bank.beans;

import com.pkproject.bank.UserLogin;
import com.pkproject.bank.model.Transfer;
import com.pkproject.bank.dao.TransferDAO;
import com.pkproject.bank.util.SessionUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * Created by domin on 6/21/17.
 */
@ManagedBean
@RequestScoped
public class TransferMoney {
    private TransferDAO transferDAO = new TransferDAO();
    private Transfer transfer = new Transfer();
    private UserLogin login;
    private User user = new User();

    @ManagedProperty(value = "#{login}")
    UserLogin userLogin;

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

    public String transferMoney() {
        user = userLogin.getUser();
        if(transfer.getAmount() > 0 && transfer.getAmount() < user.getMoney()) {
            transferDAO.sendMoney(user, transfer);
            transfer = new Transfer();
            userLogin.getUser().setMoney(userLogin.getUser().getMoney() - transfer.getAmount());
        } else {
            new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Incorrect amount",
                    "Please enter correct amount");
        }

        return "/client/transfer/transfer";
    }


}
