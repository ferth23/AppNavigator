package com.example.appnavigator.views

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.example.appnavigator.R
import com.example.appnavigator.components.TitleBar
import com.example.appnavigator.components.MainIconButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogYearCalculatorView ( navController: NavController ) {
    Scaffold (
        topBar = {
            TopAppBar (
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Red
                ),
                title = {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TitleBar ( name = "Dog Years Calculator View" )
                        MainIconButton ( icon = Icons.AutoMirrored.Filled.ArrowForward ) {
                            navController.navigate ("PriceDiscount" )
                        }
                    }
                }
            )
        }
    ) {
        DogYearCalculatorContent ( modifier = Modifier )
    }
}

@Composable
fun DogYearCalculatorContent ( modifier: Modifier = Modifier ) {
    val image = painterResource ( id = R.drawable.dog )
    var edad by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column (
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ) {
        Image (
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(500.dp, 300.dp)
                .padding(top = 100.dp)
        )

        Text (
            text = "Mis años perrunos",
            style = MaterialTheme.typography.titleMedium,
            fontSize = 35.sp,
            modifier = Modifier
                .padding ( 0.dp, 30.dp, 0.dp, 10.dp )
        )

        OutlinedTextField (
            value = edad,
            onValueChange = {
                if ( edad.isDigitsOnly() ) {
                    edad = it
                } else {
                    Toast.makeText ( context, "Ingresa un número", Toast.LENGTH_SHORT ).show()
                }
            },
            label = { Text ("Edad humana" ) },
            placeholder = { Text ("Edad humana" ) },
            leadingIcon = {
                Icon (
                    imageVector = Icons.Default.Face, contentDescription = "faceIcon"
                ) },
            keyboardOptions = KeyboardOptions ( keyboardType = KeyboardType.Number ),
            modifier = Modifier
                .width ( 400.dp )
                .padding ( 20.dp, 20.dp, 20.dp, 40.dp )
        )

        ElevatedButton(
            onClick = {
                var res = 0
                res = edad.toInt() * 7
                resultado = res.toString()
            },
            modifier = Modifier
                .width ( 220.dp )
                .height ( 60.dp )
        ) {
            Text (
                text = "Calcular",
                fontSize = 20.sp
            )
        }

        OutlinedTextField (
            value = resultado,
            onValueChange = { resultado = it },
            label = { Text ("Edad perruna" ) },
            placeholder = { Text ("Edad perruna" ) },
            readOnly = true,
            modifier = Modifier
                .width ( 400.dp )
                .padding ( 20.dp, 40.dp, 20.dp, 40.dp )
        )

        ElevatedButton (
            onClick = {
                edad = ""
                resultado = ""
            },
            modifier = Modifier
                .width ( 220.dp )
                .height ( 60.dp )
        ) {
            Text (
                text = "Borrar",
                fontSize = 20.sp
            )
        }
    }
}