package com.betacom.veicoli.process;

import java.util.List;

import com.betacom.veicoli.interfaces.GeneralInterface;
import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.services.BiciImpl;
import com.betacom.veicoli.services.MacchinaImpl;
import com.betacom.veicoli.services.MotoImpl;

public class StartVeicolo implements GeneralInterface{
	
	private List<Veicoli> veicoli;
	
	private MacchinaImpl macchinaImpl; 
	private MotoImpl motoImpl;
	private BiciImpl biciImpl;
	

	public StartVeicolo(List<Veicoli> veicoli) {
		super();
		this.veicoli = veicoli;
		this.macchinaImpl = new MacchinaImpl(veicoli);
		this.motoImpl = new MotoImpl(veicoli);
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
	}
