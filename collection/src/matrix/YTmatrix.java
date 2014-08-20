package matrix;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class YTmatrix extends JPanel{

	int x = 10;
	int y = 10;
	int i;

	int col;
	int green = 100;

	double random;
	double random1;

	int num;
	int num1;

	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

	//kan bugge, demo bruker .width, jeg bruker .getWidth()
	//	int width = (int) screensize.getWidth();
	//	int hight = (int) screensize.getHeight();

	int width = (int) screensize.width;
	int hight = (int) screensize.height;

	JFrame top = new JFrame("Matrix");

	//	String[] array = new String[50];
	//String[] array = new String[]{" ", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	char[] array = "  0123456789".toCharArray();

	public YTmatrix() {

		//		array[0] = " ";
		//		array[1] = " ";
		//		array[2] = "0";
		//		array[3] = "1";
		//		array[4] = "2";
		//		array[5] = "3";
		//		array[6] = "4";
		//		array[7] = "5";
		//		array[8] = "6";
		//		array[9] = "7";
		//		array[10] = "8";
		//		array[11] = "9";

		top.setUndecorated(true);
		top.setSize(hight, width);
		top.getContentPane().setBackground(Color.black);
		top.setLayout(null);
		top.setVisible(true);
		top.addKeyListener(new ButtonClick());
		top.add(this);
		setBounds(1,1,999,799);

	}


	public void paint(Graphics g){

		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.setBounds(1, 1, hight-1, width-1);

		top.repaint();

		for (int i = 1; i < width; i+=25) {


			for (int j = 1; j < hight; j+=15) {


				random = Math.round(Math.random()*11);
				num = (int)random;

				random1 = Math.round(Math.random()*3);
				num1 = (int)random1;

				switch (num1) {
				case 0:
					col = 255;
					green = 255;
					break;
				case 1:
					col = 0;
					green = 150;
					break;
				case 2:
					col = 0;
					green = 200;
					break;

				default:
					col = 0;
					green = 255;
					break;
				}

				g.setColor(new Color(col, green, col));
				g.drawString(""+array[num], i,j);
			}
			green = 150;
		}
		for (int i = 0; i < 60000; i++) {
			repaint();
		}
	}

	public static void main(String[] args){
		new YTmatrix();
	}
}