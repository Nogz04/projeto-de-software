CREATE DATABASE SistemaRestaurante2
USE SistemaRestaurante2

CREATE TABLE Comida (

	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL UNIQUE,
    valor DOUBLE NOT NULL,
    quantidade INT NOT NULL,
    descricao VARCHAR(300),
    estado VARCHAR(14) 
);


CREATE TABLE Bebida (

	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL UNIQUE,
    valor DOUBLE NOT NULL,
    quantidade INT NOT NULL,
    estado VARCHAR(14) 


);

CREATE TABLE Sobremesa (

	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL UNIQUE,
    valor DOUBLE NOT NULL,
    quantidade INT NOT NULL,
    descricao VARCHAR(300),
    estado VARCHAR(14) 

);


CREATE TABLE Mesa (

	id INT PRIMARY KEY AUTO_INCREMENT,
    numMesa INT NOT NULL UNIQUE


);

INSERT INTO MESA (numMesa ) VALUES (1);
INSERT INTO MESA (numMesa ) VALUES (2);
INSERT INTO MESA (numMesa ) VALUES (3);


CREATE TABLE Pedido (

	id INT PRIMARY KEY AUTO_INCREMENT,
    id_mesa INT,
    id_comida INT,
    id_bebida INT,
    id_sobremesa INT,
    FOREIGN KEY (id_mesa) REFERENCES Mesa(id),
    FOREIGN KEY (id_comida) REFERENCES Comida(id),
    FOREIGN KEY (id_bebida) REFERENCES Bebida(id),
    FOREIGN KEY (id_sobremesa) REFERENCES Sobremesa(id)
    
);




CREATE TABLE ItemPedido (

	id INT PRIMARY KEY AUTO_INCREMENT,
    id_Item INT NOT NULL,
    id_Pedido INT NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY (id_Item) REFERENCES Item(id),
	FOREIGN KEY (id_Pedido) REFERENCES Pedido(id)
    
);


-- TRIGGER PARA VERIFICAR SE TEM CARNE NO ESTOQUE

DELIMITER //

CREATE TRIGGER verifica_quantidade_carne
BEFORE INSERT ON ItemPedido
FOR EACH ROW
BEGIN
    DECLARE item_nome VARCHAR(100);
    DECLARE item_categoria VARCHAR(50);
    DECLARE item_quantidade INT;
    
    -- Obter informações do item que está sendo adicionado ao pedido
    SELECT nome, categoria, quantidade INTO item_nome, item_categoria, item_quantidade
    FROM Item
    WHERE id = NEW.id_Item;
    
    -- Verificar se é carne da categoria ingrediente com quantidade zero
    IF item_nome = 'carne' AND item_categoria = 'ingrediente' AND item_quantidade <= 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Não é possível adicionar carne ao pedido: quantidade em estoque esgotada';
    END IF;
END//

DELIMITER ;



SELECT * FROM ITEM
