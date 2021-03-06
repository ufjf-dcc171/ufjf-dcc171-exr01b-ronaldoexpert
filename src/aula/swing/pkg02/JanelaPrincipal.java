
package aula.swing.pkg02;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JanelaPrincipal extends JFrame{
    JButton btnAbrirBaskara = new JButton("Formula de Baskara");
    JButton btnAbrirForca = new JButton("Jogo da Forca");
    JButton btnAbrirCheckBox = new JButton("EXR5) Valor do produto em dolar");
    JButton btnAbrirRadioButton = new JButton("EXR2) Jogo Pedra/Papel/Tesoura");
    JButton btnAbrirComboBox = new JButton("Exemplo ComboBox");
    JButton btnAbrirLista = new JButton("Lista Pessoa");
    
    public JanelaPrincipal() throws HeadlessException{
        super("JanelaPrincipal");
        
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        
        add(btnAbrirBaskara);
        add(btnAbrirForca);
        add(btnAbrirCheckBox);
        add(btnAbrirRadioButton);
        add(btnAbrirComboBox);
        add(btnAbrirLista);
        
        btnAbrirBaskara.addActionListener(new onClickBotao());
        btnAbrirForca.addActionListener(new onClickBotao());
        btnAbrirCheckBox.addActionListener(new onClickBotao());
        btnAbrirRadioButton.addActionListener(new onClickBotao());
        btnAbrirComboBox.addActionListener(new onClickBotao());
        btnAbrirLista.addActionListener(new onClickBotao());
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
                
            }else if (e.getSource()==btnAbrirCheckBox){
                JanelaCheckBox janela2 = new JanelaCheckBox();
                janela2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                janela2.setSize(400, 400);
                janela2.setLocationRelativeTo(null);
                janela2.setVisible(true);
                janela2.setTitle("Teste CheckBox");
                
            }else if (e.getSource()==btnAbrirRadioButton){
                JanelaRadioButton janela2 = new JanelaRadioButton();
                janela2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                janela2.setSize(400, 400);
                janela2.setLocationRelativeTo(null);
                janela2.setVisible(true);
                janela2.setTitle("Teste RadioButton");
            
            }else if (e.getSource()==btnAbrirComboBox){
                JanelaComboBox janela2 = new JanelaComboBox();
                janela2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                janela2.setSize(400, 400);
                janela2.setLocationRelativeTo(null);
                janela2.setVisible(true);
                janela2.setTitle("Teste ComboBox");
            
            }else if (e.getSource()==btnAbrirLista){
                JanelaLista janela2 = new JanelaLista();
                janela2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                janela2.setSize(200, 400);
                janela2.setLocationRelativeTo(null);
                janela2.setVisible(true);
                janela2.setTitle("Teste Lista");
            }    
        }
    }
    
    
}
