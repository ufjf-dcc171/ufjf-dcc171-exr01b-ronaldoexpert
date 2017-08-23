
package aula.swing.pkg02;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class JanelaForca extends JFrame{
    JLabel lblLetra = new JLabel("Digite uma Letra:");
    JTextField txtLetra = new JTextField(20);
    JButton btnSubmeter = new JButton("Submeter");
    JPasswordField txtPalavra = new JPasswordField("RONALDO");
    JLabel lblResult;
    JPanel painel = new JPanel();   
    int cont = 0;
    public JanelaForca() throws HeadlessException{
        super("JanelaForca");
        setLayout(new FlowLayout());
        painel.setLayout(new GridLayout(11, 1));
        
        painel.add(lblLetra);
        painel.add(txtLetra);
        painel.add(btnSubmeter);
        
        painel.add(txtPalavra);
        
        add(painel);
        
        btnSubmeter.addActionListener(new onClickBotao());       
        
    }
    
    private class onClickBotao implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {  
            if(e.getSource()==btnSubmeter){
                if (cont < 5){    
                    if (verificaLetra()){
                        JOptionPane.showMessageDialog(null, "Existe a palavra!", "Jogo Forca", JOptionPane.PLAIN_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Não existe a palavra!", "Jogo Forca", JOptionPane.PLAIN_MESSAGE);
                        cont ++;
                    }
                    txtLetra.setText("");
                    txtLetra.grabFocus();                    
                }else{
                    JOptionPane.showMessageDialog(null, "Voce excedeu o numero de tentativas!", "Jogo Forca", JOptionPane.PLAIN_MESSAGE);
                    dispose();
                }                    
            }
                
        }
    }
    
    private boolean verificaLetra(){
        boolean retorno = false;
        String palavra = txtPalavra.getText();
        int i;
        Character letra;
        for (i = 0; i < palavra.length(); i++){
            if (txtLetra.equals(palavra.charAt(i) + "")){
                retorno = true;
            }else{
                retorno = false;
            }
        }
        return retorno;
    }
}
