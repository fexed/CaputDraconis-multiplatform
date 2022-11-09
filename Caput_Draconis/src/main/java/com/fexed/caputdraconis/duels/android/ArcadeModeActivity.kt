package com.fexed.caputdraconis.duels.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fexed.caputdraconis.AndroidSpellsLoader
import com.fexed.caputdraconis.android.CaputDraconisTheme
import com.fexed.caputdraconis.duels.android.DuelActivity.Companion.checkSpell
import com.fexed.caputdraconis.duels.android.DuelActivity.Companion.newSpell
import com.fexed.caputdraconis.getSpellsLoader
import com.fexed.caputdraconis.android.R
import java.util.*

class ArcadeModeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSpellsLoader.CSVFile = if (Locale.getDefault().language == "it")
            assets.open("Incantesimi.csv")
        else
            assets.open("IncantesimiEN.csv")
        val spellsLoader = getSpellsLoader()
        val spellList = spellsLoader.LoadSpells()
        val activity = this

        setContent {
            var currentSpell = remember {
                mutableStateOf(newSpell(spellList, activity))
            }
            var currentPoints = remember {
                mutableStateOf(0)
            }
            var errors by remember {
                mutableStateOf(0)
            }

            DuelActivity.GameScene(
                activity = this,
                currentSpell = currentSpell,
                currentPoints = currentPoints,
                finiteAction = {
                    if (checkSpell(currentSpell.value, "Finite")) {
                        currentSpell.value = newSpell(spellList, activity)
                        currentPoints.value++
                    } else {
                        errors++
                        if (errors == 3) finish()
                        else currentSpell.value = newSpell(spellList, activity)
                    }
                },
                protegoAction = {
                    if (checkSpell(currentSpell.value, "Protego")) {
                        currentSpell.value = newSpell(spellList, activity)
                        currentPoints.value++
                    } else {
                        errors++
                        if (errors == 3) finish()
                        else currentSpell.value = newSpell(spellList, activity)
                    }
                },
                scutumAction = {
                    if (checkSpell(currentSpell.value, "Scutum")) {
                        currentSpell.value = newSpell(spellList, activity)
                        currentPoints.value++
                    } else {
                        errors++
                        if (errors == 3) finish()
                        else currentSpell.value = newSpell(spellList, activity)
                    }
                },
                bottom = { Text(text = stringResource(id = R.string.currerrors) + " " + errors, modifier = Modifier.padding(8.dp))}
            )
        }
    }
}