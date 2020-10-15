package br.empresa.view.clientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.empresa.model.Cliente;
import br.empresa.model.Colaborador;
import br.empresa.model.Empresa;

public class AddCliente extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTF;
	private JLabel lblTelefone;
	private JLabel lblEmail;
	private JTextArea retornoTA;
	private JButton btnSalvar;
	
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private JTextField telefoneTF;
	private JTextField emailTF;
	//static Colaborador colaborador = new Colaborador();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCliente frame = new AddCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static ArrayList<Cliente> getCliente() {
		return clientes;
	}

	public static void setColaboradores(ArrayList<Cliente> clientes) {
		AddCliente.clientes = clientes;
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public AddCliente() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 762, 422);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Adicionar Clientes");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JLabel lblnomeTF = new JLabel("Nome");
		lblnomeTF.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblnomeTF.setForeground(new Color(255, 255, 255));
		
		nomeTF = new JTextField();
		nomeTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nomeTF.setColumns(10);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		retornoTA = new JTextArea();
		retornoTA.setEditable(false);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empresa empresa = new Empresa();
				String nome = nomeTF.getText();
				String telefone = telefoneTF.getText();
				String email = emailTF.getText();
				Cliente c = new Cliente(nome, telefone, email);
				
				empresa.addClientes(c);
				retornoTA.setText(Empresa.retornoResultadosCliente());
				c.incrementar();
				
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		telefoneTF = new JTextField();
		telefoneTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		telefoneTF.setColumns(10);
		
		emailTF = new JTextField();
		emailTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emailTF.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTelefone, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblnomeTF)
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
									.addGap(1)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(emailTF, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
											.addGap(158))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(nomeTF, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
											.addGap(158))
										.addComponent(telefoneTF, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSalvar)
							.addGap(210)))
					.addComponent(retornoTA, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblnomeTF)
								.addComponent(nomeTF, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTelefone, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(telefoneTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(emailTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(97)
							.addComponent(btnSalvar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(retornoTA, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
}
