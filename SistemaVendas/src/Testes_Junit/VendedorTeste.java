package Testes_Junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Cliente;
import br.com.gx2.entity.Vendedor;
import br.com.gx2.service.ServiceFactory;
import br.com.gx2.service.VendedorService;

public class VendedorTeste {

	private VendedorService vendedorService = ServiceFactory.createVendedorService();
	private Vendedor vendedor01 = new Vendedor(12, "110519", "Vendedor Tom");
	private Vendedor vendedor02 = new Vendedor(13, "535319", "Vendedor Jão");

	@Test
	public void VendedorCadastroTest() {

		boolean retorno = vendedorService.cadastrarVendedor(vendedor01);
		boolean retorno2 = vendedorService.cadastrarVendedor(vendedor02);

		assertTrue(retorno);

	}

	@Test
	public void RemoverVendedorTest() {

		boolean retorno = vendedorService.apagarVendedor(1);

		assertTrue(retorno);
		assertNull(vendedorService.pesquisarVendedorId(1));
		assertThat(vendedorService.exibirTodosVendedores().size(), is(2));
	}

	@Test
	public void RemoveVendedorInexistenteTest() {

		boolean retorno = vendedorService.apagarVendedor(null);

		assertThat(retorno, is(false));
		assertThat(vendedorService.exibirTodosVendedores().size(), is(2));
		assertNull(vendedorService.pesquisarVendedorId(2));

	}

	@Test
	public void AlterarVendedorTest() {

		Vendedor cliente = new Vendedor(14, "35456757", "Vendedor Diego");
		boolean retorno = vendedorService.alterarVendedor(cliente);

		assertTrue(retorno);
	}

	@Test
	public void PesquisaVendedorTest() {

		Vendedor pesquisaVendedor = vendedorService.pesquisarVendedorId(2);

		assertThat(pesquisaVendedor.getCodigoVendedor(), is(2));

	}

	@Test
	public void PesquisaVendedorInexistentesTest() {

		Vendedor pesquisaVendedor = vendedorService.pesquisarVendedorId(12);

		assertNull(pesquisaVendedor);

	}

	@Test
	public void ExibirTodosVendedoresTest() {

		List<Vendedor> exibir = vendedorService.exibirTodosVendedores();

		assertThat(exibir.size(), is(4));
		// System.out.println(exibir);


	}

}
