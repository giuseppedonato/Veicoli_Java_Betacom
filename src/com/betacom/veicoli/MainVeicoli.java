package com.betacom.veicoli;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import com.betacom.veicoli.services.ListImpl;
import java.util.List;
import java.util.Scanner;

import com.betacom.veicoli.Exception.VeicoliException;
import com.betacom.veicoli.Utils.Utilities;
import com.betacom.veicoli.interfaces.GeneralInterface;
import com.betacom.veicoli.models.Bici;
import com.betacom.veicoli.models.Macchina;
import com.betacom.veicoli.models.Moto;
import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.process.SequentialProcess;
import com.betacom.veicoli.singleton.Singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainVeicoli {
	private final static String PATH_PACKAGE = "com.betacom.veicoli.process";
	
	public static void main(String[] args) {
		
		String selected = "start";
		
		log.info("MainVeicoli is ready to execute {}", selected);
		
		SequentialProcess seq = new SequentialProcess();
		List<String> parameter = seq.readFile();
		
		List<Veicoli> veicoli = new ArrayList<Veicoli>();
		
		try {
			GeneralInterface obj = (GeneralInterface) loadProcess(selected, veicoli);
			executeOperation(obj, parameter);
			searchVehicle(veicoli);
		} catch (Exception e) {
			throw new VeicoliException("Process non trovato: " + e.getMessage());
		}
	}
		private static Object loadProcess(String name, List<Veicoli> veicoli) throws Exception {
			try {
				Class<?> cl = Class.forName(PATH_PACKAGE + "." + Utilities.buildClassName(name));
				Object obj = cl.getDeclaredConstructor(List.class).newInstance(veicoli);
				return obj;
			} catch (Exception e) {
				throw new VeicoliException("Process non previsto " + e.getMessage());
				
			}
		}
		
		private static void executeOperation(GeneralInterface myProcess, List<String> parameter) throws Exception{ // exception finale vuol dire -> Questa funzione puo generare un errore, la gestisce chi mi chiama.
			try {
				Method method = myProcess.getClass().getMethod("execute", List.class);
				method.invoke(myProcess, parameter); // myProcess è l'oggetto su cui eseguire il metodo, parameter perchè il metodo dell'interfaccia ha il parametro
				
			} catch (SecurityException e) {
				throw new VeicoliException("Errore di sicurezza: " + e.getMessage());
			} catch (IllegalAccessException e) {
				throw new VeicoliException("Errore IllegalAccess: " + e.getMessage());
			} catch(IllegalArgumentException e) {
				throw new VeicoliException("Errore IllegalArgument: " + e.getMessage());
			} catch (InvocationTargetException e) {
				throw new VeicoliException(e.getCause().getMessage());
			} catch (NoSuchMethodException e) {
				throw new VeicoliException("Metodo Execute non trovato");
			}
		}
		
		private static void searchVehicle(List<Veicoli> veicoli) {
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
			
			Singleton sing1 = Singleton.getInstance();
			Singleton sing2 = Singleton.getInstance();
			
			System.out.println(sing1 == sing2);  //true perchè il metodo statico getInstance restituisce sempre la stessa istanza.
		
		}
		
}
