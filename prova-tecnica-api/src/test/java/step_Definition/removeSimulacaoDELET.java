package step_Definition;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;

import org.hamcrest.core.Is;
import org.junit.Test;



public class removeSimulacaoDELET {
	
	@Test	
	public void excluirSimulacao () {
		given()
		.log().all()
		.when()
		.delete("http://localhost:8080/api/v1/simulacoes/13")
		.then()	
		.body(Is.is("OK"))
		.statusCode(200);
		
	}
	
	@Test	
	public void excluirSimulacaoInexistente () {
		given()
		.log().all()
		.when()
		.delete("http://localhost:8080/api/v1/simulacoes/99")
		.then()			
		.statusCode(404)
		.body("mensagem", containsString("Simulação não encontrada"));
		
	}

}
