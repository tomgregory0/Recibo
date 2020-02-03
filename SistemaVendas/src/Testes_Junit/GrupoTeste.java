package Testes_Junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Grupo;
import br.com.gx2.service.GrupoService;
import br.com.gx2.service.ProdutoService;
import br.com.gx2.service.ServiceFactory;

public class GrupoTeste {

	private GrupoService grupoService = ServiceFactory.createGrupoService();
	private ProdutoService service = ServiceFactory.createProdutoService();

	private Integer idGrupo01 = 1;
	private Integer idGrupo02 = 1;
	private Integer idGrupo03 = 1;
	private String descricao01 = "Eletrodomestico";
	private String descricao02 = "Roupas";
	private String descricao03 = "Eletronico";
	/*---------------Cria grupos----------*/

	private Grupo grupo01 = new Grupo(idGrupo01, descricao01);
	private Grupo grupo02 = new Grupo(idGrupo02, descricao02);
	private Grupo grupo03 = new Grupo(idGrupo03, descricao03);

	@Test
	public void GrupoCadastroTest() {

		/*---------------Cadastra os grupos----------*/

		boolean retorno1 = grupoService.cadastrarGrupo(grupo01);
		boolean retorno2 = grupoService.cadastrarGrupo(grupo02);
		boolean retorno3 = grupoService.cadastrarGrupo(grupo03);

		/*---------------Verifica se realmente foi cadastrado----------*/

		assertTrue(retorno1);
		assertTrue(retorno2);
		assertTrue(retorno3);

	}

	@Test
	public void RemoverGrupoTest() {

		/*---------------Apaga o grupo----------*/

		boolean retorno = grupoService.apagarGrupo(idGrupo01);

		/*---------------Verifica se realmente foi removido----------*/

		assertTrue(retorno);

		/*---------------Verificar se removeu algum grupo se baseando no tamanho da lista----------*/

		assertThat(grupoService.exibirTodosGrupos().size(), is(3));

		/*---------------Pesquisa o grupo inexistente----------*/

		assertNull(grupoService.pesquisarGrupoId(idGrupo01));

	}

	@Test
	public void RemoveGruposInexistenteTest() {

		/*---------------Executa o teste apagando um cliente inexistente ----------*/

		boolean retorno = grupoService.apagarGrupo(idGrupo01);
		/*---------------Verificar se Retorna o apagaCliente  retorna False----------*/

		assertThat(retorno, is(false));

		/*---------------Verificar se removeu algum cliente se baseando no tamanho da lista----------*/

		assertThat(grupoService.exibirTodosGrupos().size(), is(2));

		/*---------------Pesquisa o cliente inexistente----------*/

		assertNull(grupoService.pesquisarGrupoId(idGrupo01));

	}

	@Test
	public void AlterarGrupoTest() {
		/*---------------Cria o grupo ----------*/

		Grupo grupo = new Grupo(13, "JOGOS");

		/*---------------Executa a alteração do grupo----------*/

		boolean retorno = grupoService.alterarGrupo(grupo02);

		/*---------------Verificar se grupo foi alterado----------*/

		assertTrue(retorno);
	}

	@Test
	public void PesquisaGrupoTest() {
		/*---------------Executa a pesquisa do grupo----------*/

		Grupo pesquisaGrup = grupoService.pesquisarGrupoId(idGrupo02);

		/*---------------Verificar se o cliente pesquisado é o ele mesmo ----------*/

		assertThat(pesquisaGrup.getCodigoGrupo(), is(idGrupo02));

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
