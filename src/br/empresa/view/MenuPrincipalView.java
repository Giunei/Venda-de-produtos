package br.empresa.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.empresa.enumered.Categoria;
import br.empresa.model.Cliente;
import br.empresa.model.Colaborador;
import br.empresa.model.Empresa;
import br.empresa.model.Produto;
import br.empresa.view.clientes.ClientesView;
import br.empresa.view.colaboradores.ColaboradoresView;
import br.empresa.view.estoque.MenuEstoqueView;
import br.empresa.view.fechamento.FechamentoView;
import br.empresa.view.produtos.ProdutosView;
import br.empresa.view.venda.MenuVendaView;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class MenuPrincipalView {

	private JFrame frame;
	private static Empresa empresa = new Empresa();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Colaborador co1 = new Colaborador("Rebeca", "31/08/1992", "123.321.213-23", "+55 (31) 94123-1212", "rebeca@gmail.com", 2500.00);
		empresa.addColaboradores(co1);
		co1.incrementar();
		Colaborador co2 = new Colaborador("Barnabé", "31/08/1968", "122.321.211-23", "+55 (31) 94321-1218", "barnabee@gmail.com", 2500.00);
		empresa.addColaboradores(co2);
		co2.incrementar();
		
		Cliente cl1 = new Cliente("Nastácia", "+55 (31) 94428-5217", "nastacia@gmail.com");
		empresa.addClientes(cl1);
		cl1.incrementar();
		Cliente cl2 = new Cliente("Visconde", "+55 (31) 93473-6222", "visconde@gmail.com");
		empresa.addClientes(cl2);
		cl2.incrementar();
		
		Produto p1 = new Produto("PearPhone", Categoria.CELULARES, 2000.0, 2300.0, 10);
		empresa.addProdutos(p1);
		p1.incrementar();
		Produto p2 = new Produto("Refrigerador", Categoria.ELETRODOMESTICOS, 300.0, 399.99, 10);
		empresa.addProdutos(p2);
		p2.incrementar();
		Produto p3 = new Produto("Liquidificador", Categoria.ELETROPORTATEIS, 200.0, 240.0, 2);
		empresa.addProdutos(p3);
		p3.incrementar();
		Produto p4 = new Produto("SmartTV", Categoria.TV, 1000.0, 1300.0, 2);
		empresa.addProdutos(p4);
		p4.incrementar();
		Produto p5 = new Produto("Mouse", Categoria.INFORMATICA, 50.0, 90.0, 2);
		empresa.addProdutos(p5);
		p5.incrementar();
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalView window = new MenuPrincipalView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipalView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 153, 102));
		frame.setBounds(100, 100, 500, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 153));
		
		JLabel lblNewLabel = new JLabel("API da Imperius");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(17))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(65, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnNewButton = new JButton("Colaboradores");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Menu Colaboradores
				ColaboradoresView exibir = new ColaboradoresView();
				exibir.setBounds(100, 100, 450, 300);
				exibir.setVisible(true);
				exibir.setLocationRelativeTo(null);
				exibir.setResizable(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Menu Clientes
				ClientesView exibir = new ClientesView();
				exibir.setVisible(true);
				exibir.setLocationRelativeTo(null);
				exibir.setResizable(false);
			}
		});
		btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Produtos
				ProdutosView exibir = new ProdutosView();
				exibir.setVisible(true);
				exibir.setLocationRelativeTo(null);
				exibir.setResizable(false);
			}
		});
		btnProdutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Estoque
				MenuEstoqueView exibir = new MenuEstoqueView();
				exibir.setVisible(true);
				exibir.setResizable(false);
				exibir.setLocationRelativeTo(null);
			}
		});
		btnEstoque.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnVenda = new JButton("Venda");
		btnVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Todo Venda
				MenuVendaView exibir = new MenuVendaView();
				exibir.setVisible(true);
				exibir.setLocationRelativeTo(null);
				exibir.setResizable(false);
			}
		});
		btnVenda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnFechamento = new JButton("Fechamento");
		btnFechamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Fechamento do mês
				FechamentoView exibir = new FechamentoView();
				FechamentoView.carregarTabela();
				exibir.setVisible(true);
				exibir.setLocationRelativeTo(null);
				exibir.setResizable(false);
			}
		});
		btnFechamento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(145)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFechamento, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVenda, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEstoque, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnProdutos, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClientes, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(161, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnClientes, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnProdutos, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnEstoque, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnVenda, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnFechamento, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
