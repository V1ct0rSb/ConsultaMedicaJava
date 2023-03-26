package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Consulta;
import entities.Medico;
import entities.Paciente;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		ArrayList<Medico> medicos = new ArrayList<Medico>();
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		ArrayList<Consulta> consultas = new ArrayList<Consulta>();

		int opcao = -1;

		while (opcao != 0) {
			System.out.println("========== Menu Consultório ==========");
			System.out.println("1 - Cadastro de Médicos");
			System.out.println("2 - Cadastro de Pacientes");
			System.out.println("3 - Cadastro de Consultas");
			System.out.println("4 - Cancelamento de Consultas");
			System.out.println("5 - Relatório de Consultas Agendadas");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				cadastrarMedico(medicos, sc);
				break;
			case 2:
				cadastrarPaciente(pacientes, sc);
				break;
			case 3:
				cadastrarConsulta(medicos, pacientes, consultas, sc);
				break;
			case 4:
				cancelarConsulta(consultas, sc);
				break;
			case 5:
				relatorioConsultas(consultas, sc);
				break;
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
			System.out.println();
		}

		sc.close();
	}

//MÉDICO
	public static void cadastrarMedico(ArrayList<Medico> medicos, Scanner sc) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println();
		System.out.println("=-=-= Cadastro de Médicos =-=-=");
		System.out.print("Digite o CRM do MÉDICO: ");
		sc.nextLine();
		String crm = sc.nextLine();

		// Verificar se existe médico com msm CRM
		for (Medico medico : medicos) {
			if (medico.getCrm() == crm) {
				System.out.println("Já EXISTE um médico cadastrado com esse CRM!");
				return;
			}
		}

		System.out.print("Digite o NOME do MÉDICO: ");
		String nome = sc.nextLine();
		System.out.print("Digite a DATA DE NASCIMENTO do MÉDICO (dd/mm/aaaa): ");
		Date dataNascimento = sdf.parse(sc.next());

		System.out.print("Digite a DATA DE CADASTRO do MÉDICO (dd/mm/aaaa): ");
		Date dataCadastro = sdf.parse(sc.next());
		
		//Estanciar
		Medico novoMedico = new Medico(crm, nome, dataNascimento, dataCadastro);
		medicos.add(novoMedico);

		System.out.println("Médico cadastrado com sucesso!");
		System.out.println(novoMedico);

	}

//PACIENTE
	public static void cadastrarPaciente(ArrayList<Paciente> pacientes, Scanner sc) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println();
		System.out.println("=-=-= Cadastro de Pacientes =-=-=");
		System.out.print("Digite o CPF do PACIENTE: ");
		sc.nextLine();
		String cpf = sc.nextLine();

		// Verificar se existe paciente com msm CPF
		for (Paciente paciente : pacientes) {
			if (paciente.getCpf() == cpf) {
				System.out.println("Já EXISTE um paciente cadastrado com esse CPF!");
				return;
			}
		}

		System.out.print("Digite o NOME do PACIENTE: ");
		String nome = sc.nextLine();
		System.out.print("Digite a DATA DE NASCIMENTO do PACIENTE (dd/mm/aaaa): ");
		Date dataNascimento = sdf.parse(sc.next());
		System.out.print("Digite a DATA DE CADASTRO do PACIENTE (dd/mm/aaaa): ");
		Date dataCadastro = sdf.parse(sc.next());
		System.out.print("Digite o ENDEREÇO do PACIENTE: ");
		sc.nextLine();
		String endereco = sc.nextLine();

		//Estanciar
		Paciente novoPaciente = new Paciente(cpf, nome, dataNascimento, dataCadastro, endereco);
		pacientes.add(novoPaciente);

		System.out.println("Paciente cadastrado com sucesso!");
		System.out.println(novoPaciente);
		System.out.println(pacientes);
	}

