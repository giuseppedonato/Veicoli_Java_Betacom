package com.betacom.veicoli.services;

import java.util.List;

import com.betacom.veicoli.models.Veicoli;

public interface VeicoliInterface {
	void add(String[] params);
	
	void create(Veicoli veicolo);

    void delete(Veicoli veicolo);

    List<Veicoli> list();
}
