package it.polito.tdp.model;

public class RichWord {

	private String parola;
	private boolean corretto;
	
	public RichWord(String parola, boolean corretto) {
		super();
		this.parola = parola;
		this.corretto = corretto;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public boolean isCorretto() {
		return corretto;
	}

	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}
	
	
	
}
