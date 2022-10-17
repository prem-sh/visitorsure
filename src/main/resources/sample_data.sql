
-- sample data
insert into user(first_name, last_name, email, phone, profile_photo_url, role_id) 
values("anjan", "anjuvan", "anajn@amail.com", "9090909090",null,1);

insert into company(company_name, email, phone) 
values("Anjan and Co", "anjan@company.com", "90909090");

insert into office(company_id, phone, address, email) 
values(1,"9090909090" ,"Block y, A2Business plazza, Barty city, DSA", "anjan@office1.com");

insert into employee(office_id, employee_id_internal, first_name, last_name, email, phone, profile_photo_url) 
values(1, "EMP21", "Prathan", "Munthri", "pm@pmail.com", "9090909091", null);

insert into visitor(first_name, last_name, email, phone, profile_photo_url) 
values("Anbalagan", "V", "anub@zmail.com", "90909092", null);

insert into visit(visitor_id, employee_id, office_id, visit_start_date, visit_end_date, pass_code) 
values(1, 1, 1, "2022-10-03", "2022-10-31", 99999);
