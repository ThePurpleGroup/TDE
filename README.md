# TDE "Special Edition"

Aplicação Java com utilização do Framework Swing e conexão com banco de dados postgreSQL entregue como solicitado no documento proposto abaixo:

[Projeto no Github](https://github.com/ThePurpleGroup/TDE)

[Documento TDE](https://docs.google.com/document/d/1q0t_junb_YpJaUnrwa5k_jUZHedB2uNpJFIEzeSj7UQ/edit?usp=sharing) 

## Equipe purpleGroup

1. [Marcelo Rangel](https://github.com/MarceloRanngel)
1. [Wilker Vinicios](https://github.com/WilkerVinicios)
1. [Allas Santos](https://github.com/Allas123)

## Dependencias

Para executar vamos precisar primeiro de algumas coisas:

1. [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (Versão 11+)
1. [postgreSQL](https://www.postgresql.org/download/) (Versão 10+)
1. [JDBC Driver postgreSQL](https://jdbc.postgresql.org/download.html) (Versão 4.2.18+)

## Executando

Para executar recomendamos o uso da IDE [IntelliJ IDEA Community](https://www.jetbrains.com/pt-br/idea/download/) pois 
foi onde fizemos toda a criação do codigo tornando assim possivel editar os .form caso necessario.

A Classe **main** do projeto se encontra em _./br/com/senac/utils/Principal.java_

## Criação do Banco de Dados

Para a criação do banco basta executar o Script abaixo:
       
       CREATE TABLE endereco (
       id serial primary key not null,
       nome varchar(255) not null,
       logradouro varchar(255) not null,
       numero varchar,
       complemento varchar(255) not null,
       bairro varchar(255) not null,
       cep varchar(9) not null,
       cidade varchar(255) not null,
       estado varchar(255) not null
       );
       
       
       
       CREATE TABLE cliente (
       id serial primary key not null,
       nome varchar (100) not null,
       cpf varchar(14) not null,
       rg varchar(255) not null,
       orgao varchar(255) not null,
       data_nascimento date not null,
       id_endereco serial not null,
       FOREIGN KEY (id_endereco) REFERENCES endereco(id)
       );
       
       INSERT INTO endereco( nome,logradouro,numero, complemento,
       bairro, cep, cidade, estado) 
       VALUES ('Aurora', 'Rua', '0', 'Qd 20 Lt 17', 'Morada do Sol', '75656-442',
       'Senador Canedo', 'Goiás');
       Insert Into cliente(nome,cpf,rg,orgao,data_nascimento,id_endereco)
       values ('Enzo Henrique','758.985.855-13','514246','SSPGO','24-04-1994',1)
       


        

####Passo a Passo
1. Importe o projeto na sua IDE
1. Adicione o Driver JDBC Driver postgreSQL citado nas Dependencias.
1. Abra a classe Conection dentro de .br/com/senac/utils/Conections.java

1. Coloque as informações do seu Banco seguindo o padrão abaixo:

        url = "jdbc:postgresql://localhost:5432/nomeBanco";
        driver = "org.postgresql.Driver";
        usuario = "postgres";
        senha = "suaSenha";

1. Só dar Build e Rodar o projeto.




        

     
##Observação

###### Este projeto foi feito como requisito para a aula de POO ministrada pelo professor **Roussian Gaioso**
