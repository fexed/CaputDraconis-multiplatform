package com.fexed.caputdraconis.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

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