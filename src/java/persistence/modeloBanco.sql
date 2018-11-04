DROP TABLE endereco_cliente;
DROP TABLE cliente;
DROP TABLE endereco;
DROP TABLE produto_empresa;
DROP TABLE empresa;
DROP TABLE produto;
DROP TABLE superior;
DROP TABLE funcionario;
DROP TABLE pedido;

CREATE TABLE cliente (
    id_cliente INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(20) NOT NULL,
    telefone VARCHAR(15)
);

CREATE TABLE endereco (
    id_endereco INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    numero VARCHAR(10) NOT NULL,
    rua VARCHAR(200) NOT NULL,
    bairro VARCHAR(200) NOT NULL
);

CREATE TABLE endereco_cliente (
    id_cliente INTEGER,
    id_endereco INTEGER,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON DELETE CASCADE,
    FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco) ON DELETE CASCADE
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
    nome VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    funcao VARCHAR(100) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    responsavel VARCHAR(200)
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