
DROP DATABASE OFICINA_DEV;

CREATE DATABASE OFICINA_DEV;

USE oficina_dev;

CREATE TABLE ENDERECO(
	cod_endereco INT AUTO_INCREMENT NOT NULL,
	rua VARCHAR(30) NULL,
	numero INT NOT NULL,
	cep VARCHAR(8) NULL,
	cidade VARCHAR(25) NULL,
	estado VARCHAR(25) NULL,
	PRIMARY KEY(cod_endereco)
)ENGINE = INNODB;

CREATE TABLE MODELO(
  cod_modelo INT AUTO_INCREMENT NOT NULL,
  modelo VARCHAR(30),
  PRIMARY KEY (cod_modelo))
ENGINE = INNODB;

INSERT INTO MODELO(cod_modelo,modelo) VALUES(1,'Argo'); #fiat
INSERT INTO MODELO(cod_modelo,modelo) VALUES(2,'Cronos'); #fiat
INSERT INTO MODELO(cod_modelo,modelo) VALUES(3,'Doblo'); #fiat
INSERT INTO MODELO(cod_modelo,modelo) VALUES(4,'Fiorino'); #fiat
INSERT INTO MODELO(cod_modelo,modelo) VALUES(5,'Siena'); #fiat
INSERT INTO MODELO(cod_modelo,modelo) VALUES(6,'Mobi'); #fiat
INSERT INTO MODELO(cod_modelo,modelo) VALUES(7,'Strada'); #fiat
INSERT INTO MODELO(cod_modelo,modelo) VALUES(8,'Toro'); #fiat
INSERT INTO MODELO(cod_modelo,modelo) VALUES(9,'Uno'); #fiat

INSERT INTO MODELO(cod_modelo,modelo) VALUES(10,'EcoSport'); #ford
INSERT INTO MODELO(cod_modelo,modelo) VALUES(11,'Edge'); #ford
INSERT INTO MODELO(cod_modelo,modelo) VALUES(12,'Fiesta'); #ford
INSERT INTO MODELO(cod_modelo,modelo) VALUES(13,'Fusion'); #ford
INSERT INTO MODELO(cod_modelo,modelo) VALUES(14,'Ka'); #ford
INSERT INTO MODELO(cod_modelo,modelo) VALUES(15,'Ranger'); #ford

INSERT INTO MODELO(cod_modelo,modelo) VALUES(16,'City'); #honda
INSERT INTO MODELO(cod_modelo,modelo) VALUES(17,'Civic'); #honda
INSERT INTO MODELO(cod_modelo,modelo) VALUES(18,'CR-V'); #honda
INSERT INTO MODELO(cod_modelo,modelo) VALUES(19,'Fit'); #honda
INSERT INTO MODELO(cod_modelo,modelo) VALUES(20,'HR-V'); #honda

INSERT INTO MODELO(cod_modelo,modelo) VALUES(21,'HB-20'); #hyundai
INSERT INTO MODELO(cod_modelo,modelo) VALUES(22,'iX35'); #hyundai
INSERT INTO MODELO(cod_modelo,modelo) VALUES(23,'Tucson'); #hyundai
INSERT INTO MODELO(cod_modelo,modelo) VALUES(24,'Santa Fé'); #hyundai

INSERT INTO MODELO(cod_modelo,modelo) VALUES(25,'Pajero'); #Mitsubishi
INSERT INTO MODELO(cod_modelo,modelo) VALUES(26,'Eclipse'); #Mitsubishi
INSERT INTO MODELO(cod_modelo,modelo) VALUES(27,'Triton'); #Mitsubishi

INSERT INTO MODELO(cod_modelo,modelo) VALUES(28,'Frontier'); #Nissan
INSERT INTO MODELO(cod_modelo,modelo) VALUES(29,'March'); #Nissan
INSERT INTO MODELO(cod_modelo,modelo) VALUES(30,'Sentra'); #Nissan
INSERT INTO MODELO(cod_modelo,modelo) VALUES(31,'Versa'); #Nissan

INSERT INTO MODELO(cod_modelo,modelo) VALUES(32,'Peugeot 208'); #Peugeot
INSERT INTO MODELO(cod_modelo,modelo) VALUES(33,'Peugeot 206'); #Peugeot

INSERT INTO MODELO(cod_modelo,modelo) VALUES(34,'Captur'); #Renault
INSERT INTO MODELO(cod_modelo,modelo) VALUES(35,'Duster'); #Renault
INSERT INTO MODELO(cod_modelo,modelo) VALUES(36,'Kangoo'); #Renault
INSERT INTO MODELO(cod_modelo,modelo) VALUES(37,'KWID'); #Renault
INSERT INTO MODELO(cod_modelo,modelo) VALUES(38,'Logan'); #Renault
INSERT INTO MODELO(cod_modelo,modelo) VALUES(39,'Master'); #Renault
INSERT INTO MODELO(cod_modelo,modelo) VALUES(40,'Sandero'); #Renault
INSERT INTO MODELO(cod_modelo,modelo) VALUES(41,'Stepway'); #Renault

