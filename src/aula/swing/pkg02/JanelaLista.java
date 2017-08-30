package aula.swing.pkg02;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
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
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

public class JanelaLista extends JFrame {
    private final JLabel lblNome = new JLabel("Nome");
    private final JLabel lblIdade = new JLabel("Idade");
    private final JTextField txtNome = new JTextField("", 20);
    private final JTextField txtIdade = new JTextField("", 10);
    private final JButton btnExcluir = new JButton("Excluir");
    private final JButton btnAdd = new JButton("Adicionar");
    private final JList lstLista = new JList(new DefaultListModel());
    private final DefaultListModel modelo = (DefaultListModel) lstLista.getModel();
    
    private int indexSelected;      //Index do elemento selecionado
    private String status = "Novo"; //Variavel para saber se esta editando ou não
    
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
        
        
        lstLista.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                String item;
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    // Double-click detected
                    item = "" + lstLista.getSelectedValue();
                    String[] itemS = item.split(Pattern.quote(" - "));
                    
                    txtNome.setText("" + itemS[0]);
                    txtIdade.setText("" + itemS[1]);
                    indexSelected = lstLista.getSelectedIndex();
                    status = "Update";
                }
            }
        });
        
        
    }  
    public boolean validaCampos(){
        Boolean retorno = true;
        
        if ("".equals(txtNome.getText())){
            JOptionPane.showMessageDialog(null, "Informe o nome.", "Lista", JOptionPane.PLAIN_MESSAGE);
            txtNome.grabFocus();
            retorno = false;
        }                

        if ("".equals(txtIdade.getText())){
            JOptionPane.showMessageDialog(null, "Informe a idade.", "Lista", JOptionPane.PLAIN_MESSAGE);
            txtIdade.grabFocus();
            retorno = false;
        }        
        
        return retorno;
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
                if (validaCampos() == true){
                    Pessoa p = new Pessoa(txtNome.getText(), Integer.parseInt(txtIdade.getText()));

                    if (status == "Novo"){
                        modelo.addElement(p.toString());                    
                    }else{
                        modelo.setElementAt(p.toString(), indexSelected);
                        status = "Novo";
                    }

                    txtNome.setText("");
                    txtIdade.setText("");
                    txtNome.grabFocus();    
                }
            }
        }
    }
}
