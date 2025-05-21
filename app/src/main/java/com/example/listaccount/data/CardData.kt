package com.example.listaccount.data

import java.time.LocalTime

object CardData {

    val account1 = Account(
    name = "Najla",
    balance = 3000.0.toBigDecimal()
)
    val transaction1 = Transaction(
        account = account1,
        amount = 30.0.toBigDecimal(),
        time = LocalTime.now(),
        type = TransactionType.WITHDRAW,
        transactor = "Ahmad"
    )

    val account2 = Account(
        name = "Nora",
        balance = 3000.0.toBigDecimal()
    )
    val transaction2 = Transaction(
        account = account2,
        amount = 30.0.toBigDecimal(),
        time = LocalTime.now(),
        type = TransactionType.WITHDRAW,
        transactor = "Ahmad"
    )

    val account3 = Account(
        name = "Ali",
        balance = 1500.0.toBigDecimal())

    val transaction3 = Transaction(
    account = account3,
    amount = 30.0.toBigDecimal(),
    time = LocalTime.now(),
    type = TransactionType.WITHDRAW,
    transactor = "Ahmad"
    )

    val transaction4 = Transaction(
    account = account3,
    amount = 100.0.toBigDecimal(),
    time = LocalTime.now().minusHours(1),
    type = TransactionType.DEPOSIT,
    transactor = "Bank Transfer"
    )


    val accountList = listOf(
        transaction1,
        transaction2,
        transaction3,
        transaction4
    )

}
