package br.empresa.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.empresa.enumered.Categoria;

public class Estoque {
	
	private int indiceProduto;
	private int quantidade;
	private Produto produto = new Produto();
	
	public Estoque() {
		this.indiceProduto = 0;
		this.quantidade = 0;
	}
	
	public void adicionarProdutos(Integer indiceProduto, int quantidade) {
		this.indiceProduto = indiceProduto;
		this.quantidade = quantidade;
		for (Produto p : Empresa.produtos) {
			if(p.getCodigo().equals(indiceProduto)) {
				p.setProdutosDisponiveis(p.getProdutosDisponiveis()+quantidade);
				this.produto = p;
			}
		}
	}
	
	public void removerProdutos(Integer indiceProduto, int quantidade) {
		this.indiceProduto = indiceProduto;
		this.quantidade = quantidade;
		for (Produto p : Empresa.produtos) {
			if(p.getCodigo().equals(indiceProduto)) {
				p.setProdutosDisponiveis(p.getProdutosDisponiveis()-quantidade);
				this.produto = p;
			}
		}
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Produto: "+this.produto.getNome()+"\n");
		sb.append("Categoria: "+this.produto.getCategoria()+"\n");
		sb.append("Quantidade alterada: "+this.quantidade+"\n");
		sb.append("Quantidade atual: "+produto.getProdutosDisponiveis());
		return sb.toString();
	}
	

}
