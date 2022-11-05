package com.fexed.caputdraconis.android

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
fun CreditBox(title: String, text: String) {
    Surface(modifier = Modifier.padding(16.dp)) {
        Column {
            Text(text = title,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp))
            Text(text = text,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp))
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
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painterResource(id = R.mipmap.ic_launcher_foreground), contentDescription = null)
        }
        CreditBox(
            title = context.getString(R.string.ideazioneesviluppotext),
            text = "Federico Matteoni"
        )
        CreditBox(
            title = context.getString(R.string.graficatext),
            text = "Saverio Landini\nMartina Crucianelli"
        )
        CreditBox(
            title = context.getString(R.string.ideazionegiocotext),
            text = "Saverio Landini"
        )
        CreditBox(
            title = context.getString(R.string.sceltaincantesimitext),
            text = "Saverio Landini\nMatteo Mascagni\nJacopo Di Vito\n(Team Duelli)"
        )
        CreditBox(
            title = context.getString(R.string.fontieformuletext),
            text = "Jacopo Di Vito"
        )
        CreditBox(
            title = context.getString(R.string.effettiecontrtext),
            text = "Matteo Mascagni"
        )
        CreditBox(
            title = context.getString(R.string.supportoconsulenzatext),
            text = "Mattia Coreno\nEleonora Ugolini"
        )
        Text(text = context.getString(R.string.graziedirettivotext),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp, 0.dp, 8.dp))
        Text(text = context.getString(R.string.grazieragazzitext),
            modifier = Modifier
                .fillMaxWidth())
        Text(text = context.getString(R.string.disclaimer),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp, 0.dp, 8.dp))
        Text(text = getPlatform().getVersion(),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp))
    }
}