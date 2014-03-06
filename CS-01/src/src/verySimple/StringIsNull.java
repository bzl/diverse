package src.verySimple;

import javax.swing.JOptionPane;

public class StringIsNull {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        String myName;
        int checker;
        myName = JOptionPane.showInputDialog("Please enter your name");
        System.out.println(myName);
        checker = JOptionPane.showConfirmDialog(null, "Are you sure your name is: "+ myName);
       if (myName == ""){
                JOptionPane.showMessageDialog(null, "No name entered", "Error", JOptionPane.ERROR_MESSAGE);
       }
              if(checker == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "please start again and enter your proper name","work bitch",JOptionPane.INFORMATION_MESSAGE);
        }else{
        JOptionPane.showMessageDialog(null, "Your name is: " + myName);
        }

	}

}
