import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class ExemploCallable extends JFrame {
	
	
	private JPanel jContentPane = null;
	private JPanel pnlBotoes = null;
	private JButton btnIniciar = null;
	private JButton btnParar = null;
	private JProgressBar prbProgresso = null;
	private ExecutorService executor;
	private FutureTask<Void> future;
	
	private JPanel getPnlBotoes() {
		if (pnlBotoes == null) {
			pnlBotoes = new JPanel();
			pnlBotoes.setLayout(new FlowLayout());
			pnlBotoes.add(getBtnIniciar(), null);
			pnlBotoes.add(getBtnParar(), null);
		}
		return pnlBotoes;
	}
	
	private JButton getBtnIniciar() {
		if (btnIniciar == null) {
			btnIniciar = new JButton();
			btnIniciar.setText("Iniciar!");
			btnIniciar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					btnIniciar.setEnabled(false);
					future = new FutureTask<Void>(new Atualizador(prbProgresso));
					executor.execute(future);
					btnParar.setEnabled(true);
				}
			});
		}
		return btnIniciar;
	}
	
	private JButton getBtnParar() {
		if (btnParar == null) {
			btnParar = new JButton();
			btnParar.setEnabled(false);
			btnParar.setText("Parar!");
			btnParar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					btnParar.setEnabled(false);
					future.cancel(true);
					btnIniciar.setEnabled(true);
				}
			});
		}
		return btnParar;
	}
	
	private JProgressBar getPrbProgresso() {
		if (prbProgresso == null) {
			prbProgresso = new JProgressBar();
			prbProgresso.setStringPainted(true);
		}
		return prbProgresso;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ExemploCallable thisClass = new ExemploCallable();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setLocationRelativeTo(null);
				thisClass.setVisible(true);
			}
		});
	}
	
	public ExemploCallable() {
		super();
		initialize();
		executor = Executors.newCachedThreadPool();
	}
	
	private void initialize() {
		this.setSize(300, 111);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Exemplo Callable");
	}
	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getPnlBotoes(), BorderLayout.SOUTH);
			jContentPane.add(getPrbProgresso(), BorderLayout.CENTER);
		}
		return jContentPane;
	}
	
}


class Atualizador implements Callable<Void> {
	public Atualizador(JProgressBar prb) {
		this.prb = prb;
	}
	@Override
	public Void call() throws Exception {
		while (true) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					prb.setValue(val++);
				}
			});
			if (val >= 100)
				val = 0;
			Thread.sleep(100);
		}
	}
	private JProgressBar prb;
	private int val = 0;
}
