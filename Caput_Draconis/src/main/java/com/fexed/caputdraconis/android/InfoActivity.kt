package com.fexed.caputdraconis.android

import android.content.Context
import android.icu.text.IDNA.Info
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class InfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaputDraconisTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Credits(context = baseContext)
                }
            }
        }
    }
}

@Composable
fun Credits(context: Context) {
    Column(modifier = Modifier
        .padding(8.dp)
        .verticalScroll(rememberScrollState()) ) {
        Text(text = context.getString(R.string.appname),
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
    }
}