package service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import daos.EstabelecimentoDao;
import model.Estabelecimento;

public class EstabelecimentoService{
	static EntityManagerFactory fac = Persistence.createEntityManagerFactory("meulanche");

	public void salvar(Estabelecimento tab) {
		
		EntityManager manager = fac.createEntityManager();
		EstabelecimentoDao tabDao = new EstabelecimentoDao(manager);

		tabDao.salvar(tab);
		}

	public void alterar(Estabelecimento tab, long id) {
		EntityManager manager = fac.createEntityManager();
		EstabelecimentoDao tabDao = new EstabelecimentoDao(manager);
		try {
			manager.getTransaction().begin();
			Estabelecimento retornedTab = manager.find(Estabelecimento.class, id);
			retornedTab.setCnpj(tab.getCnpj());
			retornedTab.setRazaoSocial(tab.getRazaoSocial());
			retornedTab.setPromocoes(tab.getPromocoes());

			tabDao.alterar(retornedTab);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}

	public void remover(long id) {
		
		EntityManager manager = fac.createEntityManager();
		EstabelecimentoDao tabDao = new EstabelecimentoDao(manager);
		tabDao.remover(tabDao.buscarPorId(id),id);
	}

	public void buscarPorId(long id) {
		EntityManager manager = fac.createEntityManager();
		EstabelecimentoDao tabDao = new EstabelecimentoDao(manager);
		System.out.println(tabDao.buscarPorId(id));
	}

	public List<Estabelecimento> listar() {

		EntityManager manager = fac.createEntityManager();
		EstabelecimentoDao tabDao = new EstabelecimentoDao(manager);
		return tabDao.listar();

	}


}
