package br.com.livraria.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.livraria.model.Livro;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class JFXLivroControle implements Initializable {

	
	Livro livro = new Livro();
	
	@FXML TextField tfDescricao;
	@FXML ComboBox cbGenero;
	@FXML ComboBox cbOrigem;
	@FXML ComboBox cbFormato;
	@FXML TextField tfAutor;
	@FXML TextField tfEditora;
	@FXML TextField tfEdicao;
	@FXML TextField tfPrecoCusto;
	@FXML TextField tfPrecoVenda;
	@FXML Button bInserir;
	@FXML Button bLimpar;
	@FXML Button bCarregar;
	@FXML Button bSair;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		cbGenero.getItems().addAll("Literatura", "Ficção", "Terror");
		cbFormato.getItems().addAll("Fisico", "Digital");
		cbOrigem.getItems().addAll("Nacional", "Importado");
	}


	@FXML public void inserir() {
		
		livro.setDescricao(tfDescricao.getText());
		livro.setGenero(cbGenero.getSelectionModel().getSelectedItem().toString());
		livro.setFormato(cbFormato.getSelectionModel().getSelectedItem().toString());
		livro.setOrigem(cbOrigem.getSelectionModel().getSelectedItem().toString());
		livro.setAutor(tfAutor.getText());
		livro.setEditora(tfEditora.getText());
		livro.setEdicao( Integer.parseInt( tfEdicao.getText()));
		livro.setPrecoCusto( Double.parseDouble( tfPrecoCusto.getText()));	
		
		tfPrecoVenda.setText( String.valueOf( livro.calcularPrecoVenda()));
	}

	@FXML public void limpar() {
		
		tfDescricao.clear();
		cbGenero.setValue("");
		cbFormato.setValue("");
		cbOrigem.setValue("");
		tfAutor.clear();
		tfEditora.clear();
		tfEdicao.clear();
		tfPrecoCusto.clear();
		tfPrecoVenda.clear();
	}


	@FXML public void carregar() {
		
		tfDescricao.setText(livro.getDescricao());
		cbGenero.setValue(livro.getGenero());
		cbFormato.setValue(livro.getFormato());
		cbOrigem.setValue(livro.getOrigem());
		tfAutor.setText(livro.getAutor());
		tfEditora.setText(livro.getEditora());
		tfEdicao.setText( String.valueOf( livro.getEdicao()));
		tfPrecoCusto.setText( String.valueOf( livro.getPrecoCusto()));
		
		tfPrecoVenda.setText( String.valueOf( livro.calcularPrecoVenda()));

	}


	@FXML public void sair() {
		System.exit(0);
	}
	


}
