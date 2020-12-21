package step_Definition;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import util.geradorCPF;
public class atualizaSimulacaoPUT {
	geradorCPF geradorCPF = new geradorCPF();
	
	@Test	
	public void validaCPFnaoEncontradoNaAtualizacao () {
		String cpf = geradorCPF.geraCPFFinal();
		given()
		.log().all()
		.contentType("application/json")
		.body("{\r\n" + 
				"  \"nome\": \"Fabio Atualizado\",\r\n" + 
				"  \"cpf\": "+cpf+",\r\n" + 
				"  \"email\": \"emalalterado@gmail.com\",\r\n" + 
				"  \"valor\": 15962,\r\n" + 
				"  \"parcelas\": 3,\r\n" + 
				"  \"seguro\": true\r\n" + 
				"}")
		.when()
		.put("http://localhost:8080/api/v1/simulacoes/70266171257")
		.then()
		.body(is(not(nullValue())))
		.statusCode(404)
		.body("mensagem", containsString("CPF 80589176056 não encontrado"));
		
	}
	
	@Test	
	public void atualizaDadosSimulacao () {
		given()
		.log().all()
		.contentType("application/json")
		.body("{\r\n" + 
				"  \"nome\": \"Fabio Alterado\",\r\n" + 
				"  \"cpf\": 36110868000,\r\n" + 
				"  \"email\": \"emalalterado@gmail.com\",\r\n" + 
				"  \"valor\": 15962f,\r\n" + 
				"  \"parcelas\": 3,\r\n" + 
				"  \"seguro\": true\r\n" + 
				"}")
		.when()
		.put("http://localhost:8080/api/v1/simulacoes/21875824006")
		.then()
		.statusCode(200)
		.body(is(not(nullValue())))
		.body("id", is(notNullValue()))
		.body("nome", is("Fabio Alterado"))
		.body("cpf", is("36110868000"))
		.body("email", is("emalalterado@gmail.com"))
		.body("parcelas", is(3))
		.body("seguro", is(true));	
	    	
		
	}
	
	@Test	
	public void atualizaDadosSimulacaoParaCPFDuplicado () {
		given()
		.log().all()
		.contentType("application/json")
		.body("{\r\n" + 
				"  \"nome\": \"Fabio Alterado\",\r\n" + 
				"  \"cpf\": 36110868000,\r\n" + 
				"  \"email\": \"emalalterado@gmail.com\",\r\n" + 
				"  \"valor\": 15962,\r\n" + 
				"  \"parcelas\": 3,\r\n" + 
				"  \"seguro\": true\r\n" + 
				"}")
		.when()
		.put("http://localhost:8080/api/v1/simulacoes/21875824006")
		.then()
		.statusCode(409);	    	
		
	}
}
