![Código Certo Coders](https://utfs.io/f/3b2340e8-5523-4aca-a549-0688fd07450e-j4edu.jfif)

# 📚 Trilha Inicial BackEnd Jr
Este projeto tem como objetivo desenvolver uma API RESTful para gerenciamento de tarefas, proporcionando funcionalidades de CRUD (Create, Read, Update, Delete) de tarefas, autenticação de usuários e armazenamento dos dados em um banco de dados.

## Objetivos:
- Criar uma API que permita CRUD (Create, Read, Update, Delete) de tarefas.
- Implementar autenticação de usuários.
- Utilizar um banco de dados SQLite para armazenar as tarefas.
- Documentar todo o processo e apresentar as conclusões.

## Resumo das tecnologias utilizadas:
• Java 17
• Spring Boot
• Spring Data e SQLite
• Spring Security
• Swagger
• JWT
• Bean Validations
• ModelMapper

## Deploy

https://trilhabackendjr-jun15-production.up.railway.app

## Documentação
- Registro de Usuário: Endpoint para registrar um novo usuário.
- Login de Usuário: Endpoint para autenticar um usuário e gerar um token JWT.
- Proteção de Rotas: Garantir que apenas usuários autenticados possam acessar os endpoints de tarefas.

## Funcionalidades
- Cadastro e autenticação para usuários.
- CRUD para tarefas.

## Como utilizar
- É necessário realizar ao menos um registro de usuário para ter acesso aos endpoints.

```bash
POST: 
https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html#/usuario-controller/criarUsuario

{
  "nome": "string",
  "email": "string",
  "senha": "string"
}
```

- Fazer o login utilizando as mesmas informações cadastradas e pegar o token jwt que será gerado como resposta para acessar os endpoints das tarefas.

```bash
POST:
https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html#/usuario-controller/autenticarUsuario

{
  "emailAcesso": "string",
  "senhaAcesso": "string"
}
```

- A tarefa poderá ser gravada após validação do token copiado da resposta na criação do usuário (comentário anterior)

```bash
POST:
https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html#/tarefa-controller/criarTarefa

{
  "nome": "string",
  "data": "yyyy-MM-dd",
  "hora": "dd-mm",
  "prioridade": integer
}
```

- Para editar uma tarefa, é só preencher com o id da mesma e preencher com o(s) campo(s) que deseja mudar, o id não é alterado na edição.

```bash
PUT:
https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html#/tarefa-controller/alterarTarefa
{
  "idTarefa": "uuid",
  "nome": "string",
  "data": "yyyy-MM-dd",
  "hora": "dd-mm",
  "prioridade": integer
}
```
- Para buscar 1 tarefa pelo id
```bash
GET:
https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html#/tarefa-controller/obterTarefa
```

- Para buscar todas as taferas de um usuário autenticado, por período de datas.
```bash
GET:
https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html#/tarefa-controller/consultarTarefas
```

- Para apagar uma tarefa basta enviar o id da mesma.

```bash
DELETE:
https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html#/tarefa-controller/excluirTarefa
```

## Banco de Dados:
- Foi utlizado o SQLite como banco de dados para armazenar informações de usuários e tarefas.

## Autor
- [@mgmoura](https://www.instagram.com/mgmoura/)
  
🌐 **Contato:**
- Email: mgmoura@gmail.com

---

**The world is full of kings and queens. 
   Who blinds your eyes, 
      then steals your dreams.**
