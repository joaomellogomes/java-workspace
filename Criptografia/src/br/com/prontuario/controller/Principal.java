package br.com.prontuario.controller;

import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.prontuario.model.DAO.ConnectionFactory;
import br.com.prontuario.view.JFLogin;
import br.com.prontuario.view.JFSplashScreen;

public class Principal {

	public static void main(String[] args) {
		
		JFSplashScreen frame = new JFSplashScreen();
		JFLogin dialog = new JFLogin();
		
		try {
			ConnectionFactory.getConnection();
			
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			Thread.sleep(2850);
			
			frame.dispose();
			
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
			
		}catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ERRO: \n" + erro, "Erro ao conectar", JOptionPane.ERROR_MESSAGE);
		}catch (InterruptedException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao iniciar o programa!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}

	}

}
