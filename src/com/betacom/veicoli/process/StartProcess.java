package com.betacom.veicoli.process;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.betacom.veicoli.exception.VeicoliException;
import com.betacom.veicoli.interfaces.GeneralInterface;
import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.services.BiciImpl;
import com.betacom.veicoli.services.MacchinaImpl;
import com.betacom.veicoli.services.MotoImpl;

public class StartProcess implements GeneralInterface{
	
	private Set<String> targhe; //utilizziamo il Set per non permettere duplicati
	
	private MacchinaImpl macchinaImpl;
	private MotoImpl motoImpl;
	private BiciImpl biciImpl;
	

	public StartProcess(List<Veicoli> veicoli) {
		super();
		this.targhe = new HashSet<String>();
		this.macchinaImpl = new MacchinaImpl(veicoli, targhe);
		this.motoImpl = new MotoImpl(veicoli, targhe);
		this.biciImpl = new BiciImpl(veicoli);
	}



	@Override
	public void execute(List<String> param) {
		 for (String it : param) {

		        String[] newParams = it.split(",");
		        
		        String istr = newParams[0];
		        String type = newParams[1];
		 
		        if(istr.equals("add")) {
		        	if(type.equals("macchina")) {
		        		macchinaImpl.add(newParams);
		        	} else if (type.equals("moto")) {
		        		motoImpl.add(newParams);
		        	} else if (type.equals("bici")) {
		        		biciImpl.add(newParams);
		        	}
		        } 
		    }
		}
	
	
	public void executeOperation(GeneralInterface myProcess, List<String> parameter) throws Exception{ // exception finale vuol dire -> Questa funzione puo generare un errore, la gestisce chi mi chiama.
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
	}
