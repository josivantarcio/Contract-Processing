package model.service;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

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
