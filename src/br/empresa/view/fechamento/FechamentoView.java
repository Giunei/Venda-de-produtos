package br.empresa.view.fechamento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.empresa.model.Empresa;
import java.awt.Color;

public class FechamentoView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable fechamentoTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FechamentoView dialog = new FechamentoView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FechamentoView() {
		setBounds(100, 100, 863, 471);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 182, 193));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Fechamento do M\u00EAs");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
			lblNewLabel.setBounds(258, 11, 396, 51);
			contentPanel.add(lblNewLabel);
		}
		
		JScrollPane scrollPane = new JScrollPane(fechamentoTable);
		scrollPane.setBounds(10, 60, 827, 352);
		contentPanel.add(scrollPane);
		
		fechamentoTable = new JTable();
		scrollPane.setViewportView(fechamentoTable);
	}
	
	public static void carregarTabela() {
		String [] colunas = new String[5];
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		
		colunas[0] = "Total de vendas";
		colunas[1] = "Total de lucro";
		colunas[2] = "Vendedor do mes";
		colunas[3] = "Maior comissão";
		colunas[4] = "Produto do mês";
		
		String [][] dados = Empresa.dadosFechamento();
		
		fechamentoTable.setModel(new DefaultTableModel(dados,colunas));
	
		r = new DefaultTableCellRenderer();
		
		r.setHorizontalAlignment(JLabel.LEFT);
		fechamentoTable.getColumnModel().getColumn(0).setCellRenderer(r);
		fechamentoTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		
		r.setHorizontalAlignment(JLabel.LEFT);
		fechamentoTable.getColumnModel().getColumn(1).setCellRenderer(r);
		fechamentoTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		
		r.setHorizontalAlignment(JLabel.LEFT);
		fechamentoTable.getColumnModel().getColumn(2).setCellRenderer(r);
		fechamentoTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		
		r.setHorizontalAlignment(JLabel.LEFT);
		fechamentoTable.getColumnModel().getColumn(3).setCellRenderer(r);
		fechamentoTable.getColumnModel().getColumn(3).setPreferredWidth(150);
		
		r.setHorizontalAlignment(JLabel.LEFT);
		fechamentoTable.getColumnModel().getColumn(4).setCellRenderer(r);
		fechamentoTable.getColumnModel().getColumn(4).setPreferredWidth(150);
	}
}
