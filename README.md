# Bank account management kata for arolla

To run the api : ./mvnw spring-boot:run

BankAccount Controller : GET http://localhost:8080/api/v1/bank/bankaccount/bankaccounts/NL51ABNA4892894109

Get all operation : GET localhost:8080/api/v1/bank/operation/operations/NL51ABNA4892894109

OperationController : POST http://localhost:8080/api/v1/bank/operation/operation

    {
            "amount": 150.00,
            "operationType": "DEPOSIT",
            "bankAccountDto": {
                
                "balance": 800.00,
                "clientDto": null,
                "operationDtos": null,
                "iban": "NL51ABNA4892894109"
            },
            "createdDate": "2021-01-05T15:36:08+0000"
    }
