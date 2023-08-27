-- Cria o schema "CM"
CREATE SCHEMA IF NOT EXISTS CM;
-- Altere o parâmetro DateStyle para o formato desejado
ALTER DATABASE "ColabManager" SET DateStyle = 'ISO, DMY';
-- Usa o schema "CM"
SET search_path TO CM;

CREATE TABLE employee (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          codfuncao INTEGER NOT NULL,
                          salary DOUBLE PRECISION NOT NULL,
                          dtnascimento DATE NOT NULL,
                          dtadmissao DATE NOT NULL
);
