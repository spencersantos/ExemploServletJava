package service;

import java.util.List;
import java.util.Observable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import daos.PromocaoDao;
import model.Promocao;

public class PromocaoService extends Observable {
	static EntityManagerFactory fac = Persistence.createEntityManagerFactory("meulanche");

	public void salvar(Promocao prom) {

		EntityManager manager = fac.createEntityManager();
		PromocaoDao promDao = new PromocaoDao(manager);

		promDao.salvar(prom);
		setChanged();
		notifyObservers();
	}

	public void alterar(Promocao promocao, long id) {
		EntityManager manager = fac.createEntityManager();
		PromocaoDao promocaoDao = new PromocaoDao(manager);
		try {
			manager.getTransaction().begin();
			Promocao retornedPromocao = manager.find(Promocao.class, id);
			retornedPromocao.setDataValidade(promocao.getDataValidade());
			retornedPromocao.setDescricao(promocao.getDescricao());
			retornedPromocao.setEstabelecimento(promocao.getEstabelecimento());
			retornedPromocao.setGrupo(promocao.getGrupo());
			retornedPromocao.setNome(promocao.getNome());

			promocaoDao.alterar(retornedPromocao);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public void remover(long id) {

		EntityManager manager = fac.createEntityManager();
		PromocaoDao promocaoDao = new PromocaoDao(manager);
		promocaoDao.remover(promocaoDao.buscarPorId(id), id);
	}

	public Promocao buscarPorId(long id) {
		EntityManager manager = fac.createEntityManager();
		PromocaoDao promocaoDao = new PromocaoDao(manager);
		return promocaoDao.buscarPorId(id);
	}

	public List<Promocao> listar() {

		EntityManager manager = fac.createEntityManager();
		PromocaoDao promocaoDao = new PromocaoDao(manager);
		return promocaoDao.listar();

	}

}
