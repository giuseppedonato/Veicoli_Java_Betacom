package com.betacom.veicoli;
import java.lang.reflect.Method;
import java.util.ArrayList;
import com.betacom.veicoli.services.ListImpl;
import java.util.List;
import java.util.Scanner;

import com.betacom.veicoli.exception.VeicoliException;
import com.betacom.veicoli.interfaces.GeneralInterface;
import com.betacom.veicoli.models.Bici;
import com.betacom.veicoli.models.Macchina;
import com.betacom.veicoli.models.Moto;
import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.process.OperationProcess;
import com.betacom.veicoli.process.ReflectProcess;
import com.betacom.veicoli.process.SequentialProcess;
import com.betacom.veicoli.singleton.Singleton;
import com.betacom.veicoli.utils.Utilities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainVeicoli {
	public static void main(String[] args) {
		
		String selected = "start";
		
		log.info("MainVeicoli is ready to execute {}", selected);
		
		
		SequentialProcess seq = new SequentialProcess();
		List<Veicoli> veicoli = new ArrayList<Veicoli>();
		
		
		try {
			//Leggo il file di Request (json) che mi arriva dall'esterno
			List<String> parameter = seq.importFile();
			GeneralInterface obj = (GeneralInterface) ReflectProcess.loadProcess(selected, veicoli);
			obj.executeOperation(obj, parameter);
			OperationProcess.searchVehicle(veicoli);
			seq.exportFile(veicoli);
		} catch (Exception e) {
			throw new VeicoliException("Process non trovato: " + e.getMessage());
		}
	}
}
