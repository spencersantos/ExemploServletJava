package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.AbstractEntity;
import model.Usuario;

public abstract class AbstractDao<T extends AbstractEntity> {
	EntityManager manager;

	public AbstractDao(EntityManager manager) {
		this.manager = manager;
	}

	public void salvar(T entity) {
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
	}

	public void alterar(T entity) {
		manager.merge(entity);
	}

	public void remover(T entity, long id) {
		entity = manager.find(getEntityClass(), id);
		manager.getTransaction().begin();
		manager.remove(entity);
		manager.getTransaction().commit();
		manager.close();
	}

	public T buscarPorId(Long id) {
		T entity = manager.find(getEntityClass(), id);
		return entity;
	}

	public abstract Class<T> getEntityClass();

	public List<T> listar() {
		Query query = manager.createQuery("select c from " + getEntityClass().getSimpleName() + " c");
		List<T> entities = query.getResultList();
		return entities;

	}
	public T efetuarLogin(String userName, String senha) {

			Query query = manager.createQuery("select c from " + getEntityClass().getSimpleName() + " c where c.userName = '"+userName+"' and c.senha = '"+senha+"'");
			List<T> ob = query.getResultList();
			if(ob.isEmpty()) {
				return null;
			}else
			return ob.get(0);
	}

}
