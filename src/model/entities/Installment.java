package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The Installment class represents an installment of a contract, containing
 * information about the due date and amount to be paid.
 */
public class Installment {

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate dueDate;
    private Double amount;

    /**
     * Default constructor for Installment.
     */
    public Installment() {
    }

    /**
     * Constructs an Installment with specified due date and amount.
     * @param dueDate The due date of the installment.
     * @param amount The amount to be paid for this installment.
     */
    public Installment(LocalDate dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    /**
     * Retrieves the due date of the installment.
     * @return The due date of the installment.
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date of the installment.
     * @param dueDate The due date to be set.
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Retrieves the amount to be paid for this installment.
     * @return The amount of the installment.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets the amount to be paid for this installment.
     * @param amount The amount to be set.
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Returns a string representation of the Installment object.
     * @return A string representation including due date and amount.
     */
    @Override
    public String toString() {
        return dueDate.format(dtf) + " - " + String.format("%.2f", amount);
    }

}
