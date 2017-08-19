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
        query = "INSERT INTO `bank`.`Transfer` (`recipient_name`, `recipient_account_number`, `sender_account_number`,`amount_of_operation`,`balance`, `recipient_address`, `transfer_title`, `data_transfer`, `Account_idAccount`) VALUES (?, ?, ?, ?, ?, ?,?, ?, ?);\n";
        con = DataConnect.getConnection();
        user.deleteMoney(transfer.getAmount());

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, transfer.getRecipientName());
            ps.setString(2,transfer.getAccountNumberRecipient());
            ps.setString(3, user.getNumberAccount());
            ps.setDouble(4, transfer.getAmount());
            ps.setDouble(5, user.getMoney());
            ps.setString(6, transfer.getRecipientAddress());
            ps.setString(7,transfer.getTransferTitle());
            long millis=System.currentTimeMillis();
            java.sql.Date date=new java.sql.Date(millis);
            ps.setDate(8,date);
            ps.setInt(9, user.getIdAccount());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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


    public java.sql.Date sqlDate(java.util.Date calendarDate) {
        return new java.sql.Date(calendarDate.getTime());
    }

    public void getAllTransfersById(User user, List<Transfer> transfers) {
        query = "select * from Transfer where recipient_account_number = ?";
        con = DataConnect.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, user.getNumberAccount());
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Transfer transfer = new Transfer();

                transfer.setAccountNumber("receiver: my account"+rs.getString("recipient_account_number") + " and sender: " + rs.getString("sender_account_number"));
                transfer.setTransferTitle(rs.getString("transfer_title"));
                transfer.setAmount(rs.getDouble("amount_of_operation"));
                transfer.setBalance(rs.getDouble("balance"));
                transfer.setIdTransfer(rs.getInt("idTransfer"));
                transfer.setDataTransfer(rs.getDate("data_transfer"));
                transfers.add(transfer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        query = "select * from Transfer where sender_account_number = ?";
        con = DataConnect.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, user.getNumberAccount());
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Transfer transfer = new Transfer();

                transfer.setAccountNumber("receiver: "+rs.getString("recipient_account_number") + " and sender: my account " + rs.getString("sender_account_number"));
                transfer.setTransferTitle(rs.getString("transfer_title"));
                transfer.setAmount(-1 * rs.getDouble("amount_of_operation"));
                transfer.setBalance(rs.getDouble("balance"));
                transfer.setIdTransfer(rs.getInt("idTransfer"));
                transfer.setDataTransfer(rs.getDate("data_transfer"));
                transfers.add(transfer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
