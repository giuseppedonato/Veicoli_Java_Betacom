package com.betacom.veicoli.services;

import java.util.List;

import com.betacom.veicoli.models.Veicoli;

public class MotoImpl implements VeicoliInterface{

	private List<Veicoli> veicoli;
	
	
	
	public MotoImpl(List<Veicoli> veicoli) {
		super();
		this.veicoli = veicoli;
	}

	@Override
	public void add(String[] params) {
		
		
	}

	@Override
	public void delete(Veicoli veicolo) {
		veicoli.remove(veicolo);
		
	}

	@Override
	public List<Veicoli> list() {
		return veicoli;
	}

	@Override
	public void create(Veicoli veicolo) {
		
	}

}
