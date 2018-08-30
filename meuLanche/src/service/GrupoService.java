package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.FuncoesAplicacao;
import daos.GrupoDao;
import model.Usuario;
import model.Grupo;

public class GrupoService {
	static EntityManagerFactory fac = Persistence.createEntityManagerFactory("meulanche");

	public void salvar(Grupo grupo) {

		EntityManager manager = fac.createEntityManager();
		GrupoDao grupoDao = new GrupoDao(manager);

		grupoDao.salvar(grupo);
	}

	public void alterar(Grupo grupo, long id) {
		EntityManager manager = fac.createEntityManager();
		GrupoDao grupoDao = new GrupoDao(manager);
		
		try {
			manager.getTransaction().begin();
			Grupo retornedGrupo = manager.find(Grupo.class, id);
			retornedGrupo.setPromocao(grupo.getPromocao());
			retornedGrupo.setVencedor(grupo.getVencedor());
			retornedGrupo.setNumeroParticipantes(grupo.getNumeroParticipantes());
			grupoDao.alterar(retornedGrupo);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		
	}

	public void remover(long id) {

		EntityManager manager = fac.createEntityManager();
		GrupoDao grupoDao = new GrupoDao(manager);
		grupoDao.remover(grupoDao.buscarPorId(id), id);
	}

	public Grupo buscarPorId(long id) {
		EntityManager manager = fac.createEntityManager();
		GrupoDao grupoDao = new GrupoDao(manager);
		return grupoDao.buscarPorId(id);
	}

	public List<Grupo> listar() {

		EntityManager manager = fac.createEntityManager();
		GrupoDao grupoDao = new GrupoDao(manager);
		return grupoDao.listar();

	}

}
