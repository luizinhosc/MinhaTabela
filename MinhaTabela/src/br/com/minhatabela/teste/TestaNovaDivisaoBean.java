package br.com.minhatabela.teste;

import br.com.minhatabela.view.NovaDivisaoBean;

public class TestaNovaDivisaoBean {

	public static void main(String[] args) {
		NovaDivisaoBean div = new NovaDivisaoBean();
		
		div.getDivisao().setDescricao("SERIE  TESTE");
		div.gravar();

	}

}
