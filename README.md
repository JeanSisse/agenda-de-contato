# API REST em Java e MySQL que gerencie e disponibilize uma agenda de contatos de pessoas

## Instrução de instalação:
* Clonar o projeto para algum diretório de sua preferência na sua máquina pelo link:
* git@bitbucket.org:JeanSisse/agenda-de-contatos.git (SSH) OU
* https://JeanSisse@bitbucket.org/JeanSisse/agenda-de-contatos.git (Http);;
* Abrir o projeto em um IDE, Spring Tool Suite de preferência;
*  
* OBS.: usuário de banco de dados esta definido como "root" e o nome de banco de dados como
* "agenda_de_contatos" (será necessário criar um para o teste), mas para as devidas alterações
* acessar o arquivo application-test.properties na pasta src/main/resources, caso o DB exija uma 
* senha para acesso, por favor informar o mesmo neste arquivo.
	
## Instrução de uso 
* 
* Aplicação utilizado para testar o API: Postman
* 
* 
* ** PESQUISAR CONTATOS com o métod GET **
* 
* Listar todos os contatos (ex.: http://localhost:8080/contatos)
* Filtra pelo nome (ex.: http://localhost:8080/contatos?name=Nome da pessoa)
* Filtra pelo email (ex.: http://localhost:8080/contatos/email@dominio.com
* 
* 
* ** INSERIR CONTATO com o métod POST no formato JSON**
* 
* Ex.: acessar: http://localhost:8080/contatos/
* Selecionar opção body
* Setar opção "row" e na mesma aba escolher o formato "JSON" para o corpo da requisição a ser enviada
* 
* Formato JSON:
* {
*	"name": "Nome do contato",
*	"lastName": "Sobrenome",
*	"email": "nome@dominio.com",
*	"telefone1": "número de telefone" (obrigatorio),
*	"telefone2": "número de telefone" (opcional),
*	"telefone3": "número de telefone" (opcional, máximo de 3 telefones neste formato)
* }
*  OU
*  
* {
*	"name": "Nome do contato",
*	"lastName": "Sobrenome",
*	"email": "nome@dominio.com",
*	"telefones": [
*		"número de telefone",
*		"número de telefone",
*		... (quantos telefones quiser neste formato)
*	 ]
* }
* 
* ** ATUALIZAR CONTATO com o método PUT no formato JSON** 
* Ex.: Encotrar o contato desejado (ver ** PESQUISAR CONTATOS com o métod GET **),
* alterar o método de requisição para PUT, Selecionar opção body, 
* Setar opção "row" e na mesma aba escolher o formato "JSON" para o corpo da requisição a ser enviada
* Adicionar o id do contato a ser atualizado no link da requisição (Ex.: http://localhost:8080/contatos/id)
* 
* Formato JSON:
* {
*	"name": "Nome do contato",
*	"lastName": "Sobrenome",
*	"email": "nome@dominio.com",
*	"telefone1": "número de telefone" (obrigatorio),
*	"telefone2": "número de telefone" (opcional),
*	"telefone3": "número de telefone" (opcional, máximo de 3 telefones neste formato)
* }
*  OU
*  
* {
*	"name": "Nome do contato",
*	"lastName": "Sobrenome",
*	"email": "nome@dominio.com",
*	"telefones": [
*		"número de telefone",
*		"número de telefone",
*		... (quantos telefones quiser neste formato)
*	 ]
* }
* 
* 
* ** REMOVER CONTATO com método DELETE**
* 
* Ex.: Filtrar o contato a ser deletado, alterar o método para DELETE e informar o id do contato desejado
* (http://localhost:8080/contatos/idDoContatoParaDeletar)
