# Bank account management kata for arolla

To run the api : ./mvnw spring-boot:run

BankAccount Controller : GET http://localhost:8080/api/v1/bank/bankaccount/bankaccounts/NL51ABNA4892894109

Get all transaction : GET localhost:8080/api/v1/bank/transaction/transactions/NL51ABNA4892894109

Transactions Controller : POST http://localhost:8080/api/v1/bank/transaction/transaction

    {
            "amount": 150.00,
            "transactionType": "DEPOSIT",
            "bankAccountDto": {
                
                "balance": 800.00,
                "clientDto": null,
                "transactionDtos": null,
                "iban": "NL51ABNA4892894109"
            },
            "createdDate": "2021-01-05T15:36:08+0000"
    }
