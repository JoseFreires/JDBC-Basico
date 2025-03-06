# Anotações sobre JDBC

<p> Esse repósitório tem o intuito de armazenar conceitos iniciais sobre JDBC, principalmente o básicos que são realizados em um banco de dados (SELECT, INSERT, UPDATE, DELETE). O que está armazenado aqui foi o que aprendi em um curso da Udemy na seção bônus.</p>

## Aula 1: Conectando ao Banco de Dados

<p>Nesta aula é apresentado como se conectar ao Banco de Dados MySQL.</p>

- 1°: Criar um arquivo com as propriedades do Banco de Dados;
- 2°: Criar uma pasta com um arquivo para realizar as configurações básicas (criar conexão e fechar conexão);
- 3°: Criar um arquivo para controlar os erros que podem ocorrer. 

## Aula 2: Buscando dados do Banco (SELECT)

<p>Nesta aula é apresentado como realizar um SELECT com Java. Foi realizado o Statement para receber a QUERY e ResultSet para receber o 
resultado. OBS: sempre feche ambos no final do código.</p>


## Aula 3: Inserindo dados no Banco (INSERT)

<p>Nesta aula é apresentado como realizar um INSERT com Java. Novamente utilizamos Statement e ResultSet, mas na parte da QUERY colocamos
pontos de interrogação na parte de valores que vão ser inseridos para indicar que aquela parte o programa que vai preencher</p>


## Aula 4: Atualizando dados no Banco (UPDATE)
<p>Nesta aula é apresentado como realizar um UPDATE com Java. O conceito é parecido com o de INSERT.</p>

## Aula 5: Deletando dados no Banco (DELETE)
<p>Nesta aula é apresentado como realizar um DELETE com Java. O conceito é parecido com o de INSERT.</p>

## Aula 6: Realizando o tratamento de transações
<p>Nesta aula é apresentado como controlar o sucesso das QUERY, pois sem o tratamento correto o programa pode executar apenas uma parte do processo.</p>