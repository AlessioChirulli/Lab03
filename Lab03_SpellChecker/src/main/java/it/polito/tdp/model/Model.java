package it.polito.tdp.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Model {

	LinkedList<String> dizionario=new LinkedList<String>();
	
	public void loadDictionary(String language) {
		dizionario.clear();
	try {
		FileReader fr=new FileReader("src/main/resources/"+language+".txt");
		BufferedReader br= new BufferedReader(fr);
		String word;
		while((word=br.readLine())!=null) {
			dizionario.add(word);
		}
		br.close();
	}catch(IOException e) {
		System.out.println("Errore nella lettura da file");
	}	
	}
	
	public ArrayList<String> spellCheckText(List<String> inputTextList){
		ArrayList<String> paroleSbagliate=new ArrayList<String>();
		for(String word:inputTextList) {
			if(!dizionario.contains(word)) {
			paroleSbagliate.add(word);	
			}
		}
		return paroleSbagliate;
	}
	
	public ArrayList<String> spellCheckTextLineare(List<String> inputTextList){
		ArrayList<String> paroleSbagliate=new ArrayList<String>();
		boolean controllo=false;
		for(String word:inputTextList) {
			controllo=false;
			for(String s:dizionario) {
			if(s.equals(word)) {
				controllo=true;
			}
			}
			if(!controllo)
			paroleSbagliate.add(word);
			}
		return paroleSbagliate;
		}
		
	
	public ArrayList<String> spellCheckTextDicotomica(List<String> inputTextList){
		ArrayList<String> paroleSbagliate=new ArrayList<String>();
		boolean controllo=false;
		for(String word:inputTextList) {
			int indice=dizionario.size()/2;
			int max=dizionario.size();
			int min=0;
			controllo=false;
			while(min!=max && max-min!=1 && !controllo){
			if(word.compareTo(dizionario.get(indice))==0 ) {
				controllo=true;
				}else if(word.compareTo(dizionario.get(indice))>0) {
					min=indice;
					indice=(min+max)/2;
				}else {
					max=indice;
					indice=(min+max)/2;
				}
			}
			if(!controllo && word.compareTo(dizionario.get(indice+1))!=0)
			paroleSbagliate.add(word);
		}
		return paroleSbagliate;
	}
}
	

