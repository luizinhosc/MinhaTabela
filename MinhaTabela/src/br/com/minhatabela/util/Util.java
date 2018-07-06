package br.com.minhatabela.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.minhatabela.view.NovoTimeBean;

public class Util {

	
	
	public void simularDemora() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			Logger.getLogger(NovoTimeBean.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
