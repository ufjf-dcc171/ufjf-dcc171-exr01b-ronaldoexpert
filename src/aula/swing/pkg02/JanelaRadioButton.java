package aula.swing.pkg02;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JanelaRadioButton extends JFrame{
    private final JPanel painel = new JPanel();
    private final JRadioButton rbPedra = new JRadioButton("Pedra", false);
    private final JRadioButton rbPapel = new JRadioButton("Papel", false);;
    private final JRadioButton rbTesoura = new JRadioButton("Tesoura", false);;
    private final  ButtonGroup rgEstilo = new ButtonGroup();
    private final JButton btnSubmeter = new JButton("Submeter");
    private final JButton btnLimpar = new JButton("Limpar");
    private final JLabel lblTitulo = new JLabel("Jogo Pedra/Papel/Tesoura");
    private final JLabel lblMaquina = new JLabel("Maquina: ");
    private final JLabel lblUsuario = new JLabel("Jogador: ");
    private final JLabel lblEmpate = new JLabel("Empate: ");
    private final JLabel lblVitoria = new JLabel("");
    
    private int placarUsuario = 0;
    private int placarMaquina = 0;
    private int placarEmpate = 0;
    
    public JanelaRadioButton() throws HeadlessException{
        super("JanelaRadioButton");
        
        setLayout(new FlowLayout());        
        painel.setLayout(new GridLayout(11, 1));
        painel.add(lblTitulo);
        
        painel.add(rbPedra);
        painel.add(rbPapel);
        painel.add(rbTesoura);
        
        rgEstilo.add(rbPedra);
        rgEstilo.add(rbPapel);
        rgEstilo.add(rbTesoura);

        painel.add(btnSubmeter);
        
        painel.add(lblMaquina);
        painel.add(lblUsuario);
        painel.add(lblEmpate);
        
        painel.add(lblVitoria);
        
        painel.add(btnLimpar);
        add(painel);
        
        //Eventos botão
        btnSubmeter.addActionListener(new btnOnClick());
        btnLimpar.addActionListener(new btnOnClick());	
    }
    
    private class btnOnClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnSubmeter){
                Random numMaquina = new Random();
                
                int escolhaUsuario = 0;
                int escolhaMaquina = 0;                
                
                if (rbPedra.isSelected()){
                    escolhaUsuario = 1;
                }else if (rbPapel.isSelected()){
                    escolhaUsuario = 2;
                }else if (rbTesoura.isSelected()){
                    escolhaUsuario = 3;
                }else{
                    JOptionPane.showMessageDialog(null, "Selecione uma opção!", "Jogo Pedra/Papel/Tesoura", JOptionPane.PLAIN_MESSAGE);
                }
                
                if (escolhaUsuario > 0){
                    escolhaMaquina = numMaquina.nextInt(3);
                    while (escolhaMaquina == 0){
                        escolhaMaquina = numMaquina.nextInt(3);
                    }
                    
                    if ((escolhaMaquina == 1) && (escolhaUsuario == 2)){ //PEDRA PERDE PRA PAPEL
                        lblVitoria.setText("*** Vitoria do usuário! ***");
                        placarUsuario++;
                        
                    }else if ((escolhaMaquina == 1) && (escolhaUsuario == 3)){  //PEDRA GANHA DA TESOURA
                        lblVitoria.setText("*** Vitoria da máquina! ***");
                        placarMaquina++;
                        
                    }else if ((escolhaMaquina == 2) && (escolhaUsuario == 1)){  //PAPEL GANHA DE PEDRA
                        lblVitoria.setText("*** Vitoria da máquina! ***");
                        placarMaquina++;
                        
                    }else if ((escolhaMaquina == 2) && (escolhaUsuario == 3)){  //PAPEL PERDE PRA TESOURA
                        lblVitoria.setText("*** Vitoria do usuário! ***");
                        placarUsuario++;
                        
                    }else if ((escolhaMaquina == 3) && (escolhaUsuario == 1)){  //TESOURA PERDE PARA PEDRA
                        lblVitoria.setText("*** Vitoria do usuário! ***");
                        placarUsuario++;
                        
                    }else if ((escolhaMaquina == 3) && (escolhaUsuario == 2)){  //TESOURA GANHE DE PAPEL
                        lblVitoria.setText("*** Vitoria da máquina! ***");
                        placarMaquina++;
                    }else{
                        lblVitoria.setText("*** Empate! ***");
                        placarEmpate++;
                    }
                }
                
                lblMaquina.setText("Maquina: " + placarMaquina);
                lblUsuario.setText("Jogador: " + placarUsuario);
                lblEmpate.setText("Empate: " + placarEmpate);
            }            
        }
    }
}

/*
    **** ESCOLHAS *****
    1 - PEDRA
    2 - PAPEL
    3 - TESOURA
*/