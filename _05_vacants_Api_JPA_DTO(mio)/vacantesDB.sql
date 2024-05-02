create database lovelace_vacants; 

use lovelace_vacants;

insert into company(id,contact,location,name)
values ("111111","23242424","calle", "riwi");

desc vacant;
select * from vacant;
insert into vacant(id,description,status,title,company_id)
values(1, "Team","ACTIVE","Leader",111111)