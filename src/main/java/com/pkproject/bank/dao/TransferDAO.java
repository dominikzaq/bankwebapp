package com.pkproject.bank.dao;

import com.pkproject.bank.beans.Transfer;
import com.pkproject.bank.beans.User;

import javax.xml.crypto.Data;
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
        query = "INSERT INTO `bank`.`Transfer` (`recipient_name`, `recipient_account_number`, `sender_account_number`, `recipient_address`, `transfer_title`, `amount`, `data_transfer`, `Account_idAccount`) VALUES (?, ?, ?, ?, ?, ?, '2017-06-06', ?);\n";
        con = DataConnect.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, transfer.getRecipientName());
            ps.setString(2,transfer.getAccountNumberRecipient());
            ps.setString(3,"transfer dao nalezy zmienic to");
            ps.setString(4, transfer.getRecipientAddress());
            ps.setString(5,transfer.getTransferTitle());
            ps.setInt(6, transfer.getAmount());
            ps.setInt(7, 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
