package com.pkproject.bank.dao;

import com.pkproject.bank.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by domin on 6/20/17.
 */
public class SearchDAO {
    private Connection con = null;
    private PreparedStatement ps = null;
    private String query;
    private boolean result;

    public boolean clientByPesel(User user) {
        result = false;

        try {
            query = "Select * from Account as a join Client as c on a.Client_idClient = c.idClient where c.pesel=?";
            con = DataConnect.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user.getPesel());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setIdClient(rs.getInt("idClient"));
                user.setIdAccount(rs.getInt("idAccount"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setSex(rs.getString("sex"));
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
