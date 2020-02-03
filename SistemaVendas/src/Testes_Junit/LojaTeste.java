package Testes_Junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Loja;
import br.com.gx2.service.LojaService;
import br.com.gx2.service.ServiceFactory;

public class LojaTeste {

	private LojaService lojaService = ServiceFactory.createLojaService();
	
	private Integer idLoja01;
	private Integer idLoja02;
	private String nomeLoja01 = "Loja do Tomzinho Malvadeza";
	private String nomeLoja02 = "Loja do Serginho Malvadeza";
	
	private Loja loja01 = new Loja(idLoja01,nomeLoja01);
	private Loja loja02 = new Loja(idLoja02,nomeLoja02);

	@Test
	public void LojaCadastroTest() {

		boolean retorno1 = lojaService.cadastrarLoja(loja01);
		boolean retorno2 = lojaService.cadastrarLoja(loja02);

		assertTrue(retorno1);
		assertTrue(retorno2);
	}

	@Test
	public void RemoverLojaTest() {

		boolean retorno = lojaService.apagarLoja(idLoja01);

		assertTrue(retorno);
		assertThat(lojaService.exibirTodasLojas().size(), is(2));
		assertNull(lojaService.pesquisarLojaId(idLoja01));

	}

	@Test
	public void RemoveLojaInexistenteTest() {

		boolean retorno = lojaService.apagarLoja(757);

		assertThat(retorno, is(false));
		assertThat(lojaService.exibirTodasLojas().size(), is(2));
		assertNull(lojaService.pesquisarLojaId(757));

	}

	@Test
	public void AlterarLojaTest() {
		Loja alteracaoDeLoja = new Loja(12,"Loja Alterada");

		boolean retorno = lojaService.alterarLoja(alteracaoDeLoja);

		assertTrue(retorno);
	}

	@Test
	public void PesquisaLojaTest() {

		Loja pesquisaLoj = lojaService.pesquisarLojaId(idLoja02);

		assertThat(pesquisaLoj.getCodigoLoja(), is(10));
	}

	@Test
	public void PesquisaLojaInexistentesTest() {

		Loja pesquisaLoj = lojaService.pesquisarLojaId(78);

		assertNull(pesquisaLoj);

	}

	@Test
	public void ExibirTodasLojasTest() {

		List<Loja> exibir = lojaService.exibirTodasLojas();
		
		assertThat(exibir.size(), is(4));
	//  System.out.println(exibir);

	}
}