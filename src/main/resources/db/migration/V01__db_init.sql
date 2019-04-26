CREATE TABLE livro (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO livro (nome) VALUES ('Memórias Postumas de Bras Cubas');
INSERT INTO livro (nome) VALUES ('Auto da barca do Inferno');