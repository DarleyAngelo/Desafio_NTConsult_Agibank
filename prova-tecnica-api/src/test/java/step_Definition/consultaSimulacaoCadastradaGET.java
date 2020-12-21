package step_Definition;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class consultaSimulacaoCadastradaGET {
	
	@Test	
	public void consultaTodasSimulacoes () {
		given()
		.log().all()
		.when()
		.get("http://localhost:8080/api/v1/simulacoes")
		.then()
		.body(is(not(nullValue())))
		.body("id", is(not(nullValue())))
		.body("findAll{it.id > 0}.nome",is(not(nullValue())))		
		.statusCode(200);
	}
	
	@Test	
	public void validaSeExisteSimulacoes () {
		given()
		.log().all()
		.when()
		.get("http://localhost:8080/api/v1/simulacoes")
		.then()
		.body(is(nullValue()))
		.body("id", is(nullValue()))
		.statusCode(404);
	}

	@Test	
	public void consultaTodasSimulacoesPeloCPF () {
		given()
		.log().all()
		.when()
		.get("http://localhost:8080/api/v1/simulacoes/66414919004")
		.then()
		.statusCode(200)
		.body(is(not(nullValue())))
		.body("id", is(notNullValue()))
		.body("nome", is("Fulano"))
		.body("cpf", is("66414919004"))
		.body("email", is("fulano@gmail.com"))
		.body("valor", is(11000.0f))
		.body("parcelas", is(3))
		.body("seguro", is(true));
	}
	
}
