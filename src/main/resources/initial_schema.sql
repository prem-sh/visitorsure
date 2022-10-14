create database visitorsure;

use visitorsure;

create table user_role(
	role_id int not null auto_increment,
    role_name varchar(15) not null,
    discription varchar(250),
    primary key (role_id)
);

create table user(
	user_id int not null auto_increment, 
	first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) ,
    phone varchar(15) not null,
    profile_photo_url varchar(250) ,
    role_id int not null,
    primary key (user_id),
    foreign key (role_id) references user_role(role_id)
);

create table company(
	company_id int not null auto_increment,
    company_name varchar(50) not null,
    email varchar(50) ,
    phone varchar(15) not null,
    primary key(company_id)
);

create table office(
	office_id int not null auto_increment,
    company_id int not null,
    phone varchar(15) not null,
    address varchar(250),
    email varchar(50) not null,
    primary key (office_id),
    foreign key (company_id) references company(company_id)
);

create table visitor(
	visitor_id int not null auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) ,
    phone varchar(15) not null,
    profile_photo_url varchar(250) ,
    primary key (visitor_id)
);

create table employee(
	employee_id int not null auto_increment,
    office_id int not null,
    employee_id_internal varchar(7),
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) ,
    phone varchar(15) not null,
    profile_photo_url varchar(250) ,
    primary key (employee_id),
    foreign key (office_id) references office(office_id)
);

create table visit(
	visit_id int not null auto_increment,
    visitor_id int not null,
    employee_id int not null,
    office_id int not null,
    visit_start_date date not null,
    visit_end_date date not null,
    primary key (visit_id),
    foreign key (visitor_id) references visitor(visitor_id),
    foreign key (employee_id) references employee(employee_id)
);

