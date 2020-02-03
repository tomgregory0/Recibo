package Testes_Junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Vendedor;
import br.com.gx2.service.ServiceFactory;
import br.com.gx2.service.VendedorService;

public class VendedorTeste {

	private VendedorService vendedorService = ServiceFactory.createVendedorService();

	private int idVendedor01 = 12;
	private int idVendedor02 = 13;

	private String matricula01 = "334134";
	private String matricula02 = "544134";

	private String nomeVendedor01 = "Tom";
	private String nomeVendedor02 = "Jão";

	private Vendedor vendedor01 = new Vendedor(idVendedor01, matricula01, nomeVendedor01);
	private Vendedor vendedor02 = new Vendedor(idVendedor02, matricula02, nomeVendedor02);

	@Test
	public void VendedorCadastroTest() {

		boolean retorno = vendedorService.cadastrarVendedor(vendedor01);
		boolean retorno2 = vendedorService.cadastrarVendedor(vendedor02);

		assertTrue(retorno);
	}

	@Test
	public void RemoverVendedorTest() {

		boolean retorno = vendedorService.apagarVendedor(idVendedor01);

		assertTrue(retorno);
		assertNull(vendedorService.pesquisarVendedorId(idVendedor01));
		assertThat(vendedorService.exibirTodosVendedores().size(), is(1));
	}

	@Test
	public void RemoveVendedorInexistenteTest() {

		boolean retorno = vendedorService.apagarVendedor(543);

		assertThat(retorno, is(false));
		assertThat(vendedorService.exibirTodosVendedores().size(), is(2));
		assertNull(vendedorService.pesquisarVendedorId(543));

	}

	@Test
	public void AlterarVendedorTest() {

		Vendedor vendedor = new Vendedor(14, "35456757", "Vendedor Diego");
		boolean retorno = vendedorService.alterarVendedor(vendedor02);

		assertTrue(retorno);
	}

	@Test
	public void PesquisaVendedorTest() {

		Vendedor pesquisaVendedor = vendedorService.pesquisarVendedorId(idVendedor02);

		assertThat(pesquisaVendedor.getCodigoVendedor(), is(2));

	}

	@Test
	public void PesquisaVendedorInexistentesTest() {

		Vendedor pesquisaVendedor = vendedorService.pesquisarVendedorId(765);

		assertNull(pesquisaVendedor);

	}

	@Test
	public void ExibirTodosVendedoresTest() {

		List<Vendedor> exibir = vendedorService.exibirTodosVendedores();

		assertThat(exibir.size(), is(4));
		// System.out.println(exibir);

	}

}
