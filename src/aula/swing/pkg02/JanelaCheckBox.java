package aula.swing.pkg02;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class JanelaCheckBox extends JFrame{
    private final JPanel painel = new JPanel();
    private final JTextField txtValorProduto = new JTextField();
    private final JTextField txtValorFinal = new JTextField();
    private final JTextField txtValorDolar = new JTextField();
    private final JCheckBox chkTributado = new JCheckBox("Tributado (+60%)");
    private final JCheckBox chkICMS = new JCheckBox("ICMS (+18%)");
    private final JLabel lblVlrDolar = new JLabel("Cotação Dolar");
    private final JLabel lblVlrReal = new JLabel("vlr Produto em R$");
    private final JLabel lblVlrTotal = new JLabel("Vlr Total do Produto");
    private final JButton btnCalcular = new JButton("Calcular");
    
    public JanelaCheckBox() throws HeadlessException{
        super("JanelaCheckBox");
        setLayout(new FlowLayout());
        painel.setLayout(new GridLayout(18, 1));
        
        painel.add(lblVlrDolar);
        painel.add(txtValorDolar);
        
        painel.add(lblVlrReal);
        painel.add(txtValorProduto);
        
        painel.add(chkICMS);
        painel.add(chkTributado);
        
        painel.add(btnCalcular);
        
        painel.add(lblVlrTotal);
        painel.add(txtValorFinal);
        
        btnCalcular.addActionListener(new btnCalcularOnClick());
        
        txtValorFinal.setEditable(false);
        add(painel);
    }
    
    private class btnCalcularOnClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnCalcular){
                double vlrProdutoReal = Double.parseDouble(txtValorDolar.getText()) * Double.parseDouble(txtValorProduto.getText());
                double vlrTotal = vlrProdutoReal;                              
                                
                if ((chkICMS.isSelected()) && (chkTributado.isSelected())) {
                    vlrTotal = vlrTotal + (vlrProdutoReal * 0.60) + (vlrProdutoReal * 0.18);

                } else if (chkICMS.isSelected()) {
                    vlrTotal = vlrTotal + (vlrProdutoReal * 0.18);

                } else if (chkTributado.isSelected()) {
                    vlrTotal = vlrTotal + (vlrProdutoReal * 0.60);

                }else{
                    vlrTotal = vlrProdutoReal;
                }
                txtValorFinal.setText(vlrTotal + "");    
            }            
        }
    }
        
}
