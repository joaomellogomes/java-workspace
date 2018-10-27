package br.com.prontuario.model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.prontuario.model.Administrador;
import br.com.prontuario.model.Enfermeiro;

public class AdministradorDAO {

	public Administrador autenticar(String coren, String senha) {

		Connection con = null;
		String sql = "";

		Administrador admProcurado = new Administrador();

		try {

			con = ConnectionFactory.getConnection();

			Statement stmt = con.createStatement();

			sql = "select * from administrador where admCoren = '" + coren + "' and admSenha COLLATE utf8_bin = '" + senha + "';";

			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()) {

				admProcurado.setId(rs.getInt("admId"));
				admProcurado.setNome(rs.getString("admNome"));

			}
			rs.close();

		}catch(SQLException erro){
			JOptionPane.showMessageDialog(null, "Erro de instunção SQL "
					+ "capturado! \nERRO: \n" + erro , "Erro de instrunção SQL!", JOptionPane.ERROR_MESSAGE);
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Erro imprevisto não "
					+ "capturado! \nERRO: \n" + erro, "Erro não capturado!", JOptionPane.ERROR_MESSAGE);
		}finally{
			try{
				con.close();
			}catch(Exception erro){
				JOptionPane.showMessageDialog(null, "Erro imprevisto não "
						+ "capturado! \nERRO: \n" + erro, "Erro não capturado!", JOptionPane.ERROR_MESSAGE);
			}
		}

		return admProcurado;

	}

}
