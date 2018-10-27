package br.com.prontuario.model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.prontuario.model.Paciente;

public class PacienteDAO {
	
	public ArrayList<String> listarNomesAlas(){
		
		Connection con = null;
		String sql = "";
		
		ArrayList<String> listaAlas = new ArrayList<String>();
		
		try {
			
			con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement();
			
			sql = "select distinct pacAla from paciente order by pacAla;";
			ResultSet rs = stmt.executeQuery(sql);
			
			String umaAla = "";
			
			while(rs.next()) {
				
				umaAla = rs.getString("pacAla");
				listaAlas.add(umaAla);
				umaAla = "";
				
			}
			stmt.close();
			rs.close();
				
		}catch(SQLException erro){
			JOptionPane.showMessageDialog(null, "Erro capturado!:\nERRO: " + erro,
					"Erro de instrunção SQL!", JOptionPane.ERROR_MESSAGE);
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Erro desconhecido capturado!\nERRO: " + erro,
					"Erro desconhecido!", JOptionPane.ERROR_MESSAGE);
		}finally{
			try{
				con.close();
			}catch(SQLException erro){
				JOptionPane.showMessageDialog(null, "Erro capturado ao fechar conexão!\nERRO: " + erro,
						"Erro ao encerrar conexão com o banco de dados", JOptionPane.ERROR_MESSAGE);
			}catch (Exception erro) {
				JOptionPane.showMessageDialog(null, "Erro desconhecido capturado ao fechar conexão com banco de dados!\nERRO: " + erro,
						"Erro desconhecido de banco de dados!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		return listaAlas;
		
	}
	
	public ArrayList<Paciente> listarPaciente(String filtroAla){
		
		Connection con = null;
		String sql = "";
		
		ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();
		
		try {
			
			con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement();
			
			sql = "select * from paciente where pacAla = '" + filtroAla.trim() + "' order by pacNome;";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Paciente umPaciente = new Paciente();
				
				umPaciente.setId(rs.getInt("pacId"));
				umPaciente.setNome(rs.getString("pacNome"));
				umPaciente.setTelefone("pacTelefone");
				umPaciente.setRg(rs.getString("pacRg"));
				umPaciente.setCpf(rs.getString("pacCpf"));
				umPaciente.setSexo(rs.getString("pacSexo"));
				umPaciente.setAla(rs.getString("pacAla"));
				umPaciente.setQuarto(rs.getInt("pacQuarto"));
				umPaciente.setLeito(rs.getInt("pacLeito"));
				umPaciente.setHistorico(rs.getString("pacHistorico"));
				umPaciente.setDataNascimento(rs.getString("pacDataNascimento"));
				
				listaPaciente.add(umPaciente);
				
				umPaciente = null;
				
			}
			rs.close();
			stmt.close();
				
		}catch(SQLException erro){
			JOptionPane.showMessageDialog(null, "Erro capturado!:\nERRO: " + erro,
					"Erro de instrunção SQL!", JOptionPane.ERROR_MESSAGE);
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Erro desconhecido capturado!\nERRO: " + erro,
					"Erro desconhecido!", JOptionPane.ERROR_MESSAGE);
		}finally{
			try{
				con.close();
			}catch(SQLException erro){
				JOptionPane.showMessageDialog(null, "Erro capturado ao fechar conexão!\nERRO: " + erro,
						"Erro ao encerrar conexão com o banco de dados", JOptionPane.ERROR_MESSAGE);
			}catch (Exception erro) {
				JOptionPane.showMessageDialog(null, "Erro desconhecido capturado ao fechar conexão com banco de dados!\nERRO: " + erro,
						"Erro desconhecido de banco de dados!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		return listaPaciente;
		
	}

}












