
CREATE TABLE endereco(
	cod_endereco INT AUTO_INCREMENT NOT NULL,
	rua VARCHAR(30) NULL,
	numero INT NOT NULL,
	cep VARCHAR(8) NULL,
	cidade VARCHAR(25) NULL,
	estado VARCHAR(25) NULL,
	PRIMARY KEY(cod_endereco)
)ENGINE = INNODB;

CREATE TABLE marca(
	cod_marca INT AUTO_INCREMENT NOT NULL,
	nome VARCHAR(20),
	PRIMARY KEY (cod_marca)
)ENGINE = INNODB;

INSERT INTO marca(cod_marca,nome) VALUES(1,'Selecione');
INSERT INTO marca(cod_marca,nome) VALUES(2,'Chevrolet');
INSERT INTO marca(cod_marca,nome) VALUES(3,'Fiat');
INSERT INTO marca(cod_marca,nome) VALUES(4,'Ford');
INSERT INTO marca(cod_marca,nome) VALUES(5,'Honda');
INSERT INTO marca(cod_marca,nome) VALUES(6,'Hyundai');
INSERT INTO marca(cod_marca,nome) VALUES(7,'Mitsubishi');
INSERT INTO marca(cod_marca,nome) VALUES(8,'Nissan');
INSERT INTO marca(cod_marca,nome) VALUES(9,'Peugeot');
INSERT INTO marca(cod_marca,nome) VALUES(10,'Renault');
INSERT INTO marca(cod_marca,nome) VALUES(11,'Toyota');
INSERT INTO marca(cod_marca,nome) VALUES(12,'Volkswagen');
INSERT INTO marca(cod_marca,nome) VALUES(13,'Outro');


CREATE TABLE modelo(
  cod_modelo INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(30),
  fk_marca INT NOT NULL,
  PRIMARY KEY (cod_modelo),
		FOREIGN KEY (fk_marca) REFERENCES MARCA(cod_marca)
)ENGINE = INNODB;

INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(1,'Selecione',1); #selecione

INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(2,'Captiva',2); #Chevrolet
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(3,'Onix',2); #Chevrolet
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(4,'Montana',2); #Chevrolet
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(5,'S10',2); #Chevrolet

INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(6,'Argo',3); #fiat
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(7,'Cronos',3); #fiat
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(8,'Doblo',3); #fiat
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(9,'Fiorino',3); #fiat
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(10,'Siena',3); #fiat
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(11,'Mobi',3); #fiat
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(12,'Strada',3); #fiat
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(13,'Toro',3); #fiat
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(14,'Uno',3); #fiat
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(15,'Palio',3); #fiat

INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(16,'EcoSport',4); #ford
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(17,'Edge',4); #ford
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(18,'Fiesta',4); #ford
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(19,'Fusion',4); #ford
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(20,'Ka',4); #ford
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(21,'Ranger',4); #ford

INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(22,'City',5); #honda
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(23,'Civic',5); #honda
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(24,'CR-V',5); #honda
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(25,'Fit',5); #honda
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(26,'HR-V',5); #honda

INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(27,'HB-20',6); #hyundai
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(28,'iX35',6); #hyundai
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(29,'Tucson',6); #hyundai
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(30,'Santa Fé',6); #hyundai

INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(31,'Pajero',7); #Mitsubishi
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(32,'Eclipse',7); #Mitsubishi
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(33,'Triton',7); #Mitsubishi

INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(34,'Frontier',8); #Nissan
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(35,'March',8); #Nissan
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(36,'Sentra',8); #Nissan
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(37,'Versa',8); #Nissan

INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(38,'Peugeot 208',9); #Peugeot
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(39,'Peugeot 206',9); #Peugeot

INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(40,'Captur',10); #Renault
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(41,'Duster',10); #Renault
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(42,'Kangoo',10); #Renault
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(43,'KWID',10); #Renault
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(44,'Logan',10); #Renault
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(45,'Master',10); #Renault
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(46,'Sandero',10); #Renault
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(47,'Stepway',10); #Renault

INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(48,'Corolla',11); #Toyota
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(49,'Etios',11); #Toyota
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(50,'Hilux',11); #Toyota
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(51,'RAV4',11); #Toyota

INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(52,'Amarok',12); #Volkswagen
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(53,'Fox',12); #Volkswagen
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(54,'Gol',12); #Volkswagen
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(55,'Golf',12); #Volkswagen
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(56,'Jetta',12); #Volkswagen
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(57,'Nivus',12); #Volkswagen
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(58,'Polo',12); #Volkswagen
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(59,'Passat',12); #Volkswagen
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(60,'Fusca',12); #Volkswagen
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(61,'Saveiro',12); #Volkswagen
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(62,'Tiguan',12); #Volkswagen
INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(63,'Voyage',12); #Volkswagen

INSERT INTO modelo(cod_modelo,nome,fk_marca) VALUES(64,'Outro',13); #Outro

CREATE TABLE mecanico (
  cod_mecanico INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(80) NOT NULL,
  PRIMARY KEY (cod_mecanico))
ENGINE = INNODB;

CREATE TABLE proprietario (
  cod_proprietario INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(20),
  cpf VARCHAR(14),
  celular VARCHAR(15),
  telefone VARCHAR(20),
  fk_mecanico INT NOT NULL,
  fk_endereco INT NOT NULL,
  PRIMARY KEY (cod_proprietario),
	FOREIGN KEY(fk_mecanico) REFERENCES MECANICO(cod_mecanico),
	FOREIGN KEY(fk_endereco) REFERENCES ENDERECO(cod_endereco)
)ENGINE = INNODB;


CREATE TABLE carro (
  cod_carro INT AUTO_INCREMENT NOT NULL,
  placa VARCHAR(10) NOT NULL,
  ano INT NOT NULL,
  cor VARCHAR(10) NULL,
  fk_marca INT NOT NULL,
  fk_modelo INT NOT NULL,
  fk_proprietario INT NOT NULL,
  PRIMARY KEY (cod_carro),
    FOREIGN KEY (fk_marca) REFERENCES MARCA (cod_marca),
    FOREIGN KEY (fk_proprietario) REFERENCES PROPRIETARIO(cod_proprietario),
    FOREIGN KEY (fk_modelo) REFERENCES MODELO (cod_modelo)
)ENGINE = INNODB;

CREATE TABLE tipo_servico(
	cod_tipo_servico INT AUTO_INCREMENT NOT NULL,
	descricao  VARCHAR(100) NULL,
	PRIMARY KEY (cod_tipo_servico)
)ENGINE = INNODB;

INSERT INTO tipo_servico(cod_tipo_servico,descricao) 
		VALUES(1,'Manutenção Preventiva e Básica');
INSERT INTO tipo_servico(cod_tipo_servico,descricao) 
		VALUES(2,'Sistema de Freios');
INSERT INTO tipo_servico(cod_tipo_servico,descricao) 
		VALUES(3,'Suspensão e Direção');
INSERT INTO tipo_servico(cod_tipo_servico,descricao) 
		VALUES(4,'Motor e Periféricos');
INSERT INTO tipo_servico(cod_tipo_servico,descricao) 
		VALUES(5,'Transmissão e Embreagem');
INSERT INTO tipo_servico(cod_tipo_servico,descricao) 
		VALUES(6,'Sistema Elétrico e Eletrônico (básico)');
INSERT INTO tipo_servico(cod_tipo_servico,descricao) 
		VALUES(7,'Outros Serviços Comuns');										
     
# tabela que descreve os serviços realizados na oficina
CREATE TABLE servico_prestado (
  cod_servico_prestado INT AUTO_INCREMENT NOT NULL,
  descricao VARCHAR(500) NULL,
  preco_tabela DECIMAL NULL,
  fk_tipo_servico INT NOT NULL,
  PRIMARY KEY (cod_servico_prestado),
  	 FOREIGN KEY (fk_tipo_servico) REFERENCES TIPO_SERVICO(cod_tipo_servico)
)ENGINE = INNODB;

CREATE TABLE forma_pagamento(
		cod_forma_pagamento INT AUTO_INCREMENT NOT NULL,
		forma_pagamento VARCHAR(20),
		PRIMARY KEY(cod_forma_pagamento)
)ENGINE = INNODB;

INSERT INTO forma_pagamento(cod_forma_pagamento,forma_pagamento) 
			VALUES(1,"Pix");
INSERT INTO forma_pagamento(cod_forma_pagamento,forma_pagamento) 
			VALUES(2,"Dinheiro");

