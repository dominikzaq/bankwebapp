package com.pkproject.bank.dao;

import com.pkproject.bank.beans.User;
import com.pkproject.bank.model.Deposit;
import com.pkproject.bank.model.Transfer;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by domin on 6/20/17.
 */
public class DepositDAO {
    Connection con = null;
    PreparedStatement ps = null;
    String query = "";

    public void createDeposit(User user, Deposit deposit) {
        /*
         * delete money with account
         */
        user.setMoney(user.getMoney() - deposit.getAmount());
        query = "UPDATE `bank`.`Account` SET `money`=? WHERE `idAccount`= ?";
        con = DataConnect.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setDouble(1, user.getMoney());
            ps.setInt(2, user.getIdAccount());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*
         * add money to deposit
         */
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
    }

    public void deleteDepositById(User user, Deposit deposit) {
        query = "DELETE FROM `bank`.`Deposit` WHERE `idDeposit`='1';\n";



        //dodaj pieniadze do konta
        query = "";

    }

    public void getAllDeposit(List<Deposit> deposits, User user) {
        query = "SELECT *FROM `bank`.`Deposit` WHERE `Account_idAccount`= ?;\n";
        con = DataConnect.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, user.getIdAccount());
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Deposit deposit = new Deposit();
           /*     deposit.setIdDeposit(rs.getInt("idDeposit"));
                deposit.setNameOfDeposit(rs.getString("name_deposit"));
                deposit.setAmount(rs.getDouble("amount"));
                deposit.setClosingDate(rs.getDate("closing_date"));
                deposit.setInterestRate(1.5);*/
                deposit.setIdDeposit(1);
                deposit.setNameOfDeposit("asd");
                deposit.setAmount(1.015);
                deposit.setClosingDate(new Date());
                deposit.setInterestRate(1.5);
                deposits.add(deposit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
