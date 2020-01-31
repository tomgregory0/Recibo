package Testes_Junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Cliente;
import br.com.gx2.service.ClienteService;
import br.com.gx2.service.ServiceFactory;
import br.com.gx2.service.imp.ClienteServiceImp;

public class ClienteTeste {
	private ClienteService service = ServiceFactory.createClienteService();
	private Cliente cliente01 = new Cliente(1, "Tom Gregory", "12");
	private Cliente cliente02 = new Cliente(2, "Tom Rodrigues", "14");

	@Test
	public void ClienteCadastroTest() {

		boolean retorno = service.cadastrarCliente(cliente01);
		boolean retorno2 = service.cadastrarCliente(cliente02);

		assertTrue(retorno);

	}

	@Test
	public void RemoverClienteTest() {

		boolean retorno = service.apagarCliente(1);

		assertTrue(retorno);
		assertThat(service.exibirTodosClientes().size(), is(2));
		assertNull(service.pesquisarClienteId(1));

	}

	@Test
	public void RemoveClienteInexistenteTest() {

		boolean retorno = service.apagarCliente(757);

		assertThat(retorno, is(false));
		assertThat(service.exibirTodosClientes().size(), is(2));
		assertNull(service.pesquisarClienteId(757));

	}

	@Test
	public void AlterarClienteTest() {

		Cliente cliente = new Cliente(770, "Metodo Alterar Cliente", "85460592");
		boolean retorno = service.alterarCliente(cliente);

		assertTrue(retorno);
	}

	@Test
	public void PesquisaClienteTest() {

		Cliente pesquisaCli = service.pesquisarClienteId(768);

		assertThat(pesquisaCli.getCodigoCliente(), is(768));

	}

	@Test
	public void PesquisaClientesInexistentesTest() {

		Cliente pesquisaCli = service.pesquisarClienteId(78);

		assertNull(pesquisaCli);

	}

	@Test
	public void ExibirTodosClientesTest() {

		// List<Cliente> exibir = service.exibirTodosClientes();

		assertThat(service.exibirTodosClientes().size(), is(4));

	}
}