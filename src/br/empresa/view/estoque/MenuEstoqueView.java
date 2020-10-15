package br.empresa.view.estoque;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.empresa.model.Empresa;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MenuEstoqueView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEstoqueView frame = new MenuEstoqueView();
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
	public MenuEstoqueView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 683, 367);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 51, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Estoque");
		lblNewLabel.setBounds(17, 17, 614, 39);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 51, 153));
		panel.setBounds(17, 81, 397, 219);
		
		JLabel lblNewLabel_1 = new JLabel("AVISOS:");
		lblNewLabel_1.setBounds(490, 81, 123, 31);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		JTextArea retornoTA = new JTextArea();
		retornoTA.setBounds(447, 118, 194, 180);
		retornoTA.setText(Empresa.verificarPoucosProdutos());
		
		JButton btnNewButton = new JButton("Ver relat\u00F3rio");
		btnNewButton.setBounds(0, 34, 397, 51);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Relatório
				JOptionPane.showMessageDialog(null, Empresa.relatorioEstoque());
			}
		});
		panel.setLayout(null);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Remover produtos");
		btnNewButton_2.setBounds(0, 168, 397, 51);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Remover
				RemoverProdutosView exibir = new RemoverProdutosView();
				exibir.setVisible(true);
				exibir.setLocationRelativeTo(null);
				exibir.setResizable(false);
			}
		});
		contentPane.setLayout(null);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(btnNewButton_2);
		contentPane.add(panel);
		
		JButton btnNewButton_1 = new JButton("Rep\u00F4r produtos");
		btnNewButton_1.setBounds(0, 97, 397, 59);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Repôr produtos
				ReporProdutosView exibir = new ReporProdutosView();
				exibir.setVisible(true);
				exibir.setLocationRelativeTo(null);
				exibir.setResizable(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(retornoTA);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel);
	}
}
