import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Kristoffer Tverå
 *
 */
public class vindu {
	ChangeListener listener;
	JTextPane displayText;
	int secondsBetweenJump;

	private JFrame frame;
	private JButton btnNewButton;
	boolean alive = true;
	Thread backgroundtask;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vindu window = new vindu();
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
	public vindu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		secondsBetweenJump = 30;

		//implements the listener to slider. copypaste from intranet
		listener = new ChangeListener()
		{
			public void stateChanged(ChangeEvent event)
			{
				// update text field when the slider value changes
				JSlider source = (JSlider) event.getSource();
				displayText.setText("Seconds between each jump: " + source.getValue());
				secondsBetweenJump = source.getValue();
			}
		};


		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 20, 147));
		frame.setBounds(100, 100, 411, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		frame.addWindowListener(new java.awt.event.WindowAdapter() {
//			public void windowClosing(WindowEvent winEvt) {
//				System.exit(0);
//			}
//		});
		
		frame.setResizable(false);


		
		btnNewButton = new JButton("Start anti-afk");
		btnNewButton.setBounds(10, 198, 376, 52);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("About to modify a thread");

				if (getStatus()) {
					btnNewButton.setText("Stop anti-afk");
					frame.setState(Frame.ICONIFIED);
					startThread();
					System.out.println("confirmed alive");
					swapStatus();
				} else {
					btnNewButton.setText("Start anti-afk");
					stopThread();
					backgroundtask.interrupt();
					System.out.println("confirmed dead");
					swapStatus();
				}
				
				System.out.println("basic button click routine complete");
			}

		});
		frame.getContentPane().setLayout(null);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 191, 255));
		frame.getContentPane().add(btnNewButton);

		JSlider slider = new JSlider();
		slider.setBounds(10, 85, 376, 40);
		slider.setBackground(Color.RED);
		slider.setForeground(Color.CYAN);
		slider.setValue(30);
		slider.setMajorTickSpacing(30);
		slider.setMaximum(300);
		slider.setMinimum(30);
		slider.setMinorTickSpacing(3);
		slider.addChangeListener(listener);
		frame.getContentPane().add(slider);

		displayText = new JTextPane();
		displayText.setBounds(10, 11, 376, 26);
		displayText.setBackground(new Color(255, 20, 147));
		displayText.setForeground(new Color(0, 0, 0));
		displayText.setEditable(false);
		displayText.setText("Seconds between each jump: 30");
		frame.getContentPane().add(displayText);
		
		JTextPane txtpnHeyBtw = new JTextPane();
		txtpnHeyBtw.setText("hey btw");
		txtpnHeyBtw.setForeground(Color.BLACK);
		txtpnHeyBtw.setEditable(false);
		txtpnHeyBtw.setBackground(new Color(255, 20, 147));
		txtpnHeyBtw.setBounds(23, 148, 53, 26);
		frame.getContentPane().add(txtpnHeyBtw);
		
		JTextPane txtpnAmarSyrreSimon = new JTextPane();
		txtpnAmarSyrreSimon.setText("amar&syrre&simon");
		txtpnAmarSyrreSimon.setForeground(Color.BLACK);
		txtpnAmarSyrreSimon.setEditable(false);
		txtpnAmarSyrreSimon.setBackground(new Color(255, 20, 147));
		txtpnAmarSyrreSimon.setBounds(110, 136, 125, 26);
		frame.getContentPane().add(txtpnAmarSyrreSimon);
		
		JTextPane txtpnIsHighlevelFagts = new JTextPane();
		txtpnIsHighlevelFagts.setText("iz highlevel fag0ts");
		txtpnIsHighlevelFagts.setForeground(Color.BLACK);
		txtpnIsHighlevelFagts.setEditable(false);
		txtpnIsHighlevelFagts.setBackground(new Color(255, 20, 147));
		txtpnIsHighlevelFagts.setBounds(245, 161, 141, 26);
		frame.getContentPane().add(txtpnIsHighlevelFagts);
	}

	protected void stopThread() {
		try {
			backgroundtask.interrupt();
		} catch (Exception e) {
			System.out.println("failed while trying to stop");
		}
	}

	protected void startThread() {
		backgroundtask = new Thread(new background(secondsBetweenJump));
		backgroundtask.start();
		
	}

	protected void swapStatus() {
		if(alive){
			alive=false;
		} else{
			alive=true;
		}
	}
	
	private boolean getStatus() {
		return alive;
	}
}
