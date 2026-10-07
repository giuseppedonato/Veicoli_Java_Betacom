package com.betacom.veicoli.Utils;

public class Utilities {
	
	public static String buildClassName(String param) {
		return param.substring(0, 1).toUpperCase() + param.substring(1).toLowerCase() + "Process";
	}
	
}
