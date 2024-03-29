package com.morface.grandmafia_roleplaying

import android.content.Context
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.morface.grandmafia_roleplaying.localization.BaseActivity
import com.morface.grandmafia_roleplaying.my_theme.MainEvent
import com.morface.grandmafia_roleplaying.my_theme.MainViewModel
import com.morface.grandmafia_roleplaying.screens.DrawerContent
import com.morface.grandmafia_roleplaying.screens.ScaffoldContent
import com.morface.grandmafia_roleplaying.screens.TopBarContent
import com.morface.grandmafia_roleplaying.save_image_to_gallery.saveToGallery
import com.morface.grandmafia_roleplaying.save_image_to_gallery.takeScreenshotOfView
import com.morface.grandmafia_roleplaying.storage.Storage
import com.morface.grandmafia_roleplaying.ui.theme.AppTheme
import com.morface.grandmafia_roleplaying.ui.theme.GrandRolePlayingTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import kotlin.random.Random

class MainActivity : BaseActivity() {
    private val viewModel: MainViewModel = MainViewModel()
    private val context: Context = this

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retriveTheme(context, viewModel)

        setContent {
            CompositionLocalProvider(
                LocalLayoutDirection
                        provides LayoutDirection.Rtl
            ) {
                GrandRolePlayingTheme(viewModel.stateApp.theme) {

                    AppContent(viewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppContent(viewModel: MainViewModel) {
    val enteredNumbers = remember { mutableStateListOf("", "", "", "", "", "", "", "", "") }

    var result by remember { mutableStateOf("") }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val scenarios = listOf(
        stringResource(R.string.Scenario_hacker),
        stringResource(R.string.scenario_haker_tofangsaz),
        stringResource(R.string.scenario_haker_togangsaz_kaboy),
        stringResource(R.string.scenario_haker_togangsaz_kaboy_mahigir),
        stringResource(R.string.scenario_tofangsaz),
        stringResource(R.string.scenario_tofangsaz_karolin),
        stringResource(R.string.scenario_tofangsaz_karolin_nokhbe),
        stringResource(R.string.scenario_nokhbe)
    )

    var selectedOption by remember { mutableStateOf(scenarios[2]) }
    val enterPlayerNumbersText = stringResource(R.string.enter_player_numbers)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent(viewModel)
            }
        },
    ) {
        Scaffold(
            topBar = {
                TopBarContent(drawerState, scope)
            }, bottomBar = {
                Box(
                    contentAlignment = Alignment.Center, modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            result = ""
                            val selectedRules: Int = selectedOption.split(" - ").size
                            val players = mutableListOf<String>()

                            for (i in 0 until enteredNumbers.count()) {
                                if (enteredNumbers[i] != "") {
                                    players.add(enteredNumbers[i])
                                }
                            }

                            if (players.size >= selectedRules) {
                                val randomInts =
                                        makeRandList(0, players.count(), selectedRules)
                                    for (i in 0 until selectedRules) {
                                        result +=
                                            "${selectedOption.split(" - ")[i]} : ${players[randomInts[i]]}\n"
                                    }
                            } else {
                                result = enterPlayerNumbersText
                            }
                        },
                        shape = MaterialTheme.shapes.small
                    ) {
                        Text(text = stringResource(R.string.give_roles_to_players))
                    }
                }
            }
        )
        {
            ScaffoldContent(
                it,
                enteredNumbers,
                result,
                scenarios,
                selectedOption
            )

            Column(modifier = Modifier.padding(it)) {
                Card(modifier = Modifier.padding(8.dp)) {
                    Column {
                        Text(
                            text = stringResource(R.string.enter_numbers),
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.secondary)
                                .padding(4.dp)
                                .fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(3),
                            modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
                        ) {
                            items(9) { index ->
                                TextField(
                                    value = enteredNumbers[index],
                                    onValueChange = { value ->
                                        enteredNumbers[index] = value
                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number
                                    ),
                                    modifier = Modifier.padding(horizontal = 8.dp)
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Card(modifier = Modifier.padding(8.dp)) {
                    Column() {
                        Text(
                            text = stringResource(R.string.select_roles),
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.secondary)
                                .padding(4.dp)
                                .fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                        //DropDown
                        var expanded by remember { mutableStateOf(false) }
                        Box(modifier=Modifier.padding(8.dp)) {
                            ExposedDropdownMenuBox(
                                expanded = expanded,
                                onExpandedChange = { expanded = !expanded },
                            ) {
                                TextField(
                                    modifier = Modifier
                                        .menuAnchor()
                                        .fillMaxWidth(),
                                    readOnly = true,
                                    value = selectedOption,
                                    onValueChange = {},
                                    label = { Text(stringResource(R.string.select_a_scenario)) },
                                    trailingIcon = {
                                        ExposedDropdownMenuDefaults.TrailingIcon(
                                            expanded = expanded
                                        )
                                    },
                                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                                )
                                ExposedDropdownMenu(
                                    expanded = expanded,
                                    onDismissRequest = { expanded = false },
                                ) {
                                    scenarios.forEach { selected ->
                                        DropdownMenuItem(
                                            text = { Text(selected) },
                                            onClick = {
                                                selectedOption = selected
                                                expanded = false
                                            },
                                        )
                                    }
                                }
                            }
                        }
                        ShowResults(result)
                    }


                }
            }
        }
    }
}

@Composable
fun GridItem(text: String, onEvent: () -> Unit) {
    OutlinedButton(
        modifier = Modifier.padding(horizontal = 4.dp), shape = MaterialTheme.shapes.extraSmall,
        onClick = { onEvent() }
    ) {
        Text(text = text)
    }
}

@Composable
fun NavListHeaders(text: String) {
    Text(
        text, color = MaterialTheme.colorScheme.onPrimaryContainer, fontWeight = FontWeight.Bold,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(8.dp)
            .fillMaxWidth()
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShowResults(result: String) {

    if (result.isEmpty()) {
        Box(modifier = Modifier.padding(8.dp))
    } else {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
                .fillMaxWidth(), shape = MaterialTheme.shapes.extraSmall
        ) {
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .paint(
                        painterResource(id = R.drawable.grandmafia_light),
                        contentScale = ContentScale.Crop,
                        alpha = 0.1F
                    )
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    val view = LocalView.current
                    val context = LocalContext.current
                    val configuration = LocalConfiguration.current
                    val density = LocalDensity.current

                    val widthInDp = configuration.screenWidthDp.dp
                    val heightInDp = configuration.screenHeightDp.dp

                    val widthInPx = with(density) { widthInDp.roundToPx() }
                    val heightInPx = with(density) { heightInDp.roundToPx() }

                    val toastText = stringResource(R.string.image_saved_in_your_gallery)



                    Text(text = result, fontSize = 22.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {

                            val bitmap: Bitmap = takeScreenshotOfView(
                                view = view,
                                height = heightInPx,
                                width = widthInPx
                            )
                            val time = Calendar.getInstance().time
                            val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
                            val current = formatter.format(time)

                            saveToGallery(context, bitmap, current)
                            Toast.makeText(
                                context,
                                toastText,
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        shape = MaterialTheme.shapes.small
                    ) {
                        Text(stringResource(R.string.take_screen_shot))
                    }
                }
            }

        }
    }
}

fun makeRandList(from: Int, until: Int, take: Int): List<Int> {
    val randomInts = generateSequence {
        Random.nextInt(from, until)
    }
        .distinct()
        .take(take)
        .toList()

    return randomInts
}

fun retriveTheme(context: Context, viewModel: MainViewModel): AppTheme {
    val theme = Storage(context = context).getTheme()

    if (theme.isNotEmpty()) {
        for (item in AppTheme.values()) {
            if (theme == item.toString()) {
                viewModel.onEvent(MainEvent.ThemeChange(item))
            }
        }
    }

    return AppTheme.Dark
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES, locale = "fa")
@Composable
fun AppPreview() {
    val viewModel = MainViewModel()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        AppContent(viewModel)
    }
}
