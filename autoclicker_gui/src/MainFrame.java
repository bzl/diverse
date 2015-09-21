import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

/**
 * Example code used for university course work.
 * 
 * @author Kristoffer Tverå (Bluekristoffer@gmail.com)
 */
public class MainFrame {

	private JFrame frame;
	private JTextField clickLow;
	private JTextField clickHigh;
	private JTextField jitterLow;
	private JTextField jitterHigh;
	private final Action action = new SwingAction();
	private boolean running;
	Thread clicker;
	private JButton startStop;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		running = false;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 378, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		clickLow = new JTextField();
		clickLow.setHorizontalAlignment(SwingConstants.CENTER);
		clickLow.setText("2500");
		clickLow.setBounds(10, 50, 140, 20);
		frame.getContentPane().add(clickLow);
		clickLow.setColumns(10);
		
		clickHigh = new JTextField();
		clickHigh.setHorizontalAlignment(SwingConstants.CENTER);
		clickHigh.setText("3000");
		clickHigh.setBounds(208, 50, 140, 20);
		frame.getContentPane().add(clickHigh);
		clickHigh.setColumns(10);
		
		jitterLow = new JTextField();
		jitterLow.setHorizontalAlignment(SwingConstants.CENTER);
		jitterLow.setText("25");
		jitterLow.setBounds(10, 129, 140, 20);
		frame.getContentPane().add(jitterLow);
		jitterLow.setColumns(10);
		
		jitterHigh = new JTextField();
		jitterHigh.setHorizontalAlignment(SwingConstants.CENTER);
		jitterHigh.setText("50");
		jitterHigh.setBounds(208, 129, 140, 20);
		frame.getContentPane().add(jitterHigh);
		jitterHigh.setColumns(10);
		
		startStop = new JButton("Start");
		startStop.setText("Start");
		startStop.setAction(action);
		startStop.setBounds(10, 183, 342, 67);
		frame.getContentPane().add(startStop);
		
		JLabel click_tooltip1 = new JLabel("min. time between clicks");
		click_tooltip1.setBounds(10, 30, 140, 14);
		frame.getContentPane().add(click_tooltip1);
		
		JLabel click_tooltip2 = new JLabel("max. time between clicks");
		click_tooltip2.setBounds(208, 30, 140, 14);
		frame.getContentPane().add(click_tooltip2);
		
		JLabel jitter_tooltip1 = new JLabel("min. time buttonDown");
		jitter_tooltip1.setBounds(10, 104, 140, 14);
		frame.getContentPane().add(jitter_tooltip1);
		
		JLabel jitter_tooltip2 = new JLabel("max. time buttonDown");
		jitter_tooltip2.setBounds(208, 104, 140, 14);
		frame.getContentPane().add(jitter_tooltip2);
	}
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5858044587180098844L;
		public SwingAction() {
			putValue(NAME, "Start");
			putValue(SHORT_DESCRIPTION, "Start or stop the autoclicker");
		}
		public void actionPerformed(ActionEvent e) {
			if(started()){
				stop();
			} else{
				start();
			}
			
		}
	}
	public void start() {
		this.running = true;
		clicker = new Thread(new Background(
				Integer.parseInt(jitterLow.getText()),
				Integer.parseInt(jitterHigh.getText()),
				Integer.parseInt(clickLow.getText()),
				Integer.parseInt(clickHigh.getText())
				));
		
		clicker.start();
		
		startStop.setText("Stop");
	}

	public boolean started() {
		return this.running;
	}

	@SuppressWarnings("deprecation")
	public void stop() {
		this.running = false;
		clicker.stop();
		startStop.setText("Start");
	}
}
