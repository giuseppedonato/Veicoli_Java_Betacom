package com.betacom.veicoli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.betacom.veicoli.models.Bici;
import com.betacom.veicoli.models.Macchina;
import com.betacom.veicoli.models.Moto;
import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.process.StartVeicolo;

public class MainVeicoli {
	
	
	
	public static void main(String[] args) {
		List<String> parameter = new ArrayList<String>();
		parameter.add("add,macchina,ruote=4,alim=benzina,cat=strada,colore=bianco,marca=fiat,anno=2025,modello=500,porte=4,targa=el234gz,cc=1200");
		parameter.add("add,macchina,ruote=4,alim=benzina,cat=strada,colore=bianco,marca=fiat,anno=2026,modello=panda,porte=4,targa=el234gx,cc=1300");
		parameter.add("add,macchina,ruote=4,alim=benzina,cat=strada,colore=bianco,marca=fiat,anno=2026,modello=panda,porte=4,targa=el224fh,cc=1300");
		parameter.add("add,moto,ruote=2,alim=benzina,cat=strada,colore=nero,marca=Yamaha,anno=2025,modello=r1,targa=EL22239,cc=900");
		parameter.add("add,bici,ruote=2,alim=manuale,cat=strada,colore=nero,marca=Bianchi,anno=2025,modello=Girzl 5,marce=10,sospensione=senza,pieghevole=false");
		//parameter.add("list");
		
		System.out.println("Start Veicoli");
			
		
		List<Veicoli> veicoli = new ArrayList<Veicoli>();
		
		StartVeicolo start = new StartVeicolo(veicoli);
		start.execute(parameter);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digita la tipologia di veicolo per verificare la disponibilità");
		String selected = sc.next();
		
		for (Veicoli v : veicoli) {

		    if (selected.equalsIgnoreCase("macchina") && v instanceof Macchina) {
		        System.out.println(v);

		    } else if (selected.equalsIgnoreCase("moto") && v instanceof Moto) {
		        System.out.println(v);

		    } else if (selected.equalsIgnoreCase("bici") && v instanceof Bici) {
		        System.out.println(v);
		    } else {
		    	System.err.println("Tipologia veicolo non esistente");
		    }
		}
		
		
		
		
			
			// Vedere che brutta fine far fare al Singleton.
			// la targa dev'essere univoca come l'id.
			
		
}}
