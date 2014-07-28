package matrix;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

class ButtonClick extends KeyAdapter{

	public void keyPressed(KeyEvent ke){

		switch (ke.getKeyCode()) {
		case KeyEvent.VK_ALT:
			JOptionPane.showMessageDialog(null, "alt clicked");
			break;

		default:
			break;
		}
	}
}
