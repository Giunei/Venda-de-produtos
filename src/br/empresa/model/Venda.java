package br.empresa.model;

import java.text.DecimalFormat;
import java.util.ArrayList;

import br.empresa.enumered.Categoria;

public class Venda {
	
//	Efetuar uma venda para um cliente, de um determinado produto realizada por um determinado vendedor
//	Relatório total de vendas
//	Relatório de vendas por Categoria
	
	private Integer codigo;
	static Integer codigoAtual = 0;
	
	private String produto;
	private String comprador;
	private String vendedor;
	private Integer quantidade;
	private Double valorProdutosVendidos;
	private Double valorLucroTotal;
	static DecimalFormat df = new DecimalFormat();
	private String produtosCategoria = "";
	
	//Construtor
	
	
	
	public Venda() {
		codigo = codigoAtual;
		this.produto = "";
		this.comprador = "";
		this.vendedor = "";
		this.quantidade = 0;
		this.valorProdutosVendidos = 0.0;
		this.valorLucroTotal = 0.0;
		this.produtosCategoria = "";
	}
	

	public Venda(String produto, String comprador, String vendedor, Integer quantidade) {
		super();
		codigo = codigoAtual;
		this.produto = produto;
		this.comprador = comprador;
		this.vendedor = vendedor;
		this.quantidade = quantidade;
		this.produtosCategoria = nomeCategoria(produto);
		this.valorProdutosVendidos = 0.0;
		this.valorLucroTotal = 0.0;
	}


	//GETS e SETS
	
	public String getProduto() {
		return produto;
	}


	public void setProduto(String produto) {
		this.produto = produto;
	}


	public String getComprador() {
		return comprador;
	}


	public void setComprador(String comprador) {
		this.comprador = comprador;
	}


	public String getVendedor() {
		return vendedor;
	}


	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Double getValorProdutosVendidos() {
		return valorProdutosVendidos;
	}


	public void setValorProdutosVendidos(Double valorProdutosVendidos) {
		this.valorProdutosVendidos = valorProdutosVendidos;
	}


	public Double getValorLucroTotal() {
		return valorLucroTotal;
	}


	public void setValorLucroTotal(Double valorLucroTotal) {
		this.valorLucroTotal = valorLucroTotal;
	}


	public String getProdutosCategoria() {
		return produtosCategoria;
	}


	public void setProdutosCategoria(String produtosCategoria) {
		this.produtosCategoria = produtosCategoria;
	}


	public Integer getCodigo() {
		return codigo;
	}
	
	
	
	//MÉTODOS
	public void incrementar() {
		codigoAtual++;
	}
	
	public static String nomeCategoria(String produto) {
		String nome = "";
		
		for (Produto p : Empresa.produtos) {
			if(p.getNome() == produto) {
				if(p.getCategoria() == Categoria.CELULARES) {
					nome = "Celulares";
				}else if(p.getCategoria() == Categoria.ELETRODOMESTICOS) {
					nome = "Eletrodomésticos";
				}else if(p.getCategoria() == Categoria.ELETROPORTATEIS) {
					nome = "Eletroportáteis";
				}else if(p.getCategoria() == Categoria.INFORMATICA) {
					nome = "Informática";
				}else if(p.getCategoria() == Categoria.TV) {
					nome = "TVs";
				}else {
					nome = "Outros";
				}
			}
		}

		return nome;
	}
	
	public void setarValoresVenda(Integer indiceProduto, int quantidade) {
		for (Produto p : Empresa.produtos) {
			if(p.getCodigo().equals(indiceProduto)) {
				p.setProdutosVendidos(p.getProdutosVendidos()+quantidade);
				p.setProdutosDisponiveis(p.getProdutosDisponiveis()-quantidade);
				this.valorProdutosVendidos = p.getValorVenda();
				this.valorLucroTotal = p.getValorLucro();
			}
		}
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Vendedor: "+this.vendedor+"\n");
		sb.append("Comprador: "+this.comprador+"\n");
		sb.append("Produto: "+this.produto+"\n");
		sb.append("Quantidade: "+this.quantidade+"\n");
		sb.append("Categoria: "+this.produtosCategoria+"\n");
		return sb.toString();
	}

}
