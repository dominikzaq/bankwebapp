package com.pkproject.bank.dao;

import com.pkproject.bank.model.Deposit;
import com.pkproject.bank.beans.User;
import com.pkproject.bank.model.Transfer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	public static boolean validate(User user, String typeAccount, Transfer transfer, Deposit deposit) {
		Connection con = null;
		PreparedStatement ps = null;
		String query = "";

		try {
			if(typeAccount.equals("client")) {
				query = "Select * from Account as a join Client as c on a.Client_idClient = c.idClient where a.username = ? and a.password = ? and a.type_account= ?";
				con = DataConnect.getConnection();
				ps = con.prepareStatement(query);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword1());
				ps.setString(3, typeAccount);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					user.setIdClient(rs.getInt("idClient"));
					user.setIdAccount(rs.getInt("idAccount"));
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
			} else {
				query = "Select * from Account as a  where a.username = ? and a.password = ?";
				con = DataConnect.getConnection();
				ps = con.prepareStatement(query);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword1());
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					return true;
				}
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