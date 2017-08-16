
package aula.swing.pkg02;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
        

public class JanelaExercicio extends JFrame{
    JLabel lblA = new JLabel("A:");
    JTextField txtA = new JTextField(20);
    
    JLabel lblB = new JLabel("B:");
    JTextField txtB = new JTextField(20);
    
    JLabel lblC = new JLabel("C:");
    JTextField txtC = new JTextField(20);
    
    JPanel painel = new JPanel();
    
    
    JLabel lblRaiz1 = new JLabel("Raiz 1:");
    JTextField txtRaiz1 = new JTextField(20);
    
    JLabel lblRaiz2 = new JLabel("Raiz 2:");
    JTextField txtRaiz2 = new JTextField(20);
    
    JButton btnCalcular = new JButton("Calcular");
    
    public JanelaExercicio() throws HeadlessException{
        super("JanelaExercicio");
        setLayout(new FlowLayout());
        painel.setLayout(new GridLayout(11, 1));
        
        painel.add(lblA);
        painel.add(txtA);
        
        painel.add(lblB);
        painel.add(txtB);
        
        painel.add(lblC);
        painel.add(txtC);
        
        painel.add(btnCalcular);
        
        painel.add(lblRaiz1);
        painel.add(txtRaiz1);
        
        painel.add(lblRaiz2);
        painel.add(txtRaiz2);
        
        add(painel);
        
        btnCalcular.addActionListener(new btnCalcularonClick());
    }    
    
    private class btnCalcularonClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double raiz1 = 0;
            double raiz2 = 0;
            int NumA;
            int NumB;
            int NumC;
            double delta = 0;
            
            if(e.getSource()==btnCalcular){
                NumA = Integer.parseInt(txtA.getText());
                NumB = Integer.parseInt(txtB.getText());
                NumC = Integer.parseInt(txtC.getText());
                
                delta = (NumB*NumB)-4*(NumA)*(NumC);
                
                raiz1 = (-NumB + Math.sqrt(delta)) / (2*NumA);
                raiz2 = (-NumB - Math.sqrt(delta)) / (2*NumA);
                
                txtRaiz1.setText("" + raiz1);
                txtRaiz2.setText("" + raiz2);                
            }
        }
    }
}
