package br.empresa.view.venda;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import br.empresa.model.Empresa;
import br.empresa.model.Venda;
import javax.swing.JTabbedPane;
import java.awt.Color;

public class RelatorioPorCategoriaView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Venda venda = new Venda();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RelatorioPorCategoriaView dialog = new RelatorioPorCategoriaView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RelatorioPorCategoriaView() {
		setBounds(100, 100, 582, 629);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 153, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Celulares", null, panel_1, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panel_1.setLayout(null);
		
		JScrollPane celularesSP = new JScrollPane();
		celularesSP.setBounds(10, 11, 501, 500);
		panel_1.add(celularesSP);
		
		JTextArea celularesTA = new JTextArea();
		celularesSP.setViewportView(celularesTA);
		celularesTA.setFont(new Font("Monospaced", Font.PLAIN, 16));
		//TODO Celulares TextArea
		celularesTA.setText(Empresa.relatorioPorCategoria('C'));
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Eletrodom\u00E9sticos", null, panel, null);
		
		JScrollPane domesticosSP = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(domesticosSP, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(domesticosSP, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
		);
		
		JTextArea domesticosTA = new JTextArea();
		domesticosSP.setViewportView(domesticosTA);
		panel.setLayout(gl_panel);
		//TODO Eletrodomesticos TextArea
		domesticosTA.setText(Empresa.relatorioPorCategoria('D'));
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Eletroport\u00E1teis", null, panel_2, null);
		
		JScrollPane portateisSP = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(portateisSP, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(portateisSP, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTextArea portateisTA = new JTextArea();
		portateisSP.setViewportView(portateisTA);
		panel_2.setLayout(gl_panel_2);
		//TODO Eletroportateis TextArea
		portateisTA.setText(Empresa.relatorioPorCategoria('P'));
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(566, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("TVs", null, panel_3, null);
		
		JScrollPane tvsSP = new JScrollPane();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(tvsSP, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(tvsSP, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTextArea tvsTA = new JTextArea();
		tvsSP.setViewportView(tvsTA);
		panel_3.setLayout(gl_panel_3);
		//TODO TVs TextArea
		tvsTA.setText(Empresa.relatorioPorCategoria('T'));
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Inform\u00E1tica", null, panel_4, null);
		
		JScrollPane informaticaSP = new JScrollPane();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(informaticaSP, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(informaticaSP, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTextArea infoTA = new JTextArea();
		informaticaSP.setViewportView(infoTA);
		panel_4.setLayout(gl_panel_4);
		//TODO Informatica TextArea
		infoTA.setText(Empresa.relatorioPorCategoria('I'));
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Outros", null, panel_5, null);
		
		JScrollPane outrosSP = new JScrollPane();
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(outrosSP, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(outrosSP, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTextArea outrosTA = new JTextArea();
		outrosSP.setViewportView(outrosTA);
		panel_5.setLayout(gl_panel_5);
		contentPanel.setLayout(gl_contentPanel);
		//TODO Outros TextArea
		outrosTA.setText(Empresa.relatorioPorCategoria('O'));
	}
}
