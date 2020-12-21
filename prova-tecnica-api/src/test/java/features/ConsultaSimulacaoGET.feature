# language: pt

Funcionalidade: Realizar um cadastro para uma simulação de emprestimo
  
    Como um usuário do sistema
	Eu desejo realizar as requisições na API
	A fom de manipular as informações da simulação de emprestimo.

  Cenário: Consultar todas as simulações existentes
    
	Dado o endereço da API para realizar consulta
	Quando realizar uma requisição GET
	Então a API deverá retornar as simualações já cadastradas 

  Cenário: Verifica se existe simulação por CPF válido
  
	Dado o endereço da API para realizar consulta por um CPF válido
	Quando realizar uma requisição GET 
	Então a API deverá retornar a simulaçao do cpf informado
	E deve retornar nome, cpf, email, valor, parcelas e seguro.
	
