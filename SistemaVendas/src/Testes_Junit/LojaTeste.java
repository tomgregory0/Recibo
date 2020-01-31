package Testes_Junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.gx2.dao.ClienteDAO;
import br.com.gx2.dao.DAOFactory;
import br.com.gx2.dao.LojaDAO;
import br.com.gx2.entity.Cliente;
import br.com.gx2.entity.Loja;
import br.com.gx2.service.ClienteService;
import br.com.gx2.service.LojaService;
import br.com.gx2.service.ServiceFactory;
import br.com.gx2.service.imp.ClienteServiceImp;
import br.com.gx2.service.imp.LojaServiceImp;

public class LojaTeste {

	private LojaService lojaService = ServiceFactory.createLojaService();
	private Loja loja01 = new Loja(1, "Loja do Tom");
	private Loja loja02 = new Loja(2, "Loja do malvadeza");

	@Test
	public void ClienteCadastroTest() {

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
	public void PesquisaClienteTest() {

		Loja pesquisaLoj = lojaService.pesquisarLojaId(10);

		assertThat(pesquisaLoj.getCodigoLoja(), is(10));

	}

	@Test
	public void PesquisaLojaInexistentesTest() {

		Loja pesquisaLoj = lojaService.pesquisarLojaId(78);

		assertNull(pesquisaLoj);

	}

	@Test
	public void ExibirTodosClientesTest() {

		List<Loja> exibir = lojaService.exibirTodasLojas();

		assertThat(lojaService.exibirTodasLojas().size(), is(4));

	}
}