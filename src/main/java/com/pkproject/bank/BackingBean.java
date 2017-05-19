package com.pkproject.bank;

import javafx.event.ActionEvent;

import javax.faces.bean.*;
import java.io.Serializable;

/**
 * Created by domin on 5/19/17.
 */
@ManagedBean
@SessionScoped
public class BackingBean implements Serializable{
  private boolean conditionalFlag;

    public boolean isConditionalFlag() {
        return conditionalFlag;
    }

    public void setConditionalFlag(boolean conditionalFlag) {
        this.conditionalFlag = conditionalFlag;
    }

    public void performCheck() {
        this.conditionalFlag  = true;
        System.out.println(conditionalFlag);

    }
}
