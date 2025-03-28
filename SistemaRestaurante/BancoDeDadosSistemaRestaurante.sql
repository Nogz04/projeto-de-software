CREATE DATABASE SistemaRestaurante
USE SistemaRestaurante

CREATE TABLE Item (

	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    valor DOUBLE NOT NULL,
    quantidade INT NOT NULL


);

CREATE TABLE Mesa (

	id INT PRIMARY KEY AUTO_INCREMENT,
    numMesa INT NOT NULL


);


CREATE TABLE Pedido (

	id INT PRIMARY KEY AUTO_INCREMENT,
    id_mesa INT NOT NULL,
    FOREIGN KEY (id_mesa) REFERENCES Mesa(id)


);


CREATE TABLE ItemPedido (

	id INT PRIMARY KEY AUTO_INCREMENT,
    id_Item INT NOT NULL,
    id_Pedido INT NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY (id_Item) REFERENCES Item(id),
	FOREIGN KEY (id_Pedido) REFERENCES Pedido(id)
    


);

SELECT * FROM ITEM
