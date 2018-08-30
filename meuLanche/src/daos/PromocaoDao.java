package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Promocao;

public class PromocaoDao extends AbstractDao<Promocao> {

	static EntityManagerFactory fac = Persistence.createEntityManagerFactory("meulanche");

	public PromocaoDao(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Promocao> getEntityClass() {
		return Promocao.class;
	}

}
