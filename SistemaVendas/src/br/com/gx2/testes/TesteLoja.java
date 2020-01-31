package br.com.gx2.testes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.gx2.dao.DAOFactory;
import br.com.gx2.dao.LojaDAO;
import br.com.gx2.entity.Loja;
import br.com.gx2.service.LojaService;
import br.com.gx2.service.ServiceFactory;

public class TesteLoja {
@Test
	public  static void main(String args[]) {
		// TODO Auto-generated method stub
	
		LojaDAO dao = DAOFactory.createLojaDAO();
		
		LojaService loja = ServiceFactory.createLojaService();
		
		Loja lojaServ = new Loja(2,"NOME DA LOJA");
		
		
		Loja loja2 = loja.pesquisarLojaId(2);
		
		assertThat(loja2.getCodigoLoja(), is (2));
		
		if(loja2.getCodigoLoja() == 2){
			
			System.out.println(loja2.getNomeLoja());
		
}
		
		/*
		//Injeção de dependência
		LojaDAO dao = DAOFactory.createLojaDAO();
		
	    
		Loja loja = new Loja(18, "Google Play");
		dao.deleteById(11);
		
		
		List<Loja> lojas = dao.findAll();
		
		for (Loja l : lojas) {
			System.out.print(l.getCodigoLoja());
			System.out.print(" - ");
			System.out.println(l.getNomeLoja());
		}
		
		*/
		
	}

}
