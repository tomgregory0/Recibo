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

	/*---------------Cria Clientes----------*/

	private Cliente cliente01 = new Cliente(1, "Tom Gregory", "12");
	private Cliente cliente02 = new Cliente(2, "Tom Rodrigues", "14");

	@Test
	public void ClienteCadastroTest() {

		/*---------------Executa o teste ----------*/

		boolean retorno = service.cadastrarCliente(cliente01);
		boolean retorno2 = service.cadastrarCliente(cliente02);

		/*---------------Verificar se o Cadastro retorna True----------*/

		assertTrue(retorno);

	}

	@Test
	public void RemoverClienteTest() {

		/*---------------Executa o teste ----------*/

		boolean retorno = service.apagarCliente(1);

		/*---------------Verificar se Retorna o apagarCliente retorna True----------*/

		assertTrue(retorno);

		/*---------------Verificar se realmente removeu o cliente se baseando no tamanho da lista----------*/

		assertThat(service.exibirTodosClientes().size(), is(2));

		/*---------------Verificar se Retorna o cliente removido----------*/

		assertNull(service.pesquisarClienteId(1));

	}

	@Test
	public void RemoveClienteInexistenteTest() {

		/*---------------Executa o teste apagando um cliente inexistente ----------*/

		boolean retorno = service.apagarCliente(757);

		/*---------------Verificar se Retorna o apagaCliente  retorna False----------*/
		assertThat(retorno, is(false));

		/*---------------Verificar se removeu algum cliente se baseando no tamanho da lista----------*/

		assertThat(service.exibirTodosClientes().size(), is(2));

		/*---------------Pesquisa o cliente inexistente----------*/

		assertNull(service.pesquisarClienteId(757));

	}

	@Test
	public void AlterarClienteTest() {

		/*---------------Cria o cliente ----------*/

		Cliente cliente = new Cliente(770, "Metodo Alterar Cliente", "85460592");
		/*---------------Executa a alteração de cliente----------*/

		boolean retorno = service.alterarCliente(cliente);

		/*---------------Verificar se cliente foi alterado----------*/

		assertTrue(retorno);
	}

	@Test
	public void PesquisaClienteTest() {
		
		/*---------------Executa a pesquisa do cliente----------*/

		Cliente pesquisaCli = service.pesquisarClienteId(768);

		/*---------------Verificar se o cliente pesquisado é o ele mesmo ----------*/

		assertThat(pesquisaCli.getCodigoCliente(), is(768));

	}

	@Test
	public void PesquisaClientesInexistentesTest() {

		/*---------------Executa a pesquisa do cliente inexistente----------*/

		Cliente pesquisaCli = service.pesquisarClienteId(78);
		
		/*---------------Verificar se o cliente pesquisado existe-----------*/


		assertNull(pesquisaCli);

	}

	@Test
	public void ExibirTodosClientesTest() {
		
		/*---------------Cria a lista com os clientes----------*/

		List<Cliente> exibir = service.exibirTodosClientes();

		/*---------------Verifica se todos clientes estão ali pelo tamanho da lista----------*/

		assertThat(exibir.size(), is(4));
		// System.out.println(exibir);
	}
}