package Testes_Junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.security.Provider.Service;
import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Cliente;
import br.com.gx2.entity.Produto;
import br.com.gx2.service.GrupoService;
import br.com.gx2.service.ProdutoService;
import br.com.gx2.service.ServiceFactory;

public class ProdutoTeste {
	private GrupoService grupoService = ServiceFactory.createGrupoService();
	private ProdutoService produtoService = ServiceFactory.createProdutoService();
	private Produto iten01 = new Produto(22, "65567", "Maquina de Lava", grupoService.pesquisarGrupoId(3));

	private Produto iten02 = new Produto(23, "65567998", "Ele", grupoService.pesquisarGrupoId(4));

	@Test
	public void ProdutoCadastroTest() {

		boolean retorno = produtoService.cadastrarProduto(iten01);
		boolean retorno2 = produtoService.cadastrarProduto(iten02);

		assertTrue(retorno);

	}

	@Test
	public void RemoverProdutoTest() {

		boolean retorno = produtoService.apagarProduto(1);

		assertTrue(retorno);
		assertThat(produtoService.exibirTodosProdutos().size(), is(2));
		assertNull(produtoService.pesquisarProdutoId(1));

	}

	@Test
	public void RemoveClienteInexistenteTest() {

		boolean retorno = produtoService.apagarProduto(757);

		assertThat(retorno, is(false));
		assertThat(produtoService.exibirTodosProdutos().size(), is(2));
		assertNull(produtoService.pesquisarProdutoId(757));

	}

	@Test
	public void AlterarProdutoTest() {
		Produto produto = new Produto(8, "65567", "Maquina de Lavar", grupoService.pesquisarGrupoId(3));
		boolean retorno = produtoService.alterarProduto(produto);

		assertTrue(retorno);
	}

	@Test
	public void PesquisaProdutoTest() {

		Produto pesquisaProd = produtoService.pesquisarProdutoId(2);
		
		assertThat(pesquisaProd.getCodigoProduto(), is(2));

	}

	@Test
	public void PesquisaProdutosInexistentesTest() {

		Produto pesquisaProd = produtoService.pesquisarProdutoId(78);

		assertNull(pesquisaProd);

	}

	@Test
	public void ExibirTodosProdutosTest() {

		List<Produto> exibir = produtoService.exibirTodosProdutos();

		assertThat(produtoService.exibirTodosProdutos().size(), is(4));

	}
}
;