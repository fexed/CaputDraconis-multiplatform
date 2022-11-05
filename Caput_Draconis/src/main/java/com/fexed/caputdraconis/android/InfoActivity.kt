package com.fexed.caputdraconis.android

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
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
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { context.onBackPressed() }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
            }
            Text(text = context.getString(R.string.back),
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable { context.onBackPressed() } )
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

        val annotatedString = buildAnnotatedString {
            pushStringAnnotation(tag = "policy", annotation = "https://www.facebook.com/associazionecaputdraconis")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.primary)) {
                append(context.getString(R.string.cdfacebook))
            }
            pop()

            append("\n")

            pushStringAnnotation(tag = "terms", annotation = "http://www.caputdraconis.it")

            withStyle(style = SpanStyle(color = MaterialTheme.colors.primary)) {
                append(context.getString(R.string.cdwebsite))
            }

            pop()
        }

        val uriHandler = LocalUriHandler.current

        ClickableText(text = annotatedString, onClick = { offset ->
            annotatedString.getStringAnnotations(tag = "policy", start = offset, end = offset).firstOrNull()?.let {
                uriHandler.openUri(it.item)
            }

            annotatedString.getStringAnnotations(tag = "terms", start = offset, end = offset).firstOrNull()?.let {
                uriHandler.openUri(it.item)
            }
        })

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