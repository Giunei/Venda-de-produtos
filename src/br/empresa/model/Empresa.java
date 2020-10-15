package br.empresa.model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Empresa {
	
	//Atributos
	private String nome;
	private String cnpj;
	private static ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>() ;
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	static ArrayList<Produto> produtos = new ArrayList<Produto>();
	private static ArrayList<Venda> vendas = new ArrayList<Venda>();
	
	static DecimalFormat df = new DecimalFormat();
	////////////
	
	//Construtores
	public Empresa(String nome, String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
	public Empresa() {
	}
	////////////
	
	//Gets e Sets
	public String getNome() {
		return nome;
	}

	public static ArrayList<Colaborador> getColaboradores() {
		return colaboradores;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	//HashCode
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}
	////////////
	
	//ToString
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Nome: "+this.nome+"\n");
		sb.append("CNPJ: "+this.cnpj+"\n");
		sb.append("Colaboradores: "+colaboradores.size()+"\n");
		sb.append("Clientes: "+clientes.size()+"\n");
		sb.append("Produtos: "+produtos.size()+"\n");
		sb.append("Vendas: "+vendas.size()+"\n");
		return sb.toString();
	}
	////////////
	
	//TODO Métodos
	
	public void addColaboradores(Colaborador c) {
		colaboradores.add(c);
	}
	
	public void remColaboradores(int indice) {
		colaboradores.remove(indice);
	}
	
	public void addClientes(Cliente c) {
		clientes.add(c);
	}
	
	public void remClientes(int indice) {
		clientes.remove(indice);
	}
	
	public void addProdutos(Produto p) {
		produtos.add(p);
	}
	
	public void remProdutos(int indice) {
		produtos.remove(indice);
	}
	
	public void addVendas(Venda v) {
		vendas.add(v);
	}
	
	public void adicionarComissao(int indiceProduto, int indiceVendedor, int quantidade) {
		Double valorLucro = 0D;
		for (Produto p : produtos) {
			if(indiceProduto == p.getCodigo()) {
				valorLucro = p.getValorLucro();
			}
				
		}
		
		for (Colaborador c : colaboradores) {
			if(c.getCodigo().equals(indiceVendedor)) {
				c.setComissao((c.getComissao()+valorLucro*0.05)*(quantidade));
				c.setNumVendas(c.getNumVendas()+quantidade);
				c.setValorRecebido(c.getValorRecebido()+valorLucro+(valorLucro*0.05)*(quantidade));
			}
		}
	}
	
	
	////////////
	
		///Strings
			///TODO String Colaboradores
	public static String retornoResultadosColab() {
		StringBuffer sb = new StringBuffer();
		sb = new StringBuffer();
		sb.append("Novo colaborador:\n\n");
		for (int i = Colaborador.codigoAtual; i < colaboradores.size(); i++) {
			Colaborador c = colaboradores.get(i);
			sb.append("Nome: "+c.getNome()+"\n");
			sb.append("Data de nascimento: "+c.getDataNascimento()+"\n");
			sb.append("CPF: "+c.getCpf()+"\n");
			sb.append("Telefone: "+c.getTelefone()+"\n");
			sb.append("E-mail: "+c.getEmail()+"\n");
			sb.append("Salário: "+c.getSalario()+"\n");
			sb.append("=================");
			sb.append("\n\n");
		}
		return sb.toString();
	}
	
	public String relatorioColaboradores() {
		StringBuffer sb = new StringBuffer();
		sb = new StringBuffer();
		for (Colaborador co : colaboradores) {
			sb.append("Nome: "+co.getNome()+"\n");
            sb.append("Salário: "+co.getSalario()+"\n");
            sb.append("Número de vendas: "+co.getNumVendas()+"\n");
            sb.append("Comissão total atual: "+co.getComissao()+"\n");
            sb.append("Valor total vendido: "+co.getValorRecebido()+"\n");
            sb.append("==============================\n");
		}
		return sb.toString();
	}
	
	public String listarColaboradores() {
		StringBuffer sb = new StringBuffer();
		sb = new StringBuffer();
		for (Colaborador co : colaboradores) {
			sb.append(co.getCodigo()+" - Nome: "+co.getNome()+"\n");
            sb.append("==============================\n");
		}
		return sb.toString();
	}
	
	public String encontrarNomeColaborador(int indice) {
		Colaborador c = colaboradores.get(indice);
		return c.getNome();
		
	}
	
	public String[] vendedorComboBox() {
		String[] x = new String[colaboradores.size()];
		for (int i = 0; i < colaboradores.size(); i++) {
			Colaborador c = colaboradores.get(i);
			x[i] = c.getNome();
		}
		return x;
	}
			///TODO String Clientes
	
	
	public static String retornoResultadosCliente() {
		StringBuffer sb = new StringBuffer();
		sb = new StringBuffer();
		sb.append("Novo cliente:\n\n");
		for (int i = Cliente.codigoAtual; i < clientes.size(); i++) {
			Cliente c = clientes.get(i);
			sb.append("Nome: "+c.getNome()+"\n");
			sb.append("Telefone: "+c.getTelefone()+"\n");
			sb.append("E-mail: "+c.getEmail()+"\n");
			sb.append("=================");
			sb.append("\n\n");
		}
		return sb.toString();
	}
	
	public static String relatorioClientes() {
		StringBuffer sb = new StringBuffer();
		sb = new StringBuffer();
		for (Cliente c : clientes) {
			sb.append("Nome: "+c.getNome()+"\n");
            sb.append("Valor total gasto: "+c.getValorTotalGasto()+"\n");
            sb.append("Quantidade de produtos comprados: "+Cliente.produtosComprados.size()+"\n");
            sb.append("==============================\n");
		}
		return sb.toString();
	}
	
	public static String listarClientes() {
		StringBuffer sb = new StringBuffer();
		sb = new StringBuffer();
		for (Cliente c : clientes) {
			sb.append(c.getCodigo()+" - Nome: "+c.getNome()+"\n");
            sb.append("==============================\n");
		}
		return sb.toString();
	}
	
	public String[] compradorComboBox() {
		String[] x = new String[clientes.size()];
		for (int i = 0; i < clientes.size(); i++) {
			Cliente c = clientes.get(i);
			x[i] = c.getNome();
		}
		return x;
	}
	
	public String encontrarNomeCliente(int indice) {
		Cliente c = clientes.get(indice);
		return c.getNome();
	}
	
	
	
			///TODO String Produtos
	
	
	
	public String retornoResultadosProdutos() {
		StringBuffer sb = new StringBuffer();
		sb = new StringBuffer();
		sb.append("Novo produto:\n\n");
		for (int i = Produto.codigoAtual; i < produtos.size(); i++) {
			Produto p = produtos.get(i);
			sb.append("Nome: "+p.getNome()+"\n");
			sb.append("Categoria: "+p.getCategoria()+"\n");
            sb.append("Valor de compra: "+p.getValorCompra()+"\n");
            sb.append("Valor de venda: "+p.getValorVenda()+"\n");
            sb.append("Quantidade: "+p.getProdutosDisponiveis()+"\n");
			sb.append("=================");
			sb.append("\n\n");
		}
		return sb.toString();
	}
	
	public static String relatorioProdutos() {
		df = new DecimalFormat("#0.00");
		StringBuffer sb = new StringBuffer();
		sb = new StringBuffer();
		for (Produto p : produtos) {
			sb.append("Nome: "+p.getNome()+"\n");
			sb.append("Categoria: "+p.getCategoria()+"\n");
            sb.append("Valor de compra: "+p.getValorCompra()+"\n");
            sb.append("Valor de venda: "+p.getValorVenda()+"\n");
            sb.append("Quantidade ainda em estoque: "+p.getProdutosDisponiveis()+"\n");
            sb.append("Quantidade vendida: "+p.getProdutosVendidos()+"\n");
            sb.append("Lucro total: "+df.format(p.getValorLucro())+"\n");
            sb.append("==============================\n");
		}
		return sb.toString();
	}
	
	public static String listarProdutos() {
		StringBuffer sb = new StringBuffer();
		sb = new StringBuffer();
		for (Produto p : produtos) {
			sb.append(p.getCodigo()+" - Nome: "+p.getNome()+"\n");
            sb.append("==============================\n");
		}
		return sb.toString();
	}
	
	public String[] produtosComboBox() {
		//Usado para retornar lista de produtos para pôr em uma ComboBox, em vendas e em estoque
		String[] x = new String[produtos.size()];
		for (int i = 0; i < produtos.size(); i++) {
			Produto p = produtos.get(i);
			x[i] = p.getNome();
		}
		return x;
	}
	
	public String encontrarProduto(int indice) {
		Produto c = produtos.get(indice);
		return c.getNome();
	}
	
	
	
			///TODO String Vendas
	
	
	public static String retornoVendas() {
		StringBuffer sb = new StringBuffer();
		sb = new StringBuffer();
		sb.append("Vendido:\n\n");
		for (int i = Venda.codigoAtual; i < vendas.size(); i++) {
			Venda v = vendas.get(i);
			
			sb.append("Vendedor: "+v.getVendedor()+"\n");
			sb.append("Comprador: "+v.getComprador()+"\n");
			sb.append("Produto: "+v.getProduto()+"\n");
			sb.append("Quantidade: "+v.getQuantidade());
		}
		
		return sb.toString();
	}
	
	//TODO String Vendas Atribuir
	//Esses atribuir vão retornar os nomes para serem salvos em Arrays na classe Venda
	
	public String atribuirVendedor(Integer indiceVendedor) {
		String nomeVendedor = "";
		for (Colaborador c : colaboradores) {
			if(c.getCodigo().equals(indiceVendedor)) {
				nomeVendedor = c.getNome();
			}
		}
		return nomeVendedor;
	}
	
	public String atribuirComprador(Integer indiceComprador) {
		String nomeComprador = "";
		for (Cliente c : clientes) {
			if(c.getCodigo().equals(indiceComprador)) {
				nomeComprador = c.getNome();
			}
		}
		return nomeComprador;
	}
	
	public String atribuirProduto(Integer indiceProduto) {
		String nomeProduto = "";
		for (Produto p : produtos) {
			if(p.getCodigo().equals(indiceProduto)) {
				nomeProduto = p.getNome();
			}
		}
		return nomeProduto;
	}
	
	//TODO Vendas String relatórios
	
	public static String relatorioTodasVendas() {
		StringBuffer sb = new StringBuffer();
		df = new DecimalFormat("#0.00");
		Double valorTotal = 0.0;
		Double valorLucro = 0.0;
		int quant = 0;
		for (Venda v : vendas) {
			valorLucro += v.getValorLucroTotal() * v.getQuantidade();
			valorTotal += v.getValorProdutosVendidos() * v.getQuantidade();
			quant += v.getQuantidade();
		}
		sb.append("Produtos vendidos: "+quant+"\n");
		sb.append("Valor total: "+df.format(valorTotal)+"\n");
		sb.append("Lucro total: "+df.format(valorLucro)+"\n\n");
		sb.append("Produtos vendidos: "+quant+"\n");
		for (Venda v : vendas) {
			sb.append("\n\n=================\n");
			sb.append("Vendedor: "+v.getVendedor()+"\n");
			sb.append("Comprador: "+v.getComprador()+"\n");
			sb.append("Produto: "+v.getProduto()+"\n");
			sb.append("Valor de venda: "+ v.getValorProdutosVendidos()+"\n");
			sb.append("Quantidade: "+v.getQuantidade()+"\n");
			sb.append("Categoria: "+ v.getProdutosCategoria()+"\n");
		}
		return sb.toString();
	}
	
	public static String relatorioPorCategoria(char c) {
		//C = Celulares | D = Eletrodomésticos | P = Eletroportáteis
		//I = Informática | T = TVs | O = Outros
		df = new DecimalFormat("#0.00");
		StringBuffer sb = new StringBuffer();
		sb = new StringBuffer();
		Double valor = 0.0;
		Double lucro = 0.0;
		Double valorProduto = 0.0;
		String nomeCategoria = "";
		String nomeProduto = "";
		int quantidadeTotal = 0;
		
		switch (c) {
		case 'C':
			for (Venda v : vendas) {
				if(v.getProdutosCategoria() == "Celulares") {
					valor += v.getValorProdutosVendidos() * v.getQuantidade();
					lucro += v.getValorLucroTotal() * v.getQuantidade();
					valorProduto = v.getValorProdutosVendidos();
					nomeCategoria = v.getProdutosCategoria();
					nomeProduto = v.getProduto();
					quantidadeTotal = v.getQuantidade();
				}
			}
			break;
			
		case 'D':
			for (int i = 0; i < vendas.size(); i++) {
				Venda v = vendas.get(i);
				if(v.getProdutosCategoria() == "Eletrodomésticos") {
					valor += v.getValorProdutosVendidos() * v.getQuantidade();
					lucro += v.getValorLucroTotal() * v.getQuantidade();
					valorProduto = v.getValorProdutosVendidos();
					nomeCategoria = v.getProdutosCategoria();
					nomeProduto = v.getProduto();
					quantidadeTotal = v.getQuantidade();
				}
			}
			break;
		case 'P':
			for (int i = 0; i < vendas.size(); i++) {
				Venda v = vendas.get(i);
				if(v.getProdutosCategoria() == "Eletroportáteis") {
					valor += v.getValorProdutosVendidos() * v.getQuantidade();
					lucro += v.getValorLucroTotal() * v.getQuantidade();
					valorProduto = v.getValorProdutosVendidos();
					nomeCategoria = v.getProdutosCategoria();
					nomeProduto = v.getProduto();
					quantidadeTotal = v.getQuantidade();
				}
			}
			break;
		
		case 'I':
			for (int i = 0; i < vendas.size(); i++) {
				Venda v = vendas.get(i);
				if(v.getProdutosCategoria() == "Informática") {
					valor += v.getValorProdutosVendidos() * v.getQuantidade();
					lucro += v.getValorLucroTotal() * v.getQuantidade();
					valorProduto = v.getValorProdutosVendidos();
					nomeCategoria = v.getProdutosCategoria();
					nomeProduto = v.getProduto();
					quantidadeTotal = v.getQuantidade();
				}
			}
			break;

		case 'T':
			for (int i = 0; i < vendas.size(); i++) {
				Venda v = vendas.get(i);
				if(v.getProdutosCategoria() == "TVs") {
					valor += v.getValorProdutosVendidos() * v.getQuantidade();
					lucro += v.getValorLucroTotal() * v.getQuantidade();
					valorProduto = v.getValorProdutosVendidos();
					nomeCategoria = v.getProdutosCategoria();
					nomeProduto = v.getProduto();
					quantidadeTotal = v.getQuantidade();
				}
			}
			break;

		case 'O':
			for (int i = 0; i < vendas.size(); i++) {
				Venda v = vendas.get(i);
				if(v.getProdutosCategoria() == "Outros") {
					valor += v.getValorProdutosVendidos() * v.getQuantidade();
					lucro += v.getValorLucroTotal() * v.getQuantidade();
					valorProduto = v.getValorProdutosVendidos();
					nomeCategoria = v.getProdutosCategoria();
					nomeProduto = v.getProduto();
				}
			}
			break;

		default:
			break;
		}
		
		sb.append(nomeCategoria+"\n");
		sb.append("Valor total vendido: "+df.format(valor)+"\n");
		sb.append("Lucro total: "+df.format(lucro)+"\n");
		sb.append("Produtos vendidos: "+quantidadeTotal);
				
		for (Venda v : vendas) {
			if(v.getProdutosCategoria() == nomeCategoria) {
				sb.append("\n========================\n");
				sb.append("Produto: "+nomeProduto+"\n");
				sb.append("Quantidade: "+v.getQuantidade()+"\n");
				sb.append("Valor único do produto:"+df.format(valorProduto));
			}
		}
		return sb.toString();
	}
	
			//TODO String estoque
	
	public static String verificarPoucosProdutos() {
		StringBuffer sb = new StringBuffer();
		for (Produto p : produtos) {
			if(p.getProdutosDisponiveis() <=5) 
				sb.append(p.getNome()+" está acabando!\nQuantidade atual: "+p.getProdutosDisponiveis()+"\n\n");
		}
		return sb.toString();
	}
	
	
			//TODO String Fechamento
	
	public static String[][] dadosFechamento() {
		String[][] x = new String[2][5];
		Double valorLucro = 0D;
		int quant = 0;
		int numMax = 0;
		Colaborador colaborador = new Colaborador();
		Produto produto = new Produto();
		df = new DecimalFormat("#0.00");
		
		for (int i = 0; i < vendas.size(); i++) {
			Venda v = vendas.get(i);
			valorLucro += v.getValorLucroTotal() * v.getQuantidade();
			quant += v.getQuantidade();
		}
		for (Colaborador c : colaboradores) {
			if(numMax < c.getNumVendas()) {
				colaborador = c;
				break;
			}
		}
		for (Produto p : produtos) {
			if(numMax < p.getProdutosVendidos()) {
				produto = p;
			}
		}
		x[1][0] = quant+"";
		x[1][1] = "R$ "+df.format(valorLucro)+"";
		x[1][2] = colaborador.getNome();
		x[1][3] = "R$ "+df.format(colaborador.getComissao())+"";
		x[1][4] = produto.getNome();
		return x;
	}
	
	public static String relatorioEstoque() {
		StringBuilder sb = new StringBuilder();
		sb.append("Quantidade atual de cada produto:\n\n");
		for (Produto p : produtos) {
			sb.append(p.getNome()+" : "+p.getProdutosDisponiveis()+"\n");
		}
		return sb.toString();
	}
	
}