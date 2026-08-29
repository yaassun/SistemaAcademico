# **Sistema Acadêmico**

## Integrantes

- Yasmin Assunção 
- Késia de Jesus
- Alana de Almeida
- Luiz Felipe Souza

## Cenário escolhido

**Sistema Acadêmico**

O sistema tem como objetivo realizar o gerenciamento de informações acadêmicas, permitindo o cadastro, consulta, alteração e exclusão de estudantes.

## Instruções para execução

### Pré-requisitos

* Java JDK
* Apache NetBeans
* PostgreSQL
* Maven
* DBeaver

### Configuração do banco de dados

1. Instale e execute o PostgreSQL.
2. Crie o banco de dados `sistema_academico`.
3. Execute os comandos SQL necessários para criação das tabelas.
4. Verifique as informações de conexão no arquivo `Conexao.java`:

```text
Banco: sistema_academico
Host: localhost
Porta: 5432
Usuário: postgres
Senha: postgres
```

### Execução do sistema

1. Clone o repositório.
2. Abra o projeto no Apache NetBeans.
3. Aguarde o Maven baixar as dependências.
4. Verifique se o PostgreSQL está em execução.
5. Execute o projeto pelo NetBeans.

## Funcionalidades

O sistema possui funcionalidades para gerenciamento de estudantes, incluindo:

* Cadastro de estudantes;
* Consulta de estudantes;
* Consulta por matrícula;
* Consulta por nome;
* Alteração de dados dos estudantes;
* Exclusão de estudantes;
* Listagem dos estudantes em tabela.

O sistema utiliza Java, PostgreSQL, JDBC e Maven.

