package br.com.prontuario.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.toedter.calendar.JDateChooser;

import br.com.prontuario.model.Paciente;
import br.com.prontuario.model.DAO.EnfermeiroDAO;

public class JDCadastrarProntuario extends JDialog {
	
	//Criação dos objetos
	EnfermeiroDAO enfDAO = new EnfermeiroDAO();
	
	private JTextField jtfNome;
	private JTextArea jtaDescricao;
	private JDateChooser jdcData;
	private JSpinner jspHora;
	private JSpinner jspMinuto;
	private JButton btnSalvar;
	private JLabel lblNmeroPronturio;
	private JTextField jtfNumPront;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JDCadastrarProntuario dialog = new JDCadastrarProntuario();
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
	public JDCadastrarProntuario(Paciente paciente) {
		setBounds(100, 100, 488, 465);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(23, 32, 55, 16);
		getContentPane().add(lblNome);
		
		jtfNome = new JTextField(paciente.getNome());
		jtfNome.setEditable(false);
		jtfNome.setBounds(90, 26, 376, 28);
		getContentPane().add(jtfNome);
		jtfNome.setColumns(10);
		
		jdcData = new JDateChooser();
		jdcData.setBounds(100, 77, 153, 28);
		getContentPane().add(jdcData);
		
		JLabel lblDatahora = new JLabel("Data/hora:");
		lblDatahora.setBounds(23, 79, 76, 16);
		getContentPane().add(lblDatahora);
		
		jspHora = new JSpinner();
		jspHora.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		jspHora.setBounds(265, 77, 57, 28);
		getContentPane().add(jspHora);
		
		jspMinuto = new JSpinner();
		jspMinuto.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		jspMinuto.setBounds(334, 77, 55, 28);
		getContentPane().add(jspMinuto);
		
		JScrollPane jspDescricao = new JScrollPane();
		jspDescricao.setBounds(23, 150, 376, 140);
		getContentPane().add(jspDescricao);
		
		jtaDescricao = new JTextArea();
		jtaDescricao.setWrapStyleWord(true);
		jtaDescricao.setLineWrap(true);
		jspDescricao.setViewportView(jtaDescricao);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(23, 133, 76, 16);
		getContentPane().add(lblDescrio);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					enfDAO.cadastrarProntuario(paciente.getId(), jtaDescricao.getText(), 
							jdcData.getDateFormatString() + " - " + jspHora.getValue() + " - " +jspMinuto.getValue(), jtfNumPront.getText());
					
					dispose();
					
				}catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Verifique os dados!\nERRO: " + erro, "Erro!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		getRootPane().setDefaultButton(btnSalvar);
		btnSalvar.setBounds(6, 381, 460, 39);
		getContentPane().add(btnSalvar);
		
		lblNmeroPronturio = new JLabel("N\u00FAmero prontu\u00E1rio: ");
		lblNmeroPronturio.setBounds(23, 308, 110, 16);
		getContentPane().add(lblNmeroPronturio);
		
		jtfNumPront = new JTextField();
		jtfNumPront.setBounds(145, 302, 265, 28);
		getContentPane().add(jtfNumPront);
		jtfNumPront.setColumns(10);

	}
}
