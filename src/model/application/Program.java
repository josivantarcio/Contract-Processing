package model.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Entre os dados do contrato:");
		System.out.print("Numero: ");
		int numero = sc.nextInt();

		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate data = LocalDate.parse(sc.next(), dtf);

		System.out.println("Valor do contrato: ");
		Double valorContrato = sc.nextDouble();

		System.out.print("Entre com o numero de parcelas: ");
		int parcelas = sc.nextInt();

		Contract contract = new Contract(numero, data, valorContrato);

		ContractService service = new ContractService(new PaypalService());
		service.processContract(contract, parcelas);

		System.out.println("Parcelas: ");
		for (Installment installment : contract.getInstallments()) {
			System.out.println(installment);
		}

		sc.close();
	}

}
