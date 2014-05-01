package matrix;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Row extends JFrame implements Runnable{
	private static final long serialVersionUID = -1466778671683272811L;
	private JLabel text;
	private String sourceText;
	private int increment = 0;
	private String displayText;

	public Row(String display, int hight, int startPosX, int width) {
		super("simpleRow");
		sourceText = display;
		displayText = "";
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, hight);
		setBackground(new Color(0, 0, 0, 0));

		//		JLabel text = new JLabel("<HTML>" +
		//				"<center><font size=\"5\">@"+tweetFrom+"</font></center><br>" +
		//				"<center><font size=\"3\">"+tweet+"</font></center>" +
		//				"</HTML>");

		//		String displayText = "";
		//		displayText = display.charAt(display.length()-1)+"\n";

		text = new JLabel("");

		text.setHorizontalAlignment	( SwingConstants.CENTER );
		text.setVerticalAlignment	( SwingConstants.TOP );
		getContentPane().add(text);

		//Sets the frames location
		setLocation(startPosX, 0);

		//Sets the frame on top of current application, but does NOT steal focus.
		setFocusable(false);
		toFront();
		setAlwaysOnTop(true);

		setVisible(true);
		
		

	}

	public void tick() {

		displayText = displayText+sourceText.charAt(increment)+"<br>";
		text = new JLabel("<html><center><font size=\"6\" color=\"green\">"+displayText+"</font></center></html>");
		text.setHorizontalAlignment	( SwingConstants.CENTER );
		text.setVerticalAlignment	( SwingConstants.TOP );

		increment++;
		increment = increment % sourceText.length();
		//System.out.println(displayText);//only has debug properties
		getContentPane().removeAll();
		getContentPane().add(text);
		validate();
	}

	/*
	 * Dette funker ikke akkurat nå. Fjern det?
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		do {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tick();
		} while (true);



	}
}