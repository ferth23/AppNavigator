package com.example.appnavigator.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appnavigator.components.MainButton
import com.example.appnavigator.components.MainIconButton
import com.example.appnavigator.components.Space
import com.example.appnavigator.components.TitleBar

private val _lotoNumbers = mutableStateOf(emptyList<Int>())
val lotoNumbers: State<List<Int>> = _lotoNumbers

fun generateLotoNumbers() {
    _lotoNumbers.value = ( 1 .. 60 ).shuffled().take(6).sorted()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LotteryView ( navController: NavController ) {
    Scaffold (
        topBar = {
            TopAppBar (
                title = { TitleBar ( name = "Lottery View") },
                colors = TopAppBarDefaults.mediumTopAppBarColors (
                    containerColor = Color.Magenta
                ),
                navigationIcon = {
                    MainIconButton ( icon = Icons.AutoMirrored.Filled.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        LotteryContent ( navController )
    }
}

@Composable
fun LotteryContent ( navController: NavController ) {
    val lotoNumbers = lotoNumbers.value

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if ( lotoNumbers.isEmpty() ) {
            Text (
                text = "Lotería",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        } else {
            LotteryNumbers ( lotoNumbers )
        }

        Button (
            onClick = { generateLotoNumbers() }
        ) {
            Text (
                text = "Generar",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Space()

        MainButton (
            name = "Return to Dog Year Calculator View",
            backColor = Color.Magenta,
            color = Color.White
        ) {
            navController.navigate ( "DogYearsCalculator" )
        }
    }
}

@Composable
fun LotteryNumbers ( lotoNumbers: List<Int> ) {
    LazyRow (
        contentPadding = PaddingValues (
            horizontal = 16.dp,
            vertical = 8.dp
        )
    ) {
        items ( lotoNumbers ) { number ->
            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(48.dp)
                    .background(Color.Red, CircleShape)
            ) {
                Text (
                    text = number.toString(),
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }
    }
}