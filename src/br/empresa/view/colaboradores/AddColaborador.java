package br.empresa.view.colaboradores;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.empresa.model.Colaborador;
import br.empresa.model.Empresa;

public class AddColaborador extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTF;
	private JLabel lblDataDeNascimento;
	private JFormattedTextField nascimentoTF;
	private JLabel lblCpf;
	private JFormattedTextField cpfTF;
	private JLabel lblTelefone;
	private JTextField telefoneTF;
	private JLabel lblEmail;
	private JTextField emailTF;
	private JLabel lblSalrio;
	private JTextField salarioTF;
	private JTextArea retornoTA;
	private JButton btnSalvar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddColaborador frame = new AddColaborador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public AddColaborador() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 776, 467);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Adicionar Colaboradores");
		lblNewLabel.setBounds(143, 16, 393, 39);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JLabel lblnomeTF = new JLabel("Nome");
		lblnomeTF.setBounds(53, 104, 58, 28);
		lblnomeTF.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblnomeTF.setForeground(new Color(255, 255, 255));
		
		nomeTF = new JTextField();
		nomeTF.setBounds(291, 104, 214, 28);
		nomeTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nomeTF.setColumns(10);
		nomeTF.setForeground(Color.BLACK);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(53, 143, 234, 28);
		lblDataDeNascimento.setForeground(new Color(255, 255, 255));
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		nascimentoTF = new JFormattedTextField(new MaskFormatter("##/##/####"));
		nascimentoTF.setBounds(291, 143, 214, 29);
		nascimentoTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nascimentoTF.setText("00/00/0000");
		nascimentoTF.setForeground(Color.BLACK);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(53, 190, 66, 28);
		lblCpf.setForeground(new Color(255, 255, 255));
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		cpfTF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		cpfTF.setBounds(291, 190, 214, 29);
		cpfTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cpfTF.setText("000.000.000-00");
		cpfTF.setForeground(Color.BLACK);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(53, 237, 123, 28);
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		telefoneTF = new JTextField();
		telefoneTF.setBounds(291, 237, 214, 28);
		telefoneTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		telefoneTF.setColumns(10);
		telefoneTF.setForeground(Color.BLACK);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(53, 283, 123, 28);
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		emailTF = new JTextField();
		emailTF.setBounds(291, 288, 214, 28);
		emailTF.setColumns(10);
		emailTF.setForeground(Color.BLACK);
		
		lblSalrio = new JLabel("Sal\u00E1rio");
		lblSalrio.setBounds(53, 334, 123, 28);
		lblSalrio.setForeground(new Color(255, 255, 255));
		lblSalrio.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		salarioTF = new JTextField();
		salarioTF.setBounds(291, 334, 214, 28);
		salarioTF.setForeground(Color.BLACK);
		salarioTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		salarioTF.setColumns(10);
		
		retornoTA = new JTextArea();
		retornoTA.setBounds(554, 104, 196, 292);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(426, 381, 79, 25);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Salvar
				Empresa empresa = new Empresa();
				String nome = nomeTF.getText();
				String nascimento = nascimentoTF.getText();
				String cpf = cpfTF.getText();
				String telefone = telefoneTF.getText();
				String email = emailTF.getText();
				Double salario = Double.parseDouble(salarioTF.getText());
				
				aviso(nome, nascimento, cpf, telefone, email);
				
				if(verificarDados(nome, nascimento, cpf, telefone, email)) {
					Colaborador colaborador = new Colaborador(nome, nascimento, cpf, telefone, email, salario);
					empresa.addColaboradores(colaborador);
					
					retornoTA.setText(Empresa.retornoResultadosColab());
					JOptionPane.showMessageDialog(null, colaborador);
					colaborador.incrementar();
				}else {
					JOptionPane.showMessageDialog(null, "Você deve ter digitado algo errado, tente novamente.");
				}
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblnomeTF);
		contentPane.add(lblDataDeNascimento);
		contentPane.add(lblCpf);
		contentPane.add(lblTelefone);
		contentPane.add(lblEmail);
		contentPane.add(lblSalrio);
		contentPane.add(nomeTF);
		contentPane.add(salarioTF);
		contentPane.add(cpfTF);
		contentPane.add(nascimentoTF);
		contentPane.add(telefoneTF);
		contentPane.add(emailTF);
		contentPane.add(btnSalvar);
		contentPane.add(retornoTA);
	}
	
	public void reset() {
		nomeTF.setText("");
		nascimentoTF.setText("");
		cpfTF.setText("");
		telefoneTF.setText("");
		emailTF.setText("");
		salarioTF.setText("");;
	}
	
	public void aviso(String nome, String nascimento, String cpf, String telefone, String email) {
		if(nome.isEmpty() | nome.isBlank()) {
			nomeTF.setForeground(Color.RED);
			nomeTF.setText("Digite o nome");
		}
		if(nascimento.startsWith("00") | nascimento.substring(3,5).equals("00")) {
			nascimentoTF.setForeground(Color.RED);
			nascimentoTF.setText("Digite a data");
		}
		if(cpf.isEmpty() | cpf.isBlank()) {
			cpfTF.setForeground(Color.RED);
			cpfTF.setText("Digite o cpf");
		}
		if(telefone.isEmpty() | telefone.isBlank()) {
			telefoneTF.setForeground(Color.RED);
			telefoneTF.setText("Digite o telefone");
		}
		if(email.isEmpty() | email.isBlank()) {
			emailTF.setForeground(Color.RED);
			emailTF.setText("Digite o email");
		}
	}
	
	public Boolean verificarDados(String nome, String nascimento, String cpf, String telefone, String email) {
		// Se qualquer verificação falhar, x perde um ponto, portanto não retornará true
		int x = 5;
		
		if(nome.isEmpty() | nome.isBlank()) 
			x--;
		if(nascimento.startsWith("00") | nascimento.substring(3,4).equals("00")) 
			x--;
		if(cpf.isEmpty() | cpf.isBlank()) 
			x--;
		if(telefone.isEmpty() | telefone.isBlank()) 
			x--;
		if(email.isEmpty() | email.isBlank()) 
			x--;

		
		if(x!=5)
			return false;
		return true;
	}
	
}
