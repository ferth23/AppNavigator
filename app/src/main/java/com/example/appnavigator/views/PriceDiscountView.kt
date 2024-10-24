package com.example.appnavigator.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.appnavigator.components.MainIconButton
import com.example.appnavigator.components.ReusableButton
import com.example.appnavigator.components.SpaceH
import com.example.appnavigator.components.TextFields
import com.example.appnavigator.components.TitleBar
import com.example.appnavigator.components.TwoCards

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PriceDiscountView ( navController: NavController ) {
    Scaffold (
        topBar = {
            TopAppBar (
                title = {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        MainIconButton ( icon = Icons.AutoMirrored.Filled.ArrowBack ) {
                            navController.popBackStack()
                        }
                        TitleBar ( name = "Price Discount View" )
                        MainIconButton ( icon = Icons.AutoMirrored.Filled.ArrowForward ) {
                            navController.navigate ("Lottery" )
                        }
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors (
                    containerColor = Color.Cyan
                )
            )
        }
    ) {
        PriceDiscountContent ( it )
    }
}

@Composable
fun PriceDiscountContent ( paddingValues: PaddingValues ) {
    Column (
        modifier= Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var precioDescuento by remember { mutableStateOf("") }
        var precioTotal by remember { mutableStateOf("") }

        TwoCards (
            titulo1 = "Total",
            numero1 = precioTotal,
            titulo2 = "Descuento",
            numero2 = precioDescuento
        )

        TextFields (
            value = precio,
            onValueChange = {precio = it},
            label = "Precio"
        )

        SpaceH()

        TextFields (
            value = descuento,
            onValueChange = { descuento = it },
            label = "Descuento"
        )

        SpaceH ( 10.dp )

        ReusableButton ( text = "Calcular" ) {
            if ( precio != "" && descuento != "" ) {
                precioDescuento = ( precio.toDouble() * descuento.toDouble() / 100 ).toString()
                precioTotal = ( precio.toDouble() - precioDescuento.toDouble() ).toString()
            } else {
//                Alerta (
//                    title = "Sistema",
//                    mensaje = "Falta un valor",
//                    mensajeConfirma = "Está bien,
//                    onConfirmClick = { TODO }
//                ) {
//                }
            }
        }

        SpaceH ( 10.dp )

        ReusableButton ( text = "Borrar" ) {
            precio = ""
            descuento = ""
            precioTotal = ""
            precioDescuento = ""
        }
    }
}