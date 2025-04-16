

CREATE TABLE ENDERECO(
	cod_endereco INT AUTO_INCREMENT NOT NULL,
	rua VARCHAR(30) NULL,
	numero INT NOT NULL,
	cep VARCHAR(8) NULL,
	cidade VARCHAR(25) NULL,
	estado VARCHAR(25) NULL,
	PRIMARY KEY(cod_endereco)
)ENGINE = INNODB;

CREATE TABLE MARCA(
	cod_marca INT AUTO_INCREMENT NOT NULL,
	nome VARCHAR(20),
	PRIMARY KEY (cod_marca)
)ENGINE = INNODB;

INSERT INTO MARCA(cod_marca,nome) VALUES(1,'Selecione');
INSERT INTO MARCA(cod_marca,nome) VALUES(2,'Fiat');
INSERT INTO MARCA(cod_marca,nome) VALUES(3,'Ford');
INSERT INTO MARCA(cod_marca,nome) VALUES(4,'Honda');
INSERT INTO MARCA(cod_marca,nome) VALUES(5,'Hyundai');
INSERT INTO MARCA(cod_marca,nome) VALUES(6,'Mitsubishi');
INSERT INTO MARCA(cod_marca,nome) VALUES(7,'Nissan');
INSERT INTO MARCA(cod_marca,nome) VALUES(8,'Peugeot');
INSERT INTO MARCA(cod_marca,nome) VALUES(9,'Renault');
INSERT INTO MARCA(cod_marca,nome) VALUES(10,'Toyota');
INSERT INTO MARCA(cod_marca,nome) VALUES(11,'Volkswagen');
INSERT INTO MARCA(cod_marca,nome) VALUES(12,'Outro');


CREATE TABLE MODELO(
  cod_modelo INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(30),
  fk_marca INT NOT NULL,
  PRIMARY KEY (cod_modelo),
		FOREIGN KEY (fk_marca) REFERENCES MARCA(cod_marca)
)ENGINE = INNODB;

INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(1,'Selecione',1); #selecione

INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(2,'Argo',2); #fiat
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(3,'Cronos',2); #fiat
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(4,'Doblo',2); #fiat
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(5,'Fiorino',2); #fiat
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(6,'Siena',2); #fiat
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(7,'Mobi',2); #fiat
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(8,'Strada',2); #fiat
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(9,'Toro',2); #fiat
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(10,'Uno',2); #fiat

INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(11,'EcoSport',3); #ford
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(12,'Edge',3); #ford
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(13,'Fiesta',3); #ford
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(14,'Fusion',3); #ford
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(15,'Ka',3); #ford
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(16,'Ranger',3); #ford

INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(17,'City',4); #honda
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(18,'Civic',4); #honda
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(19,'CR-V',4); #honda
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(20,'Fit',4); #honda
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(21,'HR-V',4); #honda

INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(22,'HB-20',5); #hyundai
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(23,'iX35',5); #hyundai
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(24,'Tucson',5); #hyundai
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(25,'Santa Fé',5); #hyundai

INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(26,'Pajero',6); #Mitsubishi
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(27,'Eclipse',6); #Mitsubishi
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(28,'Triton',6); #Mitsubishi

INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(29,'Frontier',7); #Nissan
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(30,'March',7); #Nissan
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(31,'Sentra',7); #Nissan
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(32,'Versa',7); #Nissan

INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(33,'Peugeot 208',8); #Peugeot
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(34,'Peugeot 206',8); #Peugeot

INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(35,'Captur',9); #Renault
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(36,'Duster',9); #Renault
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(37,'Kangoo',9); #Renault
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(38,'KWID',9); #Renault
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(39,'Logan',9); #Renault
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(40,'Master',9); #Renault
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(41,'Sandero',9); #Renault
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(42,'Stepway',9); #Renault

INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(43,'Corolla',10); #Toyota
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(44,'Etios',10); #Toyota
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(45,'Hilux',10); #Toyota
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(46,'RAV4',10); #Toyota

INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(47,'Amarok',11); #Volkswagen
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(48,'Fox',11); #Volkswagen
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(49,'Gol',11); #Volkswagen
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(50,'Golf',11); #Volkswagen
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(51,'Jetta',11); #Volkswagen
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(52,'Nivus',11); #Volkswagen
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(53,'Polo',11); #Volkswagen
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(54,'Passat',11); #Volkswagen
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(55,'Fusca',11); #Volkswagen
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(56,'Saveiro',11); #Volkswagen
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(57,'Tiguan',11); #Volkswagen
INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(58,'Voyage',11); #Volkswagen

