# Contract Processing

## Description

This project aims to automate contract processing for a company, facilitating the generation of monthly installments based on a desired number of months. The system takes into account the simple interest applied to each installment and the payment fees of the online service used, currently PayPal.

## Features

- **Read Contract Data:** Input basic contract data such as number, date, and total value.
- **Installment Generation:** Generate payment installments based on the number of months provided.
- **Interest and Fee Calculation:** Apply simple interest of 1% per month and a payment fee of 2% per installment.
- **Installment Records:** Create payment records with adjusted dates and values.
- **Display Installment Data:** Show installment details on the screen.

## Technologies Used

- **Programming Language:** Java 17 LTS
- **Libraries:** Java Standard Libraries (e.g., `java.time` for date handling)

## Project Structure

The project follows a model-service structure with a clear separation of concerns:

- **Model:** Contains the core entities such as `Contract` and `Installment`.
- **Service:** Contains the business logic for processing contracts and integrating with online payment services.

## How to Use

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/josivantarcio/Contract-Processing.git
   ```
2. **Navigate to the Project Directory:**
   ```bash
   cd Contract-Processing
   ```
3. **Compile the Program:**
   ```bash
   javac -d bin src/model/application/Program.java
   ```
4. **Run the Program:**
   ```bash
   java -cp bin model.application.Program
   ```
5. **Enter Contract Data:** Follow the prompts to enter contract details, including number, date, total value, and number of installments.
6. **View Installments:** The generated installments will be displayed on the screen.

## Example

### Input
```
Enter contract data:
Number: 123
Date (dd/MM/yyyy): 01/07/2024
Total value: 1000.00
Enter the number of installments: 3
```

### Output
```
Installments:
01/08/2024 - 342.00
01/09/2024 - 343.42
01/10/2024 - 344.84
```

## Contributing

Contributions are welcome! Feel free to open issues and submit pull requests.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
