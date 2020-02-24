/*#1 - Write a program that will print “Cira” for numbers that are divisible by 3, 
 * print “Dinha” for number that contains “5” in it and print “CiraDinha” when the 
 * number is divisible by 3 and contains 5 in it.
 */

package sessionOneWEX;

import javax.swing.JOptionPane;

public class Programming_Logic_I {
	 /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      	
        Long number;
        String parameter;
        boolean containsFive = false;
 
        number = Long.parseLong(JOptionPane.showInputDialog("TYPE A NUMBER: "));
        parameter = Long.toString(number);
        
        for (int i = 0; i < parameter.length(); i++) {
        	if(parameter.charAt(i) == '5') {
        		containsFive = true;
        		break;
        	}
		}
        if(number % 3 == 0 && containsFive == true){
      	  JOptionPane.showInternalMessageDialog(null, "CiraDinha");
        }
        else if(number % 3 == 0){
            JOptionPane.showInternalMessageDialog(null, "Cira");
        }  
        else if(containsFive) {
        	  JOptionPane.showInternalMessageDialog(null, "Dinha");
        } 
        else
        	JOptionPane.showInternalMessageDialog(null, "The number typed it's not divisible by 3 and don't contains 5 in it.");
    }
}