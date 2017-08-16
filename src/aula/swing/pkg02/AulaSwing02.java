package aula.swing.pkg02;

import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AulaSwing02 {

    public static void main(String[] args) {
        JanelaPrincipal janela = new JanelaPrincipal();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(400, 300);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.setTitle("Principal");    
    }    
}
