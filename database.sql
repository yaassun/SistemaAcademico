--CRIAÇÃO TABELA ESTUDANTE

CREATE TABLE estudante (
    matricula VARCHAR(20) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    curso VARCHAR(100),
    semestre INTEGER,
    email VARCHAR(100),
    telefone VARCHAR(20),
    situacao VARCHAR(30),
    CONSTRAINT estudante_pkey PRIMARY KEY (matricula)
);

SELECT * FROM estudante; -- consulta todos os estudantes

