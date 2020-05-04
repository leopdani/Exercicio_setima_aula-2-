package controller;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.VendedorService;
import model.Cliente;
@WebServlet("/listar_clientes.do")
public class ListarClientesController extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String chave = request.getParameter("data[search]");
		String acao = request.getParameter("acao");
		VendedorService vendedor = new VendedorService();
		ArrayList<Cliente>lista = null;
		HttpSession session = request.getSession();
		if (acao.equals("buscar")) {
			if (chave != null&&chave.length() > 0) {
				lista = vendedor.listarClientes(chave);
			} else {
				lista = vendedor.listarClientes();
			}
			session.setAttribute("lista", lista);
		} else if (acao.equals("reiniciar")) {
			session.setAttribute("lista", null);
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarClientes.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}