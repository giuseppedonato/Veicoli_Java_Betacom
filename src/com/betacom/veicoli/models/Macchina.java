package com.betacom.veicoli.models;

public class Macchina extends Veicoli{
	
	private String targa; //univoca**
	private Integer cc;
	private Integer numeroPorte;
	
	public Macchina(String tipoVeicolo, Integer numeroRuote, String tipoAlimentazione, String categoria,
			String colore, String marca, Integer annoProduzione, String modello) {
		super(tipoVeicolo, numeroRuote, tipoAlimentazione, categoria, colore, marca, annoProduzione, modello);
	}
	
	
	
	
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public Integer getCc() {
		return cc;
	}
	public void setCc(Integer cc) {
		this.cc = cc;
	}
	public Integer getNumeroPorte() {
		return numeroPorte;
	}
	public void setNumeroPorte(Integer numeroPorte) {
		this.numeroPorte = numeroPorte;
	}


	@Override
	public String toString() {
	    return "Macchina [" + getInfoVeicolo() + ", targa=" + targa + ", cc=" + cc + ", numeroPorte=" + numeroPorte+ "]";
	}


	

	

	
	
	
	
}
