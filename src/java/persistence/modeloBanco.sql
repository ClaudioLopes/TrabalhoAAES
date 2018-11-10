DROP TABLE cliente;
DROP TABLE produto_empresa;
DROP TABLE empresa;
DROP TABLE produto;
DROP TABLE superior;
DROP TABLE funcionario;
DROP TABLE pedido;
drop table combo;

CREATE TABLE cliente (
    id_cliente INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(20) NOT NULL,
    telefone VARCHAR(15)
);

CREATE TABLE empresa (
    id_empresa INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    senha VARCHAR(20) NOT NULL,
    nome VARCHAR(200) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE produto (
    id_produto INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(200) NOT NULL UNIQUE,
    valor DOUBLE NOT NULL
);

CREATE TABLE produto_empresa (
    id_empresa INTEGER,
    id_produto INTEGER,
    FOREIGN KEY (id_empresa) REFERENCES empresa(id_empresa) ON DELETE CASCADE,
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto) ON DELETE CASCADE
);

CREATE TABLE funcionario (
    id_funcionario INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_empresa integer,
    nome VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    funcao VARCHAR(100) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    responsavel VARCHAR(200),
    foreign key (id_empresa) references empresa(id_empresa) on delete cascade
);

CREATE TABLE superior (
    id_funcionario INTEGER,
    id_superior INTEGER,
    FOREIGN KEY (id_superior) REFERENCES funcionario(id_funcionario) ON DELETE CASCADE,
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario) ON DELETE CASCADE
);

CREATE TABLE pedido (
    id_pedido INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    estado VARCHAR(50) NOT NULL,
    id_funcionario_responsavel INTEGER,
    id_cliente INTEGER NOT NULL,
    id_empresa INTEGER NOT NULL,
    total DOUBLE NOT NULL,
    forma_pagamento VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_funcionario_responsavel) REFERENCES funcionario(id_funcionario) ON DELETE CASCADE,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON DELETE CASCADE,
    FOREIGN KEY (id_empresa) REFERENCES empresa(id_empresa) ON DELETE CASCADE
);

CREATE TABLE produto_pedido (
    id_produto INTEGER,
    id_pedido INTEGER,
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto) ON DELETE CASCADE,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido) ON DELETE CASCADE
);


create table combo (
    id_combo INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_empresa integer not null,
    nome varchar(200) not null,
    total double not null,
    foreign key (id_empresa) references empresa(id_empresa) on delete cascade
);

create table produto_combo (
    id_produto integer,
    id_combo integer,
    foreign key (id_produto) references produto(id_produto) on delete cascade,
    foreign key (id_combo) references combo(id_combo) on delete cascade
);

create table funcionario_empresa (
    id_empresa integer not null,
    id_funcionario integer not null
);

INSERT INTO cliente (nome, telefone, email, senha) VALUES ('ramon', '123123', 'ramon@gmail.com', '123');
INSERT INTO cliente (nome, telefone, email, senha) VALUES ('claudio', '123123', 'claudio@gmail.com', '123');

INSERT INTO empresa (nome, email, senha) VALUES ('burgão da esquina', 'burgao@daesquina.com', '123');
INSERT INTO empresa (nome, email, senha) VALUES ('pizzaria vida loka', 'pizza@loka.com', '123');
INSERT INTO empresa (nome, email, senha) VALUES ('dogão da praça', 'dogao@dapraca.com', '123');

INSERT INTO produto(nome, valor) VALUES ('hamburguer', 6.50);
INSERT INTO produto(nome, valor) VALUES ('x-tudão monstro', 18.00);
INSERT INTO produto(nome, valor) VALUES ('guaraná', 4.00);

INSERT INTO produto(nome, valor) VALUES ('marguerita', 21);
INSERT INTO produto(nome, valor) VALUES ('frango com catupiry', 18.90);

INSERT INTO produto(nome, valor) VALUES ('cachorro quente', 6.50);
INSERT INTO produto(nome, valor) VALUES ('cachorro quente duas salsichas', 10.50);
INSERT INTO produto(nome, valor) VALUES ('água', 2.00);

INSERT INTO produto_empresa(id_empresa, id_produto) VALUES (1, 1);
INSERT INTO produto_empresa(id_empresa, id_produto) VALUES (1, 2);
INSERT INTO produto_empresa(id_empresa, id_produto) VALUES (1, 3);
INSERT INTO produto_empresa(id_empresa, id_produto) VALUES (2, 4);
INSERT INTO produto_empresa(id_empresa, id_produto) VALUES (2, 6);
INSERT INTO produto_empresa(id_empresa, id_produto) VALUES (3, 7);
INSERT INTO produto_empresa(id_empresa, id_produto) VALUES (3, 8);

insert into funcionario (id_empresa, nome, email, funcao, senha) values (1, 'Fulano', 'f@f.com', 'Administrador', '123');
insert into funcionario (id_empresa, nome, email, funcao, senha) values (1, 'Ciclano', 'c@c.com', 'Cozinheiro', '123');
insert into funcionario (id_empresa, nome, email, funcao, senha) values (1, 'Beltrano', 'b@b.com', 'Entregador', '123');

insert into superior (id_funcionario, id_superior) values (1, 2);
insert into superior (id_funcionario, id_superior) values (2, 3);

insert into funcionario (id_empresa, nome, email, funcao, senha) values (2, 'João', 'j@j.com', 'Administrador', '123');
insert into funcionario (id_empresa, nome, email, funcao, senha) values (2, 'Maria', 'm@m.com', 'Cozinheiro', '123');
insert into funcionario (id_empresa, nome, email, funcao, senha) values (2, 'José', 'z@z.com', 'Entregador', '123');

insert into superior (id_funcionario, id_superior) values (4, 5);
insert into superior (id_funcionario, id_superior) values (5, 6);

insert into funcionario (id_empresa, nome, email, funcao, senha) values (3, 'Ana', 'a@a.com', 'Administrador', '123');
insert into funcionario (id_empresa, nome, email, funcao, senha) values (3, 'Antônio', 'antonio@antonio.com', 'Cozinheiro', '123');
insert into funcionario (id_empresa, nome, email, funcao, senha) values (3, 'Enzo', 'enzo@enzo.com', 'Entregador', '123');

insert into superior (id_funcionario, id_superior) values (7, 8);
insert into superior (id_funcionario, id_superior) values (8, 9);