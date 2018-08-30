package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grupo;
import service.GrupoService;
@WebServlet("/listarPromocoes")
public class ListarPromocoes extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GrupoService service = new GrupoService();
		List<Grupo> promocoes = service.listar();
		req.setAttribute("promocoes", promocoes);
		RequestDispatcher dispatcher = req.getRequestDispatcher("listarPromocoes.jsp");
		dispatcher.forward(req, resp);
		
	}
}
	