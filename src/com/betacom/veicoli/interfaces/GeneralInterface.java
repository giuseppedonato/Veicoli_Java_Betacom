package com.betacom.veicoli.interfaces;

import java.util.List;

public interface GeneralInterface {
	void execute(List<String> param);
	void executeOperation(GeneralInterface obj, List<String> param) throws Exception;
}
