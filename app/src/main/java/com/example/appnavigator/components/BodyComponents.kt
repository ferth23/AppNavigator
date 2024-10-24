package com.example.appnavigator.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TitleView ( name: String ) {
    Text (
        text = name,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun Space () {
    Spacer (
        modifier = Modifier.height ( 10.dp )
    )
}

@Composable
fun MainButton ( name:String, backColor: Color, color: Color, onClick:() -> Unit ) {
    Button (
        onClick = onClick,
        colors = ButtonDefaults.buttonColors (
            contentColor = color,
            containerColor = backColor
        )
    ) {
        Text ( text = name )
    }
}

@Composable
fun MainCard ( titulo: String, numero: String, modifier: Modifier=Modifier ) {
    Card (
        modifier = Modifier,
        colors = CardDefaults.cardColors ( containerColor = Color.LightGray )
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding ( 16.dp )
        ) {
            Text ( text = titulo, color = Color.Black, fontSize = 20.sp )
            Text ( text = "$$numero", color = Color.Black, fontSize = 20.sp )
        }
    }
}

@Composable
fun TwoCards ( titulo1: String, numero1: String, titulo2: String, numero2: String ) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        MainCard (
            titulo = titulo1,
            numero = numero1,
            modifier = Modifier
                .padding ( 30.dp )
                .weight ( 1f )
        )

        SpaceW ( 30.dp )

        MainCard (
            titulo = titulo2,
            numero = numero2,
            modifier = Modifier
                .padding ( 30.dp )
                .weight ( 1f )
        )
    }
}

@Composable
fun TextFields ( value: String, onValueChange: (String) -> Unit, label: String ) {
    OutlinedTextField (
        value = value,
        onValueChange = onValueChange,
        label= { Text ( text= label ) },
        keyboardOptions = KeyboardOptions ( keyboardType = KeyboardType.Number ),
        modifier = Modifier
            .fillMaxWidth()
            .padding ( horizontal = 30.dp )
    )
}

@Composable
fun ReusableButton ( text: String, color: Color = MaterialTheme.colorScheme.primary, onClick: () -> Unit ) {
    OutlinedButton (
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors (
                contentColor = color,
                containerColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding ( horizontal = 30.dp )
    ) {
        Text ( text = text )
    }
}

@Composable
fun SpaceH ( size: Dp = 5.dp ) {
    Spacer ( modifier = Modifier.height ( size ) )
}

@Composable
fun SpaceW ( size: Dp = 5.dp ) {
    Spacer ( modifier = Modifier.width ( size ) )
}




