CREATE TABLE agendamento_servico (
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
  fk_mecanico INT NOT NULL,
  PRIMARY KEY (cod_agendamento_servico),
  	 FOREIGN KEY (fk_forma_pagamento) REFERENCES FORMA_PAGAMENTO(cod_forma_pagamento),
	 FOREIGN KEY (fk_proprietario) REFERENCES PROPRIETARIO(cod_proprietario),
	 FOREIGN KEY (fk_servico_prestado) REFERENCES SERVICO_PRESTADO(cod_servico_prestado),
	 FOREIGN KEY (fk_mecanico) REFERENCES MECANICO(cod_mecanico)
)ENGINE = INNODB;


INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(1,'Troca de óleo do motor + filtro de óleo',45.00,1);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(2,'Troca de filtro de ar do motor',150.00,1);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(3,'Troca de filtro de combustível',50.00,1);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(4,'Troca de filtro de cabine (ar-condicionado)',45.00,1);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(5,'Troca de fluido de arrefecimento (água + aditivo)',120.00,1);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(6,'Troca de fluido de freio',140.00,1);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(7,'Troca de fluido de transmissão automática',160.00,1);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(8,'Troca de óleo da caixa de câmbio manual',120.00,1);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(9,'Troca de vela de ignição',120.00,1);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(10,'Troca de cabos de vela / bobina',70.00,1);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(11,'Troca / regulagem / retesamento de correia dentada ou correia em V',250.00,1);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(12,'Troca de tensor e polia da correia',250.00,1);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(13,'Limpeza / regulagem de bicos injetores',250.00,1);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(14,'Limpeza do corpo de borboleta',250.00,1);	
			
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(15,'Troca de pastilhas de freio dianteiras / traseiras',250.00,2);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(16,'Troca de discos de freio',250.00,2);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(17,'Retífica de discos de freio',250.00,2);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(18,'Troca de lonas de freio a tambor',250.00,2);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(19,'Retífica / troca de tambor de freio',250.00,2);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(20,'Sangria / troca do fluido de freio',250.00,2);																											
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(21,'Reparo / troca de pinça de freio',250.00,2);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(22,'Reparo / troca de cilindro de roda',250.00,2);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(23,'Reparo / regulagem do freio de mão',250.00,2);	
			
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(24,'Alinhamento de direção',250.00,3);				
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(25,'Balanceamento de rodas',250.00,3);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(26,'Troca de amortecedor dianteiro / traseiro',250.00,3);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(27,'Troca de mola helicoidal',250.00,3);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(28,'Troca de bandeja / braço oscilante',250.00,3);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(29,'Troca de bucha de bandeja / barra estabilizadora',250.00,3);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(30,'Troca de pivô de bandeja',250.00,3);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(31,'Troca de barra estabilizadora / buchas',250.00,3);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(32,'Troca de terminal de direção / barra axial',250.00,3);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(33,'Troca de caixa de direção (hidráulica ou elétrica)',250.00,3);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(34,'Reparo / troca de bomba de direção hidráulica',250.00,3);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(35,'Troca de fluido de direção hidráulica',250.00,3);				
			
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(36,'Retífica de motor (pistão, anéis, bronzinas, etc.)',250.00,4);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(37,'Retífica / troca de cabeçote',250.00,4);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(38,'Troca de junta do cabeçote',250.00,4);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(39,'Reparo / troca de bomba dágua',250.00,4);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(40,'Troca de termostato',250.00,4);		
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(41,'Troca de ventoinha / motor da ventoinha',250.00,4);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(42,'Reparo / troca de alternador',250.00,4);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(43,'Reparo / troca de motor de arranque',250.00,4);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(44,'Troca de bomba de combustível (tanque ou externa)',250.00,4);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(45,'Limpeza / troca de sensor MAF, MAP, lambda (sonda lambda)',250.00,4);
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(46,'Troca de bobina de ignição individual',250.00,4);
					
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(47,'Troca / reparo de kit de embreagem (disco, platô, rolamento)',250.00,5);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(48,'Reparo / troca de cabo de embreagem',250.00,5);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(49,'Reparo / troca de cilindro mestre / escravo da embreagem',250.00,5);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(50,'Revisão / reparo de câmbio automático (troca de solenoides, óleo, etc.)',250.00,5);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(51,'Troca de semi-eixo / homocinética',250.00,5);	
			
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(52,'Diagnóstico com scanner OBD',250.00,6);				
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(53,'Troca de bateria',250.00,6);				
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(54,'Reparo / recarga do alternador',250.00,6);				
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(55,'Reparo de chicote elétrico',250.00,6);				
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(56,'Troca de farol / lanterna / lâmpadas',250.00,6);				
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(57,'Troca de fusíveis / relés',250.00,6);				
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(58,'Reparo de vidros elétricos / travas',250.00,6);				
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(59,'Troca de sensores diversos (temperatura, rotação, etc.)',250.00,6);	

INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(60,'Reparo / troca de escapamento (catalisador, abafador, coletor)',250.00,7);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(61,'Troca de coxim do motor / câmbio',250.00,7);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(62,'Troca de mangueiras (radiador, aquecimento, etc.)',250.00,7);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(63,'Limpeza / reparo do sistema de ar-condicionado (carga de gás)',250.00,7);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(64,'Troca de pneus / reparo de pneu furado',250.00,7);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(65,'Calibragem e rodízio de pneus',250.00,7);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(66,'Polimento / cristalização de faróis',250.00,7);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(67,'Lavagem / limpeza técnica do motor',250.00,7);	
INSERT INTO servico_prestado(cod_servico_prestado,descricao, preco_tabela,fk_tipo_servico) 
			VALUES(68,'Instalação de acessórios (alarme, som, película, etc.)',250.00,7);															
				
CREATE TABLE num_orcamento (
  cod_num_orcamento INT AUTO_INCREMENT,
  num_orcamento INT NOT NULL,
  PRIMARY KEY (cod_num_orcamento)
 )ENGINE = INNODB;
 				
				
CREATE TABLE orcamento(
	cod_orcamento INT AUTO_INCREMENT NOT NULL,
	nome_cliente VARCHAR(30) NOT NULL,
	email VARCHAR(50),
	telefone VARCHAR(50),
	endereco VARCHAR(100),
	cidade VARCHAR(100),
	estado VARCHAR(100),
	data_emissao DATE,
	valido_ate DATE,
	fk_marca INT NOT NULL,
	fk_modelo INT NOT NULL,
	fk_mecanico INT NOT NULL,
	fk_num_orcamento INT NOT NULL,
	carro_ano INT,
	carro_cor VARCHAR(20),
	placa VARCHAR(20),
	observacao VARCHAR(500), 
	PRIMARY KEY (cod_orcamento),
		FOREIGN KEY (fk_marca) REFERENCES MARCA (cod_marca),
		FOREIGN KEY (fk_modelo) REFERENCES MODELO (cod_modelo),
		FOREIGN KEY (fk_mecanico) REFERENCES MECANICO (cod_mecanico),
		FOREIGN KEY (fk_num_orcamento) REFERENCES NUM_ORCAMENTO (cod_num_orcamento)
)ENGINE = INNODB;


