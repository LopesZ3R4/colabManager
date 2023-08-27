-- Cria o schema "CM"
CREATE SCHEMA IF NOT EXISTS CM;

-- Usa o schema "CM"
SET search_path TO CM;

CREATE TABLE employee (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255),
                          codfuncao INTEGER,
                          salary DOUBLE PRECISION,
                          dtnascimento DATE,
                          dtadmissao DATE
);
