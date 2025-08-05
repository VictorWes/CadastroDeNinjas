CREATE TABLE tb_cadastro (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    idade INTEGER,
    missoes_id BIGINT,
    ranking VARCHAR(255)
);

ALTER TABLE tb_cadastro ADD CONSTRAINT fk_missoes
FOREIGN KEY (missoes_id) REFERENCES missoes(id);