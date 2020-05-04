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
import model.Cliente;
//import service.ClienteService;
import service.VendedorService;

@WebServlet("/ManterCliente.do")
public class ManterClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pAcao = request.getParameter("acao");
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pFone = request.getParameter("fone");
		String pEmail = request.getParameter("email");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {
		}
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(pNome);
		cliente.setFone(pFone);
		cliente.setEmail(pEmail);
		//ClienteService cs = new ClienteService();
		VendedorService cs = new VendedorService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		if (pAcao.equals("Criar")) {
			cs.criar(cliente);
			ArrayList<Cliente>lista = new ArrayList<>();
			lista.add(cliente);
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarClientes.jsp");
		} else if (pAcao.equals("Excluir")) {
			cs.excluir(cliente.getId());
			ArrayList<Cliente>lista =
					(ArrayList<Cliente>) session .getAttribute( "lista");
			lista.remove(busca(cliente, lista));
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarClientes.jsp");
		} else if (pAcao.equals("Alterar")) {
			cs.atualizar(cliente);
			ArrayList<Cliente>lista =
					(ArrayList<Cliente>) session .getAttribute( "lista");
			int pos = busca(cliente, lista);
			lista.remove(pos);
			lista.add(pos, cliente);
			session.setAttribute("lista", lista);
			request.setAttribute("cliente", cliente);
			view = request.getRequestDispatcher("VisualizarCliente.jsp");
		} else if (pAcao.equals("Visualizar")) {
			cliente = cs.carregar(cliente.getId());
			request.setAttribute("cliente", cliente);
			view = request.getRequestDispatcher("VisualizarCliente.jsp");
		} else if (pAcao.equals("Editar")) {
			cliente = cs.carregar(cliente.getId());
			request.setAttribute("cliente", cliente);
			view = request.getRequestDispatcher("AlterarCliente.jsp");
		}
		view.forward(request, response);
	}

	public int busca(Cliente cliente, ArrayList<Cliente>lista) {
		Cliente to;
		for(int i = 0; i<lista.size(); i++){
			to = lista.get(i);
			if(to.getId() == cliente.getId()){
				return i;
			}
		}
		return -1;
	}
}