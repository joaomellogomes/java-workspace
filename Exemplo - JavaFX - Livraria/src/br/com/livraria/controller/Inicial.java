package br.com.livraria.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Inicial extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/com/livraria/view/JFXLivroLayout.fxml"));
		BorderPane nodeRoot = loader.load();
		Scene scene = new Scene(nodeRoot);
		primaryStage.setScene(scene);
		
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setResizable(false);
		primaryStage.centerOnScreen();	
		
		primaryStage.show();
	}

	
	public static void main(String[] args) {
		
		launch(args);
	}

	
}
