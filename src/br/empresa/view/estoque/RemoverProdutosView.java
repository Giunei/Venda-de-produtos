package br.empresa.view.estoque;

import java.awt.BorderLayout;
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
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.empresa.model.Empresa;
import br.empresa.model.Estoque;
import javax.swing.SpinnerNumberModel;

public class RemoverProdutosView extends JFrame {

	private JPanel contentPane;
	private static Empresa empresa = new Empresa();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverProdutosView frame = new RemoverProdutosView();
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
	public RemoverProdutosView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 652, 328);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 51, 153));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Retirar Produtos");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(215, 11, 229, 46);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 51, 153));
		panel.setBounds(10, 78, 616, 197);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Produto:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 33, 94, 29);
		panel.add(lblNewLabel_1);
		
		//TODO Produtos ComboBox
		JComboBox produtoCB = new JComboBox();
		produtoCB.setModel(new DefaultComboBoxModel(empresa.produtosComboBox()));
		produtoCB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		produtoCB.setBounds(151, 36, 185, 29);
		panel.add(produtoCB);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantidade:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 85, 116, 29);
		panel.add(lblNewLabel_1_1);
		
		JSpinner quantidadeSp = new JSpinner();
		quantidadeSp.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		quantidadeSp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		quantidadeSp.setBounds(151, 87, 74, 31);
		panel.add(quantidadeSp);
		
		JTextArea retornoTA = new JTextArea();
		retornoTA.setFont(new Font("Monospaced", Font.PLAIN, 15));
		retornoTA.setEditable(false);
		retornoTA.setBounds(371, 33, 235, 118);
		panel.add(retornoTA);
		
		JButton btnSalvar = new JButton("Retirar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Salvar
				Estoque estoque = new Estoque();
				int indiceProduto = 0;
				int quantidade = 0;
				
				indiceProduto = produtoCB.getSelectedIndex();
				quantidade = Integer.parseInt(quantidadeSp.getValue()+"");
				
				estoque.removerProdutos(indiceProduto, quantidade);
				retornoTA.setText(estoque+"");
			}
		});
		btnSalvar.setBounds(151, 145, 110, 41);
		panel.add(btnSalvar);
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 16));
	}

}
