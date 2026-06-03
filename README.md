# 🚗 AutoShop Manager — Sistema de Gestão para Oficinas

> Sistema web completo para gestão de oficinas mecânicas, desenvolvido com Java 17, Spring Boot e MariaDB. Cobre desde o cadastro de clientes e veículos até o controle financeiro e emissão de relatórios.

![Java](https://img.shields.io/badge/Java-17-007396?style=flat-square&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![MariaDB](https://img.shields.io/badge/MariaDB-10.x-003545?style=flat-square&logo=mariadb&logoColor=white)
![Status](https://img.shields.io/badge/Status-Em%20Produção-brightgreen?style=flat-square)

---

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Arquitetura](#arquitetura)
- [Tecnologias](#tecnologias)
- [Pré-requisitos](#pré-requisitos)
- [Como Executar](#como-executar)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [API Endpoints](#api-endpoints)
- [Screenshots](#screenshots)
- [Decisões Técnicas](#decisões-técnicas)
- [Contato](#contato)

---

## 📌 Sobre o Projeto

O **AutoShop Manager** nasceu de uma necessidade real: oficinas mecânicas que ainda gerenciam ordens de serviço em papel ou planilhas perdem tempo, cometem erros e têm dificuldade em acompanhar o histórico do cliente.

Este sistema foi desenvolvido **do zero** — da análise de requisitos até o deployment — com foco em usabilidade para usuários não técnicos e na robustez necessária para um ambiente de produção.

**Contexto:** Projeto freelance desenvolvido em Nürnberg, Deutschland (2018–presente)

---

## ✅ Funcionalidades

### Gestão de Clientes & Veículos
- Cadastro completo de clientes (PF/PJ)
- Histórico de veículos por cliente
- Busca por placa, CPF/CNPJ ou nome

### Ordens de Serviço
- Abertura e acompanhamento de OS em tempo real
- Status configurável: `ABERTA` → `EM ANDAMENTO` → `AGUARDANDO PEÇAS` → `CONCLUÍDA`
- Atribuição de mecânicos responsáveis
- Registro de peças utilizadas com integração ao estoque

### Financeiro
- Controle de pagamentos (dinheiro, cartão, transferência)
- Geração de orçamentos em PDF via **JasperReports**
- Dashboard com receita por período

### Estoque
- Cadastro de peças e fornecedores
- Alertas de estoque mínimo
- Histórico de entradas e saídas

---

## 🏗️ Arquitetura

```
┌─────────────────────────────────────────────────────┐
│                    Frontend (Web)                    │
│              Angular + HTML5 + CSS3                  │
└────────────────────────┬────────────────────────────┘
                         │ REST/JSON
┌────────────────────────▼────────────────────────────┐
│                  Backend (API)                       │
│         Java 17 + Spring Boot + Spring MVC          │
│                                                      │
│  ┌──────────────┐  ┌──────────────┐  ┌───────────┐ │
│  │  Controller  │  │   Service    │  │Repository │ │
│  │    Layer     │→ │    Layer     │→ │  (JPA)    │ │
│  └──────────────┘  └──────────────┘  └─────┬─────┘ │
└───────────────────────────────────────────-┼────────┘
                                             │ Hibernate ORM
┌────────────────────────────────────────────▼────────┐
│                   MariaDB Database                   │
│         (clientes, veículos, OS, estoque)            │
└─────────────────────────────────────────────────────┘
```

**Padrão utilizado:** MVC com separação em camadas (Controller → Service → Repository)  
**Segurança:** Spring Security com autenticação JWT  
**Deploy:** JAR executável em servidor Linux (Ubuntu Server)

---

## 🛠️ Tecnologias

| Camada | Tecnologia | Versão |
|---|---|---|
| Linguagem | Java | 17 |
| Framework | Spring Boot | 3.x |
| Persistência | Hibernate / JPA | 6.x |
| Banco de Dados | MariaDB | 10.x |
| Segurança | Spring Security + JWT | — |
| Relatórios | JasperReports | 6.x |
| Build | Maven | 3.x |
| Versionamento | Git | — |

---

## ⚙️ Pré-requisitos

- Java 17+
- MariaDB 10.x rodando localmente ou em servidor
- Maven 3.8+

```bash
java -version   # deve exibir: openjdk 17...
mvn -version    # deve exibir: Apache Maven 3.8...
```

---

## 🚀 Como Executar

### 1. Clonar o repositório
```bash
git clone https://github.com/jaqueline/autoshop-manager.git
cd autoshop-manager
```

### 2. Configurar o banco de dados
```bash
# Criar o banco no MariaDB
mysql -u root -p
CREATE DATABASE autoshop_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 3. Configurar application.properties
```properties
# src/main/resources/application.properties
spring.datasource.url=jdbc:mariadb://localhost:3306/autoshop_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### 4. Build e execução
```bash
mvn clean install
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

---

## 📁 Estrutura do Projeto

```
autoshop-manager/
├── src/
│   ├── main/
│   │   ├── java/com/autoshop/
│   │   │   ├── controller/       # REST Controllers
│   │   │   ├── service/          # Regras de negócio
│   │   │   ├── repository/       # Spring Data JPA Repositories
│   │   │   ├── model/            # Entidades JPA
│   │   │   ├── dto/              # Data Transfer Objects
│   │   │   ├── config/           # Spring Security, CORS
│   │   │   └── exception/        # Tratamento global de erros
│   │   └── resources/
│   │       ├── application.properties
│   │       └── reports/          # Templates JasperReports (.jrxml)
│   └── test/
│       └── java/com/autoshop/    # Testes unitários e de integração
├── pom.xml
└── README.md
```

---


## 🧠 Decisões Técnicas

**Por que Spring Boot?**  
Reduz drasticamente o boilerplate de configuração e tem excelente integração com todo o ecossistema Java — Hibernate, Spring Security, JasperReports. Facilita também o deploy via JAR executável.

**Por que MariaDB ao invés de MySQL?**  
Performance superior em queries complexas, licença mais permissiva (GPL v2), e melhor suporte a tipos de dados modernos. Compatível com a maioria dos provedores de hospedagem europeus.

**Por que JPA + Hibernate ao invés de JDBC puro?**  
O modelo de dados tem muitos relacionamentos (Cliente → Veículo → OS → Peças). O mapeamento objeto-relacional do Hibernate elimina SQL repetitivo e facilita a manutenção.

**Tratamento de erros**  
Uso de `@ControllerAdvice` + `@ExceptionHandler` para retornar respostas padronizadas em JSON para todos os erros, facilitando o consumo pelo frontend.

---

## 📞 Contato

**Jaqueline** — FullStack Java Developer  
📧 jaquelinevl90@protonmail.com  
📍 Nürnberg, Deutschland


