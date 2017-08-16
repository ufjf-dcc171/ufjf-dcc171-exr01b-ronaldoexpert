
package aula.swing.pkg02;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JanelaPrincipal extends JFrame{
    JButton btnAbrirBaskara = new JButton("Formula de Baskara");
    JButton btnAbrirForca = new JButton("Abrir Forca");
    
    public JanelaPrincipal() throws HeadlessException{
        super("JanelaPrincipal");
        
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        
        add(btnAbrirBaskara);
        add(btnAbrirForca);
        btnAbrirBaskara.addActionListener(new onClickBotao());
        btnAbrirForca.addActionListener(new onClickBotao());
    }

    private class onClickBotao implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnAbrirBaskara){
                JanelaExercicio janela = new JanelaExercicio();
                janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                janela.setSize(400, 400);
                janela.setLocationRelativeTo(null);
                janela.setVisible(true);
                janela.setTitle("Equacao Segundo Grau"); 
                
            }else if (e.getSource()==btnAbrirForca){
                JanelaForca janela2 = new JanelaForca();
                janela2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                janela2.setSize(400, 400);
                janela2.setLocationRelativeTo(null);
                janela2.setVisible(true);
                janela2.setTitle("Jogo da Forca");
            }
                
        }
    }
    
    
}
