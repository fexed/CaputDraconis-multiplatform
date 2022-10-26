package com.fexed.caputdraconis.android

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fexed.caputdraconis.Platform
import com.fexed.caputdraconis.getPlatform

class InfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaputDraconisTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Credits(context = this)
                }
            }
        }
    }
}

@Composable
fun Credits(context: ComponentActivity) {
    Column(modifier = Modifier
        .padding(8.dp)
        .verticalScroll(rememberScrollState()) ) {
        IconButton(onClick = { context.onBackPressed() }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
        }
        Text(text = context.getString(R.string.credits),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp))
        Text(text = context.getString(R.string.ideazioneesviluppotext),
             fontWeight = FontWeight.Bold,
             fontSize = 20.sp,
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(8.dp))
        Text(text = "Federico Matteoni")
        Text(text = context.getString(R.string.graficatext),
             fontWeight = FontWeight.Bold,
             fontSize = 20.sp,
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(8.dp))
        Text(text = "Saverio Landini\nMartina Crucianelli")
        Text(text = context.getString(R.string.ideazionegiocotext),
             fontWeight = FontWeight.Bold,
             fontSize = 20.sp,
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(8.dp))
        Text(text = "Saverio Landini")
        Text(text = context.getString(R.string.sceltaincantesimitext),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp))
        Text(text = "Saverio Landini\nMatteo Mascagni\nJacopo Di Vito\n(Team Duelli)")
        Text(text = context.getString(R.string.fontieformuletext),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp))
        Text(text = "Jacopo Di Vito")
        Text(text = context.getString(R.string.effettiecontrtext),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp))
        Text(text = "Matteo Mascagni")
        Text(text = context.getString(R.string.supportoconsulenzatext),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp))
        Text(text = "Mattia Coreno\nEleonora Ugolini")
        Text(text = context.getString(R.string.graziedirettivotext),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp, 0.dp, 0.dp))
        Text(text = context.getString(R.string.grazieragazzitext),
            modifier = Modifier
                .fillMaxWidth())
        Text(text = context.getString(R.string.disclaimer),
            modifier = Modifier
                .fillMaxWidth())
        Text(text = getPlatform().getVersion(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp))
    }
}