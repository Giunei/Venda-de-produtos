package br.empresa.view.colaboradores;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import br.empresa.model.Colaborador;
import br.empresa.model.Empresa;
import java.awt.Color;

public class RemoverColaborador extends JFrame {

	private JPanel contentPane;
	private JTextField indiceTF;
	static Colaborador co = new Colaborador();
	private static Empresa empresa = new Empresa();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverColaborador frame = new RemoverColaborador();
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
	public RemoverColaborador() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 473);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(153, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextArea listaTA = new JTextArea();
		listaTA.setBounds(214, 45, 188, 377);
		listaTA.setText(empresa.listarColaboradores());
		listaTA.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("Lista de Colaboradores");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(214, 17, 161, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Digite o Índice do Colaborador");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(12, 102, 190, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		indiceTF = new JTextField();
		indiceTF.setBounds(12, 140, 116, 30);
		indiceTF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		indiceTF.setColumns(10);
		
		
		//SALVAR
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.setBounds(12, 183, 116, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = "";
				int indice = 0;
				indice = Integer.parseInt(indiceTF.getText());
				nome = empresa.encontrarNomeColaborador(indice);
				empresa.remColaboradores(indice);
				listaTA.setText(empresa.listarColaboradores());
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
