package com.pkproject.bank.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by domin on 5/16/17.
 */
@ManagedBean()
@SessionScoped
public class Transfer implements Serializable {
    private int idTransfer;
    private String recipientName;
    private String accountNumberRecipient;
    private String recipientAddress;
    private String transferTitle;
    private Date dataTransfer;
    private Integer amount;
    private String nameSender;

    public int getIdTransfer() {
        return idTransfer;
    }

    public void setIdTransfer(int idTransfer) {
        this.idTransfer = idTransfer;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getAccountNumberRecipient() {
        return accountNumberRecipient;
    }

    public void setAccountNumberRecipient(String accountNumberRecipient) {
        this.accountNumberRecipient = accountNumberRecipient;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getTransferTitle() {
        return transferTitle;
    }

    public void setTransferTitle(String transferTitle) {
        this.transferTitle = transferTitle;
    }

    public Date getDataTransfer() {
        return dataTransfer;
    }

    public void setDataTransfer(Date dataTransfer) {
        this.dataTransfer = dataTransfer;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNameSender() {
        return nameSender;
    }

    public void setNameSender(String nameSender) {
        this.nameSender = nameSender;
    }

    public void send() {
        System.out.println("udalo sie");
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean getTrue() {
        return true;
    }

}

