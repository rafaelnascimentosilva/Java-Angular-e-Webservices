/*	MYSQL	*/
CREATE TABLE tb_contato(
	id_contato  int(2) 		not null auto_increment,
	nome 		varchar(45) not null,
	fone 		varchar(45) not null,
	nascimento 	date,
	primary key(id_contato)	);

CREATE TABLE tb_usuario(
	id_usuario int(2) not null auto_increment,
	login varchar(45) not null,
	senha varchar(45) not null,
	primary key(id_usuario)	);	
	
	
/*	SQL SERVER	*/
	
CREATE TABLE [dbregisterAngular].[dbo].[tb_contato](
	id_contato  int identity (1,1) PRIMARY KEY,
	nome 		varchar(45) not null,
	fone 		varchar(45) not null,
	nascimento 	date);


CREATE TABLE [dbregisterAngular].[dbo].[tb_usuario](
	id_usuario int identity (1,1) PRIMARY KEY,
	login varchar(45) not null,
	senha varchar(45) not null	);