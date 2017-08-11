package aula.swing.pkg02;

import javax.swing.JOptionPane;

public class AulaSwing02 {

    public static void main(String[] args) {
        String largura, altura, comprimento;
        double volume = 0.0;
        
        largura = JOptionPane.showInputDialog("Digite a largura: ");
        altura = JOptionPane.showInputDialog("Digite a altura: ");
        comprimento = JOptionPane.showInputDialog("Digite a comprimento: ");
        
        volume = Double.parseDouble(largura) * Double.parseDouble(altura) * Double.parseDouble(comprimento);
        
        
        JOptionPane.showMessageDialog(null, "O volume é : " + volume,
                "Volume", JOptionPane.PLAIN_MESSAGE);
    
    }
    
}
