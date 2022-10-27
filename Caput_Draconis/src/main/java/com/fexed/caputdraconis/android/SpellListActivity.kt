package com.fexed.caputdraconis.android

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import com.fexed.caputdraconis.AndroidSpellsLoader.Companion.CSVFile
import com.fexed.caputdraconis.Spell
import com.fexed.caputdraconis.SpellListUtility

import com.fexed.caputdraconis.getSpellsLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import kotlinx.coroutines.launch
import java.util.*

class SpellListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CSVFile = if (Locale.getDefault().language == "it")
            assets.open("Incantesimi.csv")
        else
            assets.open("IncantesimiEN.csv")
        val spellsLoader = getSpellsLoader()
        val spellList = spellsLoader.LoadSpells()

        setContent {
            var query by remember { mutableStateOf("") }
            val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()

            CaputDraconisTheme {
                StandardScaffold(context = this, scaffoldState = rememberScaffoldState(), actions =  {
                    IconButton(onClick = { startActivity(Intent(baseContext, InfoActivity::class.java)) }) {
                        Icon(Icons.Filled.Info, getString(R.string.info))
                    }
                }) {
                    LazyColumn(state = listState) {
                        item {
                            TextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                value = query,
                                onValueChange = { query = it },
                                placeholder = { Text(getString(R.string.search)) }
                            )
                        }
                        items(items = SpellListUtility.Search(query, spellList), itemContent =  { spell ->
                            SpellListElement(context = baseContext, spell = spell)
                            Divider()
                        })
                    }.run {
                        coroutineScope.launch {
                            listState.scrollToItem(1)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StandardScaffold(context: Context, scaffoldState: ScaffoldState, actions: (@Composable RowScope.() -> Unit), content: (@Composable () -> Unit)) {
    Scaffold(scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(context.getString(R.string.appname)) },
                actions = actions,
                navigationIcon = {
                    Image(
                        painterResource(R.drawable.shield),
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            )
        },
        bottomBar = {
            Banner(bannerId = "ca-app-pub-3940256099942544/2934735716")
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = MaterialTheme.colors.primaryVariant) {
                Text(text = "Game")
            }
        }
    ){
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colors.background,
            content = content
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SpellListElement(context: Context, spell: Spell) {
    var showSpellDialog by remember { mutableStateOf(false)}

    if (showSpellDialog) SpellDialog(context = context, spell = spell) { showSpellDialog = false }

    Surface(onClick = {showSpellDialog = true}) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)) {
            Text(text = spell.nome,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth())
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = spell.categoria,
                    fontSize = 14.sp)
                Text(text = spell.fonte,
                    fontSize = 10.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End)
            }
        }
    }
}

@Composable
fun SpellDialog(context: Context, spell: Spell, onClose: () -> Unit) {
    Dialog(onDismissRequest = onClose) {
        Surface(shape = MaterialTheme.shapes.large, elevation = 10.dp, modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()) {
            Box(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Column(modifier = Modifier
                    .padding(16.dp)
                    .wrapContentSize()) {
                    Text(text = spell.nome,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        modifier = Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "${context.getString(R.string.category)}: ${spell.categoria}", fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "${context.getString(R.string.defensivespell)}: ${spell.difinc}", fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = spell.descrizione, modifier = Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "${context.getString(R.string.source)}: ${spell.fonte}",
                        fontSize = 10.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End)
                }
            }
        }
    }
}

@Composable
fun Banner(bannerId: String) {
    AndroidView( modifier = Modifier.fillMaxWidth(),
        factory = { context ->
        AdView(context).apply {
            setAdSize(AdSize.BANNER)
            adUnitId = bannerId
            loadAd(AdRequest.Builder().build())
        }
    })
}
