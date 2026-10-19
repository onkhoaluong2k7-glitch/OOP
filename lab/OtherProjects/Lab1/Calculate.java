
import javax.swing.JOptionPane;


public class Calculate {

   public static void main(String[] args) {
        String sn1, sn2;
        sn1 = JOptionPane.showInputDialog(null, 
            "Please input the first number: ", "Input the first number",
            JOptionPane.INFORMATION_MESSAGE);
        sn2 = JOptionPane.showInputDialog(null, 
            "Please input the second number: ", "Input the second number",
            JOptionPane.INFORMATION_MESSAGE);
        double s1 = Double.parseDouble(sn1);
        double s2 = Double.parseDouble(sn2);
        double result = s1+s2;
        JOptionPane.showMessageDialog(null, "Plus: "+result);
        
        JOptionPane.showMessageDialog(null, "Minus: "+(s1-s2));
        
        JOptionPane.showMessageDialog(null, "Multi: "+ s1*s2);
        
        if (s2 != 0) JOptionPane.showMessageDialog(null, "Div: "+ s1/s2);
        System.exit(0);
   }
}
