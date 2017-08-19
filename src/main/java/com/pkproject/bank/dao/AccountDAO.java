package com.pkproject.bank.dao;

import com.pkproject.bank.beans.Account;
import com.pkproject.bank.beans.User;

import java.sql.*;
import java.time.LocalDate;


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
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);\n";
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getSex());
            preparedStatement.setString(5, user.getPesel());
            Date date=Date.valueOf("" +user.getDateOfBirth());
            preparedStatement.setDate(6, date);
            preparedStatement.setString(7, user.getPlaceOfBirth());
            preparedStatement.setString(8, user.getCitizenship());
            preparedStatement.setString(9, user.getCity());
            preparedStatement.setString(10, user.getStreet());
            preparedStatement.setInt(11, user.getStreetNumber());
            preparedStatement.setString(12, user.getPostCode());
            preparedStatement.setString(13, user.getCountry());
            preparedStatement.setInt(14, user.getPhoneNumber());
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

        try {
            query = "DELETE from Transfer where Account_idAccount = " + user.getIdAccount();
            preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();

            query = "DELETE from Deposit where Account_idAccount = "+ user.getIdAccount();
            preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();

            query = "DELETE from Account where idAccount = " + user.getIdAccount();
            preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();

            query = "DELETE from Client where idClient = " + user.getIdClient();
            preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePassword(User user) {
        con = DataConnect.getConnection();
        try {
            query = "UPDATE `bank`.`Account` SET `password`=? WHERE `idAccount`= ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, user.getTempPassword2());
            preparedStatement.setInt(2, user.getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }


    public void changePersonalDetails(User user) {
        con = DataConnect.getConnection();
        try {
            query = "UPDATE `bank`.`Client` SET `firstname`=?, `lastname`=?, `sex`=?, `pesel`=?, `date_of_birth`=?, `place_of_birth`=?, `citizenship`=? WHERE `idClient`=?;\n";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getSex());
            preparedStatement.setString(4, user.getPesel());

            Date date=Date.valueOf("2020-04-01");

            preparedStatement.setDate(5, date);
            preparedStatement.setString(6, user.getPlaceOfBirth());
            preparedStatement.setString(7, user.getCitizenship());
            preparedStatement.setInt(8, user.getIdClient());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeAddressDetails(User user) {
        con = DataConnect.getConnection();
        try {
            query = "UPDATE `bank`.`Client` SET `city`=?, `street`=?, `number_street`=?, `postcode`=?, `country`=? WHERE `idClient`=?;\n";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, user.getCity());
            preparedStatement.setString(2, user.getStreet());
            preparedStatement.setInt(3, user.getStreetNumber());
            preparedStatement.setString(4, user.getPostCode());
            preparedStatement.setString(5, user.getCountry());
            preparedStatement.setInt(6, user.getIdClient());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void changeContactInformation(User user) {
        con = DataConnect.getConnection();
        query = "UPDATE `bank`.`Client` SET `email`=?, `phone`=? WHERE `idClient`=?;\n\n";
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setInt(2, user.getPhoneNumber());
            preparedStatement.setInt(3, user.getIdClient());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void moneyOperation(User user) {
        con = DataConnect.getConnection();
        try {
            query = "UPDATE `bank`.`Account` SET `money`=? WHERE `idAccount`=?;";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setDouble(1, user.getMoney());
            preparedStatement.setInt(2, user.getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

