![Código Certo Coders](https://utfs.io/f/3b2340e8-5523-4aca-a549-0688fd07450e-j4edu.jfif)

# 📚 Trilha Inicial BackEnd Jr
Este projeto tem como objetivo desenvolver uma API RESTful para gerenciamento de tarefas, proporcionando funcionalidades de CRUD (Create, Read, Update, Delete) de tarefas, autenticação de usuários e armazenamento dos dados em um banco de dados.

### Tecnologia utilizada
- Spring Boot
- Maven
- Spring Data
- Spring Security
- SQLite
- JWT
- Docker
- Java 17

### Deploy
```bash
https://janioofi-task.up.railway.app/
```

### Documentação
```bash
https://janioofi-task.up.railway.app/swagger-ui/index.html
```
### Funcionalidades
- CRUD para usuários.
- CRUD para tarefas.

## Como utilizar
- Necessário realizar um registro de usuário para ter acesso aos endpoints.
```bash
POST: https://janioofi-task.up.railway.app/api/register

{
   "usuario":"string",
   "senha":"string
}
```
- Fazer o login preenchendo com as mesmas informações registradas e pegar o token que será gerado como resposta para acessar os endpoints.
```bash
POST: https://janioofi-task.up.railway.app/api/login

{
   "usuario":"string",
   "senha":"string
}
```
- A tarefa tem o campo de status que pode ser preenchido com, CANCELADO, PENDENTE ou CONCLUIDO. o Id não é necessário preencher, pode deixar como 0.
```bash
POST: https://janioofi-task.up.railway.app/api/tarefa

{
  "idTarefa": 0,
  "descricao": "string",
  "status": "PENDENTE"
}
```
- Para editar uma tarefa, é só preencher com o id na url e depois preencher com os campos que deseja mudar
```bash
PUT: https://janioofi-task.up.railway.app/api/tarefa/{id}

{
  "idTarefa": 0,
  "descricao": "string",
  "status": "PENDENTE"
}
```
- Para listar todas tarefas.
```bash
GET: https://janioofi-task.up.railway.app/api/tarefa
```
- Para apagar é só enviar um o id como  parâmetro
```bash
DELETE: https://janioofi-task.up.railway.app/api/tarefa/{id}
```



## Autor
- [@janioofi](https://www.instagram.com/janioofi/)
