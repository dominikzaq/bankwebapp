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
    private Connection connection;
    private String query;

    public void createUser(User user) throws SQLException {
        connection = DataConnect.getConnection();

       query = "INSERT INTO `bank`.`Client` (`firstname`, `lastname`, `sex`, `pesel`, `date_of_birth`, `place_of_birth`, `citizenship`, `city`, `street`, `number_street`, `postcode`, `country`, `phone`) " +
                "VALUES (?, ?, ?, ?, '2017-05-05', ?, ?, ?, ?, ?, ?, ?, ?);\n";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getSex());
            preparedStatement.setString(4, user.getPesel());
           // preparedStatement.setDate(5, user.getDateOfBirth());
            preparedStatement.setString(5, user.getPlaceOfBirth());
            preparedStatement.setString(6, user.getCitizenship());
            preparedStatement.setString(7, user.getCity());
            preparedStatement.setString(8, user.getStreet());
            preparedStatement.setInt(9, user.getStreetNumber());
            preparedStatement.setString(10, user.getPostCode());
            preparedStatement.setString(11, user.getCountry());
            preparedStatement.setInt(12, user.getPhoneNumber());
            preparedStatement.execute();

            query = "select idClient from `Client` where pesel='" + user.getPesel() + "'";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            int idClient = 0;
            while(resultSet.next()) {
                idClient = resultSet.getInt(1);
            }

            query = "INSERT INTO `bank`.`Account` (`username`, `password`, `type_account`, `money`, `number_account`, `Client_idClient`) VALUES (?, ?, ?, ?, ?, ?);\n";
            preparedStatement = connection.prepareStatement(query);
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

            if (connection != null) {
                connection.close();
            }
        }
    }

    public void deleteUser(User user) {
    }

    public void changePassword(User user) {

    }

    public boolean userByPesel(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "";

        try {
            query = "Select * from Account as a join Client as c on a.Client_idClient = c.idClient where c.pesel=?";
            con = DataConnect.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user.getPesel());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setSex(rs.getString("sex"));
                user.setPesel(rs.getString("pesel"));
                user.setDateOfBirth(rs.getDate("date_of_birth"));
                user.setPlaceOfBirth(rs.getString("place_of_birth"));
                user.setCitizenship(rs.getString("citizenship"));

                user.setCity(rs.getString("city"));
                user.setStreet(rs.getString("street"));
                user.setPostCode(rs.getString("postcode"));
                user.setCountry(rs.getString("country"));
                user.setStreetNumber(rs.getInt("number_street"));

                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getInt("phone"));

                user.setNumberAccount(rs.getString("number_account"));
                user.setMoney(rs.getDouble("money"));
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
        }
        return false;
    }

}

