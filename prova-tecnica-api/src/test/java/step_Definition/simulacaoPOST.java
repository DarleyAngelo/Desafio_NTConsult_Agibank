package step_Definition;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import util.*;



public class simulacaoPOST {

	geradorCPF geradorCPF = new geradorCPF();

	@Test	
	public void validaNovaSimulacaoComSucesso () {

		String cpf = geradorCPF.geraCPFFinal();

		given()
		.log().all()
		.contentType("application/json")
		.body("{\"nome\": \"Novo Cliente\", \"cpf\":"+cpf+", \"email\": \"darley2@gmail.com\", \"valor\": 5900, \"parcelas\": 8, \"seguro\": true}")
		.when()
		.post("http://localhost:8080/api/v1/simulacoes")
		.then()
		.body(is(not(nullValue())))
		.body("id", is(notNullValue()))
		.body("nome", is("Novo Cliente"))
		.body("cpf", is(cpf))
		.body("email", is("darley2@gmail.com"))
		.body("valor", is(5900))
		.body("parcelas", is(8))
		.body("seguro", is(true))
		.statusCode(201);
	}

	@Test	
	public void validaCPFDuplicado () {

		given()
		.log().all()
		.contentType("application/json")
		.body("{\r\n" + 
				"  \"nome\": \"Alessandra\",\r\n" + 
				"  \"cpf\":46341155905,\r\n" + 
				"  \"email\": \"email@email.com\",\r\n" + 
				"  \"valor\": 1200,\r\n" + 
				"  \"parcelas\": 3,\r\n" + 
				"  \"seguro\": false\r\n" + 
				"}")
		.when()
		.post("http://localhost:8080/api/v1/simulacoes")
		.then()
		.body(is(not(nullValue())))
		.statusCode(400)
		.body("mensagem", containsString("CPF duplicado"));
	}

	@Test	
	public void validaFaltadeDadosObrigatorios () {
		given()
		.log().all()
		.contentType("application/json")
		.body("{\r\n" + 
				"  \"nome\": \"Alessandra\",\r\n" + 
				"  \"cpf\": ,\r\n" + 
				"  \"email\": \"email@email.com\",\r\n" + 
				"  \"valor\": ,\r\n" + 
				"  \"parcelas\": ,\r\n" + 
				"  \"seguro\": false\r\n" + 
				"}")
		.when()
		.post("http://localhost:8080/api/v1/simulacoes")
		.then()
		.body(is(not(nullValue())))
		.statusCode(400);

	}


	@Test	
	public void validaParcelaMenorSendoMenorQue2 () {
		String cpf = geradorCPF.geraCPFFinal();
		given()
		.log().all()
		.contentType("application/json")
		.body("{\r\n" + 
				"  \"nome\": \"Fabio de Melo\",\r\n" + 
				"  \"cpf\":"+cpf+",\r\n" + 
				"  \"email\": \"email@email.com\",\r\n" + 
				"  \"valor\": 1200,\r\n" + 
				"  \"parcelas\": 0,\r\n" + 
				"  \"seguro\": true\r\n" + 
				"}")
		.when()
		.post("http://localhost:8080/api/v1/simulacoes")
		.then()
		.body(is(not(nullValue())))
		.statusCode(400)
		.body("erros.parcelas", containsString("Parcelas deve ser igual ou maior que 2"));

	}

	@Test	
	public void validaValorMaiorQue40Mil () {
		String cpf = geradorCPF.geraCPFFinal();

		given()
		.log().all()
		.contentType("application/json")
		.body("{\r\n" + 
				"  \"nome\": \"Fabio de Melo\",\r\n" + 
				"  \"cpf\":"+cpf+",\r\n" + 
				"  \"email\": \"email@email.com\",\r\n" + 
				"  \"valor\": 850000,\r\n" + 
				"  \"parcelas\": 6,\r\n" + 
				"  \"seguro\": false\r\n" + 
				"}")
		.when()
		.post("http://localhost:8080/api/v1/simulacoes")
		.then()
		.body(is(not(nullValue())))
		.statusCode(400)
		.body("erros.valor", containsString("Valor deve ser menor ou igual a R$ 40.000"));

	}

	@Test	
	public void validaFormatoEmail () {
		String cpf = geradorCPF.geraCPFFinal();
		given()
		.log().all()
		.contentType("application/json")
		.body("{\r\n" + 
				"  \"nome\": \"Fabio de Melo\",\r\n" + 
				"  \"cpf\":"+cpf+",\r\n" + 
				"  \"email\": \"emaiemail.com\",\r\n" + 
				"  \"valor\": 5000,\r\n" + 
				"  \"parcelas\": 6,\r\n" + 
				"  \"seguro\": false\r\n" + 
				"}")
		.when()
		.post("http://localhost:8080/api/v1/simulacoes")
		.then()
		.body(is(not(nullValue())))
		.statusCode(400)
		.body("erros.email", containsString("E-mail deve ser um e-mail válido"));

	}

	@Test	
	public void validaFormatoCPFInvalido () {
		String cpfInvlaido = geradorCPF.geraCPFFinalnvalido();
		
		given()
		.log().all()
		.contentType("application/json")
		.body("{\r\n" + 
				"  \"nome\": \"Fabio de Melo\",\r\n" + 
				"  \"cpf\": "+cpfInvlaido+",\r\n" + 
				"  \"email\": \"emai@email.com\",\r\n" + 
				"  \"valor\": 5000,\r\n" + 
				"  \"parcelas\": 6,\r\n" + 
				"  \"seguro\": false\r\n" + 
				"}")
		.when()
		.post("http://localhost:8080/api/v1/simulacoes")
		.then()
		.body(is(not(nullValue())))
		.statusCode(400);
	

	}


}
