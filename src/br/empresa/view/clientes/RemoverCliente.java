package br.empresa.view.clientes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import br.empresa.model.Cliente;
import br.empresa.model.Empresa;
import java.awt.Color;
import javax.swing.UIManager;

public class RemoverCliente extends JFrame {

	private JPanel contentPane;
	private JTextField indiceTF;
	static Cliente c = new Cliente();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverCliente frame = new RemoverCliente();
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
	public RemoverCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextArea listaTA = new JTextArea();
		listaTA.setBounds(213, 45, 196, 384);
		listaTA.setText(Empresa.listarClientes());
		listaTA.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("Lista de Clientes");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(213, 16, 114, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Digite o \u00CDndice do Cliente");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(15, 105, 188, 17);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		indiceTF = new JTextField();
		indiceTF.setBounds(15, 140, 116, 30);
		indiceTF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		indiceTF.setColumns(10);
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setBounds(15, 188, 116, 28);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empresa empresa = new Empresa();
				String nome = "";
				int indice = 0;
				indice = Integer.parseInt(indiceTF.getText());
				nome = empresa.encontrarNomeCliente(indice);
				empresa.remClientes(indice);
				listaTA.setText(Empresa.listarClientes());
				JOptionPane.showMessageDialog(null, nome+" foi removido!");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_1);
		contentPane.add(indiceTF);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel);
		contentPane.add(listaTA);
	}

}
