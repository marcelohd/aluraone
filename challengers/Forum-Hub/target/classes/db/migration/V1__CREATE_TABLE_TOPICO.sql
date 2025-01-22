CREATE TABLE Curso (
    id varchar(48) not null,
    nome VARCHAR(200) not null,
    categoria varchar(100) not null,
    primary key (id)
);

CREATE TABLE Perfil(
    id varchar(48) not null,
    nome varchar(50) not null,
    primary key (id)
);

CREATE TABLE Usuario (
    id varchar(48) not null,
    nome varchar(20) not null,
    email varchar(100) not null,
    senha varchar(200) not null,
    perfil_id varchar(48) not null,
    primary key (id),
    CONSTRAINT USUARIO_X_PERFIL FOREIGN KEY (perfil_id) REFERENCES Perfil (id)
);

CREATE TABLE Resposta (
    id varchar(48) not null,
    mensagem text not null,
    topico_id varchar(48) not null,
    dataCriacao datetime not null,
    autor_id varchar(48) not null,
    solucao text not null,
    CONSTRAINT RESPOSTA_X_AUTOR FOREIGN KEY (autor_id) REFERENCES Usuario (id),
    primary key (id)
);

CREATE TABLE Topico(
    id varchar(48) not null,
    titulo varchar(100) not null,
    mensagem text not null,
    dataCriacao datetime not null,
    status tinyint not null default 1,
    autor_id varchar(48) not null,
    curso_id varchar(48) not null,
    resposta_id varchar(48) not null,
    CONSTRAINT TOPICO_X_AUTOR FOREIGN KEY (autor_id) REFERENCES Usuario (id),
    CONSTRAINT TOPICO_X_RESPOSTA FOREIGN KEY (resposta_id) REFERENCES Resposta (id),
    CONSTRAINT TOPICO_X_CURSO FOREIGN KEY (curso_id) REFERENCES Curso (id),
    primary key (id)
);