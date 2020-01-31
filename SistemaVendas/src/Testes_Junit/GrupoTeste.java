package Testes_Junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Cliente;
import br.com.gx2.entity.Grupo;
import br.com.gx2.entity.Produto;
import br.com.gx2.service.GrupoService;
import br.com.gx2.service.ProdutoService;
import br.com.gx2.service.ServiceFactory;

public class GrupoTeste {

	private GrupoService grupoService = ServiceFactory.createGrupoService();
	private ProdutoService service = ServiceFactory.createProdutoService();

	private Grupo grupo01 = new Grupo(1, "Eletrodomestico");
	private Grupo grupo02 = new Grupo(2, "Eletronico");
	private Grupo grupo03 = new Grupo(3, "Roupas");

	@Test
	public void GrupoCadastroTest() {

		boolean retorno = grupoService.cadastrarGrupo(grupo01);
		boolean retorno2 = grupoService.cadastrarGrupo(grupo02);
		boolean retorno3 = grupoService.cadastrarGrupo(grupo03);

		assertTrue(retorno);

	}

	@Test
	public void RemoverGrupoTest() {

		boolean retorno = grupoService.apagarGrupo(1);

		assertTrue(retorno);
		assertThat(grupoService.exibirTodosGrupos().size(), is(3));
		assertNull(grupoService.pesquisarGrupoId(1));

	}

	@Test
	public void RemoveClienteInexistenteTest() {

		boolean retorno = grupoService.apagarGrupo(2);

		assertThat(retorno, is(false));
		assertThat(grupoService.exibirTodosGrupos().size(), is(2));
		assertNull(grupoService.pesquisarGrupoId(2));

	}

	@Test
	public void AlterarGrupoTest() {
		
		Grupo grupo = new Grupo(13,"JOGOS");
		boolean retorno = grupoService.alterarGrupo(grupo);

		assertTrue(retorno);
	}

	@Test
	public void PesquisaGrupoTest() {

		Grupo pesquisaGrup = grupoService.pesquisarGrupoId(3);

		assertThat(pesquisaGrup.getCodigoGrupo(), is(3));
		
	}

//	@Test
//	public void PesquisaClientesInexistentesTest() {
//
//		Cliente pesquisaCli = service.pesquisarClienteId(78);
//
//		assertNull(pesquisaCli);
//
//	}

	@Test
	public void ExibirTodosGruposTest() {

		List<Grupo> exibir = grupoService.exibirTodosGrupos();

		assertThat(grupoService.exibirTodosGrupos().size(), is(3));

	}

}
