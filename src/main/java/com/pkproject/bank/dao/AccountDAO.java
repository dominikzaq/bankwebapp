package com.pkproject.bank.dao;

import com.pkproject.bank.beans.Account;
import com.pkproject.bank.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by domin on 6/19/17.
 */
public class AccountDAO {
    private PreparedStatement preparedStatement;
    private Connection con;
    private String query;

    public void createUser(User user) throws SQLException {
        con = DataConnect.getConnection();

       query = "INSERT INTO `bank`.`Client` (`firstname`, `lastname`,`email`, `sex`, `pesel`, `date_of_birth`, `place_of_birth`, `citizenship`, `city`, `street`, `number_street`, `postcode`, `country`, `phone`) " +
                "VALUES (?, ?, ?, ?, ?, '2017-05-05', ?, ?, ?, ?, ?, ?, ?, ?);\n";
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getSex());
            preparedStatement.setString(5, user.getPesel());
           // preparedStatement.setDate(5, user.getDateOfBirth());
            preparedStatement.setString(6, user.getPlaceOfBirth());
            preparedStatement.setString(7, user.getCitizenship());
            preparedStatement.setString(8, user.getCity());
            preparedStatement.setString(9, user.getStreet());
            preparedStatement.setInt(10, user.getStreetNumber());
            preparedStatement.setString(11, user.getPostCode());
            preparedStatement.setString(12, user.getCountry());
            preparedStatement.setInt(13, user.getPhoneNumber());
            preparedStatement.execute();

            query = "select idClient from `Client` where pesel='" + user.getPesel() + "'";
            preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            int idClient = 0;
            while(resultSet.next()) {
                idClient = resultSet.getInt(1);
            }

            query = "INSERT INTO `bank`.`Account` (`username`, `password`, `type_account`, `money`, `number_account`, `Client_idClient`) VALUES (?, ?, ?, ?, ?, ?);\n";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword1());
            preparedStatement.setString(3, "client");
            preparedStatement.setDouble(4, user.getMoney());
            preparedStatement.setString(5, user.getNumberAccount());
            preparedStatement.setInt(6, idClient);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (con != null) {
                con.close();
            }
        }
    }

    public void deleteUser(User user) {
        con = DataConnect.getConnection();

        query = "DELETE from Transfer where Account_idAccount = 4";
        try {
            preparedStatement = con.prepareStatement(query);

            preparedStatement.executeUpdate();

            query = "DELETE from Deposit where Account_idAccount = 4";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();

            query = "DELETE from Account where Account_idAccount = 4";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();

            query = "DELETE from Client where idClient = 4";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePassword(User user) {

    }
}

