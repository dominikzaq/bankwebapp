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
            }CREATE SCHEMA bank;

create table Account
(
  idAccount int not null auto_increment
    primary key,
  username varchar(255) not null,
  password varchar(255) not null,
  type_account varchar(100) not null,
  money int null,
  number_account varchar(27) not null,
  Client_idClient int null,
  foreign key (Client_idClient) references bank.Client (idClient)
);

create table Account_has_Employee
(
  Account_idAccount int null,
  Employee_idEmployee int null,
  foreign key (Account_idAccount) references bank.Account (idAccount),
  foreign key (Employee_idEmployee) references bank.Employee (idEmployee)
);

create table Client
(
	idClient int not null auto_increment
		primary key,
	firstname varchar(255) not null,
	lastname varchar(255) not null,
    email varchar(255) not null,
	sex varchar(50) not null,
	pesel varchar(255) not null,
	date_of_birth DATE not null,
	place_of_birth varchar(255) not null,
	citizenship varchar(255) not null,
	city varchar(255) not null,
	street varchar(255) not null,
	number_street int not null,
	postcode varchar(255) not null,
	country varchar(255) not null,
    phone int not null
);


create table Deposit
(
  idDeposit int not null auto_increment
    primary key,
  name_deposit varchar(255) not null,
  amount Double not null,
  closing_date date not null,
   Account_idAccount int null,
  foreign key (Account_idAccount) references bank.Account (idAccount)
);

create table Employee
(
  idEmployee int not null auto_increment
    primary key,
  name int null,
  idNumber int not null
);

create table Transfer
(
  idTransfer int not null auto_increment
    primary key,
  recipient_name varchar(255) null,
  recipient_account_number varchar(27) not null,
  sender_account_number varchar(27) not null,
  recipient_address varchar(500) null,
  transfer_title varchar(1000) null,
  amount DOUBLE null,
  data_transfer date not null,
  Account_idAccount int null,
  foreign key (Account_idAccount) references bank.Account (idAccount)
);



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
        try {
            query = "UPDATE `bank`.`Account` SET `password`=? WHERE `idAccount`= ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, user.getPassword2());
            preparedStatement.setInt(2, user.getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }


    public void changePersonalDetails() {
        query = "UPDATE `bank`.`Client` SET `firstname`='a', `lastname`='a', `sex`='Malae', `pesel`='95121206811', `date_of_birth`='2017-05-06', `place_of_birth`='asdf', `citizenship`='sadq' WHERE `idClient`='2';\n";
    }

    public void changeAddressDetails() {
        query = "UPDATE `bank`.`Client` SET `city`='a', `street`='a', `number_street`='89', `postcode`='56-56a', `country`='fasa' WHERE `idClient`='2';\n";

    }

    public void changeContactInformation() {
        query = "UPDATE `bank`.`Client` SET `email`='asds@wp.pl', `phone`='665654' WHERE `idClient`='2';\n\n";

    }

    public void addMoney() {
        query = "UPDATE `bank`.`Account` SET `money`='50' WHERE `idAccount`='2';";

    }

    public void payOut() {
        query = "UPDATE `bank`.`Account` SET `money`='0' WHERE `idAccount`='2';";
    }

}

