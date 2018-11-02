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
    nome VARCHAR(200) NOT NULL,
    valor INTEGER NOT NULL
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
    id_funcionario_responsavel INTEGER NOT NULL,
    FOREIGN KEY (id_funcionario_responsavel) REFERENCES funcionario(id_funcionario) ON DELETE CASCADE
);