package com.pkproject.bank.dao;

/**
 * Created by domin on 5/4/17.
 */
public class LoginDAO {

    public static boolean validate(String userName, String password) {
        if(userName.equals("user") && password.equals("user")) {
            return true;
        }
        return false;
    }
}
