package com.morface.grandmafia_roleplaying.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.morface.grandmafia_roleplaying.GridItem
import com.morface.grandmafia_roleplaying.NavListHeaders
import com.morface.grandmafia_roleplaying.R
import com.morface.grandmafia_roleplaying.my_theme.MainEvent
import com.morface.grandmafia_roleplaying.my_theme.MainViewModel
import com.morface.grandmafia_roleplaying.storage.Storage
import com.morface.grandmafia_roleplaying.ui.theme.AppTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DrawerContent(viewModel: MainViewModel) {

    val context = LocalContext.current

    var bannerImageId by remember {
        mutableStateOf(R.drawable.usa_flag_round_icon_64)
    }

    val darkStr: String = stringResource(R.string.dark)

    var enableDarkItems by remember {
        mutableStateOf(true)
    }

    bannerImageId = if (enableDarkItems) {
        R.drawable.grandmafia_light
    } else {
        R.drawable.grandmafia_dark
    }


    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = bannerImageId),
                contentDescription = "App Drawer Logo",
                contentScale = ContentScale.Fit
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(R.string.grand_mafia_team),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item { Spacer(modifier = Modifier.height(8.dp)) }
            stickyHeader {
                NavListHeaders(text = stringResource(R.string.theme))
            }
        }
        Divider(thickness = 1.dp)

        LazyVerticalGrid(
            modifier = Modifier.padding(horizontal = 16.dp),
            columns = GridCells.Fixed(2),
            content = {
                items(AppTheme.values()) {
                    GridItem(
                        text = it.toString(),
                        onEvent = {
                            viewModel.onEvent(MainEvent.ThemeChange(it))
                            enableDarkItems = it.toString().contains(darkStr)
                            println(it.toString())
                            Storage(context).setTheme(it.toString())
                        }
                    )
                }
            }
        )
        Divider(thickness = 1.dp)
        //
        NavListHeaders(text = stringResource(R.string.about))
        Column(modifier = Modifier.padding(start = 16.dp, top = 8.dp)) {
            Text(
                text = stringResource(R.string.with_love_for_grand_mafia_team),
            )
            Text(text = stringResource(R.string.programmer_alireza_pazhouhesh))
            Text(text = stringResource(R.string.kotlin_with_jetpack_compose))
            Text(text = "")
        }
        NavListHeaders(text = stringResource(R.string.contact))
        Column(modifier = Modifier.padding(start = 16.dp, top = 8.dp)) {
            val uriHandler = LocalUriHandler.current
            val rubikaLink = "https://rubika.ir/joing/EDBAEEJH0TEDCHTQGTWSFMWCUGGVNOQZ"
            Text(text = stringResource(R.string.rubika_channel), modifier = Modifier.clickable {
                uriHandler.openUri(rubikaLink)
            })
            Text(stringResource(R.string.panco_group_grand_mafia))
        }
    }
}