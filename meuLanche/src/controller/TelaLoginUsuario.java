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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class TelaLoginUsuario extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/meuLanche/cadastro.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String senha = request.getParameter("senha");
		
		if(userName.equals("") || senha.equals("")) {
			request.setAttribute("mensagemErro", "Usuário ou senha não preenchidos. Verifique os dados inseridos.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		UsuarioService userControll = new UsuarioService();
		Usuario user = userControll.efetuarLogin(userName, senha);
		
		if(user == null) {
			request.setAttribute("mensagemErro", "Usuário ou senha inválidos. Verifique os dados inseridos.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("clienteLogado", user);
		response.sendRedirect("/meuLanche/cliente.jsp");
		
		
		
		
		
	}

}