INSERT INTO MODELO(cod_modelo,modelo) VALUES(42,'Corolla'); #Toyota
INSERT INTO MODELO(cod_modelo,modelo) VALUES(43,'Etios'); #Toyota
INSERT INTO MODELO(cod_modelo,modelo) VALUES(44,'Hilux'); #Toyota
INSERT INTO MODELO(cod_modelo,modelo) VALUES(45,'RAV4'); #Toyota

INSERT INTO MODELO(cod_modelo,modelo) VALUES(46,'Amarok'); #Volkswagen
INSERT INTO MODELO(cod_modelo,modelo) VALUES(47,'Fox'); #Volkswagen
INSERT INTO MODELO(cod_modelo,modelo) VALUES(48,'Gol'); #Volkswagen
INSERT INTO MODELO(cod_modelo,modelo) VALUES(49,'Golf'); #Volkswagen
INSERT INTO MODELO(cod_modelo,modelo) VALUES(50,'Jetta'); #Volkswagen
INSERT INTO MODELO(cod_modelo,modelo) VALUES(51,'Nivus'); #Volkswagen
INSERT INTO MODELO(cod_modelo,modelo) VALUES(52,'Polo'); #Volkswagen
INSERT INTO MODELO(cod_modelo,modelo) VALUES(53,'Passat'); #Volkswagen
INSERT INTO MODELO(cod_modelo,modelo) VALUES(54,'Fusca'); #Volkswagen
INSERT INTO MODELO(cod_modelo,modelo) VALUES(55,'Saveiro'); #Volkswagen
INSERT INTO MODELO(cod_modelo,modelo) VALUES(56,'Tiguan'); #Volkswagen
INSERT INTO MODELO(cod_modelo,modelo) VALUES(57,'Voyage'); #Volkswagen

CREATE TABLE MARCA(
	cod_marca INT AUTO_INCREMENT NOT NULL,
	nome VARCHAR(20),
	fk_modelo INT NOT NULL,
	PRIMARY KEY (cod_marca),
		FOREIGN KEY (fk_modelo) REFERENCES modelo(cod_modelo)
)ENGINE = INNODB;

INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(1,'Fiat',1);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(2,'Fiat',2);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(3,'Fiat',3);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(4,'Fiat',4);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(5,'Fiat',5);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(6,'Fiat',6);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(7,'Fiat',7);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(8,'Fiat',8);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(9,'Fiat',9);


INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(10,'Ford',10);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(11,'Honda',11);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(12,'Hyundai',12);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(13,'Mitsubishi',13);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(14,'Nissan',14);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(15,'Peugeot',15);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(16,'Renault',16);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(17,'Toyota',17);
INSERT INTO MARCA(cod_marca,nome,fk_modelo) VALUES(18,'Volkswagen',18);

