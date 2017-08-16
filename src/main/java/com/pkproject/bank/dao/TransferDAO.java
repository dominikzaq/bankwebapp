package com.pkproject.bank.dao;

import com.pkproject.bank.beans.User;
import com.pkproject.bank.model.Transfer;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by domin on 6/20/17.
 */
public class TransferDAO {
    Connection con = null;
    PreparedStatement ps = null;
    String query = "";

    public void sendMoney(User user, Transfer transfer) {
        query = "INSERT INTO `bank`.`Transfer` (`recipient_name`, `recipient_account_number`, `sender_account_number`, `recipient_address`, `transfer_title`, `amount`, `data_transfer`, `Account_idAccount`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);\n";
        con = DataConnect.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, transfer.getRecipientName());
            ps.setString(2,transfer.getAccountNumberRecipient());
            ps.setString(3, user.getNumberAccount());
            ps.setString(4, transfer.getRecipientAddress());
            ps.setString(5,transfer.getTransferTitle());
            ps.setDouble(6, transfer.getAmount());
            DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
            ps.setDate(7, Date.valueOf(df.format(transfer.getDataTransfer())));
            ps.setInt(8, user.getIdAccount());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        user.setMoney(user.getMoney() - transfer.getAmount());

        query = "UPDATE `bank`.`Account` SET `money`=? WHERE `idAccount`= ?";
        con = DataConnect.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setDouble(1,user.getMoney());
            ps.setInt(2, user.getIdAccount());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllTransfersById(User user, List<Transfer> transfers) {
        query = "select * from Account  as a join Transfer as t on a.idAccount = t.Account_idAccount where a.idAccount = ?";
        con = DataConnect.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, user.getIdAccount());
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Transfer transfer = new Transfer();

                transfer.setAccountNumber(rs.getString("number_account"));
                transfer.setTransferTitle(rs.getString("transfer_title"));
                transfer.setAmount(rs.getDouble("amount"));
                transfer.setIdTransfer(rs.getInt("idTransfer"));
                transfers.add(transfer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
