package br.com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.mvc.model.LeitorSmartPhone;
import br.com.mvc.util.ConnectionFactory;

public class LeitorDAOSmartPhone {
			
	private LeitorSmartPhone leitor3;
	private Connection conn; // Conecta com o banco de dados
	private PreparedStatement ps; // Permite executar querys
	private ResultSet rs; // Tabela
	
	public LeitorDAOSmartPhone() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("Erro"+ e.getMessage());
		}
	}
	 //Método Salvar SmartPhone
	public void salvarSmartPhone(LeitorSmartPhone leitor3) throws Exception{
		try {
			String sql = "INSERT INTO smartphones(COD, MARCA, MEMORIA, MODELO, ARMAZENAMENTO, GARANTIA, VERSAOSO, QUANTIDADE, PRECO)" +
							"VALUES(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,leitor3.getCodSP());
			ps.setString(2, leitor3.getMarca());
			ps.setString(3, leitor3.getMemoria());
			ps.setString(4,leitor3.getModelo());
			ps.setString(5,leitor3.getArmazenamento());
			ps.setString(6, leitor3.getGarantia());
			ps.setString(7, leitor3.getVersaoSo());
			ps.setInt(8,leitor3.getQuantidade());
			ps.setDouble(9,leitor3.getPreco());
			ps.executeUpdate();
			
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "Erro ao Salvar!");
		}
	}
	//Metódo Excluir
		public void excluir(int codSP) throws Exception {
			try {
				String sql="DELETE FROM smartphones "
						+ " WHERE COD=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, codSP);
				ps.executeUpdate();
		
			}catch(Exception e) {
				throw new Exception("Erro ao excluir"+e.getMessage());
			}
		}
		
		//Método Consultar
		public LeitorSmartPhone consultar(int codSP) throws Exception {
			try {
				ps = conn.prepareStatement("SELECT * FROM smartphones WHERE COD=?");
				ps.setInt(1, codSP);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					String marca = rs.getString("MARCA");
					String memoria = rs.getString("MEMORIA");
					String modelo = rs.getString("MODELO");
					String armazenamento = rs.getString("ARMAZENAMENTO");
					String garantia = rs.getString("GARANTIA");
					String versaoSo = rs.getString("VERSAOSO");
					int quantidade = rs.getInt("QUANTIDADE");
					double preco = rs.getDouble("PRECO");
					leitor3 = new LeitorSmartPhone(codSP, marca, memoria, modelo, armazenamento, garantia, versaoSo, quantidade, preco);
				}
				return leitor3;
			
			}catch(Exception e) {
				throw new Exception("Erro ao listar" + e.getMessage());
			}
		}

}
