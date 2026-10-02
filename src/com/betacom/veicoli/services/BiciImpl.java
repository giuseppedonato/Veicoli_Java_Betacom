package com.betacom.veicoli.services;

import java.util.List;

import com.betacom.veicoli.models.Veicoli;

public class BiciImpl implements VeicoliInterface{

	private List<Veicoli> veicoli;
	
	
	public BiciImpl(List<Veicoli> veicoli) {
		super();
		this.veicoli = veicoli;
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
	public void add(String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Veicoli veicolo) {
		// TODO Auto-generated method stub
		
	}
	
}
