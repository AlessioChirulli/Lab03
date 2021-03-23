package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
    
	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboLingue;

    @FXML
    private TextArea txtLingua;

    @FXML
    private Button btnCheck;

    @FXML
    private TextArea txtResult;

    @FXML
    private Label txtErrori;

    @FXML
    private Button btnReset;

    @FXML
    private Label txtTempo;

    @FXML
    void doCheck(ActionEvent event) {
    double tempo=(double)System.nanoTime();
    String testo=txtLingua.getText();
    testo=testo.toLowerCase();
    testo=testo.replaceAll("[.,\\/#!$%\\^&\\*;:{}=-_'()\\[\\]\"]", "");
    StringTokenizer parole = new StringTokenizer(testo, " ");
    ArrayList<String> listaParole=new ArrayList<String>();
    while(parole.hasMoreTokens())  {
    	listaParole.add(parole.nextToken());
    }
    this.model.loadDictionary((String)comboLingue.getValue());
    ArrayList<String>paroleSbagliate=this.model.spellCheckTextDicotomica(listaParole);
    String s="";
    for(String parola:paroleSbagliate) {
    	s+=parola+"\n";
    }
    double tempo2=(double)System.nanoTime();
    txtErrori.setText("The text contains "+paroleSbagliate.size()+" errors");
    txtResult.setText(s);
    txtTempo.setText("Spell check completed in "+((tempo2-tempo)/1e9)+" secondi");
    }

    @FXML
    void doReset(ActionEvent event) {
    txtResult.clear();
    txtTempo.setText("");
    txtLingua.clear();
    comboLingue.setValue("");
    txtErrori.setText("");
    }

    public void setModel(Model m) {
    	this.model = m ;
    	String language[]=new String[]{"Italian","English"};
    	comboLingue.getItems().addAll(language);
    	
    	
    }
    
    @FXML
    void initialize() {
        assert comboLingue != null : "fx:id=\"comboLingue\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtLingua != null : "fx:id=\"txtLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrori != null : "fx:id=\"txtErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}


