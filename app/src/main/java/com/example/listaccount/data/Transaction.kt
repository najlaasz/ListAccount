package com.example.listaccount.data

import java.math.BigDecimal
import java.time.LocalTime

data class Transaction(
    val account: Account,
    val time: LocalTime,
    val type: TransactionType,
    val amount: BigDecimal,
    val transactor: String
)

enum class TransactionType {
    DEPOSIT,
    WITHDRAW
}