package com.fexed.caputdraconis.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.fexed.caputdraconis.AndroidSpellsLoader.Companion.CSVFile
import com.fexed.caputdraconis.Spell

import com.fexed.caputdraconis.getSpellsLoader

class SpellListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CSVFile = assets.open("Incantesimi.csv")
        val spellsLoader = getSpellsLoader()
        val spells = spellsLoader.LoadSpells()

        setContent {
            CaputDraconisTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SpellList(spells = spells)
                }
            }
        }
    }
}

@Composable
fun SpellList(spells: List<Spell>) {
    Surface(shape = MaterialTheme.shapes.large, modifier = Modifier.padding(horizontal = 16.dp), elevation = 10.dp) {
        LazyColumn {
            items(items = spells, itemContent =  { spell ->
                SpellListElement(spell = spell)
                Divider()
            })
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SpellListElement(spell: Spell) {
    var showSpellDialog by remember { mutableStateOf(false)}

    if (showSpellDialog) SpellDialog(spell = spell) { showSpellDialog = false }

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
fun SpellDialog(spell: Spell, onClose: () -> Unit) {
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
                    Text(text = spell.categoria, fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Difesa: ${spell.difinc}", fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = spell.descrizione, modifier = Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = spell.fonte,
                        fontSize = 10.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End)
                }
            }
        }
    }
}

@Preview
@Composable
fun ListPreview() {
    CaputDraconisTheme {
        Column {
            SpellListElement(Spell("Nome", "Descrizione", "Difesa", "Categoria", "Fonte"))
            SpellListElement(Spell("Nome", "Descrizione", "Difesa", "Categoria", "Fonte"))
            SpellListElement(Spell("Nome", "Descrizione", "Difesa", "Categoria", "Fonte"))
        }
    }
}

@Preview
@Composable
fun DialogPreview() {
    CaputDraconisTheme {
        SpellDialog(Spell("Nome", "Descrizione molto molto lunga\nDescrizione molto molto lunga\nDescrizione molto molto lunga\nDescrizione molto molto lunga\n", "Difesa", "Categoria", "Fonte")) {}
    }
}
