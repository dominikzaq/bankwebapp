package com.pkproject.bank.beans;

import com.pkproject.bank.model.Transfer;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by domin on 12.04.17.
 */
@Component
@ManagedBean
@SessionScoped
public class TransferView implements Serializable{

    private List<Transfer> transfers;

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public String getAllTransfers() {
        transfers = new ArrayList<>();

        return "/client/transfer/checkTransfer";
    }
}
