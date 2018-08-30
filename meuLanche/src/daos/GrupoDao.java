package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Grupo;

public class GrupoDao extends AbstractDao<Grupo> {

	static EntityManagerFactory fac = Persistence.createEntityManagerFactory("meulanche");

	public GrupoDao(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Grupo> getEntityClass() {
		return Grupo.class;
	}

}
