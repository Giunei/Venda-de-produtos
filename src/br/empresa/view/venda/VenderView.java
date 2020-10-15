package br.empresa.view.venda;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.empresa.model.Cliente;
import br.empresa.model.Colaborador;
import br.empresa.model.Empresa;
import br.empresa.model.Produto;
import br.empresa.model.Venda;


public class VenderView extends JFrame {

	private JPanel contentPane;
	private Produto p = new Produto();
	private Cliente cl = new Cliente();
	private Colaborador co = new Colaborador();
	private Venda venda = new Venda();
	private static Empresa empresa = new Empresa();
	static JComboBox vendedorCB;
	static JComboBox compradorCB;
	static JComboBox produtoCB;
	static JSpinner produtoQuantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VenderView frame = new VenderView();
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
	public VenderView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 711, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 51));
		panel.setBounds(0, 0, 695, 339);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Venda");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Colaborador");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblNewLabel_1_1 = new JLabel("Cliente");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Produto");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		
		compradorCB = new JComboBox();
		//Comprador
		cl = new Cliente();
		compradorCB.setModel(new DefaultComboBoxModel(empresa.compradorComboBox()));
		
		vendedorCB = new JComboBox();
		//Vendedor
		co = new Colaborador();
		vendedorCB.setModel(new DefaultComboBoxModel(empresa.vendedorComboBox()));
		
		//Produto
		produtoCB = new JComboBox();
		p = new Produto();
		produtoCB.setModel(new DefaultComboBoxModel(empresa.produtosComboBox()));
		
		produtoQuantidade = new JSpinner();
		produtoQuantidade.setFont(new Font("Dialog", Font.BOLD, 16));
		produtoQuantidade.setModel(new SpinnerNumberModel(1, 1, 200, 1));
		
		JTextArea retornoTA = new JTextArea();
		retornoTA.setForeground(new Color(0, 0, 0));
		retornoTA.setBackground(new Color(102, 153, 51));
		retornoTA.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO SALVAR
				
				Integer indiceVendedor = 0;
				Integer indiceComprador = 0;
				Integer indiceProduto = 0;
				Integer quantidade = 0;
				
				indiceVendedor = vendedorCB.getSelectedIndex();
				indiceComprador = compradorCB.getSelectedIndex();
				indiceProduto = produtoCB.getSelectedIndex();
				quantidade = Integer.parseInt(produtoQuantidade.getValue()+"");
				if(Produto.verificarProdutosDisponiveis(indiceProduto, quantidade)) {
					retornoTA.setForeground(new Color(0, 0, 0));
					String vendedor = empresa.atribuirVendedor(indiceVendedor);
					String comprador = empresa.atribuirComprador(indiceComprador);
					String produto = empresa.atribuirProduto(indiceProduto);
					
					Venda v = new Venda(produto, comprador, vendedor, quantidade);
					v.setarValoresVenda(indiceProduto, quantidade);
					empresa.addVendas(v);
					empresa.adicionarComissao(indiceProduto, indiceVendedor, quantidade);
					
					retornoTA.setText(Empresa.retornoVendas());
					JOptionPane.showMessageDialog(null, v);
					resetar();
					venda.incrementar();
				}else {
					retornoTA.setForeground(new Color(250,0,0));
					retornoTA.setText("Nosso estoque não tem \nessa quantidade de produtos");
					
				}
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblNewLabel_1_2 = new JLabel("Quantidade");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 16));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(compradorCB, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(vendedorCB, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(produtoCB, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(produtoQuantidade, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
								.addComponent(retornoTA, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(vendedorCB, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(produtoQuantidade, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(compradorCB, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(produtoCB, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton))
						.addComponent(retornoTA, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
	
	public void resetar() {
		vendedorCB.setSelectedIndex(0);
		compradorCB.setSelectedIndex(0);
		produtoCB.setSelectedIndex(0);
		produtoQuantidade.setValue(1);
	}
}
