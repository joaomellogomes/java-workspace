package br.com.prontuario.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import br.com.prontuario.model.Paciente;
import br.com.prontuario.model.PacienteTableModel;
import br.com.prontuario.model.DAO.PacienteDAO;

public class JDPacientes extends JDialog {
	
	//Criação dos objetos
	PacienteDAO pacDAO = new PacienteDAO();
	
	private JTable jtbPacientes;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JDPacientes dialog = new JDPacientes();
//					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//					dialog.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the dialog.
	 */
	public JDPacientes(String ala) {
		setBounds(100, 100, 830, 448);
		getContentPane().setLayout(null);
		
		JLabel lblPacientesNaAla = new JLabel("Pacientes na ala");
		lblPacientesNaAla.setFont(new Font("Segoe Print", Font.PLAIN, 58));
		lblPacientesNaAla.setBounds(33, 27, 485, 63);
		getContentPane().add(lblPacientesNaAla);
		
		JScrollPane jspPacientes = new JScrollPane();
		jspPacientes.setBounds(33, 102, 758, 281);
		getContentPane().add(jspPacientes);
		
		final PacienteTableModel model = new PacienteTableModel(pacDAO.listarPaciente(ala));
		jtbPacientes = new JTable();
		jtbPacientes.getTableHeader().setReorderingAllowed(false);
		jtbPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtbPacientes.setModel(model);
		jspPacientes.setViewportView(jtbPacientes);
		
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(jtbPacientes.getSelectedRowCount() != 1) {
					JOptionPane.showMessageDialog(null, "Selecione um paciente!", "Selecione uma linha", JOptionPane.ERROR_MESSAGE);
				}else {
					
					Paciente umPaciente = new Paciente();

					PacienteTableModel model = (PacienteTableModel) jtbPacientes.getModel();

					umPaciente = model.getPaciente(jtbPacientes.getSelectedRow());
					
					JDCadastrarProntuario jd = new JDCadastrarProntuario(umPaciente);
					jd.setLocationRelativeTo(null);
					jd.setModal(true);
					jd.setVisible(true);
					
				}
				
			}
		});
		btnConsultar.setBounds(577, 47, 212, 43);
		getContentPane().add(btnConsultar);

	}
}
