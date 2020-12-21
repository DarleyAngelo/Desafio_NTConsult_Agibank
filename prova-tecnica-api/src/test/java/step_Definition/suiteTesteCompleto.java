package step_Definition;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({ 

	simulacaoPOST.class,
	restricoestestGET.class,
	removeSimulacaoDELET.class,	
	consultaSimulacaoCadastradaGET.class,
	atualizaSimulacaoPUT.class,
})

public class suiteTesteCompleto  {
	
}