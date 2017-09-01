<h1>web application</h1>
<p>jsf/primefaces</p>

<p>
database: mysql
login: root
password: root
</p>

<code>
CREATE SCHEMA bank;

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

create table Transfer ( idTransfer int not null auto_increment primary key, recipient_name varchar(255) null, recipient_account_number varchar(27) not null, sender_account_number varchar(27) not null, recipient_address varchar(500) null, transfer_title varchar(1000) null, amount_of_operation DOUBLE null, data_transfer date not null, Account_idAccount int null, foreign key (Account_idAccount) references bank.Account (idAccount) ); 
</code>
