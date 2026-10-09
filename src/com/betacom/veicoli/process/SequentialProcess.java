package com.betacom.veicoli.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.betacom.veicoli.exception.VeicoliException;
import com.betacom.veicoli.models.Veicoli;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SequentialProcess {
	private static final String PATH = "/Users/giuseppedonato/Documents/RequestDto/Request.txt";
	
	private final ObjectMapper mapper;
	
	
	
	public SequentialProcess() {
		super();
		this.mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	public List<String> readFile() {
		List<String> result = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(PATH))){ // permette di leggere i file con le stringhe, altrimenti legge carattere per carattere
			String line = reader.readLine();
			while (line != null) {
				result.add(line);
				line = reader.readLine();
			}
		} catch (Exception e) {
			throw new VeicoliException(e.getMessage());
		}
		return result;
	}
	
	public void exportFile(List<Veicoli> veicoli) {
		try {
		  mapper.writeValue(new File(PATH), veicoli);
		} catch (Exception e) {
			throw new VeicoliException(e.getMessage());
		}
	} 
	
	
	public List<String> importFile() {
		List<Map<String, Object>> vehicles;
		
	    try {
	        String jsonString = Files.readString(Path.of(PATH));

	        vehicles = mapper.readValue(
    		jsonString,  new TypeReference<List<Map<String, Object>>>() {}
    		); 
	    }catch (Exception e) {
			return readFile();
		}
	    
	        List<String> parameter = new ArrayList<>();

	        for (Map<String, Object> vehicle : vehicles) {
	            StringBuilder str = new StringBuilder();

	            str.append("add,");
	            str.append(vehicle.get("tipoVeicolo")).append(",");
	            str.append("ruote=").append(vehicle.get("numeroRuote")).append(",");
	            str.append("alim=").append(vehicle.get("tipoAlimentazione")).append(",");
	            str.append("cat=").append(vehicle.get("categoria")).append(",");
	            str.append("colore=").append(vehicle.get("colore")).append(",");
	            str.append("marca=").append(vehicle.get("marca")).append(",");
	            str.append("anno=").append(vehicle.get("annoProduzione")).append(",");
	            str.append("modello=").append(vehicle.get("modello"));

	            String tipo = (String) vehicle.get("tipoVeicolo");

	            if (tipo.equals("macchina")) {

	                str.append(",porte=").append(vehicle.get("numeroPorte"));
	                str.append(",targa=").append(vehicle.get("targa"));
	                str.append(",cc=").append(vehicle.get("cc"));

	            } else if (tipo.equals("moto")) {

	                str.append(",targa=").append(vehicle.get("targa"));
	                str.append(",cc=").append(vehicle.get("cc"));

	            } else if (tipo.equals("bici")) {

	                str.append(",marce=").append(vehicle.get("numeroMarce"));
	                str.append(",sospensione=").append(vehicle.get("tipoSospenzione"));
	                str.append(",pieghevole=").append(vehicle.get("pieghevole"));
	            }

	            parameter.add(str.toString());
	        }
	        parameter.forEach(p -> System.out.println(p.toString()));
	        return parameter;
	}
	
	
	
	
}
