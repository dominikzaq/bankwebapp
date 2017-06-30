package com.pkproject.bank.dao;

import com.pkproject.bank.beans.User;
import com.pkproject.bank.model.Deposit;
import com.pkproject.bank.model.Transfer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by domin on 6/30/17.
 */
public class DataDAO {
    Connection con = null;
    PreparedStatement ps = null;
    String query = "";

    public void changePersonalDate(User user) {
        try {
            query = "UPDATE `bank`.`Client` SET `firstname`='as', `lastname`='as', `sex`='Female', `date_of_birth`='2019-05-06', `place_of_birth`='asda', `citizenship`='sada' WHERE `idClient`='2';\n";
            con = DataConnect.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeAddress(User user) {
     /*   query = "";
        con = DataConnect.getConnection();
        ps = con.prepareStatement(query);
        ps.executeUpdate();*/

    }

    public void changeContact(User user) {
        query = "";
        con = DataConnect.getConnection();

    }

    public void changePassword(User user) {
        query = "";
        con = DataConnect.getConnection();

    }
}
