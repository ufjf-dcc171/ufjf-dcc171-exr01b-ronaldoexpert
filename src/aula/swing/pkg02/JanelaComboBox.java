package aula.swing.pkg02;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class JanelaComboBox extends JFrame{
    private final JPanel painel = new JPanel(); 
    private final JComboBox<String> cbPao;
    private final JComboBox<String> cbRecheio;
    private final JComboBox<String> cbQueijo;
    private final JCheckBox chkBacon = new JCheckBox("Bacon");
    private final JCheckBox chkTomate = new JCheckBox("Tomate");
    private final JTextField txtPedido = new JTextField(25);
    private final JLabel lblPao = new JLabel("* Pão *");
    private final JLabel lblRecheio = new JLabel("* Recheio *");
    private final JLabel lblQueijo = new JLabel("* Queijo *");
    
    public JanelaComboBox() throws HeadlessException{
        super("JanelaComboBox");
        setLayout(new FlowLayout());
        painel.setLayout(new GridLayout(11, 1));
        
        String[] paes = {"Italiano", "Parmezão", "Três Queijos"};
        String[] recheios = {"Carne", "Frango", "Atum", "Presunto"};
        String[] queijos = {"Suíço", "Prato", "Cheddar", "Sem Queijo"};
        
        cbPao = new JComboBox<>(paes);
        painel.add(lblPao);
        painel.add(cbPao);
        
        cbRecheio = new JComboBox<>(recheios);
        painel.add(lblRecheio);
        painel.add(cbRecheio);
        
        cbQueijo = new JComboBox<>(queijos);
        painel.add(lblQueijo);
        painel.add(cbQueijo);
        
        painel.add(chkBacon);
        painel.add(chkTomate);
        txtPedido.setEditable(false);
        painel.add(txtPedido);
        
        add(painel);
        
        
        
        cbPao.addItemListener(new MontaSanduba());
        cbRecheio.addItemListener(new MontaSanduba());
        cbQueijo.addItemListener(new MontaSanduba());
        chkBacon.addItemListener(new MontaSanduba());
        chkTomate.addItemListener(new MontaSanduba());
        cbPao.setSelectedIndex(1);

    }
    
    private class MontaSanduba implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            StringBuilder sb = new StringBuilder();
            
            sb.append((String) cbPao.getSelectedItem());
            sb.append(" ");
            sb.append((String) cbRecheio.getSelectedItem());
            sb.append(" ");
            sb.append((String) cbQueijo.getSelectedItem());
            sb.append(chkBacon.isSelected()?" Bacon":"");
            sb.append(chkTomate.isSelected()?" Tomate":"");
            txtPedido.setText(sb.toString());
        }
    }
    
}
