package br.empresa.model;

import java.text.DecimalFormat;
import java.util.ArrayList;

import br.empresa.enumered.Categoria;

public class Produto {
	
	private Integer codigo;
	private String nome;
	private Categoria categoria;
	private Double valorCompra;
	private Double valorVenda;
	private Double valorLucro;
	private Integer produtosDisponiveis;
	private Integer produtosVendidos;
	static Integer codigoAtual = 0;
	static DecimalFormat df = new DecimalFormat();
	
	
	//Construtores
	
	public Produto(String nome, Categoria categoria, Double valorCompra, Double valorVenda, Integer produtosDisponiveis) {
		super();
		this.codigo = codigoAtual;
		this.nome = nome;
		this.categoria = categoria;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
		this.produtosDisponiveis = produtosDisponiveis;
		this.produtosVendidos = 0;
		this.valorLucro = valorVenda - valorCompra;
	}

	public Produto() {
		this.codigo = codigoAtual;
		this.produtosVendidos = 0;
	}

	
	//Gets e Sets
	
	
	public String getNome() {
		return nome;
	}

	public Double getValorLucro() {
		return valorLucro;
	}

	public void setValorLucro(Double valorLucro) {
		this.valorLucro = valorLucro;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	public Integer getProdutosDisponiveis() {
		return produtosDisponiveis;
	}

	public void setProdutosDisponiveis(Integer produtosDisponiveis) {
		this.produtosDisponiveis = produtosDisponiveis;
	}
	
	public Integer getProdutosVendidos() {
		return produtosVendidos;
	}

	public void setProdutosVendidos(Integer produtosVendidos) {
		this.produtosVendidos = produtosVendidos;
	}
	
	//HashCode
	

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	//toString
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Código: "+this.codigo+"\n");
		sb.append("Nome: "+this.nome+"\n");
		sb.append("Categoria: "+this.categoria+"\n");
		sb.append("Quantidade Disponível: "+this.produtosDisponiveis+"\n");
		sb.append("Preço de Venda: "+this.valorVenda+"\n");
		return sb.toString();
	}
	
	
	//Métodos
	
	public void incrementar() {
		codigoAtual++;
	}
	
	public static Boolean verificarProdutosDisponiveis(int indiceProduto, int quantidade) {
		Produto p = new Produto();
		for (Produto pr : Empresa.produtos) {
			if(pr.getCodigo().equals(indiceProduto)) {
				p = pr;
			}
		}
		if(p.getProdutosDisponiveis() < 0 | quantidade > p.getProdutosDisponiveis()) {
			return false;
		}
		return true;
	}
	
}
