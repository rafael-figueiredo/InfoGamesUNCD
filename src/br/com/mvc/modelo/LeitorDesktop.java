package br.com.mvc.model;

public class LeitorDesktop {
	// Atributos
	private int cod;
	private String modeloGabinete;
	private String placaVideo;
	private String memoriaRam;
	private String processador;
	private String modeloCooler;
	private String waterCooler;
	private String modeloHD;
	private String tamanhoHD;
	private String SO;
	private String teclado;
	private String mouse;
	private int quantidade;
	private double preco;
	
	// Construtor vazio
	public LeitorDesktop() {
		
	}
	
	// Construtor
	public LeitorDesktop(int cod, String modeloGabinete, String placaVideo, String memoriaRam, String processador, String modeloCooler,
			String waterCooler, String modeloHD, String tamanhoHD, String SO, String teclado, String mouse, int quantidade, double preco) {
		this.cod = cod;
		this.modeloGabinete = modeloGabinete;
		this.memoriaRam = memoriaRam;
		this.placaVideo = placaVideo;
		this.processador = processador;
		this.modeloCooler = modeloCooler;
		this.waterCooler = waterCooler;
		this.modeloHD = modeloHD;
		this.tamanhoHD = tamanhoHD;
		this.SO = SO;
		this.teclado = teclado;
		this.mouse = mouse;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	// Getters e Setters
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getModeloGabinete() {
		return modeloGabinete;
	}

	public void setModeloGabinete(String modeloGabinete) {
		this.modeloGabinete = modeloGabinete;
	}

	public String getPlacaVideo() {
		return placaVideo;
	}

	public void setPlacaVideo(String placaVideo) {
		this.placaVideo = placaVideo;
	}

	public String getMemoriaRam() {
		return memoriaRam;
	}

	public void setMemoriaRam(String memoriaRam) {
		this.memoriaRam = memoriaRam;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getModeloCooler() {
		return modeloCooler;
	}

	public void setModeloCooler(String modeloCooler) {
		this.modeloCooler = modeloCooler;
	}

	public String getWaterCooler() {
		return waterCooler;
	}

	public void setWaterCooler(String waterCooler) {
		this.waterCooler = waterCooler;
	}

	public String getModeloHD() {
		return modeloHD;
	}

	public void setModeloHD(String modeloHD) {
		this.modeloHD = modeloHD;
	}

	public String getTamanhoHD() {
		return tamanhoHD;
	}

	public void setTamanhoHD(String tamanhoHD) {
		this.tamanhoHD = tamanhoHD;
	}

	public String getSO() {
		return SO;
	}

	public void setSO(String SO) {
		this.SO = SO;
	}

	public String getTeclado() {
		return teclado;
	}

	public void setTeclado(String teclado) {
		this.teclado = teclado;
	}

	public String getMouse() {
		return mouse;
	}

	public void setMouse(String mouse) {
		this.mouse = mouse;
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
