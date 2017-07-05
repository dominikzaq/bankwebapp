package com.pkproject.bank.beans;

import com.pkproject.bank.UserLogin;
import com.pkproject.bank.model.Transfer;
import com.pkproject.bank.dao.TransferDAO;
import com.pkproject.bank.util.SessionUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * Created by domin on 6/21/17.
 */
@ManagedBean
@SessionScoped
public class TransferMoney {
    private TransferDAO transferDAO = new TransferDAO();
    private Transfer transfer = new Transfer();
    private User user = new User();

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

    public String transferMoney() {

        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        UserLogin  userLogin = (UserLogin) sessionMap.get("userLogin");
        user = userLogin.getUser();
        transferDAO.sendMoney(user, transfer);

        transferDAO = new TransferDAO();
        user = new User();
        user.setIdAccount(1);
        user.setNumberAccount("111111111111");
        transferDAO.sendMoney(user, transfer);
        return "/client/mainclient";
    }


}
