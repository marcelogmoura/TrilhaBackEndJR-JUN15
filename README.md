[Código Certo Coders](https://utfs.io/f/3b2340e8-5523-4aca-a549-0688fd07450e-j4edu.jfif)

# 📚 Trilha Inicial BackEnd Jr
Este projeto tem como objetivo desenvolver uma API RESTful para gerenciamento de tarefas, proporcionando funcionalidades de CRUD (Create, Read, Update, Delete) de tarefas, autenticação de usuários e armazenamento dos dados em um banco de dados.

## Tecnlogias utilizadas
- Java 17
- Spring Boot
- Maven
- Spring Data
- Spring Security
- SQLite (exigência da trilha)
- JWT



## Deploy

```bash
https://trilhabackendjr-jun15-production.up.railway.app/
```

## Documentação
```bash
https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html
```

## Funcionalidades

- CRUD para tarefas
- Criação, autenticação e listagem de usuários

## Como utilizar
- Necessário realizar um registro de usuário para ter acesso aos endpoints.
```bash
POST: https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html#/usuario-controller/criarUsuario

{
  "nome": "string",
  "email": "string",
  "senha": "string"
}
```

- Efetuar o login utilizando as mesmas informações do registro, pegar o token que será gerado como resposta para acessar os endpoints de tarefas.
   
```bash
POST: https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html#/usuario-controller/autenticarUsuario

{
  "emailAcesso": "string",
  "senhaAcesso": "string"
}
```

- A tarefa tem o campo de prioridade que pode ser preenchido com número inteiro. Data deve seguir o formato yyyy-MM-dd e a hora HH-mm.

```bash
POST: https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html#/tarefa-controller/criarTarefa

{
  "nome": "string",
  "data": "yyyy-MM-dd",
  "hora": "HH-mm",
  "prioridade": Integer
}
```

- Para editar uma tarefa, é só preencher com o id da tarefa depois preencher com os campos de acordo com a necessidade.

```bash
PUT: https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html#/tarefa-controller/obterTarefa

{
  "idTarefa": "UUID",
  "nome": "string",
  "data": "yyyy-MM-dd",
  "hora": "HH-mm",
  "prioridade": Integer
}
```

- Para listar uma tarefa pelo id.

```bash
GET: https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html#/tarefa-controller/obterTarefa

{
  "idTarefa": "UUID",
  "nome": "string",
  "data": "yyyy-MM-dd",
  "hora": "HH-mm",
  "prioridade": Integer
}
```

- Para listar todas as tarefas de um usuário, reconhecido pelo token, por um período de datas.

```bash
GET: https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html#/tarefa-controller/consultarTarefas

``` 

- Para deletar uma tarefa é só enviar um o id como parâmetro
```bash
DELETE: https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html#/tarefa-controller/excluirTarefa


```

## Autor 
- [@mgmoura](https://www.instagram.com/mgmoura/)


**"The world is full of kings and queens who blind your eyes and steal your dreams."**