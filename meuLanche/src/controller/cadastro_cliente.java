package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Endereco;
import model.Usuario;
import service.UsuarioService;

/**
 * Servlet implementation class CadastroClienteServlet
 */
@WebServlet("/cadastro_cliente")
public class cadastro_cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario user = (Usuario) sessao.getAttribute("clienteLogado");

		if (user.getId() != null) {
			UsuarioService service = new UsuarioService();
			Usuario usuario = service.buscarPorId(user.getId());
			request.setAttribute("usuario", usuario);
		}

		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession sessao = request.getSession();
			String id = request.getParameter("id");
			String userName = request.getParameter("userName");
			String senha = request.getParameter("senha");
			String nome = request.getParameter("nome");
			long cpf = Long.parseLong(request.getParameter("cpf"));
			String email = request.getParameter("email");
			int idade = Integer.parseInt(request.getParameter("idade"));
			String bairro = request.getParameter("bairro");
			String rua = request.getParameter("rua");
			int numero = Integer.parseInt(request.getParameter("numero"));
			String complemento = request.getParameter("complemento");
			String cidade = request.getParameter("cidade");

			Usuario user = new Usuario();
			Endereco end = new Endereco();
			user.setUserName(userName);
			user.setSenha(senha);
			user.setNome(nome);
			user.setCpf(cpf);
			user.setEmail(email);
			user.setIdade(idade);
			end.setBairro(bairro);
			end.setRua(rua);
			end.setNumero(numero);
			end.setComplemento(complemento);
			end.setCidade(cidade);
			user.setEndereco(end);

			UsuarioService service = new UsuarioService();
			if (!id.equals("")) {
				user.setId(new Long(id));
				service.alterar(user, user.getId());
			} else {
				service.salvar(user);
			}
			if(!id.equals("")) 
				response.sendRedirect("/meuLanche/listarCliente");
			else
				response.sendRedirect("/meuLanche/");

		} catch (NumberFormatException e) {
			request.setAttribute("mensagemErro", "Preenchimento incorreto dos campos. Verifique os dados inseridos.");
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
			return;
		}
	}
}