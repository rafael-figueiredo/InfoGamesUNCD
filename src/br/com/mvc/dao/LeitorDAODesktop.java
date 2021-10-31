package br.com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.mvc.model.LeitorConsole;
import br.com.mvc.model.LeitorDesktop;
import br.com.mvc.util.ConnectionFactory;

public class LeitorDAODesktop {
	
	private LeitorDesktop leitor;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public LeitorDAODesktop() throws Exception {
		try {
			// Conexão com banco de dados utilizando try catch
			conn = ConnectionFactory.getConnection();
		}catch(Exception e) {
			throw new Exception("Erro " + e.getMessage());
		}
	}
	
	// Método salvar
	public void salvar(LeitorDesktop leitor) throws Exception{
		try {
			String sql = "INSERT INTO desktop(cod, ModeloGabinete, PlacaVideo, MemoriaRam, Processador, ModeloCooler, WaterCooler, ModeloHD, TamanhoHD,"
					+ "SO, Teclado, Mouse, Quantidade, Preco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, leitor.getCod());
			ps.setString(2, leitor.getModeloGabinete());
			ps.setString(3, leitor.getPlacaVideo());
			ps.setString(4, leitor.getMemoriaRam());
			ps.setString(5, leitor.getProcessador());
			ps.setString(6, leitor.getModeloCooler());
			ps.setString(7, leitor.getWaterCooler());
			ps.setString(8, leitor.getModeloHD());
			ps.setString(9, leitor.getTamanhoHD());
			ps.setString(10, leitor.getSO());
			ps.setString(11, leitor.getTeclado());
			ps.setString(12, leitor.getMouse());
			ps.setInt(13, leitor.getQuantidade());
			ps.setDouble(14, leitor.getPreco());
			ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception("Erro ao salvar " + e.getMessage());
		}
	}
	
	//Metódo Excluir
		public void excluir(int cod) throws Exception {
			try {
				String sql="DELETE FROM desktop WHERE COD=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, cod);
				ps.executeUpdate();
		
			}catch(Exception e) {
				throw new Exception("Erro ao excluir"+e.getMessage());
			}
		}
	
	//Método Consultar
		public LeitorDesktop consultar(int cod) throws Exception {
			try {
				ps = conn.prepareStatement("SELECT * FROM desktop WHERE cod=?");
				ps.setInt(1, cod);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					String modeloGabinete = rs.getString("ModeloGabinete");
					String placaVideo = rs.getString("PlacaVideo");
					String memoriaRam = rs.getString("memoriaRam");
					String processador = rs.getString("Processador");
					String modeloCooler = rs.getString("ModeloCooler");
					String waterCooler = rs.getString("WaterCooler");
					String modeloHD = rs.getString("ModeloHD");
					String tamanhoHD = rs.getString("TamanhoHD");
					String so = rs.getString("SO");
					String teclado = rs.getString("Teclado");
					String mouse = rs.getString("Mouse");
					int quantidade = rs.getInt("Quantidade");
					double preco = rs.getDouble("Preco");
					leitor = new LeitorDesktop(cod, modeloGabinete, placaVideo, memoriaRam, processador, modeloCooler, waterCooler, modeloHD, tamanhoHD, so, teclado, mouse, quantidade, preco);
				}
				return leitor;
			
			}catch(Exception e) {
				throw new Exception("Erro ao listar" + e.getMessage());
			}
		}
}
