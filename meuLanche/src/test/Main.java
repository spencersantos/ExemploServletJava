package test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.Endereco;
import model.FuncoesAplicacao;
import model.Grupo;
import model.Promocao;
import model.Usuario;
import service.GrupoService;
import service.PromocaoService;
import service.UsuarioService;
import model.Sorteio;

public class Main {

	public static void main(String[] args) throws ParseException {

		UsuarioService userControll = new UsuarioService();
		Usuario user = new Usuario();
		Endereco endereco = new Endereco();
		Promocao promocao = new Promocao();
		PromocaoService prom = new PromocaoService();
		String string = "16/10/2018";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date data = formato.parse("12/10/2018");
		Sorteio sorteio = Sorteio.getIstance();

		FuncoesAplicacao func = new FuncoesAplicacao();
		Grupo grupo = new Grupo();
		GrupoService gru = new GrupoService();
		
		//sorteio
		
		//System.out.println(sorteio.sorteio(gru.buscarPorId(50)));
		
		//verificar usuario
		
		//System.out.println(userControll.efetuarLogin("le", "minhasenha"));
		
		//add promocao
		/*
		promocao.setNome("cachaça de graca");
		promocao.setDescricao("isso mesmo");
		promocao.setDataValidade(data);
		promocao.setEstabelecimento(null);
		promocao.setGrupo(null);
		prom.salvar(promocao);
		*/
		
		//add grupo
		/*
		grupo.setPromocao(prom.buscarPorId(50));
		grupo.setVencedor(0);
		grupo.setNumeroParticipantes(0);
		gru.salvar(grupo);
		*/
		
		//Add novo user
		/*
		  user.setNome("leila"); 
		  user.setCpf(578); 
		  user.setEmail("lei@");
		  user.setUserName("le");
		//  user.setGrupo(gru.buscarPorId(50));
		  user.setGrupo(null);
		  user.setSenha("minhasenha");

		  endereco.setBairro("bairro do a"); endereco.setCidade("jampa");
		  endereco.setComplemento("pica pau"); endereco.setNumero(88);
		  endereco.setRua("rua do tonho");
		  
		  user.setIdade(18);
		  user.setEndereco(endereco);
		  userControll.salvar(user);
		 */

		// Aterando usuario
		/*
		  user.setNome("zejr");
		  user.setCpf(5666);
		  user.setEmail("jr@eu");
		  user.setUserName("ze");
		  user.setGrupo(null);
		  user.setSenha("minhasenha");
		  
		  endereco.setBairro("bairro do e"); endereco.setCidade("jampa");
		  endereco.setComplemento("pica pau"); endereco.setNumero(864);
		  endereco.setRua("rua do ze");
		  
		  user.setIdade(25);
		  user.setEndereco(endereco);
		  userControll.alterar(user, 350);
		  */
		 
		// Apagando um usuario **n funciona

		 //userControll.remover(250);
		 

		// buscar pelo id
		// userControll.buscarPorId(250);

		// listar usuarios
		 //userControll.listar();

	}

}
