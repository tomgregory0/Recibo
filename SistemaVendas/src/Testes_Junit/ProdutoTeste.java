package Testes_Junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Grupo;
import br.com.gx2.entity.Produto;
import br.com.gx2.service.GrupoService;
import br.com.gx2.service.ProdutoService;
import br.com.gx2.service.ServiceFactory;

public class ProdutoTeste {
	private GrupoService grupoService = ServiceFactory.createGrupoService();
	private ProdutoService produtoService = ServiceFactory.createProdutoService();

	private Grupo grupo01 = new Grupo(12, "Descricao");

	private Integer idProduto01 = 12;
	private Integer idProduto02 = 13;

	private String ncm01 = "23123";
	private String ncm02 = "76543";

	private String descriProduto01 = "Maquina de lavar";
	private String descriProduto02 = "Eletro";

	private Produto iten01 = new Produto(idProduto01, ncm01, descriProduto01, grupo01);
	private Produto iten02 = new Produto(idProduto02, ncm02, descriProduto02, grupo01);

	@Test
	public void ProdutoCadastroTest() {

		boolean retorno = produtoService.cadastrarProduto(iten01);
		boolean retorno2 = produtoService.cadastrarProduto(iten02);

		assertTrue(retorno);

	}

	@Test
	public void RemoverProdutoTest() {

		boolean retorno = produtoService.apagarProduto(idProduto01);

		assertTrue(retorno);
		assertThat(produtoService.exibirTodosProdutos().size(), is(2));
		assertNull(produtoService.pesquisarProdutoId(idProduto01));

	}

	@Test
	public void RemoveProdutoInexistenteTest() {

		boolean retorno = produtoService.apagarProduto(757);

		assertThat(retorno, is(false));
		assertThat(produtoService.exibirTodosProdutos().size(), is(2));
		assertNull(produtoService.pesquisarProdutoId(757));

	}

	@Test
	public void AlterarProdutoTest() {
		Produto produto = new Produto(8, "65567", "Maquina de Lavar", grupo01);
		boolean retorno = produtoService.alterarProduto(produto);

		assertTrue(retorno);
	}

	@Test
	public void PesquisaProdutoTest() {

		Produto pesquisaProd = produtoService.pesquisarProdutoId(idProduto02);

		assertThat(pesquisaProd.getCodigoProduto(), is(idProduto02));

	}

	@Test
	public void PesquisaProdutosInexistentesTest() {

		Produto pesquisaProd = produtoService.pesquisarProdutoId(78);

		assertNull(pesquisaProd);

	}

	@Test
	public void ExibirTodosProdutosTest() {

		List<Produto> exibir = produtoService.exibirTodosProdutos();

		assertThat(exibir.size(), is(4));
		// System.out.println(exibir);
	}
}
