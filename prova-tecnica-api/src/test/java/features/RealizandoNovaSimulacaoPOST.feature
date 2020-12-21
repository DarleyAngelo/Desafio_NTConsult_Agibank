# language: pt

Funcionalidade: Realiza Nova simulação
  
    Como um usuário do sistema
	Eu desejo realizar as requisições na API
	A fim de manipular as informações da simulação de emprestimo.

  Cenário: Realizar nova simulação
    
	Dado o endereço da API para realizar nova simulação
	Quando realizar uma requisição POST
	E passando nome, cpf, email, valor, parcelas e seguro
	Então a API deverá retornar código 201
	E e retornar id, nome, cpf, email, valor, parcelas e seguro 

  Cenário: Validar CPF dplicado
  
	Dado o endereço da API para realizar nova simulação com CPF já cadastrado
	Quando realizar uma requisição POST
	E passando nome, cpf, email, valor, parcelas e seguro
	Então a API deverá retornar código 400
	E e retornar mensagem "CPF duplicado"
	
  Cenário: Verificar dados obrigatórios
  
	Dado o endereço da API para realizar nova simulação
	Quando realizar uma requisição POST
	E deixo de informar nome, cpf, email, valor, parcelas ou seguros
	Então a API deverá retornar código 400
	E e retornar mensagem "Campos obrigatórios devem ser informados"
	
 Cenário: Validando quantidade de parcelas 
  
	Dado o endereço da API para realizar nova simulação 
	Quando realizar uma requisição POST
	E passo o parmâmetro <parcelas> menos ou igual a 0
	Então a API deverá retornar código 400
	E e retornar mensagem "Parcelas deve ser igual ou maior que 2"
	
 Cenário: Validando valor do emprestimo
  
	Dado o endereço da API para realizar nova simulação 
	Quando realizar uma requisição POST
	E passo o parmâmetro <valor> maior ou igual a 40000
	Então a API deverá retornar código 400
	E e retornar mensagem "Valor deve ser menor ou igual a R$ 40.000"
		
	
 Cenário: Validando formato do email
  
	Dado o endereço da API para realizar nova simulação 
	Quando realizar uma requisição POST
	E passo o parmâmetro <email> igual a "emmemmem.com.br
	Então a API deverá retornar código 400
	E e retornar mensagem "E-mail deve ser um e-mail válido"
		