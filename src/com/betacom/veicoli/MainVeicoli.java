package com.betacom.veicoli;

import java.util.ArrayList;
import com.betacom.veicoli.services.ListImpl;
import java.util.List;
import java.util.Scanner;

import com.betacom.veicoli.models.Bici;
import com.betacom.veicoli.models.Macchina;
import com.betacom.veicoli.models.Moto;
import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.process.StartVeicolo;
import com.betacom.veicoli.singleton.Singleton;

public class MainVeicoli {
	
	
	
	public static void main(String[] args) {
		List<String> parameter = new ArrayList<String>();
		parameter.add("add,macchina,ruote=4,alim=benzina,cat=strada,colore=bianco,marca=fiat,anno=2025,modello=500,porte=4,targa=el234gz,cc=1200");
		parameter.add("add,macchina,ruote=4,alim=benzina,cat=strada,colore=bianco,marca=fiat,anno=2023,modello=panda,porte=4,targa=el234gx,cc=1300");
		parameter.add("add,macchina,ruote=4,alim=benzina,cat=strada,colore=bianco,marca=fiat,anno=2026,modello=panda,porte=4,targa=el214gx,cc=1300");
		parameter.add("add,moto,ruote=2,alim=benzina,cat=strada,colore=nero,marca=Yamaha,anno=2019,modello=r1,targa=EL22239,cc=900");
		parameter.add("add,bici,ruote=2,alim=manuale,cat=strada,colore=nero,marca=Bianchi,anno=2025,modello=Girzl 5,marce=10,sospensione=senza,pieghevole=false");
		
		System.out.println("Start Veicoli");
			
		
		List<Veicoli> veicoli = new ArrayList<Veicoli>();
		
		StartVeicolo start = new StartVeicolo(veicoli);
		start.execute(parameter);
		
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digita la tipologia di veicolo per verificare la disponibilità");
		String selected = sc.next();
		switch (selected.toLowerCase()) {

		case "macchina":
		    for (Veicoli v : veicoli) {
		        if (v instanceof Macchina) {
		            System.out.println(v);
		        }
		    }
		    break;

		case "moto":
		    for (Veicoli v : veicoli) {
		        if (v instanceof Moto) {
		            System.out.println(v);
		        }
		    }
		    break;

		case "bici":
		    for (Veicoli v : veicoli) {
		        if (v instanceof Bici) {
		            System.out.println(v);
		        }
		    }
		    break;

		case "list":
			//stampa tutti i veicoli caricati
		    ListImpl listI = new ListImpl(veicoli);
		    listI.printList();
		    break;

		default:
		    System.err.println("Nessuna tipologia di veicolo trovata!");
		    break;
		}
		
		sc.close();
		
		Singleton sing1 = Singleton.getInstance();
		Singleton sing2 = Singleton.getInstance();
		
		System.out.println(sing1 == sing2);  //true perchè il metodo statico getInstance restituisce sempre la stessa istanza.
			
		
}}
