/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.accessiblenames

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import digital.intopia.compose.R
import digital.intopia.compose.ui.helpers.GenericScaffold
import digital.intopia.compose.ui.helpers.ShowAlert
import digital.intopia.compose.ui.helpers.StandaloneLink

@Composable
fun ContentDescriptionStartScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_content_description_start),
        onBackPressed = onBackPressed
    ) { modifier: Modifier ->
        val (isAddPersonAlertOpen, setIsAddPersonAlertOpen) = remember { mutableStateOf(false) }
        val (isDeleteAlertOpen, setIsDeleteAlertOpen) = remember { mutableStateOf(false) }
        val scrollState = rememberScrollState()
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp
            ),
            modifier = modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
        ) {
            Text("The icon buttons below are not labelled in code.")
            Text("The link label below is generic, it's impossible to know what it's about.")
            Text("Use contentDescription to define a custom label for an element.")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Unlabelled icon buttons", style = MaterialTheme.typography.bodyLarge)
            Row {
                IconButton(onClick = { setIsAddPersonAlertOpen(true) }) {
                    Icon(
                        painter = painterResource(R.drawable.outline_person_add_24),
                        // FIXME: Update the Icon contentDescription
                        contentDescription = null
                    )
                }
                // FIXME: Label the IconButton itself rather than the child Icon
                IconButton(onClick = { setIsDeleteAlertOpen(true) }) {
                    Icon(
                        painter = painterResource(R.drawable.outline_delete_24),
                        contentDescription = null
                    )
                }
            }
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Generic link", style = MaterialTheme.typography.bodyLarge)

            // FIXME: Add contextual custom label
            StandaloneLink("More", "https://stonemaiergames.com/games/wingspan")

            if (isAddPersonAlertOpen) {
                ShowAlert(setIsAddPersonAlertOpen, "Add person button tapped")
            }
            if (isDeleteAlertOpen) {
                ShowAlert(setIsDeleteAlertOpen, "Delete file button tapped")
            }
        }
    }
}

@Preview
@Composable
fun PreviewContentDescriptionStartScreen() {
    ContentDescriptionStartScreen {  }
}