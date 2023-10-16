CREATE SCHEMA preAVA;
USE preAVA ;


CREATE TABLE IF NOT EXISTS produto (
	id       int not null primary key,
	nome  varchar (50) not null,
	marca varchar (50) null,
	preco double);
    
    insert into produto values(1,'asdads','asdasd',123);
    
    
    select * from produto;