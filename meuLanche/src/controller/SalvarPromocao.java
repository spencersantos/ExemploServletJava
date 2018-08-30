package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.GrupoService;
import service.UsuarioService;

@WebServlet("/SalvarPromocao")
public class SalvarPromocao extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("clienteLogado");
		UsuarioService service = new UsuarioService();
		GrupoService serviceGrupo = new GrupoService();
		long id = Long.parseLong(request.getParameter("idGrupo"));
		usuario.setGrupo(serviceGrupo.buscarPorId(id));
		service.alterar(usuario,usuario.getId());
		response.sendRedirect("/meuLanche/usuario");
	}

}
