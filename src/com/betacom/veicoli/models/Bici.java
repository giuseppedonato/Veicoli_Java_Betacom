package com.betacom.veicoli.models;

public class Bici extends Veicoli{
	
	public Bici(String tipoVeicolo, Integer numeroRuote, String tipoAlimentazione, String categoria,
			String colore, String marca, Integer annoProduzione, String modello) {
		super(tipoVeicolo, numeroRuote, tipoAlimentazione, categoria, colore, marca, annoProduzione, modello);
	}
	
	private Integer numeroCorone;
	private Integer numeroMarce;
	private String tipoFreno;
	private String tipoSospenzione; // senza, mono, bi
	private Boolean pieghevole;
	
	
	
	public Integer getNumeroCorone() {
		return numeroCorone;
	}
	public void setNumeroCorone(Integer numeroCorone) {
		this.numeroCorone = numeroCorone;
	}
	public Integer getNumeroMarce() {
		return numeroMarce;
	}
	public void setNumeroMarce(Integer numeroMarce) {
		this.numeroMarce = numeroMarce;
	}
	public String getTipoFreno() {
		return tipoFreno;
	}
	public void setTipoFreno(String tipoFreno) {
		this.tipoFreno = tipoFreno;
	}
	public String getTipoSospenzione() {
		return tipoSospenzione;
	}
	public void setTipoSospenzione(String tipoSospenzione) {
		this.tipoSospenzione = tipoSospenzione;
	}
	public Boolean getPieghevole() {
		return pieghevole;
	}
	public void setPieghevole(Boolean pieghevole) {
		this.pieghevole = pieghevole;
	} 
}
