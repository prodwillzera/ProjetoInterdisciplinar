CREATE DATABASE IF NOT EXISTS projetoInter;

-- DROP DATABASE projetoInter;

USE projetoInter;

CREATE TABLE if not exists usuario (
	id int primary key auto_increment,
    username varchar(50),
    passwords varchar(50),
    card int
);

CREATE TABLE if not exists produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    tamanho INT,
    preco DECIMAL(10,2),
    estoque INT
);

CREATE TABLE if not exists carrinho (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_produto) REFERENCES produto(id)
);

-- UPDATE produto SET id = 1 WHERE id = 5;

INSERT INTO produto (nome, tamanho, preco, estoque)
VALUES
('Jordan Air Jordan 1 High OG SP Travis Scott', 40, 13701.00, 2),
('Jordan Air Jordan 1 High OG SP Travis Scott', 42, 13701.00, 2),
('Nike Tênis x Supreme Air Force 1 Low', 36, 11330.00, 2),
('Nike Tênis x Supreme Air Force 1 Low', 38, 11330.00, 2);

INSERT INTO produto(nome, tamanho, preco, estoque)
VALUES
("Nike Tênis  Travis Scott Air Force 1 Low 'Cactus Jack'", 36, 11330.00, 2),
("Nike Tênis  Travis Scott Air Force 1 Low 'Cactus Jack'", 38, 11330.00, 2);

INSERT INTO produto(nome, tamanho, preco, estoque)
VALUES
('Nike Tênis x Supreme Air Force 1 Low', 40, 2574.00, 2),
('Nike Tênis x Supreme Air Force 1 Low', 42, 2574.00, 2);

UPDATE produto SET preco = '2574.00' WHERE id = 3;
UPDATE produto SET preco = '2574.00' WHERE id = 4;

INSERT INTO produto (nome, tamanho, preco, estoque)
VALUES
('VETEMENTS Bermuda cargo jeans cintura alta  ', 36, 16153.00, 8),
('VETEMENTS Bermuda cargo jeans cintura alta  ', 38, 16153.00, 8),
('VETEMENTS Bermuda cargo jeans cintura alta  ', 40, 16153.00, 8),
('VETEMENTS Bermuda cargo jeans cintura alta  ', 42, 16153.00, 8),
('Helmut Lang Bermuda de couro', 36, 7933.00, 6),
('Helmut Lang Bermuda de couro', 38, 7933.00, 6),
('Helmut Lang Bermuda de couro', 40, 7933.00, 6),
('Helmut Lang Bermuda de couro', 42, 7933.00, 6),
('Dolce & Gabbana Short com estampa de logo', 36, 7933.00, 7),
('Dolce & Gabbana Short com estampa de logo', 38, 7933.00, 7),
('Dolce & Gabbana Short com estampa de logo', 40, 7933.00, 7),
('Dolce & Gabbana Short com estampa de logo', 42, 7933.00, 7),
('adidas Camiseta Mercedes-AMG Formula 1 Team', 36, 1291.00, 6),
('adidas Camiseta Mercedes-AMG Formula 1 Team', 38, 1291.00, 6),
('adidas Camiseta Mercedes-AMG Formula 1 Team', 40, 1291.00, 6),
('adidas Camiseta Mercedes-AMG Formula 1 Team', 42, 1291.00, 6),
('Off-White Camiseta Arrow', 36, 2497.00, 8),
('Off-White Camiseta Arrow', 38, 2497.00, 8),
('Off-White Camiseta Arrow', 40, 2497.00, 8),
('Off-White Camiseta Arrow', 42, 2497.00, 8),
('Off-White Camiseta com estampa de logo', 36, 2620.00, 13),
('Off-White Camiseta com estampa de logo', 38, 2620.00, 13),
('Off-White Camiseta com estampa de logo', 40, 2620.00, 13),
('Off-White Camiseta com estampa de logo', 42, 2620.00, 13);

INSERT INTO produto(nome, tamanho, preco, estoque)
VALUES
('Manière De Voir Calça wide leg Serge com pregas', 36, 2354.00, 2),
('Manière De Voir Calça wide leg Serge com pregas', 38, 2354.00, 2),
('Palm Angels Calça esportiva com listra', 36, 4392.00, 4),
('Palm Angels Calça esportiva com listra', 38, 4392.00, 4),
('Palm Angels Calça esportiva com listra', 40, 4392.00, 4),
('Palm Angels Calça esportiva com listra', 42, 4392.00, 4),
('GCDS Calça cargo wide leg de tweed', 38, 8013.00, 2),
('GCDS Calça cargo wide leg de tweed', 40, 8013.00, 2);

INSERT INTO produto(nome, tamanho, preco, estoque)
VALUES
('WAVEIGL', 67, 9.00, 1);

SELECT * FROM produto;

SELECT * FROM usuario
ORDER BY id DESC LIMIT 5;
-- select * from jogador;

-- DELETE FROM usuario WHERE id = 1;

-- DELETE FROM usuario;

-- DELETE FROM produto where id IN (6,7);

TRUNCATE TABLE usuario;

DESCRIBE usuario;

SELECT 
    p.nome,
    c.quantidade,
    p.preco
FROM carrinho c
INNER JOIN produto p
ON c.id_produto = p.id;

SELECT 
    p.nome,
    p.tamanho,
    c.quantidade,
    p.preco
FROM carrinho c
INNER JOIN produto p 
ON c.id_produto = p.id
WHERE c.id_usuario = 1;

ALTER TABLE usuario
ADD COLUMN tipo VARCHAR(20);

UPDATE usuario SET tipo = 'staff' WHERE username = 'william'; 

UPDATE usuario SET tipo = 'staff' WHERE username = 'admin'; 

UPDATE usuario SET username = 'teste2' WHERE id = 5;

SELECT * FROM usuario;

UPDATE usuario SET tipo = 'cliente' WHERE tipo IS NULL;