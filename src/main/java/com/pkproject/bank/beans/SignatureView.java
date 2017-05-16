package com.pkproject.bank.beans;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by domin on 5/15/17.
 */
@ManagedBean
@SessionScoped
public class SignatureView implements Serializable {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
