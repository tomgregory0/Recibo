package Testes_Junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Cliente;
import br.com.gx2.entity.CupomFiscal;
import br.com.gx2.entity.Loja;
import br.com.gx2.entity.Vendedor;
import br.com.gx2.service.ClienteService;
import br.com.gx2.service.CupomFiscalService;
import br.com.gx2.service.GrupoService;
import br.com.gx2.service.LojaService;
import br.com.gx2.service.ProdutoService;
import br.com.gx2.service.ServiceFactory;
import br.com.gx2.service.VendedorService;

public class CupomFiscalTeste {

	private ClienteService service = ServiceFactory.createClienteService();
	private LojaService lojaService = ServiceFactory.createLojaService();
	private CupomFiscalService cupomService = ServiceFactory.createCupomFiscalService();
	private VendedorService vendedorService = ServiceFactory.createVendedorService();
	private GrupoService grupoService = ServiceFactory.createGrupoService();
	private ProdutoService produtoService = ServiceFactory.createProdutoService();

	Vendedor vendedor = vendedorService.pesquisarVendedorId(3);
	Cliente cliente = service.pesquisarClienteId(2);
	Loja loja = lojaService.pesquisarLojaId(3);
	CupomFiscal cupom33 = cupomService.pesquisarCupomFiscalId(1);

	Date data = new Date();

	CupomFiscal cupom01 = new CupomFiscal(null, 100.0, data, loja, cliente, vendedor);

	@Test
	public void CupomFiscalCadastroTest() {

		boolean retorno = cupomService.cadastrarCupomFiscal(cupom01);

		assertTrue(retorno);

	}

	@Test
	public void RemoverCupomTest() {

		boolean retornoCup = cupomService.apagarCupomFiscal(1);
		boolean retornoCli = service.apagarCliente(801);
		boolean retornoVend = vendedorService.apagarVendedor(2 - 535319);
		boolean retornoApag = lojaService.apagarLoja(4);

		// assertTrue(retornoCli);
		// assertTrue(retornoVend);
		// assertTrue(retornoApag);
		assertTrue(retornoCup);
		assertThat(cupomService.exibirTodosCuponsFiscais().size(), is(1));
		assertNull(cupomService.pesquisarCupomFiscalId(1));

	}

	@Test
	public void RemoveCupomFiscalInexistenteTest() {

		boolean retornoCup = cupomService.apagarCupomFiscal(1);
		boolean retornoCli = service.apagarCliente(801);
		boolean retornoVend = vendedorService.apagarVendedor(2 - 535319);
		boolean retornoApag = lojaService.apagarLoja(4);

		// assertTrue(retornoCli);
		// assertTrue(retornoVend);
		// assertTrue(retornoApag);
		assertFalse(retornoCup);
		assertThat(cupomService.exibirTodosCuponsFiscais().size(), is(2));
		assertNull(cupomService.pesquisarCupomFiscalId(757));

	}

	@Test
	public void AlterarCupomTest() {

		// CupomFiscal cupom = new CupomFiscal(770, "Metodo Alterar Cliente",
		// "85460592");
		// boolean retorno = cupomService.alterarCupomFiscal(cupom);

		// assertTrue(retorno);
	}

	@Test
	public void PesquisaCupomTest() {

		CupomFiscal pesquisaCupom = cupomService.pesquisarCupomFiscalId(2);

		assertThat(pesquisaCupom.getCodigoCupom(), is(2));

	}

	@Test
	public void PesquisaCupomFiscalInexistentesTest() {

		CupomFiscal pesquisaCupom = cupomService.pesquisarCupomFiscalId(78);

		assertNull(pesquisaCupom);

	}

	@Test
	public void ExibirTodosCuponsFiscaisTest() {

		List<CupomFiscal> exibir = cupomService.exibirTodosCuponsFiscais();

		assertThat(exibir.size(), is(1));

	}
}