INSERT INTO MODELO(cod_modelo,nome,fk_marca) VALUES(59,'Outro',12); #Outro

CREATE TABLE PROPRIETARIO (
  cod_proprietario INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(20),
  cpf VARCHAR(14),
  celular VARCHAR(15),
  telefone VARCHAR(10),
  mecanico VARCHAR(10),
  fk_endereco INT NOT NULL,
  PRIMARY KEY (cod_proprietario),
	FOREIGN KEY(fk_endereco) REFERENCES ENDERECO(cod_endereco))
ENGINE = INNODB;


CREATE TABLE CARRO (
  cod_carro INT AUTO_INCREMENT NOT NULL,
  placa VARCHAR(10) NOT NULL,
  ano INT NOT NULL,
  cor VARCHAR(10) NULL,
  fk_marca INT NOT NULL,
  fk_proprietario INT NOT NULL,
  PRIMARY KEY (cod_carro),
    FOREIGN KEY (fk_marca) REFERENCES MARCA (cod_marca),
    FOREIGN KEY (fk_proprietario) REFERENCES proprietario(cod_proprietario)
)ENGINE = INNODB;

    
# tabela que descreve os serviços realizados na oficina
CREATE TABLE SERVICO_PRESTADO (
  cod_servico_prestado INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(45) NULL,
  descricao VARCHAR(30) NULL,
  preco_tabela DECIMAL NULL,
  PRIMARY KEY (cod_servico_prestado))
ENGINE = INNODB;

CREATE TABLE FORMA_PAGAMENTO(
		cod_forma_pagamento INT AUTO_INCREMENT NOT NULL,
		forma_pagamento VARCHAR(20),
		PRIMARY KEY(cod_forma_pagamento)
)ENGINE = INNODB;

INSERT INTO FORMA_PAGAMENTO(cod_forma_pagamento,forma_pagamento) 
			VALUES(1,"Pix");
INSERT INTO FORMA_PAGAMENTO(cod_forma_pagamento,forma_pagamento) 
			VALUES(2,"Dinheiro");
INSERT INTO FORMA_PAGAMENTO(cod_forma_pagamento,forma_pagamento) 
			VALUES(3,"Link Pagamento");

CREATE TABLE AGENDAMENTO_SERVICO (
  cod_agendamento_servico INT AUTO_INCREMENT NOT NULL,
  data_servico DATE,
  horario TIME,
  status_servico VARCHAR(10),
  status_pagamento VARCHAR(10),
  preco_cobrado DECIMAL,
  lembrete BOOLEAN DEFAULT FALSE,
  fk_forma_pagamento INT NOT NULL,
  fk_proprietario INT NOT NULL,
  fk_servico_prestado INT NOT NULL,
  PRIMARY KEY (cod_agendamento_servico),
  	 FOREIGN KEY (fk_forma_pagamento) REFERENCES FORMA_PAGAMENTO(cod_forma_pagamento),
	 FOREIGN KEY (fk_proprietario) REFERENCES PROPRIETARIO(cod_proprietario),
	 FOREIGN KEY (fk_servico_prestado) REFERENCES SERVICO_PRESTADO(cod_servico_prestado))
ENGINE = INNODB;


INSERT INTO SERVICO_PRESTADO(cod_servico_prestado,nome,descricao, preco_tabela) 
			VALUES(1,'Troca de óleo + filtros','',45.00);
			
INSERT INTO SERVICO_PRESTADO(cod_servico_prestado,nome,descricao, preco_tabela) 
			VALUES(2,'Troca de Correia Dentada','',150.00);
			
INSERT INTO SERVICO_PRESTADO(cod_servico_prestado,nome,descricao, preco_tabela) 
			VALUES(3,'Troca da Correia de Acessórios','',50.00);
			
INSERT INTO SERVICO_PRESTADO(cod_servico_prestado,nome,descricao, preco_tabela) 
			VALUES(4,'Troca do Óleo de Câmbio Manual','',45.00);

INSERT INTO SERVICO_PRESTADO(cod_servico_prestado,nome,descricao, preco_tabela) 
			VALUES(5,'Revisão de Freio Diant.','',120.00);

