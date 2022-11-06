package com.fexed.caputdraconis.duel.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fexed.caputdraconis.android.Banner
import com.fexed.caputdraconis.android.CaputDraconisTheme
import com.fexed.caputdraconis.android.R
import com.fexed.caputdraconis.duels.DuelUtility

class DuelActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaputDraconisTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainMenu(context = this)
                }
            }
        }
    }

    @Composable
    fun MainMenu(context: ComponentActivity) {
        StandardScaffold(context = context, scaffoldState = rememberScaffoldState(), actions = {}) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Stats(context)
                Text(text = context.getString(R.string.selectmode),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp))
                ModeCard(
                    title = context.getString(R.string.survmode),
                    desc = context.getString(R.string.survmodedesc),
                    buttontxt = context.getString(R.string.play),
                    button = { /* TODO */ }
                )
                ModeCard(
                    title = context.getString(R.string.arcademode),
                    desc = context.getString(R.string.arcademodedesc),
                    buttontxt = context.getString(R.string.play),
                    button = { /* TODO */ }
                )
                ModeCard(
                    title = context.getString(R.string.timermode),
                    desc = context.getString(R.string.timermodedesc),
                    buttontxt = context.getString(R.string.play),
                    button = { /* TODO */ }
                )
            }
        }
    }

    @Composable
    fun ModeCard(title: String, desc: String, buttontxt: String, button: (() -> Unit)) {
        Surface(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()) {
            Column {
                Text(text = title,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp))
                Text(text = desc,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(), horizontalArrangement = Arrangement.Center) {
                    Button(onClick = button) {
                        Text(text = buttontxt)
                    }
                }
            }
        }
    }

    @Composable
    fun Stats(context: ComponentActivity) {
        Surface(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()) {
            Column {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = context.getString(R.string.incnumb))
                    Text(text = DuelUtility.getTotalSpellsNumber(context).toString(), modifier = Modifier.padding(0.dp, 0.dp, 24.dp, 0.dp))
                }
            }
        }
    }

    @Composable
    fun StandardScaffold(context: ComponentActivity, scaffoldState: ScaffoldState, actions: (@Composable RowScope.() -> Unit), content: (@Composable () -> Unit)) {
        Scaffold(scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    title = { Text(context.getString(R.string.minigame)) },
                    actions = actions,
                    navigationIcon = {
                        Icon(imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier.clickable { context.onBackPressed() })
                    }
                )
            },
            bottomBar = {
                Banner(bannerId = context.getString(R.string.test_banner_id))
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
}