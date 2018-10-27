drop database prontuario;
create database prontuario;
use prontuario;

create table if not exists paciente(
	pacId int(5) primary key auto_increment,
    pacNome varchar(200),
    pacTelefone varchar(40),
    pacRg varchar(30),
    pacCpf varchar(30),
    pacSexo varchar(15),
    pacAla varchar(30),
    pacQuarto int(5),
    pacLeito int(5),
    pacHistorico varbinary(1000),
    pacDataNascimento varchar(20)
);

select * from paciente where pacId = 2 order by pacId;
insert into paciente() values(not null, 'joao','343253', '3425', '4535345', 'Masculino', 'B', 1, 4, 'loucura', '30/06/2000');

create table if not exists administrador(
	admId int(5) primary key auto_increment,
    admNome varchar(200),
    admCoren varchar(100),
    admSenha varchar(20)
);

create table if not exists enfermeiro(
	enfId int(5) primary key auto_increment,
    enfNome varchar(200),
    enfCoren varbinary(10000),
    enfSenha varchar(20)
);
insert into enfermeiro() values(not null,'nome', 'coren', 'a');

-- MD5
INSERT INTO enfermeiro (enfId, enfCoren) VALUES (not null, cast(MD5('abc123') as char(50))); 
INSERT INTO paciente (pacId, pacHistorico) VALUES (not null, cast(MD5('abc123') as char(50))); 

INSERT INTO paciente (proId, pacHistorico, pacId) VALUES (not null, cast(MD5('abc123') as char(50))); 

select *, cast(MD5(enfCoren) as char(50)) from enfermeiro;

-- AES
insert into enfermeiro(enfId, enfCoren) values(not null, AES_ENCRYPT('123', 'chave'));
insert into paciente(pacId, pacHistorico) values(not null, AES_ENCRYPT('PALMEIRAS NÃO TEM MUNDIAL', 'chave'));

select *, cast(AES_DECRYPT(enfCoren, 'chave') AS CHAR(50)) end_data FROM enfermeiro;


create table if not exists prontuario(
	proId int(5) primary key auto_increment,
    descricao varchar(1000),
    hora varchar(20),
    numeroProntuario varchar(40),
    pacId int(5),
    Constraint FK_prontuario_paciente_pacId Foreign key (pacId) References paciente (pacId)
);

select *, cast(AES_DECRYPT(descricao, 'chave') AS CHAR(50)) descricao  FROM prontuario;