CREATE DATABASE mercado2015;

USE mercado2015;

CREATE  TABLE IF NOT EXISTS  `mercadoria`
(
  `id`        INT NOT NULL ,
  `descricao` VARCHAR(100) NOT NULL ,
  `preco`     DECIMAL(10,2) NOT NULL ,
  PRIMARY KEY (`id`) 
);
  
CREATE  TABLE IF NOT EXISTS  `compra` (
  `id` INT NOT NULL ,
  `data` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`id`) );
 
  CREATE  TABLE IF NOT EXISTS  `pagamento` (
  `id` INT NOT NULL ,
  `data` VARCHAR(10) NOT NULL ,
  `valor` DECIMAL(10,2) NOT NULL ,
  `idcompra` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Pagamento_Compra1` (`idcompra` ASC) ,
  CONSTRAINT `fk_Pagamento_Compra1`
    FOREIGN KEY (`idcompra` )
    REFERENCES  `Compra` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE  TABLE IF NOT EXISTS  `itemCompra` (
  `idItemCompra` INT NOT NULL ,
  `quantidade` INT NOT NULL ,
  `idmercadoria` INT NOT NULL ,
  `idcompra` INT NOT NULL ,
  PRIMARY KEY (`idItemCompra`) ,
  INDEX `fk_ItemCompra_Mercadoria` (`idmercadoria` ASC) ,
  INDEX `fk_ItemCompra_Compra1` (`idcompra` ASC) ,
  CONSTRAINT `fk_ItemCompra_Mercadoria`
    FOREIGN KEY (`idmercadoria` )
    REFERENCES  `Mercadoria` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemCompra_Compra1`
    FOREIGN KEY (`idcompra` )
    REFERENCES  `Compra` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
insert into mercadoria (id,descricao,preco) values (1,'Sabão em Pó 1kg',           8.70);
insert into mercadoria (id,descricao,preco) values (2,'Amaciante 500ml',           12.10);
insert into mercadoria (id,descricao,preco) values (3,'Detergente 500ml',          3.20);
insert into mercadoria (id,descricao,preco) values (4,'Água Sanitária 5L',         9.94);
insert into mercadoria (id,descricao,preco) values (5,'Esponja de Aço',            1.20);
insert into mercadoria (id,descricao,preco) values (6,'Buchinha de Pia',           1.13);
insert into mercadoria (id,descricao,preco) values (7,'Sabão em Pedra',            2.00);
insert into mercadoria (id,descricao,preco) values (8,'Sabonete',                  1.50);
insert into mercadoria (id,descricao,preco) values (9,'Shampo 250ml',              13.45);
insert into mercadoria (id,descricao,preco) values (10,'Condicionador 250ml',      14.13);
insert into mercadoria (id,descricao,preco) values (11,'Desinfetante 1L',          3.50);
insert into mercadoria (id,descricao,preco) values (12,'Lustra Móveis 150ml',      15.89);
insert into mercadoria (id,descricao,preco) values (13,'Tira Manchas 150ml',       6.80);
insert into mercadoria (id,descricao,preco) values (14,'Limpa Vidros 150ml',       8.90);
insert into mercadoria (id,descricao,preco) values (15,'Álcool 1L',                4.5);
insert into mercadoria (id,descricao,preco) values (16,'Saco de Lixo 30l',         8.97);
insert into mercadoria (id,descricao,preco) values (17,'Saco de lixo 50l',         12.34);
insert into mercadoria (id,descricao,preco) values (18,'Refrigerante 2l',          4.5);
insert into mercadoria (id,descricao,preco) values (19,'Suco Garrafa 1l',          5.67);
insert into mercadoria (id,descricao,preco) values (20,'Suco Caixinha 500ml',      2.34);
insert into mercadoria (id,descricao,preco) values (21,'Suco Sachê',               0.89);
insert into mercadoria (id,descricao,preco) values (22,'Leite Integral 1L',        3.89);
insert into mercadoria (id,descricao,preco) values (23,'Leite Desnatado 1L',       3.89);
insert into mercadoria (id,descricao,preco) values (24,'Arroz 5kg',                18.45);
insert into mercadoria (id,descricao,preco) values (25,'Feijão 2kg',               19.40);
insert into mercadoria (id,descricao,preco) values (26,'Macarrão 500g',            8.70);
insert into mercadoria (id,descricao,preco) values (27,'Extrato de Tomate 350g',   12.10);
insert into mercadoria (id,descricao,preco) values (28,'Molho de Tomate 350g',     3.20);
insert into mercadoria (id,descricao,preco) values (29,'Sal 500g',                 9.94);
insert into mercadoria (id,descricao,preco) values (30,'Açúcar 1kg',               1.20);
insert into mercadoria (id,descricao,preco) values (31,'Achocolatado 500g',        1.13);
insert into mercadoria (id,descricao,preco) values (32,'Bolacha 200g',             2.00);
insert into mercadoria (id,descricao,preco) values (33,'Café 500g',                1.50);
insert into mercadoria (id,descricao,preco) values (34,'Farofa Pronta 500g',       13.45);
insert into mercadoria (id,descricao,preco) values (35,'Fubá 500g',                14.13);
insert into mercadoria (id,descricao,preco) values (36,'Farinha de Trigo 1kg',     3.50);
insert into mercadoria (id,descricao,preco) values (37,'Farinha de Milho 500g',    15.89);
insert into mercadoria (id,descricao,preco) values (38,'Farinha de Mandioca 500g', 6.80);
insert into mercadoria (id,descricao,preco) values (39,'Sardinha 250g',            8.90);
insert into mercadoria (id,descricao,preco) values (40,'Atum 250g',                4.5);
insert into mercadoria (id,descricao,preco) values (41,'Maionese 250g',            8.97);
insert into mercadoria (id,descricao,preco) values (42,'Molho de Pimenta 100g',    12.34);
insert into mercadoria (id,descricao,preco) values (43,'Ervilha 350g',             4.5);
insert into mercadoria (id,descricao,preco) values (44,'Milho Verde 350g',         5.67);
insert into mercadoria (id,descricao,preco) values (45,'Seleta 350g',              2.34);
insert into mercadoria (id,descricao,preco) values (46,'Doce de Leite 200g',       0.89);
insert into mercadoria (id,descricao,preco) values (47,'Goiabada 300g',            3.89);
insert into mercadoria (id,descricao,preco) values (48,'Milho de Pipoca 300g',     3.89);
insert into mercadoria (id,descricao,preco) values (49,'”Óleo de Cozinha 1L',      18.45);
insert into mercadoria (id,descricao,preco) values (50,'Leite em Pó 500g',         19.40);
insert into mercadoria (id,descricao,preco) values (51,'Creme de Leite 350g',      8.70);
insert into mercadoria (id,descricao,preco) values (52,'Leite Condensado 350g',    12.10);
insert into mercadoria (id,descricao,preco) values (53,'Pão de Forma 400g',        3.20);
insert into mercadoria (id,descricao,preco) values (54,'Alface Unidade',           9.94);
insert into mercadoria (id,descricao,preco) values (55,'Couve Unidade',            1.20);
insert into mercadoria (id,descricao,preco) values (56,'Batata 1kg',               1.13);
insert into mercadoria (id,descricao,preco) values (57,'Tomate 1kg',               2.00);
insert into mercadoria (id,descricao,preco) values (58,'Cenoura 500g',             1.50);
insert into mercadoria (id,descricao,preco) values (59,'Beterraba 500g',           13.45);
insert into mercadoria (id,descricao,preco) values (60,'Chicória Unidade',         14.13);
insert into mercadoria (id,descricao,preco) values (61,'Mandioca 1kg',             3.50);
insert into mercadoria (id,descricao,preco) values (62,'Chuchu 500g',              15.89);
insert into mercadoria (id,descricao,preco) values (63,'Espinafre Unidade',        6.80);
insert into mercadoria (id,descricao,preco) values (64,'Banana 500g',              8.90);
insert into mercadoria (id,descricao,preco) values (65,'Ovos Dúzia',               4.5);
insert into mercadoria (id,descricao,preco) values (66,'Uva 1kg',                  8.97);
insert into mercadoria (id,descricao,preco) values (67,'Abacate Unidade',          12.34);
insert into mercadoria (id,descricao,preco) values (68,'Mamão Unidade',            4.5);
insert into mercadoria (id,descricao,preco) values (69,'Melância Unidade',         5.67);
insert into mercadoria (id,descricao,preco) values (70,'Melão Unidade',            2.34);
insert into mercadoria (id,descricao,preco) values (71,'Jiló 350g',                0.89);
insert into mercadoria (id,descricao,preco) values (72,'Quiabo 300g',              3.89);
insert into mercadoria (id,descricao,preco) values (73,'Salsa Unidade',            3.89);
insert into mercadoria (id,descricao,preco) values (74,'Cheiro Verde Unidade',     18.45);
insert into mercadoria (id,descricao,preco) values (75,'Cebola 1kg',               19.40);
insert into mercadoria (id,descricao,preco) values (76,'Queijo Minas 400g',        8.70);
insert into mercadoria (id,descricao,preco) values (77,'Queijo Mussarela 300g',    12.10);
insert into mercadoria (id,descricao,preco) values (78,'Queijo Outros 300g',       3.20);
insert into mercadoria (id,descricao,preco) values (79,'Manteiga 250g',            9.94);
insert into mercadoria (id,descricao,preco) values (80,'Margarina 250g',           1.20);
insert into mercadoria (id,descricao,preco) values (81,'Iogurte 500ml',            1.13);
insert into mercadoria (id,descricao,preco) values (82,'Presunto 300g',            2.00);
insert into mercadoria (id,descricao,preco) values (83,'Peixe 350g',               1.50);
insert into mercadoria (id,descricao,preco) values (84,'Frango 1kg',               13.45);
insert into mercadoria (id,descricao,preco) values (85,'Carne Vermelha 1kg',       14.13);
insert into mercadoria (id,descricao,preco) values (86,'Carne Seca 500g',          3.50);
insert into mercadoria (id,descricao,preco) values (87,'Salsicha 500g',            15.89);