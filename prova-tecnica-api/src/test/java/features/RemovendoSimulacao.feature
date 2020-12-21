# language: pt

Funcionalidade: Realizar exclusão de simualações
  
    Como um usuário do sistema
	Eu desejo realizar as requisições na API
	A fim de manipular as informações da simulação de emprestimo.

  Cenário: Excluir uma simulaçao
    
	Dado o endereço da API para realizar a exclusão por um código de uma simulaçao
	Quando realizar uma requisição DELTE
	Então a API deverá apagar a simulação existente 
	E retornar código 200 
	E mensagem "OK"

  Cenário: Deletando uma simulçao inexistente
  
	Dado o endereço da API para realizar a exclusão por um código de uma simulação inexistente
	Quando realizar uma requisição DELTE
	Então a API deverá retornar erro 404
	E mensagem "Simulação não encontrada"