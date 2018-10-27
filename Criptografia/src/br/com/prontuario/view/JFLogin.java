package br.com.prontuario.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.DarkStar;

import br.com.prontuario.model.Administrador;
import br.com.prontuario.model.Enfermeiro;
import br.com.prontuario.model.DAO.AdministradorDAO;
import br.com.prontuario.model.DAO.EnfermeiroDAO;
import br.com.prontuario.model.DAO.PacienteDAO;

public class JFLogin extends JFrame {

	//Criação dos objetos
	AdministradorDAO admDAO = new AdministradorDAO();
	
	EnfermeiroDAO enfDAO = new EnfermeiroDAO();
	
	PacienteDAO pacDAO = new PacienteDAO();

	private JPanel contentPane;
	private JTextField jtfCoren;
	private JPasswordField jpfSenha;
	private JCheckBox jcbAdministrador;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					JFLogin frame = new JFLogin();
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the frame.
	 */
	public JFLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlCabecalho = new JPanel();
		pnlCabecalho.setBackground(SystemColor.activeCaption);
		pnlCabecalho.setBounds(6, 6, 410, 83);
		contentPane.add(pnlCabecalho);
		pnlCabecalho.setLayout(null);

		JLabel lblLogin = new JLabel("login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Segoe Print", Font.BOLD, 50));
		lblLogin.setBounds(164, 6, 130, 71);
		pnlCabecalho.add(lblLogin);

		JLabel lblCoren = new JLabel("COREN:");
		lblCoren.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblCoren.setBounds(50, 128, 72, 33);
		contentPane.add(lblCoren);

		jtfCoren = new JTextField();
		jtfCoren.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jtfCoren.setBounds(134, 125, 198, 39);
		contentPane.add(jtfCoren);
		jtfCoren.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblSenha.setBounds(50, 199, 72, 33);
		contentPane.add(lblSenha);

		jpfSenha = new JPasswordField();
		jpfSenha.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jpfSenha.setBounds(134, 196, 198, 39);
		contentPane.add(jpfSenha);

		jcbAdministrador = new JCheckBox("Administrador");
		jcbAdministrador.setBounds(228, 272, 104, 18);
		contentPane.add(jcbAdministrador);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String coren = jtfCoren.getText(), senha = String.valueOf(jpfSenha.getPassword());

						if(jcbAdministrador.isSelected()) {

							final Administrador admAutenticado = admDAO.autenticar(coren, senha);

							if(!admAutenticado.getNome().equals("")) {

								//chamar janela do adm com parâmetros necessários


								dispose();

							}else {
								JOptionPane.showMessageDialog(null, "Verifique seu COREN e senha", "Erro ao logar",
										JOptionPane.ERROR_MESSAGE);
							}

						}else if(!jcbAdministrador.isSelected()) {

							final Enfermeiro enfAutenticado = enfDAO.autenticar(coren, senha);

							if(!enfAutenticado.getNome().equals("")) {

								//chamar janela do enfermeiro com parâmetros necessários
								JList jlsAlas = new JList();
								JScrollPane jspAlas = new JScrollPane();
								jspAlas.setBounds(0, 0, 200, 100);
								jspAlas.setBorder(new TitledBorder(null, "Alas", TitledBorder.CENTER, TitledBorder.TOP, null, null));
								jspAlas.setViewportView(jlsAlas);
								
								//jlsDistribuidores
								DefaultListModel modeloConferir = new DefaultListModel();

								for(String p : pacDAO.listarNomesAlas()){
									modeloConferir.addElement(p);
								}
								
								jlsAlas.setModel(modeloConferir);
								
								Object[] botoes = {"Selecionar", "Cancelar"};
								
								JLabel lblSelecionarDistribuidor = new JLabel("<html>Selecione uma ala:<br><b></b></html>");
								lblSelecionarDistribuidor.setFont(new Font("Arial", Font.BOLD, 14));
								
								int op = JOptionPane.showOptionDialog(null, new Object[]{lblSelecionarDistribuidor, jspAlas}, 
										"Solicitar vacina",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,botoes, botoes[0]);
								
								String alaSelecionada = jlsAlas.getSelectedValue().toString();
								
								if(op == JOptionPane.OK_OPTION) {
									//buscar no banco a ala selecionada
									JDPacientes jf = new JDPacientes(alaSelecionada);
									jf.setLocationRelativeTo(null);
									jf.setModal(true);
									jf.setVisible(true);
								}else {
									
								}

								dispose();

							}else {
								JOptionPane.showMessageDialog(null, "Verifique seu COREN e senha", "Erro ao logar",
										JOptionPane.ERROR_MESSAGE);
							}

						}

			}
		});
		getRootPane().setDefaultButton(btnEntrar);
		btnEntrar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnEntrar.setBounds(6, 312, 410, 39);
		contentPane.add(btnEntrar);

		try{
			PlasticLookAndFeel.setPlasticTheme(new DarkStar() {
			});
			try{

				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			}catch(InstantiationException erro){
				Logger.getLogger(JFLogin.class.getName()).log(Level.SEVERE, null, erro);
			}catch(IllegalAccessException erro){
				Logger.getLogger(JFLogin.class.getName()).log(Level.SEVERE, null, erro);
			}catch(UnsupportedLookAndFeelException erro){
				Logger.getLogger(JFLogin.class.getName()).log(Level.SEVERE, null, erro);
			}
		}catch(ClassNotFoundException erro){
			JOptionPane.showMessageDialog(null, "Classe não encontrada", "Classe não encontrada!",
					JOptionPane.ERROR_MESSAGE);
		}
		SwingUtilities.updateComponentTreeUI(this);
		this.setBackground(SystemColor.darkGray);

	}
}
