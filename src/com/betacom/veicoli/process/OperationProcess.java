package com.betacom.veicoli.process;

import java.util.List;
import java.util.Scanner;

import com.betacom.veicoli.models.Bici;
import com.betacom.veicoli.models.Macchina;
import com.betacom.veicoli.models.Moto;
import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.services.ListImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperationProcess {

	public static void searchVehicle(List<Veicoli> veicoli) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digita la tipologia di veicolo per verificare la disponibilità");
		String veichleType = sc.next();
		switch (veichleType.toLowerCase()) {

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
			log.info(
			"Attenzione!!! Solo per oggi trovi vetture oltre il 2022 al 50%, basta digitare 2022"
					);
			String paramFilter = sc.next();
			ListImpl listI = new ListImpl(veicoli);
			if ("2022".equals(paramFilter.trim())) {
				veicoli.stream()
					.filter(v -> v.getAnnoProduzione() > 2022)
					.forEach(f -> System.out.println(f.getModello()));
			} else {
				listI.printList();
			}
		    break;

		default:
		    System.err.println("Nessuna tipologia di veicolo trovata!");
		    break;
		}
		
		sc.close();
	}}