INSERT INTO SERVICO_PRESTADO(cod_servico_prestado,nome,descricao, preco_tabela) 
			VALUES(6,'Revisão de Freio Tras.','',140.00);
			
INSERT INTO SERVICO_PRESTADO(cod_servico_prestado,nome,descricao, preco_tabela) 
			VALUES(7,'Suspensão Amortecedor','',160.00);
			
INSERT INTO SERVICO_PRESTADO(cod_servico_prestado,nome,descricao, preco_tabela) 
			VALUES(8,'Suspensão Diversos','',120.00);
			
INSERT INTO SERVICO_PRESTADO(cod_servico_prestado,nome,descricao, preco_tabela) 
			VALUES(9,'Revisão Motor','',120.00);
			
INSERT INTO SERVICO_PRESTADO(cod_servico_prestado,nome,descricao, preco_tabela) 
			VALUES(10,'Limpeza de Bicos','',70.00);
			
INSERT INTO SERVICO_PRESTADO(cod_servico_prestado,nome,descricao, preco_tabela) 
			VALUES(11,'Troca de Embreagem','',250.00);
			

CREATE TABLE ORCAMENTO(
	cod_orcamento INT AUTO_INCREMENT NOT NULL,
	numero_orcamento INT  NOT NULL,
	nome_cliente  VARCHAR(20),
	endereco VARCHAR(20),
	cidade VARCHAR(20),
	estado VARCHAR(10),
	email VARCHAR(20),
	telefone VARCHAR(20),
	data_emissao DATE,
	fk_modelo INT NOT NULL,
	fk_marca INT NOT NULL,
	carro_ano INT NOT NULL,
	placa  VARCHAR(07),
	observacao VARCHAR(50),
	mecanico VARCHAR(10),
	PRIMARY KEY (cod_orcamento),
		FOREIGN KEY (fk_marca)
   	 REFERENCES MARCA (cod_marca),
		FOREIGN KEY (fk_modelo)
   	 REFERENCES MODELO (cod_modelo))
ENGINE = INNODB;

CREATE SEQUENCE SQ_NUMERO_ORCAMENTO START WITH 1 INCREMENT BY 1;


CREATE TRIGGER TR_INCREMENT_NUM_ORCAMENTO
AFTER INSERT
	ON orcamento FOR EACH ROW 
		UPDATE orcamento SET orcamento.numero_orcamento = (SELECT  NEXTVAL(sq_numero_orcamento));	
		

CREATE TABLE ITEM_DESCRICAO(
	cod_item_descricao INT AUTO_INCREMENT NOT NULL,
	item INT NOT NULL,
	descricao VARCHAR(20),
	quantidade INT NOT NULL,
	valor_unitario DECIMAL NOT NULL,
	fk_orcamento INT NOT NULL,
	PRIMARY KEY(cod_item_descricao),
		FOREIGN KEY(fk_orcamento)
		REFERENCES ORCAMENTO (cod_orcamento)
)ENGINE = INNODB;


#TABELA CRIADA PARA LANCAR DE FORMA RAPIDA SERVICO SEM AGENDAMENTO
CREATE TABLE servico_rapido(
	cod_servico_rapido INT AUTO_INCREMENT NOT NULL,
	preco_cobrado DECIMAL NOT NULL,
	data_servico DATE NOT NULL,
	observacao VARCHAR(20),
	PRIMARY KEY(cod_servico_rapido)
)ENGINE = INNODB;
	
	
create table papel (
	id bigint not null auto_increment, 
	nome varchar(255), 
	primary key (id)
) engine=INNODB;

create table usuario (
	id bigint not null auto_increment,
	email varchar(255), 
	nome varchar(255), 
	senha varchar(255), 
	primary key (id)
) engine=INNODB;



create table usuario_papeis (
	papeis_id bigint not null, 
	usuario_id bigint not null
	) engine=InnoDB;     
	
INSERT INTO usuario(id,email,nome, senha) VALUES(1,"jaquelinesv90@gmail.com","jaqueline","$2a$10$wFfG3W0JSZZX8wfm1fd2POC.QYArI9KUxS4CMAC1UQJMNM76uWvwC");
INSERT INTO papel(id,nome) VALUES(1,"ROLE_ADMIN");
INSERT INTO usuario_papeis(papeis_id,usuario_id) VALUES(1,1);  