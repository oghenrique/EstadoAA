package br.senai.sp.jandira.estadoaa

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.estadoaa.ui.theme.EstadoAATheme
import java.net.PasswordAuthentication

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EstadoAATheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var nomeState = remember {
        mutableStateOf("")
    }

    var opcaoState = remember {
        mutableStateOf(false)
    }

    val contexto = LocalContext.current

    Column {
        OutlinedTextField(
            value = nomeState.value,
            onValueChange = {
                nomeState.value = it
                Log.i("SENAI",
                    "VALOR: $it"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword
            ),
            visualTransformation = PasswordVisualTransformation()
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = opcaoState.value ,
                onCheckedChange = {
                    opcaoState.value = it
                }
            )
            Text(text = "Opção 1")
        }
        Text(text = nomeState.value)
        Button(onClick = {
            Toast.makeText(
                contexto,
                nomeState.value,
                Toast.LENGTH_SHORT
            ).show()
        }) {
            Text(text = "Clique me!!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EstadoAATheme {
        Greeting("Android")
    }
}