package br.com.mvc.model;

public class LeitorSmartPhone {

	private int codSP;
	private String marca;
	private String memoria;
	private String modelo;
	private String armazenamento;
	private String garantia;
	private String versaoSo;
	private int    quantidade;
	private double preco;
	
	public LeitorSmartPhone(){
		
	} 
	
	public LeitorSmartPhone(int cod, String marca, String memoria, String modelo, String armazenamento, String garantia, String versaoSo, 
			int quantidade, double preco) {
		
			this.codSP = cod;
			this.marca = marca;
			this.memoria = memoria;
			this.modelo = modelo;
			this.armazenamento = armazenamento;
			this.garantia = garantia;
			this.versaoSo = versaoSo;
			this.quantidade = quantidade;
			this.preco = preco;
		
	}
	
	// Getters e Setters
	
	public int getCodSP() {
		return codSP;
	}

	public void setCodSP(int codSP) {
		this.codSP = codSP;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(String armazenamento) {
		this.armazenamento = armazenamento;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public String getVersaoSo() {
		return versaoSo;
	}

	public void setVersaoSo(String versaoSo) {
		this.versaoSo = versaoSo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