CREATE TABLE PROPRIETARIO (
  cod_proprietario INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(20),
  cpf VARCHAR(14),
  celular VARCHAR(10),
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


CREATE TABLE AGENDAMENTO_SERVICO (
  cod_agendamento_servico INT AUTO_INCREMENT NOT NULL,
  data_servico DATE,
  horario TIME,
  status_servico VARCHAR(10),
  status_pagamento VARCHAR(10),
  preco_cobrado DECIMAL,
  forma_pagamento VARCHAR(10),
  fk_proprietario INT NOT NULL,
  fk_servico_prestado INT NOT NULL,
  PRIMARY KEY (cod_agendamento_servico),
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
			

CREATE TABLE LOGIN (
  cod_login INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(15) NOT NULL,
  senha VARCHAR(10) NOT NULL,
  PRIMARY KEY (cod_login))
ENGINE = InnoDB;


CREATE TABLE ORCAMENTO(
	cod_orcamento INT AUTO_INCREMENT NOT NULL,
	numero_orcamento INT NOT NULL,
	nome_cliente  VARCHAR(20),
	data_emissao DATE,
	fk_modelo INT NOT NULL,
	fk_marca INT NOT NULL,
	carro_ano INT NOT NULL,
	observacao VARCHAR(50),
	valor_mao_obra DECIMAL, 
	mecanico VARCHAR(10),
	PRIMARY KEY (cod_orcamento),
		FOREIGN KEY (fk_marca)
   	 REFERENCES MARCA (cod_marca),
		FOREIGN KEY (fk_modelo)
   	 REFERENCES MODELO (cod_modelo))
ENGINE = INNODB;


CREATE TABLE ITEM_DESCRICAO(
	cod_item_descricao INT AUTO_INCREMENT NOT NULL,
	item INT NOT NULL,
	descricao VARCHAR(20),
	quantidade INT NOT NULL,
	valor_unitario DECIMAL NOT NULL,
	PRIMARY KEY(cod_item_descricao))
ENGINE = INNODB;


CREATE TABLE ORCAMENTO_ITEM_DESCRICAO(
	cod_orcamento_item_descricao INT AUTO_INCREMENT NOT NULL,
	fk_orcamento INT NOT NULL,
	fk_item_descricao INT NOT NULL,
	PRIMARY KEY(cod_orcamento_item_descricao),
		FOREIGN KEY(fk_orcamento)
			REFERENCES ORCAMENTO(cod_orcamento),
		FOREIGN KEY(fk_item_descricao)
			REFERENCES ITEM_DESCRICAO(cod_item_descricao))
ENGINE = INNODB;


ALTER TABLE orcamento ADD COLUMN fk_orcamento_item_descricao INT NOT NULL;
ALTER TABLE orcamento ADD FOREIGN KEY (fk_orcamento_item_descricao)		
		 REFERENCES  ORCAMENTO_ITEM_DESCRICAO (cod_orcamento_item_descricao);
		 
ALTER TABLE ITEM_DESCRICAO ADD COLUMN fk_orcamento_item_descricao INT NOT NULL;
ALTER TABLE ITEM_DESCRICAO ADD FOREIGN KEY(fk_orcamento_item_descricao)
			REFERENCES ORCAMENTO_ITEM_DESCRICAO(cod_orcamento_item_descricao);
		 

INSERT INTO endereco (cod_endereco,rua,numero,cep,cidade,estado) VALUES(1,'Rua XV de Novembro',00,00,'Curitiba','Paraná');
INSERT INTO endereco (cod_endereco,rua,numero,cep,cidade,estado) VALUES(2,'Rua das Flores',00,00,'Curitiba','Paraná');
INSERT INTO endereco (cod_endereco,rua,numero,cep,cidade,estado) VALUES(3,'Rua Franz Kroeker 460',00,00,'Curitiba','Paraná');
INSERT INTO endereco (cod_endereco,rua,numero,cep,cidade,estado) VALUES(4,'Rua Francisco Derosso 870',00,00,'Curitiba','Paraná');

INSERT INTO PROPRIETARIO (cod_proprietario,nome,cpf,celular,telefone,mecanico,fk_endereco) 
			VALUES(1,'ze do monza','024.322.780-45','98865-0987','','Leonildo',1);
			
INSERT INTO PROPRIETARIO (cod_proprietario,nome,cpf,celular,telefone,mecanico,fk_endereco) 
			VALUES(2,'jorge','090.450.665-30','98865-0112','','Leonildo',2);	
			
INSERT INTO PROPRIETARIO (cod_proprietario,nome,cpf,celular,telefone,mecanico,fk_endereco) 
			VALUES(3,'lincoln','121.322.689-10','98878-0799','','Leonildo',3);
			
INSERT INTO PROPRIETARIO (cod_proprietario,nome,cpf,celular,telefone,mecanico,fk_endereco) 
			VALUES(4,'jorge vizinho','889.650.344-09','98867-0132','3378046','Jeferson',4);
			
INSERT INTO PROPRIETARIO (cod_proprietario,nome,cpf,celular,telefone,mecanico,fk_endereco) 
			VALUES(5,'seu jorge','010.120.350-80','98990-3552','','Jeferson',4);	
			
		
			
INSERT INTO CARRO(cod_carro,placa,ano,cor,fk_marca,fk_proprietario) 
		VALUES(1,'ABC-2001',2011,'branco',1,1);

INSERT INTO CARRO(cod_carro,placa,ano,cor,fk_marca,fk_proprietario) 
		VALUES(2,'ABC-1234',2011,'preto',2,2);

INSERT INTO CARRO(cod_carro,placa,ano,cor,fk_marca,fk_proprietario) 
		VALUES(3,'ABC-5678',2011,'prata',3,3);
		
			
INSERT INTO AGENDAMENTO_SERVICO(cod_agendamento_servico,
											data_servico,
											horario,
											status_servico,
											status_pagamento,
											preco_cobrado,
											forma_pagamento,
											fk_proprietario,
											fk_servico_prestado) 
			VALUES(1,"2024-03-21",'13:00',"FEITO","RECEBIDO",45.00,'PIX',1,1);
			
			
INSERT INTO AGENDAMENTO_SERVICO(cod_agendamento_servico,
											data_servico,
											horario,
											status_servico,
											status_pagamento,
											preco_cobrado,
											forma_pagamento,
											fk_proprietario,
											fk_servico_prestado) 
			VALUES(2,"2024-03-21",'13:00',"NAO_FEITO","RECEBIDO",45.00,"DINHEIRO",1,1);			
			
#TABELA CRIADA PARA LANCAR DE FORMA RAPIDA SERVICO SEM AGENDAMENTO
CREATE TABLE servico_rapido(
	cod_servico_rapido INT AUTO_INCREMENT NOT NULL,
	preco_cobrado DECIMAL NOT NULL,
	data_servico DATE NOT NULL,
	observacao VARCHAR(20),
	PRIMARY KEY(cod_servico_rapido))



