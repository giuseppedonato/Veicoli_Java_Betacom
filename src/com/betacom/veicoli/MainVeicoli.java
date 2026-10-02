package com.betacom.veicoli;

import java.util.ArrayList;
import java.util.List;

import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.process.StartVeicolo;

public class MainVeicoli {
	
	
	
	public static void main(String[] args) {
		List<String> parameter = new ArrayList<String>();
		parameter.add("add,macchina,ruote=4,alim=benzina,cat=strada,colore=bianco,marca=fiat,anno=2025,modello=500,porte=4,targa=el234gx,cc=1200");
		parameter.add("add,macchina,ruote=4,alim=benzina,cat=strada,colore=bianco,marca=fiat,anno=2026,modello=panda,porte=4,targa=el234gx,cc=1300");
		parameter.add("add,macchina,ruote=4,alim=benzina,cat=strada,colore=bianco,marca=fiat,anno=2026,modello=panda,porte=4,targa=el234gx,cc=1300");
		parameter.add("add,moto,ruote=2,alim=benzina,cat=strada,colore=nero,marca=Yamaha,anno=2025,modello=r1,targa=EL22239,cc=900");
		parameter.add("add,bici,ruote=2,alim=manuale,cat=strada,colore=nero,marca=Bianchi,anno=2025,modello=Girzl 5,marce=10,sospensione=senza,pieghevole=no");
		//parameter.add("list");
		
		System.out.println("Start Veicoli");
			
		
		List<Veicoli> veicoli = new ArrayList<Veicoli>();
		StartVeicolo start = new StartVeicolo(veicoli);
		
		start.execute(parameter);
		
		for (Veicoli veicolo : veicoli) {
			
			// mettere toString in tutte le classi IMPL per stampare il loro contenuto.
			// Completare l'implementazione di bici e moto.
			// Vedere che brutta fine far fare al Singleton.
			// la targa dev'essere univoca come l'id.
			
		    System.out.println("ID: " + veicolo.getId());
		    System.out.println("Tipo: " + veicolo.getTipoVeicolo());
		    System.out.println("Ruote: " + veicolo.getNumeroRuote());
		    System.out.println("Alimentazione: " + veicolo.getTipoAlimentazione());
		    System.out.println("Categoria: " + veicolo.getCategoria());
		    System.out.println("Colore: " + veicolo.getColore());
		    System.out.println("Marca: " + veicolo.getMarca());
		    System.out.println("Anno: " + veicolo.getAnnoProduzione());
		    System.out.println("Modello: " + veicolo.getModello());
		
	}
}}
