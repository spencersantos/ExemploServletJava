package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Estabelecimento;


public class EstabelecimentoDao extends AbstractDao<Estabelecimento> {

	static EntityManagerFactory fac = Persistence.createEntityManagerFactory("meulanche");

	public EstabelecimentoDao(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Estabelecimento> getEntityClass() {
		return Estabelecimento.class;
	}

}
