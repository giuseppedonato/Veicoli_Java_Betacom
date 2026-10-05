package com.betacom.veicoli.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.betacom.veicoli.models.Moto;
import com.betacom.veicoli.models.Veicoli;

public class MotoImpl implements VeicoliInterface{

	private List<Veicoli> veicoli;
	private Set<String> targhe;
	
	
	public MotoImpl(List<Veicoli> veicoli, Set<String> targhe) {
		super();
		this.veicoli = veicoli;
		this.targhe = targhe;
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
		Moto moto = (Moto) veicolo; //cast necessario per il controllo della targa
		  // Controllo anno di produzione
        int annoCorrente = LocalDateTime.now().getYear();

        if (moto.getAnnoProduzione() > annoCorrente) {
            System.err.println(
            		 moto.getModello() + " " +  moto.getAnnoProduzione() + " -> l'anno è superiore alla data attuale: "
            	                + annoCorrente
            );
            return;
        }
        
    	if(!targhe.add(moto.getTarga())) { //mi basta fare questo controllo siccome il Set non accetta duplicati
    		 System.err.println("Errore: il numero di targa è gia esistente nei nostri db " + moto.getTarga());
    		 return;
    	}
		veicoli.add(veicolo);
	}

}
