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
import com.fexed.caputdraconis.duels.DuelTimerUtility
import com.fexed.caputdraconis.duels.DuelUtility
import kotlinx.coroutines.Job
import java.util.*

class TimerModeActivity : ComponentActivity() {
    lateinit var duelTimer: Job
    lateinit var spellTimer: Job

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
            var currentSpell by remember {
                mutableStateOf(newSpell(spellList, activity))
            }
            var currentPoints by remember {
                mutableStateOf(0)
            }

            duelTimer = DuelTimerUtility().createDuelTimer {
                activity.finish()
            }
            duelTimer.start()

            spellTimer = DuelTimerUtility().createSpellTimer {
                currentSpell = newSpell(spellList, activity)
            }
            spellTimer.start()

            CaputDraconisTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = currentSpell.nome /*+ ">" + currentSpell.difinc */,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            fontSize = 42.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                            Button(onClick = {
                                if (checkSpell(currentSpell, "Finite")) {
                                    currentSpell = newSpell(spellList, activity)
                                    currentPoints++
                                } else finish()
                            }) {
                                Text(text = "Finite", fontSize = 20.sp)
                            }
                            Button(onClick = {
                                if (checkSpell(currentSpell, "Protego")) {
                                    currentSpell = newSpell(spellList, activity)
                                    currentPoints++
                                } else finish()
                            }) {
                                Text(text = "Protego", fontSize = 20.sp)
                            }
                            Button(onClick = {
                                if (checkSpell(currentSpell, "Scutum")) {
                                    currentSpell = newSpell(spellList, activity)
                                    currentPoints++
                                } else finish()
                            }) {
                                Text(text = "Scutum", fontSize = 20.sp)
                            }
                        }
                        Text(text = getString(R.string.incnumb) + ": $currentPoints")
                        //Text(text = "Elapsed: ${duelTimer.elapsedSeconds}s")
                    }
                }
            }
        }
    }

    override fun onPause() {
        spellTimer.cancel()
        duelTimer.cancel()
        finish()
        super.onPause()
    }
}