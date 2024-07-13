package model.service;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

/**
 * The ContractService class handles the processing of contracts,
 * including the calculation of installments based on specified months,
 * using an OnlinePaymentService for interest and fee calculations.
 */
public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    /**
     * Constructs a ContractService with the specified OnlinePaymentService.
     * @param onlinePaymentService The service used for payment calculations.
     */
    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    /**
     * Processes the given contract to calculate installments based on the number of months.
     * Each installment is calculated with interest and fees from the OnlinePaymentService.
     * @param contract The contract to be processed.
     * @param months The number of months for installment calculation.
     */
    public void processContract(Contract contract, Integer months) {

        double parcelaBase = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {

            LocalDate validadeDate = contract.getDate().plusMonths(i);

            double interest = onlinePaymentService.interest(parcelaBase, i);
            double fee = onlinePaymentService.paymentFee(parcelaBase + interest);
            double quota = parcelaBase + interest + fee;

            contract.getInstallments().add(new Installment(validadeDate, quota));

        }

    }

}
