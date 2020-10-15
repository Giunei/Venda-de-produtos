package br.empresa.model;

import java.util.ArrayList;
import java.util.List;


public class Colaborador {
	
	private String nome;
	private String dataNascimento;
	private String cpf;
	private String telefone;
	private String email;
	private Double salario;
	private Integer codigo;
	private Integer numVendas;
	private Double comissao;
	private Double valorRecebido;
	static Integer codigoAtual = 0;
	
	
	
	///Construtores///
	
	public Colaborador(String nome, String dataNascimento, String cpf, String telefone, String email, Double salario) {
		super();
		this.codigo = codigoAtual;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.salario = salario;
		this.numVendas = 0;
		this.comissao = 0.0;
		this.valorRecebido = 0.0;
	}

	public Colaborador() {
		this.codigo = codigoAtual;
		this.numVendas = 0;
		this.comissao = 0.0;
		this.valorRecebido = 0.0;
	}
	
	
	///Gets e Sets///
	

	public String getNome() {
		return nome;
	}

	public Integer getNumVendas() {
		return numVendas;
	}

	public void setNumVendas(Integer numVendas) {
		this.numVendas = numVendas;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Double getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(Double valorVendido) {
		this.valorRecebido = valorVendido;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
	
	///HashCode and Equals///
	
	
	
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
		Colaborador other = (Colaborador) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	///toString///
	

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Nome: "+this.nome+"\n");
		sb.append("Data de nascimento: "+this.dataNascimento+"\n");
		sb.append("CPF: "+this.cpf+"\n");
		sb.append("Telefone: "+this.telefone+"\n");
		sb.append("E-mail: "+this.telefone+"\n");
		sb.append("Salário: "+this.salario);
		return sb.toString();
	}
	
	
	
	//Métodos
	
	
	public void incrementar() {
		codigoAtual++;
	}
	
}