# language: pt

Funcionalidade: Realizar uma simulação de emprestimo.
  
    Como um usuário do sistema
	Eu desejo realizar as requisições na API
	A fom de manipular as informações da simulação de emprestimo.

  Cenário: Validar CPF não encontrado
    
	Dado o endereço da API para realizar simulação através do CPF
	Quando realizar uma requisição PUT
	Então a API deverá retornar se CPF não encontrado

  Cenário: Atualizar dados da Simulação
  
	Dado o endereço da API para realizar atualização dos dados da simulação
	Quando realizar uma requisição PUT
	E passando nome, cpf, email, valor, parcelas e seguro
	Então a API deverá setar os novos dados com sucesso
	
 Cenário: Atualizar dados mas com CPf duplicado
  
	Dado o endereço da API para realizar atualização dos dados da simulação
	Quando realizar uma requisição PUT
	E passando nome, email, valor, parcelas,  seguro
	E um CPF já cadastrado para uma simulação
	Então a API deverá retornar erro 409
	
	
	