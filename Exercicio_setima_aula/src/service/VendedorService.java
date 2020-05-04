package service;
import java.util.ArrayList;
import model.Cliente;
import dao.ClienteDAO;

public class VendedorService {
	ClienteDAO dao;
	public VendedorService(){
		dao = new ClienteDAO();
		
	}
	public ArrayList<Cliente> listarClientes(){
		return dao.listarClientes();
	}
	public ArrayList<Cliente> listarClientes(String chave){
		return dao.listarClientes(chave);
	}
	
	
	public int criar(Cliente cliente) {
		return dao.criar(cliente);
	}
	
	public void atualizar(Cliente cliente){
		dao.atualizar(cliente);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Cliente carregar(int id){
		return dao.carregar(id);
	}
}