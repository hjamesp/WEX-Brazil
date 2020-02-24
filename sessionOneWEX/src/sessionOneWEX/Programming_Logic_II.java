/*#2 - Write a program that will sum all digits of a integer */

package sessionOneWEX;

import javax.swing.JOptionPane;
 
public class Programming_Logic_II {

	public static void main(String[] args) {
		
		Integer sum = 0;
		
		char[] number = JOptionPane.showInputDialog("Type a number:").toCharArray();
		
		for (char value : number) {
			sum = sum + Character.getNumericValue(value);
		}
		JOptionPane.showInternalMessageDialog(null, "The sum of all digits is:   " + sum);
	}

}
