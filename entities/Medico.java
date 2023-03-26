package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Medico {
	private String crm;
	private String nome;
	private Date dataNascimento;
	private Date dataCadastro;

	public Medico(String crm, String nome, Date dataNascimento, Date dataCadastro) {
		this.crm = crm;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
	}

	// getters e setters
	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
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

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Médico [CRM=" + crm + ", nome=" + nome + ", dataNascimento=" + sdf.format(dataNascimento)
				+ ", dataCadastro=" + sdf.format(dataCadastro) + "]";
	}
}
