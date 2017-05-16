package com.pkproject.bank;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by domin on 12.04.17.
 */
@ManagedBean
@SessionScoped
public class B implements Serializable{
   String c = "k";

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void save() {
        System.out.println(c);
    }
}
