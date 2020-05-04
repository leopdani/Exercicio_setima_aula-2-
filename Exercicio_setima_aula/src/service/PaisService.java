package service;

import java.util.ArrayList;
import model.Pais;
import dao.PaisDAO;


public class PaisService {
	PaisDAO dao;
	public PaisService(){
		dao = new PaisDAO();
		
	}
	
	public ArrayList<Pais> listarPaises(){
		return dao.listarPaises(); 
	}
	
	 public ArrayList<Pais> listarPaises(String chave){
		return dao.listarPaises(chave);
	 }
	
	public void criar(Pais pais) {
		dao.criar(pais); 
	}
	
	public void atualizar(Pais pais){
		dao.atualizar(pais);
	}
	
	public void excluir(int id){
		 dao.excluir(id);
	}
	
	public Pais carregar(int id){
		return dao.carregar(id);
	}
	
	/* public ArrayList<Pais> listarTodos() {
		return PaisDAO.listarTodos();
	} */

}