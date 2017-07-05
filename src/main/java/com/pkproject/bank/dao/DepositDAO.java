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
        query = "DELETE FROM `bank`.`Deposit` WHERE `idDeposit`='1';\n";



        //dodaj pieniadze do konta
        query = "";

    }

    public void getAllDeposit(List<Deposit> deposits) {
        query = "SELECT *FROM `bank`.`Deposit` WHERE `Account_idAccount`='4';\n";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Deposit deposit = new Deposit();
                deposit.setIdDeposit(rs.getInt("idDeposit"));
                deposit.setNameOfDeposit(rs.getString("name_deposit"));
                deposit.setAmount(rs.getDouble("amount"));
                deposit.setClosingDate(rs.getDate(String.valueOf(rs.getDate("closing_date"))));
                deposit.setInterestRate(rs.getDouble("1.5"));
                deposits.add(deposit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
