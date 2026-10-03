package com.betacom.veicoli.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.veicoli.models.Moto;
import com.betacom.veicoli.models.Veicoli;

public class MotoImpl implements VeicoliInterface{

	private List<Veicoli> veicoli;
	
	
	
	public MotoImpl(List<Veicoli> veicoli) {
		super();
		this.veicoli = veicoli;
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
	    
	    Moto moto = new Moto(
	    		"moto",
	    		Integer.parseInt(map.get("ruote")),
	    		map.get("alim"),
	            map.get("cat"),
	            map.get("colore"),
	            map.get("marca"),
	            Integer.parseInt(map.get("anno")),
	            map.get("modello")
            );
	    
	    	moto.setCc(Integer.parseInt(map.get("cc")));
	    	moto.setTarga(map.get("targa"));
	    	
	    	create(moto);
	    
		
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
		veicoli.add(veicolo);
	}

}
