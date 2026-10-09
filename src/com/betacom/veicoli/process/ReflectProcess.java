package com.betacom.veicoli.process;
import java.util.List;

import com.betacom.veicoli.exception.VeicoliException;
import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.utils.Utilities;

public class ReflectProcess {
	private final static String PATH_PACKAGE = "com.betacom.veicoli.process";
	
	public static Object loadProcess(String name, List<Veicoli> veicoli) throws Exception {
		try {
			Class<?> cl = Class.forName(PATH_PACKAGE + "." + Utilities.buildClassName(name));
			Object obj = cl.getDeclaredConstructor(List.class).newInstance(veicoli);
			return obj;
		} catch (Exception e) {
			throw new VeicoliException("Process non previsto " + e.getMessage());
			
		}
	}
}
