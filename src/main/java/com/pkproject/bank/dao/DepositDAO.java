package com.pkproject.bank.dao;

import com.pkproject.bank.beans.User;
import com.pkproject.bank.model.Deposit;
import com.pkproject.bank.model.Transfer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by domin on 6/20/17.
 */
public class DepositDAO {
    Connection con = null;
    PreparedStatement ps = null;
    String query = "";

    public void createDeposit(User user, Deposit deposit) {
        query = "INSERT INTO `bank`.`Deposit` (`name_deposit`, `closing_date`,`amount`, `Account_idAccount`) VALUES (?, '2017-05-09',?, ?);\n";
        con = DataConnect.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, deposit.getNameOfDeposit());
            ps.setDouble(2, deposit.getAmount());
            ps.setInt(3, user.getIdAccount());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //usun pieniadze z konta
    }

    public void deleteDepositById(User user, Deposit deposit) {
        query = "";



        //dodaj pieniadze do konta
        query = "";

    }
}
