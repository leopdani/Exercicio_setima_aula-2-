package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pais;

public class PaisDAO {
	public static void criar(Pais to) {
		String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getPopulacao());
			stm.setString(3, to.getArea());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					to.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void atualizar(Pais to) {
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getPopulacao());
			stm.setString(3, to.getArea());
			stm.setInt(4, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  void excluir(int id) {
		System.out.println("Passei PaisDAO");
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  Pais carregar(int id) {
		Pais to = new Pais(); 
		to.setId(id);
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais WHERE pais.id =?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, to.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					/* to.setId(rs.getInt("id")); */
					to.setNome(rs.getString("nome"));
					to.setPopulacao(rs.getString("populacao"));
					to.setArea(rs.getString("area"));
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}



	public ArrayList<Pais> listarPaises() {
		Pais pais;
		ArrayList<Pais>lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					pais = new Pais();
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getString("Populacao"));
					pais.setArea(rs.getString("area"));
					lista.add(pais);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	public ArrayList<Pais> listarPaises(String chave) {
		Pais pais;
		ArrayList<Pais>lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais where upper(nome) like ?";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					pais = new Pais();
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getString("populacao"));
					pais.setArea(rs.getString("area"));
					lista.add(pais);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
}

