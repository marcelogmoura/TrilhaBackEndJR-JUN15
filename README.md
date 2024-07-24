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
- Para visualizar a documentação da API, clique no link:

```bash
https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html
```

## Documentação
- Para visualizar a documentação da API, clique no link:
```bash
https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html
```

## Funcionalidades

- CRUD para tarefas:
Crie, visualize, atualize e exclua tarefas com facilidade.
- Criação, autenticação e listagem de usuários:
Gerencie seus usuários com segurança e controle de acesso.
- Autenticação JWT:
Utilize tokens JWT para garantir a segurança das suas requisições.
- Controle de acesso:
Acesse as funcionalidades da API de acordo com suas permissões.
- Armazenamento de dados em SQLite:
Seus dados são armazenados de forma segura e persistente.

## Como utilizar
- Para ter acesso aos endpoints da API, é necessário realizar um registro de usuário. Utilize a seguinte requisição POST:
```bash
https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html#/usuario-controller/criarUsuario

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
