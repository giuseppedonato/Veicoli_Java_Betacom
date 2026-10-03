package com.betacom.veicoli.models;

public class Moto extends Veicoli{
	
	private String targa;
	private Integer cc;
	
	
	public Moto(String tipoVeicolo, Integer numeroRuote, String tipoAlimentazione, String categoria,
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


	@Override
	public String toString() {
		return "Moto [targa=" + targa + ", cc=" + cc + ", getId()=" + getId() + ", getTipoVeicolo()=" + getTipoVeicolo()
				+ ", getNumeroRuote()=" + getNumeroRuote() + ", getTipoAlimentazione()=" + getTipoAlimentazione()
				+ ", getCategoria()=" + getCategoria() + ", getColore()=" + getColore() + ", getMarca()=" + getMarca()
				+ ", getAnnoProduzione()=" + getAnnoProduzione() + ", getModello()=" + getModello() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
	
}
