package br.empresa.view.venda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.empresa.model.Empresa;
import br.empresa.model.Venda;

public class MenuVendaView extends JFrame {

	private JPanel contentPane;
	private Empresa empresa = new Empresa();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuVendaView frame = new MenuVendaView();
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
	public MenuVendaView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 457, 344);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton vendabtn = new JButton("Atribuir uma Venda");
		vendabtn.setBounds(58, 55, 315, 53);
		vendabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Vender
				VenderView exibir = new VenderView();
				exibir.setVisible(true);
				exibir.setResizable(false);
				exibir.setLocationRelativeTo(null);
			}
		});
		contentPane.setLayout(null);
		vendabtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(vendabtn);
		
		JButton btnNewButton_1 = new JButton("Relat\u00F3rio total de vendas");
		btnNewButton_1.setBounds(58, 212, 315, 53);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Relatorio Total
				Venda v = new Venda();
				RelatorioTotalview rel = new RelatorioTotalview();
				rel.setVisible(true);
				rel.setLocationRelativeTo(null);
				rel.setResizable(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Relat\u00F3rio de vendas por categoria");
		btnNewButton_2.setBounds(58, 133, 315, 56);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Por categoria
				RelatorioPorCategoriaView exibir = new RelatorioPorCategoriaView();
				exibir.setVisible(true);
				exibir.setLocationRelativeTo(null);
				exibir.setResizable(false);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Venda");
		lblNewLabel.setBounds(-155, 12, 736, 31);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);
	}

}
