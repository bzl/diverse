import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Robot;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class vindu {
	ChangeListener listener;
	JTextPane displayText;
	int secondsBetweenJump;

	private JFrame frame;

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
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Start Jumping");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setState(Frame.ICONIFIED);

				long sleepTime = secondsBetweenJump*1000;
				try {
					//wait before first execution to allow user to enter app
					Thread.sleep(15000);
					Robot robot = new Robot();

					while(true){

						Thread.sleep(sleepTime);

						int keyPress = (int) (Math.random()*7);

						switch (keyPress) {

						case 1:
							robot.keyPress(KeyEvent.VK_W);
							robot.keyRelease(KeyEvent.VK_W);
							break;
						case 2:
							robot.keyPress(KeyEvent.VK_A);
							robot.keyRelease(KeyEvent.VK_A);
							break;
						case 3:
							robot.keyPress(KeyEvent.VK_S);
							robot.keyRelease(KeyEvent.VK_S);
							break;
						case 4:
							robot.keyPress(KeyEvent.VK_D);
							robot.keyRelease(KeyEvent.VK_D);
							break;

						default:
							robot.keyPress(KeyEvent.VK_SPACE);
							robot.keyRelease(KeyEvent.VK_SPACE);
							break;
						}
					}
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBounds(10, 198, 376, 52);
		frame.getContentPane().add(btnNewButton);

		JSlider slider = new JSlider();
		slider.setBackground(Color.RED);
		slider.setForeground(Color.CYAN);
		slider.setValue(120);
		slider.setMajorTickSpacing(30);
		slider.setMaximum(300);
		slider.setMinimum(30);
		slider.setMinorTickSpacing(3);
		slider.setBounds(10, 85, 376, 40);
		slider.addChangeListener(listener);
		frame.getContentPane().add(slider);





		displayText = new JTextPane();
		displayText.setBackground(new Color(255, 20, 147));
		displayText.setForeground(new Color(0, 0, 0));
		displayText.setEditable(false);
		displayText.setText("Seconds between each jump: 30");
		displayText.setBounds(10, 11, 376, 26);
		frame.getContentPane().add(displayText);
	}
}
