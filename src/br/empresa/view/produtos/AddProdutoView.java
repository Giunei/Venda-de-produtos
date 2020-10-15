package br.empresa.view.produtos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.empresa.enumered.Categoria;
import br.empresa.model.Empresa;
import br.empresa.model.Produto;

public class AddProdutoView extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTF;
	private JTextField valorCompraTF;
	private JTextField valorVendaTF;
	private JTextField quantidadeTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProdutoView frame = new AddProdutoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddProdutoView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 764, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 51));
		contentPane.setForeground(new Color(218, 165, 32));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 51));
		panel.setForeground(new Color(218, 165, 32));
		panel.setBounds(10, 11, 728, 399);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adicionar Produtos");
		lblNewLabel.setForeground(new Color(255, 255, 224));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(181, 11, 358, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(30, 103, 163, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Valor de compra");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1_1.setBounds(30, 145, 205, 31);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Valor de venda");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1_2.setBounds(30, 187, 163, 31);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Quantidade");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1_2_1.setBounds(30, 229, 163, 31);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Categoria");
		lblNewLabel_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1_2_2.setBounds(30, 271, 163, 31);
		panel.add(lblNewLabel_1_2_2);
		
		nomeTF = new JTextField();
		nomeTF.setBounds(251, 103, 163, 31);
		panel.add(nomeTF);
		nomeTF.setColumns(10);
		
		valorCompraTF = new JTextField();
		valorCompraTF.setColumns(10);
		valorCompraTF.setBounds(251, 145, 163, 31);
		panel.add(valorCompraTF);
		
		valorVendaTF = new JTextField();
		valorVendaTF.setColumns(10);
		valorVendaTF.setBounds(251, 187, 163, 31);
		panel.add(valorVendaTF);
		
		quantidadeTF = new JTextField();
		quantidadeTF.setColumns(10);
		quantidadeTF.setBounds(251, 234, 163, 31);
		panel.add(quantidadeTF);
		
		JComboBox categoriaCB = new JComboBox();
		categoriaCB.setModel(new DefaultComboBoxModel(new String[] {"ELETRODOMESTICOS", "CELULARES", "TV", "INFORMATICA", "ELETROPORTATEIS", "OUTRO"}));
		categoriaCB.setBounds(251, 276, 163, 31);
		panel.add(categoriaCB);
		
		JTextArea retornoTA = new JTextArea();
		retornoTA.setEditable(false);
		retornoTA.setBounds(466, 103, 239, 286);
		panel.add(retornoTA);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO SALVAR
              Empresa empresa = new Empresa();
              String nome = nomeTF.getText();
              Double valorCompra = Double.parseDouble(valorCompraTF.getText());
              Double valorVenda = Double.parseDouble(valorVendaTF.getText());
              int quantidade = Integer.parseInt(quantidadeTF.getText());
              Categoria categoria = Categoria.values()[categoriaCB.getSelectedIndex()];
              
              Produto p = new Produto(nome, categoria, valorCompra, valorVenda, quantidade);
              empresa.addProdutos(p);
              retornoTA.setText(empresa.retornoResultadosProdutos());
              p.incrementar();
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSalvar.setBounds(304, 358, 110, 31);
		panel.add(btnSalvar);
	}
	
	
}
