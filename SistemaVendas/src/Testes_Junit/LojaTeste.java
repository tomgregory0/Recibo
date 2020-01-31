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
	private Loja loja01 = new Loja(1, "Loja do Tomzinho Malvadeza");
	private Loja loja02 = new Loja(2, "Loja do Malvadeza");

	@Test
	public void LojaCadastroTest() {

		boolean retorno = lojaService.cadastrarLoja(loja01);
		boolean retorno2 = lojaService.cadastrarLoja(loja02);

		assertTrue(retorno);

	}

	@Test
	public void RemoverLojaTest() {

		boolean retorno = lojaService.apagarLoja(1);

		assertTrue(retorno);
		assertThat(lojaService.exibirTodasLojas().size(), is(2));
		assertNull(lojaService.pesquisarLojaId(1));

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

		boolean retorno = lojaService.alterarLoja(loja02);

		assertTrue(retorno);
	}

	@Test
	public void PesquisaLojaTest() {

		Loja pesquisaLoj = lojaService.pesquisarLojaId(10);

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