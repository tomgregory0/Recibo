package Testes_Junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Cliente;
import br.com.gx2.entity.CupomFiscal;
import br.com.gx2.entity.Grupo;
import br.com.gx2.entity.Loja;
import br.com.gx2.entity.Produto;
import br.com.gx2.entity.Vendedor;
import br.com.gx2.service.ClienteService;
import br.com.gx2.service.CupomFiscalService;
import br.com.gx2.service.GrupoService;
import br.com.gx2.service.LojaService;
import br.com.gx2.service.ProdutoService;
import br.com.gx2.service.ServiceFactory;
import br.com.gx2.service.VendedorService;

public class CupomFiscalTest {

	private ClienteService service = ServiceFactory.createClienteService();
	private LojaService lojaService = ServiceFactory.createLojaService();
	private CupomFiscalService cupomService = ServiceFactory.createCupomFiscalService();
	private VendedorService vendedorService = ServiceFactory.createVendedorService();
	private GrupoService grupoService = ServiceFactory.createGrupoService();
	private ProdutoService produtoService = ServiceFactory.createProdutoService();

	double valorT = 34434;

	private Cliente cliente01 = new Cliente(1, "Tomzinho Malvadeza", "12");
	private Grupo grupo01 = new Grupo(1, "Eletrodomestico");
	private Loja loja02 = new Loja(2, "Loja do malvadeza");
	private Produto iten01 = new Produto(22, "65567", "Maquina de Lava", grupoService.pesquisarGrupoId(3));
	private Vendedor vendedor01 = new Vendedor(12, "110519", "Vendedor Tom");
	private CupomFiscal cupom01 = new CupomFiscal(null, valorT, new Date(), loja02, cliente01, vendedor01);

	// ItensCupomFiscal listaItens = new ItensCupomFiscal();

	@Test
	public void CupomFiscalCadastroTest() {

		boolean retorno = cupomService.cadastrarCupomFiscal(cupom01);
		// boolean retorno2 = cupomService.cadastrarCupomFiscal(cupom02);

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

		boolean retorno = cupomService.apagarCupomFiscal(757);

		assertThat(retorno, is(false));
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

		assertThat(cupomService.exibirTodosCuponsFiscais().size(), is(1));

	}
}
