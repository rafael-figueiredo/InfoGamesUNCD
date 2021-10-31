package br.com.mvc.model;

public class LeitorNotebook {
	private int cod;
	private String marca;
	private String processador;
	private String memoriaRam;
	private String armazenamento;
	private String tela;
	private String sistema;
	private int qtdProduto;
	private double preco;
	
	// Construtor vazio
	public LeitorNotebook() {
			
	}
	
	// Construtor
	public LeitorNotebook(int cod, String marca, String processador, String memoriaRam, String armazenamento, String tela,
			String sistema, int  qtdProduto, double preco) {
		this.cod = cod;
		this.marca = marca;
		this.processador = processador;
		this.memoriaRam = memoriaRam;
		this.armazenamento = armazenamento;
		this.tela = tela;
		this.sistema = sistema;
		this.qtdProduto = qtdProduto;
		this.preco = preco;
	}
	
	// Getters e Setters
	public int getCod() {
		return cod;
	}
	
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getProcessador() {
		return processador;
	}
	
	public void setProcessador(String processador) {
		this.processador = processador;
	}	

	public String getMemoriaRam() {
		return memoriaRam;
	}
	
	public void setMemoriaRam(String memoriaRam) {
		this.memoriaRam = memoriaRam;
	}

	public String getArmazenamento() {
		return armazenamento;
	}
	
	public void setArmazenamento(String armazenamento) {
		this.armazenamento = armazenamento;
	}
	
	public String getTela() {
		return tela;
	}
	
	public void setTela(String tela) {
		this.tela = tela;
	}
	
	public String getSistema() {
		return sistema;
	}
	
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public int getQtdProduto() {
		return qtdProduto;
	}
	
	public void setqtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}
	
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
			
}
