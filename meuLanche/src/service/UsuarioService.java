package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import daos.UsuarioDao;
import model.FuncoesAplicacao;
import model.Usuario;

public class UsuarioService {
	static EntityManagerFactory fac = Persistence.createEntityManagerFactory("meulanche");
	Usuario user = new Usuario();

	
	
	public void salvar(Usuario user) {

		EntityManager manager = fac.createEntityManager();
		UsuarioDao userDao = new UsuarioDao(manager);

		userDao.salvar(user);
	}

	public void alterar(Usuario user, long id) {
		EntityManager manager = fac.createEntityManager();
		UsuarioDao userDao = new UsuarioDao(manager);
		FuncoesAplicacao func = new FuncoesAplicacao();
		try {
			manager.getTransaction().begin();
			Usuario retornedUser = manager.find(Usuario.class, id);
			retornedUser.setCpf(user.getCpf());
			retornedUser.setEmail(user.getEmail());
			retornedUser.setEndereco(user.getEndereco());
			retornedUser.setNome(user.getNome());
			retornedUser.setUserName(user.getUserName());
			retornedUser.setIdade(user.getIdade());
			retornedUser.setSenha(user.getSenha());
			if (func.verificarGrupo(user,retornedUser)==true)
				retornedUser.setGrupo(user.getGrupo());
			//else
				//System.out.println("grupo cheio.");
			userDao.alterar(retornedUser);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}

	public void remover(long id) {

		EntityManager manager = fac.createEntityManager();
		UsuarioDao userDao = new UsuarioDao(manager);
		userDao.remover(userDao.buscarPorId(id), id);
	}

	public Usuario buscarPorId(long id) {
		EntityManager manager = fac.createEntityManager();
		UsuarioDao userDao = new UsuarioDao(manager);
		return userDao.buscarPorId(id);
	}

	public List<Usuario> listar() {

		EntityManager manager = fac.createEntityManager();
		UsuarioDao userDao = new UsuarioDao(manager);
		return userDao.listar();

	}
	public Usuario efetuarLogin(String login,String senha) {
		EntityManager manager = fac.createEntityManager();
		UsuarioDao userDao = new UsuarioDao(manager);
		
		try {
			return userDao.efetuarLogin(login, senha);
		}finally {
			manager.close();
		}
	}

}
