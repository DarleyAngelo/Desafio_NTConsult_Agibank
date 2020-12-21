# language: pt

Funcionalidade: Consulta restrições 
  
    Como um usuário do sistema
	Eu desejo realizar as requisições na API
	A fim de manipular as informações da simulação de emprestimo.

  Cenário: Validar CPF com restrições
    
	Dado o endereço da API para realizar a consulta por restrições pelo CPF com requisições
	Quando realizar uma requisição GET
	Então a API deverá retornar código 200 
	E mensagem "O CPF XXXX tem problema"

  Cenário: Validar CPF sem restrições
  
	Dado o endereço da API para realizar a consulta por restrições pelo CPF sem requisições
	Quando realizar uma requisição GET
	Então a API deverá retornar código 204 
	