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

	/*---------------Cria grupos----------*/

	private Grupo grupo01 = new Grupo(1, "Eletrodomestico");
	private Grupo grupo02 = new Grupo(2, "Eletronico");
	private Grupo grupo03 = new Grupo(3, "Roupas");

	@Test
	public void GrupoCadastroTest() {

		/*---------------Cadastra os grupos----------*/

		boolean retorno = grupoService.cadastrarGrupo(grupo01);
		boolean retorno2 = grupoService.cadastrarGrupo(grupo02);
		boolean retorno3 = grupoService.cadastrarGrupo(grupo03);

		/*---------------Verifica se realmente foi cadastrado----------*/

		assertTrue(retorno);

	}

	@Test
	public void RemoverGrupoTest() {

		/*---------------Apaga o grupo----------*/

		boolean retorno = grupoService.apagarGrupo(1);

		/*---------------Verifica se realmente foi removido----------*/

		assertTrue(retorno);

		/*---------------Verificar se removeu algum grupo se baseando no tamanho da lista----------*/

		assertThat(grupoService.exibirTodosGrupos().size(), is(3));

		/*---------------Pesquisa o grupo inexistente----------*/

		assertNull(grupoService.pesquisarGrupoId(1));

	}

	@Test
	public void RemoveGruposInexistenteTest() {

		/*---------------Executa o teste apagando um cliente inexistente ----------*/

		boolean retorno = grupoService.apagarGrupo(2);
		/*---------------Verificar se Retorna o apagaCliente  retorna False----------*/

		assertThat(retorno, is(false));

		/*---------------Verificar se removeu algum cliente se baseando no tamanho da lista----------*/

		assertThat(grupoService.exibirTodosGrupos().size(), is(2));

		/*---------------Pesquisa o cliente inexistente----------*/

		assertNull(grupoService.pesquisarGrupoId(2));

	}

	@Test
	public void AlterarGrupoTest() {
		/*---------------Cria o grupo ----------*/

		Grupo grupo = new Grupo(13, "JOGOS");

		/*---------------Executa a alteração do grupo----------*/

		boolean retorno = grupoService.alterarGrupo(grupo);

		/*---------------Verificar se grupo foi alterado----------*/

		assertTrue(retorno);
	}

	@Test
	public void PesquisaGrupoTest() {
		/*---------------Executa a pesquisa do grupo----------*/

		Grupo pesquisaGrup = grupoService.pesquisarGrupoId(3);

		/*---------------Verificar se o cliente pesquisado é o ele mesmo ----------*/

		assertThat(pesquisaGrup.getCodigoGrupo(), is(3));

	}

	@Test
	public void PesquisaGrupoInexistentesTest() {
		/*---------------Executa a pesquisa do cliente inexistente----------*/

		Grupo pesquisaGrup = grupoService.pesquisarGrupoId(78);

		/*---------------Verificar se o cliente pesquisado existe-----------*/

		assertNull(pesquisaGrup);

	}

	@Test
	public void ExibirTodosGruposTest() {
		/*---------------Cria a lista com os clientes----------*/

		List<Grupo> exibir = grupoService.exibirTodosGrupos();

		/*---------------Verifica se todos clientes estão ali pelo tamanho da lista----------*/

		assertThat(exibir.size(), is(4));
		// System.out.println(exibir);

	}

}
