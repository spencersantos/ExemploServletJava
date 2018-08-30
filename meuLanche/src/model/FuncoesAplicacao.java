package model;


import service.EstabelecimentoService;
import service.GrupoService;
import service.UsuarioService;



public class FuncoesAplicacao {

	Grupo grupo = new Grupo();
	GrupoService gru = new GrupoService();
	UsuarioService userControll = new UsuarioService();
	EstabelecimentoService estControll = new EstabelecimentoService();
	boolean test;

	public boolean verificarGrupo(Usuario newUser, Usuario oldUser) {

		if (oldUser.getGrupo() != null && newUser.getGrupo() != null) {

			if (newUser.getGrupo().getNumeroParticipantes() <= 30) {
				grupo = newUser.getGrupo();
				if (newUser.getGrupo().getId() == oldUser.getGrupo().getId()) {
					System.out.println("ja participa dessa promocao.");
					return true;
				} else {
					grupo.setNumeroParticipantes(newUser.getGrupo().getNumeroParticipantes() + 1);
					gru.alterar(grupo, grupo.getId());
					return true;
				}

			}  
		} else{
			if(newUser.getGrupo() != null) {
			grupo.setNumeroParticipantes(newUser.getGrupo().getNumeroParticipantes() + 1);
			gru.alterar(grupo, grupo.getId());}	
			return true;
		}
			
			return false;

	}

	public boolean autenticarDadosUser(Usuario user) {
		boolean b = false;
		for(int i=0; i<userControll.listar().size(); i++) {
			if(user.getCpf()==userControll.listar().get(i).getCpf()||user.getEmail()==userControll.listar().get(i).getEmail()||user.getUserName()==userControll.listar().get(i).getUserName()) 
				b = true;
		}
		return b;
	}
	public boolean autenticarDadosEst(Estabelecimento est) {
		boolean b = false;
		for(int i=0; i<estControll.listar().size(); i++) {
			if(est.getCnpj()==estControll.listar().get(i).getCnpj()) 
				b = true;
		}
		return b;
	}

}
