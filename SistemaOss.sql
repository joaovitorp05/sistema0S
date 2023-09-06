/**
 * Sistema para gestão de OS
 * @author Gustavo Cavalcante
 */
 
 create database dbsistemaos;
 use dbsistemaos;
   
 -- unique (não permite valores duplicados no campo)
 create table usuarios (
	id int primary key auto_increment,
    nome varchar(50) not null,
    login varchar(15) not null unique,
    senha varchar(250) not null,
    perfil varchar(10) not null
);

describe usuarios;

-- uso do md5() para criptografar uma senha
insert into usuarios(nome,login,senha,perfil)
values('Administrador','admin', md5('admin'), 'admin');

insert into usuarios(nome,login,senha,perfil)
values('José de Assis','joseassis', md5('123@senac'), 'user');


select * from usuarios;
select * from usuarios where nome = "Administrador";
select * from usuarios where login = "admin";

-- login(autenticação)
select * from usuarios where login = 'admin' and senha = md5('admin');

-- busca avançada pelo nome (estilo google)
select nome from usuarios where nome like 'r%' order by nome;

create table clientes (
	idcli int primary key auto_increment,
    nome varchar(50) not null,
    fone varchar(15) not null,
    cep varchar(10),
    endereco varchar(50) not null,
    numero varchar(10) not null,
    complemento varchar(20),
    bairro varchar(30) not null,
    cidade varchar(30) not null,
    uf char(2) not null
);

insert into clientes(nome,fone,cep,endereco,numero,complemento,bairro,cidade,uf)
values ('Kelly Cristina','99999-1234','03307000','Rua Tuiuti','2769','apt 23',
'Tatuapé','São Paulo','SP');
insert into clientes(nome,fone,cep,endereco,numero,complemento,bairro,cidade,uf)
values ('Sirlene Sanches','99999-1111','03307000','Rua Tuiuti','2769','apt 23',
'Tatuapé','São Paulo','SP');

select * from clientes;
delete from clientes where idcli = 1;
    
/* Relacionamento de tabelas 1 - N */

-- timestamp default current_timestamp (data e hora autmática)
-- decimal (números não inteiros) 10,2 (dígitos,casas decimais)
-- foreign key(FK) chave estrangeira
-- 1 (FK) ------- N (PK)
create table servicos (
	os int primary key auto_increment,
	dataOS timestamp default current_timestamp,
    equipamento varchar(200) not null,
    defeito varchar(200) not null,
    valor decimal(10,2),
    idcli int not null,
    foreign key(idcli) references clientes(idcli)
);
    
drop table servicos;

insert into servicos (equipamento,defeito,valor,idcli)
values ('Notebook LeNovo G90','Troca da fonte',250,1);

select * from servicos;

create table fornecedores (
	idfor int primary key auto_increment,
    razao varchar(50) not null,
    fantasia varchar(50) not null,
	vendedor varchar(20),
    cnpj varchar(20) not null unique,
	ie varchar(20),
    email varchar(50) not null,
	site varchar(50),
    fone varchar(15) not null,
    cep varchar(10),
    endereco varchar(50) not null,
    bairro varchar(30) not null,
    complemento varchar(20),
    numero varchar(10) not null,
    cidade varchar(30) not null,
    uf char(2) not null
);

insert into fornecedores (razao, fantasia, fone, email, cnpj, endereco,
numero, bairro, cidade, uf) values ('Terabyte Shop Comercial Ltda','Terabyte',
'41 33314545','contato@terabyteshop.com','07993973000118','Av. João Gualberto',
'1255','Alto da XV','Curitiba','PR');

select * from fornecedores;

-- tabela de produtos
-- date trabalhar com datas (AAAA-MM-DD)
-- char (String de caracteres não variáveis)
-- longblob (armazena formato binário "imagens")
create table produtos (
	codigo int primary key auto_increment,
    barcode varchar(250) unique,
    produto varchar(50) not null,
    lote varchar(20) not null,
    descricao varchar(250) not null,
    foto longblob,
    fabricante varchar(50),
    dataent timestamp default current_timestamp,
    dataval date not null,
    estoque int not null,
    estoquemin int not null,
    unidade char(2) not null,
    localarm varchar(50),
    custo decimal(10,2) not null,
    lucro decimal(10,2),
    idfor int not null,
    foreign key (idfor) references fornecedores (idfor)
);

drop table produtos;
drop table fornecedores;
drop table users;
drop table fornecedor;

-- tipo date YYYYMMDD
insert into produtos (produto, lote, descricao, dataval, estoque,
estoquemin, unidade, custo, idfor) values ('Fonte ATX 450','1',
'Fonte ATX Real 450 Watts',20280802,5,2,'UN',275.35,1);

select * from produtos;

-- selecionar produto pelo código (código do produto)
select * from produtos where codigo = 1;


-- selecionando o conteúdo de 2 ou mais tabelas
select * from servicos
inner join clientes
on servicos.idcli = clientes.idcli;

/** RELATÓRIOS **/
-- clientes
select nome,fone from clientes order by nome;

-- servicos
select
servicos.os,servicos.dataOS,servicos.equipamento,servicos.defeito,
servicos.valor,
clientes.nome
from servicos
inner join clientes
on servicos.idcli = clientes.idcli;

select * from produtos inner join fornecedores
on produtos.idfor = fornecedores.idfor
where codigo =1;





    