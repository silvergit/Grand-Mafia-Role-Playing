package com.morface.grandmafia_roleplaying.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.morface.grandmafia_roleplaying.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBarContent(drawerState: DrawerState, scope: CoroutineScope) {
    TopAppBar(
        title = { Text(stringResource(R.string.grand_mafia)) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
        actions = {
            Icon(
                Icons.Filled.Menu, "",
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .clickable {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed)
                                    open()
                                else
                                    close()
                            }
                        }
                    }
            )
        }
    )
}