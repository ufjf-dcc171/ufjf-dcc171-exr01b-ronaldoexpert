package aula.swing.pkg02;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class JanelaLista extends JFrame {
    private final JLabel lblNome = new JLabel("Nome");
    private final JLabel lblIdade = new JLabel("Idade");
    private final JTextField txtNome = new JTextField("", 20);
    private final JTextField txtIdade = new JTextField("", 20);
    private final JButton btnExcluir = new JButton("Excluir");
    private final JButton btnAdd = new JButton("Adicionar");
    private final JList lstLista = new JList(new DefaultListModel());
    private final DefaultListModel modelo = (DefaultListModel) lstLista.getModel();
    
    public JanelaLista() throws HeadlessException{
        super("JanelaLista");
        setLayout(new BorderLayout(5,5));
        
        JPanel pnlNorth = new JPanel(new BorderLayout(5, 5));
        JPanel pnlBotoes = new JPanel(new BorderLayout(5, 5));
        JPanel pnlLista = new JPanel(new BorderLayout(5, 5));
        JPanel pnlIdade = new JPanel(new BorderLayout(5, 5));
        JPanel pnlNome = new JPanel(new BorderLayout(5, 5));
        
        pnlNome.add(lblNome, BorderLayout.NORTH);
        pnlNome.add(txtNome, BorderLayout.SOUTH);
        
        pnlIdade.add(lblIdade, BorderLayout.NORTH);
        pnlIdade.add(txtIdade, BorderLayout.SOUTH);
        
        pnlNorth.add(pnlNome, BorderLayout.NORTH);
        pnlNorth.add(pnlIdade, BorderLayout.SOUTH);
        
        add(pnlNorth, BorderLayout.NORTH);
        
        pnlBotoes.add(btnAdd, BorderLayout.NORTH);
        pnlBotoes.add(btnExcluir, BorderLayout.SOUTH);
        add(pnlBotoes, BorderLayout.CENTER);
        
        pnlLista.add(new JScrollPane(lstLista), BorderLayout.SOUTH);
        add(pnlLista, BorderLayout.SOUTH);
        
        lstLista.setVisibleRowCount(10);
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Ação enter no textfield para adicionar na lista
        btnAdd.addActionListener(new onClickBotao());
       
        //Ação no botão para excluir elemento
        btnExcluir.addActionListener(new onClickBotao()); 
    }  
    
    private class onClickBotao implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {  
            if(e.getSource()==btnExcluir){
                for(Object o: lstLista.getSelectedValuesList()){
                    System.out.println(o);
                    modelo.removeElement(o);
                }
            }else if(e.getSource()==btnAdd){
                Pessoa p = new Pessoa(txtNome.getText(), Integer.parseInt(txtIdade.getText()));
                modelo.addElement(p.toString());
                txtNome.setText("");
                txtIdade.setText("");
                txtNome.grabFocus();
            }
                
        }
    }
}
