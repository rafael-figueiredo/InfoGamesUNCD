package br.com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.mvc.model.LeitorConsole;
import br.com.mvc.model.LeitorGame;
import br.com.mvc.util.ConnectionFactory;

public class LeitorDAOGame {	// CRUD
	private LeitorGame leitor2;
	private Connection conn2; // Conecta com o banco de dados
	private PreparedStatement ps2; // Permite executar querys
	private ResultSet rs2; // Tabela
	
	public LeitorDAOGame() throws Exception {
		try {
			conn2 = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("Erro"+ e.getMessage());
		}
	}
	
	public void salvarGames(LeitorGame leitor2) throws Exception {
		try {
			String sql2="INSERT INTO games(COD, NOME, PLATAFORMA, GARANTIA, QUANTIDADE, PRECO) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			ps2 = conn2.prepareStatement(sql2);
			ps2.setInt(1, leitor2.getCod());
			ps2.setString(2, leitor2.getNome());
			ps2.setString(3, leitor2.getPlataforma());
			ps2.setString(4, leitor2.getGarantia());
			ps2.setInt(5, leitor2.getQuantidade());
			ps2.setDouble(6, leitor2.getPreco());
			ps2.executeUpdate();
	
		}catch(Exception e) {
			throw new Exception("Erro ao salvar"+e.getMessage());
		}
	}
	
	public void excluir(int cod) throws Exception {
		try {
			String sql2="DELETE FROM games "
					+ " WHERE COD=?";
			ps2 = conn2.prepareStatement(sql2);
			ps2.setInt(1, cod);
			ps2.executeUpdate();
	
		}catch(Exception e) {
			throw new Exception("Erro ao excluir"+e.getMessage());
		}
	}
	
	//Método Consultar
		public LeitorGame consultar(int cod) throws Exception {
			try {
				ps2 = conn2.prepareStatement("SELECT * FROM games WHERE COD=?");
				ps2.setInt(1, cod);
				rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					String nome = rs2.getString("NOME");
					String plataforma = rs2.getString("PLATAFORMA");
					String garantia = rs2.getString("GARANTIA");
					int    quantidade = rs2.getInt("QUANTIDADE");
					double preco = rs2.getDouble("PRECO");
					leitor2 = new LeitorGame(cod, nome, plataforma, garantia, quantidade, preco);
				}
				return leitor2;
			
			}catch(Exception e) {
				throw new Exception("Erro ao listar" + e.getMessage());
			}
		}
}
