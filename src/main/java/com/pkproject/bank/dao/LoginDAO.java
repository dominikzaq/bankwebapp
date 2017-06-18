package com.pkproject.bank.dao;

import com.pkproject.bank.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	public static boolean validate(User user, String typeAccount) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select * from Account where username = ? and password = ? and type_account= ?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword1());
			ps.setString(3, typeAccount);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setSex(rs.getString("sex"));
				user.setPesel(rs.getString(""));
				user.setDateOfBirth(rs.getDate("date_of_birth"));
				user.setPlaceOfBirth(rs.getString("place_of_birth"));
				user.setCitizenship(rs.getString("citizenship"));

				user.setCity(rs.getString("city"));
				user.setStreet(rs.getString("street"));
				user.setPostCode(rs.getString("postcode"));
				user.setCountry(rs.getString("country"));

				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getInt("ph"));

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