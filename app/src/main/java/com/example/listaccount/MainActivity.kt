package com.example.listaccount

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listaccount.data.Account
import com.example.listaccount.data.CardData
import com.example.listaccount.data.Transaction
import com.example.listaccount.data.TransactionType
import com.example.listaccount.ui.theme.ListAccountTheme
import java.math.BigDecimal
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListAccountTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AccountStatementListScreen(
                        modifier = Modifier.padding(innerPadding),
                        CardData.accountList
                    )
                }
            }
        }
    }


}

@Composable
fun AccountStatementListScreen(modifier: Modifier, transactionList: List<Transaction>) {
    LazyColumn(modifier = modifier) {
      items (transactionList)
       { trans ->
            AccountCard(transaction = trans,
                modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun AccountCard(transaction: Transaction, modifier: Modifier) {
    Card(modifier = modifier.fillMaxWidth()) {
        val formatter = DateTimeFormatter.ofPattern("hh:mm a")
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = transaction.account.name, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Text(text = transaction.account.balance.toString())
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = transaction.transactor)
                Text(text = transaction.time.format(formatter))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${if (transaction.type == TransactionType.DEPOSIT) "+" else "-"} KWD ${transaction.amount.stripTrailingZeros().toPlainString()}",
                    color = if (transaction.type == TransactionType.DEPOSIT) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.error
                )
                Text(text = transaction.type.name)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListAccountTheme {


    }
}