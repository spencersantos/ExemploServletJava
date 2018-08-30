package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

/**
 * Servlet implementation class exclusao_usuario
 */
@WebServlet("/exclusao_usuario")
public class exclusao_usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
    public exclusao_usuario() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		UsuarioService service = new UsuarioService();
		Usuario usuario = (Usuario) sessao.getAttribute("clienteLogado");
		System.out.println(usuario);
		service.remover(usuario.getId());
		sessao.invalidate();
		request.setAttribute("mensagemExclusao", "Usuário excluído com sucesso!");
		response.sendRedirect("/meuLanche/login.jsp");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		sessao.invalidate();
		response.sendRedirect("/meuLanche/login.jsp");
		
	}

}