//CONSULTA
	public static void cadastrarConsulta(ArrayList<Medico> medicos, ArrayList<Paciente> pacientes,
			ArrayList<Consulta> consultas, Scanner sc) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");

		System.out.println();
		System.out.println("==== Cadastro de Consultas ====");

		// Listar os médicos disponíveis
		System.out.println("Médicos disponíveis: ");
		for (Medico medico : medicos) {
			System.out.println(medico.getCrm() + " - " + medico.getNome());
		}

		System.out.print("Digite o CRM do MÉDICO: ");
		sc.nextLine();
		String crm = sc.nextLine();

		System.out.println();

		// Encontrar o médico correspondente
		Medico medicoEscolhido = null;
		for (Medico medico : medicos) {
			if (medico.getCrm().equals(crm)) {
				medicoEscolhido = medico;
				break;
			}
		}

		if (medicoEscolhido == null) {
			System.out.println("Médico NÃO encontrado.");
			return;
		}

		// Listar os pacientes disponíveis
		System.out.println("Pacientes disponíveis: ");
		for (Paciente paciente : pacientes) {
			System.out.println(paciente.getCpf() + " - " + paciente.getNome());
		}
		System.out.print("Escolha o paciente (digite o CPF): ");
		String cpf = sc.next();

		// Buscar o paciente escolhido
		Paciente pacienteEscolhido = null;
		for (Paciente paciente : pacientes) {
			if (paciente.getCpf().equals(cpf)) {
				pacienteEscolhido = paciente;
				break;
			}
		}

		if (pacienteEscolhido == null) {
			System.out.println("Paciente NÃO encontrado.");
			return;
		}

		System.out.print("Digite a DATA da consulta (dd/mm/aaaa): ");
		Date dataConsulta = sdf.parse(sc.next());
		System.out.print("Digite o HORÁRIO da consulta (hh:mm:ss): ");
		Date horaConsulta = sdf2.parse(sc.next());

		System.out.print("É a primeira consulta desse paciente com esse médico? (S/N) ");

		char resp = sc.next().charAt(0);
		boolean primeiraConsulta = false;
		if (resp == 'S' || resp == 's') {
			primeiraConsulta = true;
		}
		double valor = primeiraConsulta ? 350.0 : 300.0;
		String status = "Agendada";

		Consulta novaConsulta = new Consulta(medicoEscolhido, pacienteEscolhido, dataConsulta, horaConsulta,
				primeiraConsulta, status, valor);
		consultas.add(novaConsulta);

		System.out.println("Consulta cadastrada com sucesso!");

		System.out.println(novaConsulta);
		System.out.println(consultas);

	}

	public static void cancelarConsulta(ArrayList<Consulta> consultas, Scanner sc) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println();
		System.out.println("==== Cancelamento de Consultas ====");

		System.out.print("Digite o CRM do médico da consulta: ");
		String crm = sc.next();

		System.out.print("Digite o CPF do paciente da consulta: ");
		String cpf = sc.next();

		System.out.print("Digite a DATA da consulta (dd/mm/aaaa): ");
		Date dataConsulta = sdf.parse(sc.next());

		boolean consultaCancelada = false;
		// Procurar a consulta a ser cancelada
		for (Consulta consulta : consultas) {
			if (consulta.getMedico().getCrm().equals(crm) && consulta.getPaciente().getCpf().equals(cpf)
					&& consulta.getDataConsulta().equals(dataConsulta)) {
				consultas.remove(consulta);
				System.out.println("Consulta cancelada com sucesso!");
				return;
			}
		}

		if (!consultaCancelada) {
			System.out.println("Consulta NÃO encontrada!");
		}
	}

	public static void relatorioConsultas(ArrayList<Consulta> consultas, Scanner sc) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("==== Relatório de Consultas Agendadas ====");
		System.out.print("Digite a data desejada para o relatório (dd/mm/aaaa):");
		sc.nextLine();
		Date dataConsulta = sdf.parse(sc.next());
		System.out.print("Digite o CRM do médico desejado: ");
		sc.nextLine();
		String crm = sc.nextLine();

		double valorTotal = 0.0;
		int quantidadeConsultas = 0;
		for (Consulta consulta : consultas) {
			if (consulta.getDataConsulta().equals(dataConsulta) && consulta.getMedico().getCrm().equals(crm)
					&& consulta.getStatusConsulta().equals("Agendada")) {
				Paciente paciente = consulta.getPaciente();
				Medico medico = consulta.getMedico();
				String dataConsultaStr = new SimpleDateFormat("dd/MM/yyyy").format(consulta.getDataConsulta());
				String horaConsultaStr = new SimpleDateFormat("HH:mm").format(consulta.getHoraConsulta());
				String primeiraConsultaStr = consulta.isPrimeiraConsulta() ? "Sim" : "Não";
				System.out.println("Paciente: " + paciente.getNome());
				System.out.println("Médico: " + medico.getNome());
				System.out.println("Data: " + dataConsultaStr);
				System.out.println("Hora: " + horaConsultaStr);
				System.out.println("Primeira consulta? " + primeiraConsultaStr);
				System.out.println("Valor da consulta: R$ " + consulta.getValorConsulta());
				System.out.println();
				quantidadeConsultas++;
				valorTotal += consulta.getValorConsulta();
			}
			
			else {
				System.out.println("Valores informados NÃO encontrado");
		}
		}

		System.out.println("Quantidade de consultas agendadas: " + quantidadeConsultas);
		System.out.println("Valor total das consultas: R$ " + valorTotal);
	}
}
