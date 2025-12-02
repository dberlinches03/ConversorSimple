package com.example.conversorsimple

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.conversorsimple.ui.theme.ConversorSimpleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConversorSimpleTheme {
                Convertor()
            }
        }
    }
}

@Composable
fun Convertor(
    viewModel: ConversorViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Conversor de Temperatura")
        Spacer(modifier = Modifier.padding(8.dp))

        OutlinedTextField(
            value = viewModel.valorEntrada.value,
            onValueChange = { viewModel.onValueChange(it) },
            label = { Text(text = "Valor") }
        )

        Spacer(modifier = Modifier.padding(16.dp))
        Row {
            Button(onClick = { viewModel.convertToFarenheit() }) {
                Text("ºF")
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Button(onClick = { viewModel.convertToCelsius() }) {
                Text("ºC")
            }
        }

        Text(text = viewModel.resultado.value)
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConversorSimpleTheme {
        Convertor()
    }
}
