package br.com.prontuario.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.prontuario.model.Enfermeiro;

public class EnfermeiroDAO {
	
	public Enfermeiro autenticar(String coren, String senha) {
		
		Connection con = null;
		String sql = "";
		
		Enfermeiro enfProcurado = new Enfermeiro();
		
		try {
			
			con = ConnectionFactory.getConnection();
			
			Statement stmt = con.createStatement();
			
			sql = "select * from enfermeiro where enfCoren = '" + coren + "' and enfSenha COLLATE utf8_bin = '" + senha + "';";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				enfProcurado.setId(rs.getInt("enfId"));
				enfProcurado.setNome(rs.getString("enfNome"));
				
			}
			rs.close();
			
		}catch(SQLException erro){
			JOptionPane.showMessageDialog(null, "Erro de instun��o SQL "
					+ "capturado! \nERRO: \n" + erro , "Erro de instrun��o SQL!", JOptionPane.ERROR_MESSAGE);
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Erro imprevisto n�o "
					+ "capturado! \nERRO: \n" + erro, "Erro n�o capturado!", JOptionPane.ERROR_MESSAGE);
		}finally{
			try{
				con.close();
			}catch(Exception erro){
				JOptionPane.showMessageDialog(null, "Erro imprevisto n�o "
						+ "capturado! \nERRO: \n" + erro, "Erro n�o capturado!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		return enfProcurado;
		
	}
	
	public void cadastrarProntuario(int idPaciente, String descricao, String dataHora, String numeroProntuario) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		
		try {
			
			con = ConnectionFactory.getConnection();
			
			sql = "insert into prontuario() values(not null, AES_ENCRYPT(?, 'chave'), ?, ?, ?);";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, descricao);
			ps.setString(2, dataHora);
			ps.setString(3, numeroProntuario);
			ps.setInt(4, idPaciente);
			
			ps.executeUpdate();
			ps.close();
			
			JOptionPane.showMessageDialog(null, "Prontu�rio cadastrado!", "Cadastrar prontu�rio", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(SQLException erro) {
			JOptionPane.showMessageDialog(null, "ERRO:\n" + erro, "Erro de instru��o SQL", JOptionPane.ERROR_MESSAGE);
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, "ERRO:\n" + erro, "Erro desconhecido", JOptionPane.ERROR_MESSAGE);
		}finally {
			try {
				con.close();
			}catch(Exception erro) {
				JOptionPane.showMessageDialog(null, "Erro desconhecido ao encerrar conex�o\ncom o banco de dados!",
						"Erro ao fechar conex�o", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}
