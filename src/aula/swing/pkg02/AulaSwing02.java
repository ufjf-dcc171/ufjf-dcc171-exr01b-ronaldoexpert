package aula.swing.pkg02;

import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AulaSwing02 {

    public static void main(String[] args) {
        JanelaExercicio janela = new JanelaExercicio();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(400, 500);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.setTitle("Equacao Segundo Grau");    
    }    
}
