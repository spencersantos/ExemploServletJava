package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Usuario;

public class UsuarioDao extends AbstractDao<Usuario> {

	

	public UsuarioDao(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Usuario> getEntityClass() {
		return Usuario.class;
	}

}
