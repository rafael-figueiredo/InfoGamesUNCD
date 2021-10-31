package br.com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.mvc.model.LeitorConsole;
import br.com.mvc.util.ConnectionFactory;

public class LeitorDAOConsole { // CRUD
	
	private LeitorConsole leitor;
	private Connection conn; // Conecta com o banco de dados
	private PreparedStatement ps; // Permite executar querys
	private ResultSet rs; // Tabela
	
	public LeitorDAOConsole() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("Erro"+ e.getMessage());
		}
	}
	
	//M�todo Salvar
	public void salvarConsoles(LeitorConsole leitor) throws Exception {
		try {
			String sql="INSERT INTO consoles(COD, NOME, PLATAFORMA, FABRICANTE, MODELO, GARANTIA, QUANTIDADE, PRECO) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, leitor.getCod());
			ps.setString(2, leitor.getNome());
			ps.setString(3, leitor.getPlataforma());
			ps.setString(4, leitor.getFabricante());
			ps.setString(5, leitor.getModelo());
			ps.setString(6, leitor.getGarantia());
			ps.setInt(7, leitor.getQuantidade());
			ps.setDouble(8, leitor.getPreco());
			ps.executeUpdate();
	
		}catch(Exception e) {
			throw new Exception("Erro ao salvar"+e.getMessage());
		}
	}
	
	
	//Met�do Excluir
	public void excluir(int cod) throws Exception {
		try {
			String sql="DELETE FROM consoles "
					+ " WHERE COD=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cod);
			ps.executeUpdate();
	
		}catch(Exception e) {
			throw new Exception("Erro ao excluir"+e.getMessage());
		}
	}
	
	//M�todo Consultar
	public LeitorConsole consultar(int cod) throws Exception {
		try {
			ps = conn.prepareStatement("SELECT * FROM consoles WHERE COD=?");
			ps.setInt(1, cod);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String nome = rs.getString("NOME");
				String plataforma = rs.getString("PLATAFORMA");
				String fabricante = rs.getString("FABRICANTE");
				String modelo = rs.getString("MODELO");
				String garantia = rs.getString("GARANTIA");
				int quantidade = rs.getInt("QUANTIDADE");
				double preco = rs.getDouble("PRECO");
				leitor = new LeitorConsole(cod, nome, plataforma, fabricante, modelo, garantia, quantidade, preco);
			}
			return leitor;
		
		}catch(Exception e) {
			throw new Exception("Erro ao listar" + e.getMessage());
		}
	}
}
