package com.pkproject.bank.beans;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by domin on 5/14/17.
 */
@ManagedBean
@SessionScoped
public class CalendarManagedBean implements Serializable {
    private Date date = new Date();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
