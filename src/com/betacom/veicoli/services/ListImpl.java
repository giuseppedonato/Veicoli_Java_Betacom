package com.betacom.veicoli.services;

import java.util.List;

import com.betacom.veicoli.models.Veicoli;

public class ListImpl implements VeicoliInterface{

	private List<Veicoli> veicoli;
	
	public ListImpl(List<Veicoli> veicoli) {
		super();
		this.veicoli = veicoli;
	}
	
	public void printList() {
		for (Veicoli v : veicoli) {
			System.out.println(v);
		}
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
		
		
	}

}
