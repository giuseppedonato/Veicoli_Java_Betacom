package com.betacom.veicoli.models;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Veicoli {
	private static Integer counter = 0; //id univoco del record (oggetto)
	private Integer id;
	private String tipoVeicolo;  //macchina, moto, bici
	private Integer numeroRuote;
	private String tipoAlimentazione; //benzina, elettrica
	private String categoria;    //strada, fuoristrada, suv
	private String colore;
	private String marca;
	private Integer annoProduzione;
	private String modello;
	
	
	
	public Veicoli(String tipoVeicolo, Integer numeroRuote, String tipoAlimentazione, String categoria,
			String colore, String marca, Integer annoProduzione, String modello) {
		super();
		
		counter++;
		this.id = counter;
		this.tipoVeicolo = tipoVeicolo;
		this.numeroRuote = numeroRuote;
		this.tipoAlimentazione = tipoAlimentazione;
		this.categoria = categoria;
		this.colore = colore;
		this.marca = marca;
		this.annoProduzione = annoProduzione;
		this.modello = modello;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipoVeicolo() {
		return tipoVeicolo;
	}
	public void setTipoVeicolo(String tipoVeicolo) {
		this.tipoVeicolo = tipoVeicolo;
	}
	public Integer getNumeroRuote() {
		return numeroRuote;
	}
	public void setNumeroRuote(Integer numeroRuote) {
		this.numeroRuote = numeroRuote;
	}
	public String getTipoAlimentazione() {
		return tipoAlimentazione;
	}
	public void setTipoAlimentazione(String tipoAlimentazione) {
		this.tipoAlimentazione = tipoAlimentazione;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getAnnoProduzione() {
		return annoProduzione;
	}
	public void setAnnoProduzione(Integer annoProduzione) {
		this.annoProduzione = annoProduzione;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}

	// abbiamo deciso di utilizzare questo metodo per mantenere l'output piuù pulito
	public String getInfoVeicolo() {
	    return "id=" + id
	            + ", tipoVeicolo=" + tipoVeicolo
	            + ", numeroRuote=" + numeroRuote
	            + ", tipoAlimentazione=" + tipoAlimentazione
	            + ", categoria=" + categoria
	            + ", colore=" + colore
	            + ", marca=" + marca
	            + ", annoProduzione=" + annoProduzione
	            + ", modello=" + modello;
	}
	
	
	
}
