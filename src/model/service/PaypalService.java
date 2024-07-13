package model.service;

/**
 * The PaypalService class implements the OnlinePaymentService interface
 * to provide payment fee and interest calculations specific to Paypal.
 */
public class PaypalService implements OnlinePaymentService {

    /**
     * Calculates the payment fee based on the specified amount.
     * @param amount The amount on which the fee is calculated.
     * @return The calculated payment fee.
     */
    @Override
    public Double paymentFee(Double amount) {
        return amount * 0.02;
    }

    /**
     * Calculates the interest based on the specified amount and months.
     * @param amount The principal amount on which interest is calculated.
     * @param months The number of months for which interest is calculated.
     * @return The calculated interest amount.
     */
    @Override
    public Double interest(Double amount, Integer months) {
        return amount * 0.01 * months;
    }

}
