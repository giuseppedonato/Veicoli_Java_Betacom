package com.betacom.veicoli.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.betacom.veicoli.models.Macchina;
import com.betacom.veicoli.models.Veicoli;

public class MacchinaImpl implements VeicoliInterface {

    private List<Veicoli> veicoli;
    private Set<String> targhe;

    public MacchinaImpl(List<Veicoli> veicoli, Set<String> targhe) {
        super();
        this.veicoli = veicoli;
        this.targhe = targhe;
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

        Macchina macchina = new Macchina(
            "macchina",
            Integer.parseInt(map.get("ruote")),
            map.get("alim"),
            map.get("cat"),
            map.get("colore"),
            map.get("marca"),
            Integer.parseInt(map.get("anno")),
            map.get("modello")
        );

        macchina.setTarga(map.get("targa"));
        macchina.setCc(Integer.parseInt(map.get("cc")));
        macchina.setNumeroPorte(Integer.parseInt(map.get("porte")));

        create(macchina);
    }

    @Override
    public void create(Veicoli veicolo) {
    	Macchina macchina = (Macchina) veicolo; //cast necessario per il controllo della targa
    	
    	if(!targhe.add(macchina.getTarga())) { //mi basta fare questo controllo siccome il Set non accetta duplicati
    		 System.err.println("Error: number plate already exists: " + macchina.getTarga());
    		 return;
    	}
    	
        veicoli.add(veicolo);
    }
}

