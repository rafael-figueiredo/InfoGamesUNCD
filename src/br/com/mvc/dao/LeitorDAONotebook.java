package br.com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.mvc.model.LeitorNotebook;
import br.com.mvc.util.ConnectionFactory;

public class LeitorDAONotebook {
	
	private LeitorNotebook leitor;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public LeitorDAONotebook() throws Exception {
		try {
			// Conexão com banco de dados utilizando try catch
			conn = ConnectionFactory.getConnection();
		}catch(Exception e) {
			throw new Exception("Erro " + e.getMessage());
		}
	}
	// Método salvar
		public void salvarNotebook(LeitorNotebook leitor) throws Exception{
			try {
				String sql = "INSERT INTO notebook(cod, marca, processador, memoriaRam, armazenamento, tela, sistema, qtdProduto, preco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, leitor.getCod());
				ps.setString(2, leitor.getMarca());
				ps.setString(3, leitor.getProcessador());
				ps.setString(4, leitor.getMemoriaRam());
				ps.setString(5, leitor.getArmazenamento());
				ps.setString(6, leitor.getTela());
				ps.setString(7, leitor.getSistema());
				ps.setInt(8, leitor.getQtdProduto());
				ps.setDouble(9, leitor.getPreco());
				ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//Metódo Excluir
				public void excluir(int cod) throws Exception {
					try {
						String sql="DELETE FROM notebook WHERE COD=?";
						ps = conn.prepareStatement(sql);
						ps.setInt(1, cod);
						ps.executeUpdate();
				
					}catch(Exception e) {
						throw new Exception("Erro ao excluir"+e.getMessage());
					}
				}
				
				//Método Consultar
				public LeitorNotebook consultar(int cod) throws Exception {
					try {
						ps = conn.prepareStatement("SELECT * FROM desktop WHERE cod=?");
						ps.setInt(1, cod);
						rs = ps.executeQuery();
						
						if(rs.next()) {
							String marca = rs.getString("Marca");
							String processador = rs.getString("Processador");
							String memoriaRam = rs.getString("MemoriaRam");
							String armazenamento = rs.getString("Armazenamento");
							String tela = rs.getString("Tela");
							String sistema = rs.getString("Sistema");
							int qtdProduto = rs.getInt("QtdProduto");
							double preco = rs.getDouble("Preco");
							leitor = new LeitorNotebook(cod, marca, processador, memoriaRam, armazenamento, tela, sistema, qtdProduto, preco);
						}
						return leitor;
					
					}catch(Exception e) {
						throw new Exception("Erro ao listar" + e.getMessage());
					}
				}
	
	
	
	

}
