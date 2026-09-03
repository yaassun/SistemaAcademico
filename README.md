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

## INSTRUÇÕES DE CONEXÃO - BANCO NEONDB

### Dados de Conexão
```text

| Host: ep-old-pond-acsehzt0-pooler.sa-east-1.aws.neon.tech
| Porta: 5432
| Database: neondb
| Usuário: neondb_owner
| Senha: npg_QMatRnP4I7ko
```

### Connection String (URI)

postgresql://neondb_owner:npg_QMatRnP4I7ko@ep-old-pond-acsehzt0-pooler.sa-east-1.aws.neon.tech/neondb?sslmode=require&channel_binding=require

### Como Conectar

1. No seu cliente de banco (DBeaver, TablePlus, pgAdmin, etc.), crie uma nova conexão do tipo PostgreSQL.
2. Preencha os campos Host, Porta, Database, Usuário e Senha conforme acima.
3. Ative a opção SSL/TLS como `require`.
4. Ao listar os databases, use apenas o `neondb` (ignore o database `postgres`, que é padrão do sistema).


## Execução do sistema

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

