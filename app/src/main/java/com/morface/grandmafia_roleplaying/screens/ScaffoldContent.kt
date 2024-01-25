package com.morface.grandmafia_roleplaying.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
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
    result: String,
    radioOptions: List<String>,
    selectedOption: String
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
        ShowResults(result)
    }
}
