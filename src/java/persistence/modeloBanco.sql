CREATE TABLE cliente (
    id_cliente INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    telefone VARCHAR(15)
);

CREATE TABLE endereco (
    id_endereco INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    numero VARCHAR(10) NOT NULL,
    rua VARCHAR(200) NOT NULL,
    bairro VARCHAR(200) NOT NULL
);

CREATE TABLE endereco_cliente (
    id_cliente INTEGER PRIMARY KEY,
    id_endereco INTEGER PRIMARY KEY,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON DELETE CASCADE,
    FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco) ON DELETE CASCADE
);

CREATE TABLE empresa (
    id_empresa INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(200) NOT NULL,
);

CREATE TABLE produto (
    id_produto INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(200) NOT NULL,
    valor INTEGER NOT NULL
);

CREATE TABLE produto_empresa (
    id_empresa INTEGER PRIMARY KEY,
    id_produto INTEGER PRIMARY KEY,
    FOREIGN KEY (id_empresa) REFERENCES empresa(id_empresa) ON DELETE CASCADE,
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto) ON DELETE CASCADE
);

CREATE TABLE funcionario (
    id_funcionario INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    funcao VARCHAR(100) NOT NULL,
    id_superior INTEGER,
    responsavel VARCHAR(200),
    FOREIGN KEY (id_superior) REFERENCES funcionario(id_funcionario) ON DELETE CASCADE
);

CREATE TABLE pedido (
    id_pedido INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    estado VARCHAR(50) NOT NULL,
    id_funcionario_responsavel INTEGER NOT NULL,
    FOREIGN KEY (id_funcionario_responsavel) REFERENCES funcionario(id_funcionario) ON DELETE CASCADE
);