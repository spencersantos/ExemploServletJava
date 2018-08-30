package model;

import java.util.List;
import java.util.Random;


public class Sorteio {


	private static Sorteio instance = null;
	
	public Usuario sorteio(Grupo grupo) {
		Random random = new Random();
		List<Usuario> users = grupo.getUsuario();
		Usuario sorteado = users.get(random.nextInt(users.size()));
		return sorteado;
	}
	public static Sorteio getIstance() {
		
		if(instance == null) {
			instance = new Sorteio();
		}
		return instance;
	}
}
