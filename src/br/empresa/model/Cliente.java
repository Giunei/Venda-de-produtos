package br.empresa.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	static Integer codigoAtual = 0;
	private Integer codigo;
	private String 	nome;
	private String	telefone;
	private String 	email;
	private Double 	valorTotalGasto;
	
	static List<Produto> produtosComprados = new ArrayList<Produto>();
	
	//Construtores
	
	public Cliente(String nome, String telefone, String email) {
		super();
		this.codigo = codigoAtual;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.valorTotalGasto = 0.0;
	}
	
	public Cliente() {
		this.codigo = codigoAtual;
		this.valorTotalGasto = 0.0;
	}

	
	//Gets e Sets
	
	public String getNome() {
		return nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Double getValorTotalGasto() {
		return valorTotalGasto;
	}
	
	//Hash Code
	
	
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Codigo: "+this.codigo+"\n");
		sb.append("Nome: "+this.nome+"\n");
		sb.append("Telefone: "+this.telefone+"\n");
		sb.append("Email: "+this.email+"\n");
		sb.append("Valor Total Gasto: "+this.valorTotalGasto+"\n");
		return sb.toString();
	}
	
	//Métodos
	
	
	public void incrementar() {
		codigoAtual++;
	}
	
}
