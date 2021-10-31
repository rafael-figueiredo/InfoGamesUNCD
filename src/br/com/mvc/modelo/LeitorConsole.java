package br.com.mvc.model;

public class LeitorConsole {
	//Atributos
	private int cod;
	private String nome;
	private String plataforma;
	private String fabricante;
	private String modelo;
	private String garantia;
	private int quantidade;
	private double preco;
	
	//Construtores
	public LeitorConsole() {
	}
	
	public LeitorConsole(int cod, String nome, String plataforma, String fabricante, String modelo, String garantia, int quantidade, double preco) {
		this.cod = cod;
		this.nome = nome;
		this.plataforma = plataforma;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.garantia = garantia;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	//Getters e Setters
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
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
