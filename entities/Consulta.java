package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Consulta {
	private Medico medico;
	private Paciente paciente;
	
	private Date dataConsulta;
	private Date horaConsulta;
	private boolean primeiraConsulta;
	private String statusConsulta;
	private double valorConsulta;

	public Consulta(Medico medico, Paciente paciente, Date dataConsulta, Date horaConsulta, boolean primeiraConsulta,
			String statusConsulta, double valorConsulta) {
		this.medico = medico;
		this.paciente = paciente;
		this.dataConsulta = dataConsulta;
		this.horaConsulta = horaConsulta;
		this.primeiraConsulta = primeiraConsulta;
		this.statusConsulta = statusConsulta;
		this.valorConsulta = valorConsulta;
	}

	public Medico getMedico() {
		return medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public Date getHoraConsulta() {
		return horaConsulta;
	}

	public boolean isPrimeiraConsulta() {
		return primeiraConsulta;
	}

	public String getStatusConsulta() {
		return statusConsulta;
	}

	public double getValorConsulta() {
		return valorConsulta;
	}

	public void setMedico(Medico médico) {
		this.medico = médico;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public void setHoraConsulta(Date horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	public void setPrimeiraConsulta(boolean primeiraConsulta) {
		this.primeiraConsulta = primeiraConsulta;
	}

	public void setStatusConsulta(String statusConsulta) {
		this.statusConsulta = statusConsulta;
	}

	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Consulta [medico=" + medico + ", paciente=" + paciente + ", dataConsulta=" + sdf.format(dataConsulta)
				+ ", primeiraConsulta=" + primeiraConsulta + " statusConsulta :" + statusConsulta + " valorConsulta"+ valorConsulta + "]";
		
	}


	
}