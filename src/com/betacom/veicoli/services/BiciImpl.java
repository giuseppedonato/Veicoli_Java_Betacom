package com.betacom.veicoli.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.veicoli.models.Bici;
import com.betacom.veicoli.models.Moto;
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
		Map<String, String> map = new HashMap<String, String>();
	    for (int i = 2; i < params.length; i++) {
	
	        String[] parametro = params[i].split("=");
	
	        map.put(
	            parametro[0].trim(),
	            parametro[1].trim()
	        );
	    }
	    
	    Bici bici = new Bici(
	    		"bici",
	    		Integer.parseInt(map.get("ruote")),
	    		map.get("alim"),
	            map.get("cat"),
	            map.get("colore"),
	            map.get("marca"),
	            Integer.parseInt(map.get("anno")),
	            map.get("modello")
            );
	    
	    	bici.setTipoSospenzione(map.get("sospesione"));
	    	bici.setPieghevole(Boolean.parseBoolean(map.get("pieghevole")));
	    	
	    	create(bici);
	    
		
	}

	@Override
	public void create(Veicoli veicolo) {
		veicoli.add(veicolo);
		
	}
	
}
