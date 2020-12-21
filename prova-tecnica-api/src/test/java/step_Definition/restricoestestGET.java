package step_Definition;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import util.geradorCPF;

public class restricoestestGET {
	geradorCPF geradorCPF = new geradorCPF();

	@Test	
	public void validaCPFComRestricao () {
		given()
		.log().all()
		.when()
		.get("http://localhost:8080/api/v1/restricoes/97093236014")
		.then()
		.body(is(not(nullValue())))
		.statusCode(200)
		.body("mensagem", containsString("O CPF 97093236014 tem problema"));
	}

	@Test	
	public void validaCPFSemRestricao (){
		
		String cpf = geradorCPF.geraCPFFinal();
		given()
		.log().all()
		.when()
		.get("http://localhost:8080/api/v1/restricoes/"+cpf+"")
		.then()
		.body(is(not(nullValue())))
		.statusCode(204);
	}

}