CREATE TABLE item_descricao(
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


CREATE TABLE tipo_chave_pix(
	cod_tipo_chave_pix INT AUTO_INCREMENT NOT NULL,
	descricao VARCHAR(20),
	PRIMARY KEY(cod_tipo_chave_pix)
)ENGINE = INNODB;

INSERT INTO tipo_chave_pix(cod_tipo_chave_pix, descricao) VALUES(1,'Selecione');
INSERT INTO tipo_chave_pix(cod_tipo_chave_pix, descricao) VALUES(2,'CNPJ');
INSERT INTO tipo_chave_pix(cod_tipo_chave_pix, descricao) VALUES(3,'CPF');
INSERT INTO tipo_chave_pix(cod_tipo_chave_pix, descricao) VALUES(4,'Email');
INSERT INTO tipo_chave_pix(cod_tipo_chave_pix, descricao) VALUES(5,'Telefone');


CREATE TABLE qrcode(
	cod_pagamento INT AUTO_INCREMENT NOT NULL,
	nome_beneficiario VARCHAR(30),
	chave_pix VARCHAR(50),
	valor  DECIMAL,
	cidade_beneficiario VARCHAR(50),
	imagem_qr_code LONGBLOB,
	chave_copia_cola VARCHAR(400),
	nome_arquivo VARCHAR(20),
	fk_chave_pix INT NOT NULL,
	fk_mecanico INT NOT NULL,
	PRIMARY KEY(cod_pagamento),
		FOREIGN KEY(fk_chave_pix)
		REFERENCES TIPO_CHAVE_PIX (cod_tipo_chave_pix),
		FOREIGN KEY(fk_mecanico)
		REFERENCES MECANICO (cod_mecanico)
)ENGINE = INNODB;


CREATE TABLE documento(
	cod_documento INT AUTO_INCREMENT NOT NULL,
    tipo VARCHAR(30),
	nome_arquivo  VARCHAR(50) NOT NULL,
	tamanho_arquivo INT,
	hash_arquivo VARCHAR(50) NOT NULL,
	conteudo MEDIUMBLOB NOT NULL,
	data_upload DATETIME DEFAULT CURRENT_TIMESTAMP,
	fk_mecanico INT NOT NULL,
	PRIMARY KEY(cod_documento),
		FOREIGN KEY(fk_mecanico)
		REFERENCES MECANICO (cod_mecanico)
)ENGINE = INNODB;


#TABELA CRIADA PARA LANCAR DE FORMA RAPIDA SERVICO SEM AGENDAMENTO
CREATE TABLE servico_rapido(
	cod_servico_rapido INT AUTO_INCREMENT NOT NULL,
	preco_cobrado DECIMAL NOT NULL,
	data_servico DATE NOT NULL,
	observacao VARCHAR(20),
	PRIMARY KEY(cod_servico_rapido)
)ENGINE = INNODB;
	
CREATE TABLE papel (
        id BIGINT NOT NULL AUTO_INCREMENT,
        nome VARCHAR(50),
        PRIMARY KEY(id)
)ENGINE = INNODB;
    
    
CREATE TABLE usuario (
        id BIGINT NOT NULL AUTO_INCREMENT,
        email VARCHAR(80),
        nome VARCHAR(50),
        senha VARCHAR(200),
       PRIMARY KEY(id)
)ENGINE = INNODB;


CREATE TABLE usuario_papeis (
        usuario_id BIGINT NOT NULL,
        papeis_id BIGINT NOT NULL
)ENGINE = INNODB;

	
INSERT INTO papel(id,nome) VALUES(1,"ROLE_ADMIN");
INSERT INTO papel(id,nome) VALUES(2,"ROLE_USER");


INSERT INTO mecanico(cod_mecanico,nome) VALUES(1,'Administrador Sistema');
INSERT INTO mecanico(cod_mecanico,nome) VALUES(2,'Leonildo');
INSERT INTO mecanico(cod_mecanico,nome) VALUES(3,'Jeferson');
INSERT INTO mecanico(cod_mecanico,nome) VALUES(4,'Visitante');


INSERT INTO usuario(id,nome,email, senha) VALUES(1,"Administrador Sistema","jaquelinesv90@gmail.com","$2a$10$wFfG3W0JSZZX8wfm1fd2POC.QYArI9KUxS4CMAC1UQJMNM76uWvwC");
INSERT INTO usuario_papeis(usuario_id,papeis_id) VALUES(1,1);

INSERT INTO usuario(id,nome,email, senha) VALUES(2,"Leonildo","oficinamecanicaleonildo@gmail.com","$2a$10$wFfG3W0JSZZX8wfm1fd2POC.QYArI9KUxS4CMAC1UQJMNM76uWvwC");
INSERT INTO usuario_papeis(usuario_id,papeis_id) VALUES(2,2);

INSERT INTO usuario(id,nome,email, senha) VALUES(3,"Jeferson","jefersonduckinhoduck@gmail.com","$2a$10$wFfG3W0JSZZX8wfm1fd2POC.QYArI9KUxS4CMAC1UQJMNM76uWvwC");
INSERT INTO usuario_papeis(usuario_id,papeis_id) VALUES(3,2);

INSERT INTO usuario(id,nome,email, senha) VALUES(4,"Visitante","jaquelinesv1990@gmail.com","$2a$10$wFfG3W0JSZZX8wfm1fd2POC.QYArI9KUxS4CMAC1UQJMNM76uWvwC");
INSERT INTO usuario_papeis(usuario_id,papeis_id) VALUES(4,2);
