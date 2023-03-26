package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Paciente {
	private String cpf;
	private String nome;
	private Date dataNascimento;
	private Date dataCadastro;
	private String endereco;

	public Paciente(String cpf, String nome, Date dataNascimento, Date dataCadastro, String endereco) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.endereco = endereco;
	}

	// getters e setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return "Paciente [CPF=" + cpf + ", nome=" + nome + ", dataNascimento=" + format.format(dataNascimento)
				+ ", dataCadastro=" + format.format(dataCadastro) + ", endereco=" + endereco + "]";
	}
}
