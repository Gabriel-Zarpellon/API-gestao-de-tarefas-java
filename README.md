# Projeto

Neste projeto é desenvolvida uma API para a criação, listagem, deleção e busca de tarefas.

## Objetivos da Aplicação

    1. Criação de Tarefa: Permite que o usuário adicione novas tarefas ao sistema, com cada tarefa tendo um identificador único, titulo, status e descrição.
    
    2. Listagem de Tarefas: Visualização de todas as tarefas disponíveis no sistema. Além disso, permite que o usuário filtre tarefas pelo status.
    
    3. Busca de Tarefa: Oferece uma funcionalidade de busca para localizar rapidamente tarefas pelo ID.
    
    4. Deleção de Tarefa: Oferece uma funcionalidade de deleção de tarefa por ID.

## Estrutura

A aplicação é estruturada em várias partes, cada uma com sua responsabilidade específica:

    - Entidade de Tarefa (TaskEntity): Define a estrutura de dados para as tarefas.
    
    - Controlador de Tarefas (TaskController): Gerencia o fluxo de requisição do usuário, entrada e saída de dados.
    
    - Serviço de Tarefas (TaskService): Gerencia a lógica da aplicação com as operações de criação, leitura, deleção e busca de tarefa.
    
    - Repositório de Tarefas (TaskRepository): Gerencia os métodos do ORM do JPA.
    
    - DTO para criação de Tarefas (TaskCreateDTO): Gerencia como os dados devem ser recebidos pela aplicação.
    
    - Exceções Personalizadas: Inclui exceções customizadas para tratar situações específicas como conflitos de nome e produtos não encontrados.

# API Gestão de Tarefas

## Rotas de usuário

### Registro de tarefa POST /api/tasks

Padrão de corpo

```json
{
	"title": "Tarefa 1",
	"status": "Pendente",
	"description": "Descrição da tarefa"
}
```

Padrão de resposta (STATUS 201)

```json
{
	"id": "612d78fe-6848-43a0-a458-0452ef08b247",
	"title": "Tarefa 1",
	"status": "Pendente",
	"description": "Descrição da tarefa"
}
```

Possíveis erros 

400 BAD REQUEST

```json
[
	{
		"error": "Title is required."
	},
	{
		"error": "Status is required."
	},
	{
		"error": "Description is required."
	}
]
```

### Leitura de tarefas GET /api/tasks

Padrão de resposta (STATUS 200)

```json
[
	{
		"id": "612d78fe-6848-43a0-a458-0452ef08b247",
		"title": "Tarefa 1",
		"status": "Pendente",
		"description": "Descrição da tarefa"
	}
]
```

URL Search Params

| Parâmetro | Exemplo de uso            | Descrição                                                                        |
| --------- | ------------------------- | -------------------------------------------------------------------------------- |
|  status   | /api/tasks?status=exemplo | Forneça o "status" da tarefa para trazer somente tarefas com ostatus determinado |


### Leitura de tarefas por id GET /api/tasks/id


Padrão de resposta (STATUS 200)

```json
{
	"id": "612d78fe-6848-43a0-a458-0452ef08b247",
	"title": "Tarefa 1",
	"status": "Pendente",
	"description": "Descrição da tarefa"
}
```

Possíveis erros 

STATUS 404 NOT FOUND

```json
{
	"error": "Task not found."
}
```

### Exclusão de tarefas por id DELETE /api/tasks/id


Padrão de resposta (STATUS 204)

Nenhum corpo de resposta 


Possíveis erros 

STATUS 404 NOT FOUND

```json
{
	"error": "Task not found."
}
```


