package com.morface.grandmafia_roleplaying.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.morface.grandmafia_roleplaying.R
import com.morface.grandmafia_roleplaying.ShowResults

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScaffoldContent(
    it: PaddingValues,
    enteredNumbers: SnapshotStateList<String>,
    cityRoles: List<String>,
    chipStates: SnapshotStateList<Boolean>,
    result: String
) {
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
        SelectRolesCard(cityRoles, chipStates)
        ShowResults(result)
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SelectRolesCard(cityRoles: List<String>, chipStates: SnapshotStateList<Boolean>) {
    val numbers = List(size = 4) { it + 1 }
    Card(modifier = Modifier.padding(8.dp)) {
        Column {
            Text(
                text = stringResource(R.string.select_roles),
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
                items(numbers) { number ->
                    Row(horizontalArrangement = Arrangement.Center) {
                        FilterChip(
                            selected = chipStates[number - 1],
                            onClick = { chipStates[number - 1] = !chipStates[number - 1] },
                            label = { Text(cityRoles[number - 1]) },
                            colors = InputChipDefaults.inputChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primary,
                                selectedLabelColor = MaterialTheme.colorScheme.onTertiary,
                            ),
                            leadingIcon = if (chipStates[number - 1]) {
                                {
                                    Icon(
                                        imageVector = Icons.Filled.Done,
                                        contentDescription = "Done icon",
                                        tint = MaterialTheme.colorScheme.onPrimary
                                    )
                                }
                            } else {
                                null
                            },
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        }
    }
}