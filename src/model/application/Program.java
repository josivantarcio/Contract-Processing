package model.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

/**
 * The Program class contains the main method to interactively process a contract,
 * calculate installments, and display them using user input.
 */
public class Program {

    /**
     * Main method to execute the contract processing application.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Prompt user for contract details
        System.out.println("Entre os dados do contrato:");
        System.out.print("Numero: ");
        int numero = sc.nextInt();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(sc.next(), dtf);

        System.out.println("Valor do contrato: ");
        Double valorContrato = sc.nextDouble();

        System.out.print("Entre com o numero de parcelas: ");
        int parcelas = sc.nextInt();

        // Create a new Contract object based on user input
        Contract contract = new Contract(numero, data, valorContrato);

        // Create a ContractService instance using PaypalService for payment processing
        ContractService service = new ContractService(new PaypalService());

        // Process the contract to calculate installments
        service.processContract(contract, parcelas);

        // Display the installments generated for the contract
        System.out.println("Parcelas: ");
        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }

        sc.close();
    }

}
