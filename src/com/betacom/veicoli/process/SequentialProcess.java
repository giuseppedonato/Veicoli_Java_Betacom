package com.betacom.veicoli.process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SequentialProcess {
	private static final String PATH = "/Users/giuseppedonato/Documents/RequestDto/Request.txt";
	
	public List<String> readFile() {
		List<String> result = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(PATH))){ //permette di leggere il file con le stringhe, altrimenti legge carattere per carattere
			String line = reader.readLine();
			while (line != null) {
				result.add(line);
				line = reader.readLine();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return result;
	}
}
