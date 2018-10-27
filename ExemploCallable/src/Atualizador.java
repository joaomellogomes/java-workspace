//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.FutureTask;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JProgressBar;
//import javax.swing.SwingUtilities;
//public class Atualizador implements Callable<Void> {
//	public Atualizador(JProgressBar prb) {
//		this.prb = prb;
//	}
//	@Override
//	public Void call() throws Exception {
//		while (true) {
//			SwingUtilities.invokeLater(new Runnable() {
//				public void run() {
//					prb.setValue(val++);
//				}
//			});
//			if (val >= 100)
//				val = 0;
//			Thread.sleep(100);
//		}
//	}
//	private JProgressBar prb;
//	private int val = 0;
//}
