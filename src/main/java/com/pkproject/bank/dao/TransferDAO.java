package com.pkproject.bank.dao;

import com.pkproject.bank.beans.User;
import com.pkproject.bank.model.Transfer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by domin on 6/20/17.
 */
public class TransferDAO {
    Connection con = null;
    PreparedStatement ps = null;
    String query = "";

    public void sendMoney(User user, Transfer transfer) {
        query = "INSERT INTO `bank`.`Transfer` (`recipient_name`, `recipient_account_number`, `recipient_address`, `transfer_title`, `amount`, `data_transfer`, `nazwa_nadawcy`, `Account_idAccount`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        con = DataConnect.getConnection();
        try {
            ps = con.prepareStatement(query);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
