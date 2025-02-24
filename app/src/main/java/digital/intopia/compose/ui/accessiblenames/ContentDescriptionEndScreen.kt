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
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import digital.intopia.compose.R
import digital.intopia.compose.ui.helpers.GenericScaffold
import digital.intopia.compose.ui.helpers.ShowAlert
import digital.intopia.compose.ui.helpers.StandaloneLink

@Composable
fun ContentDescriptionEndScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_content_description_end),
        onBackPressed = onBackPressed
    ) { modifier: Modifier ->
        val (isAddUserAlertOpen, setIsAddUserAlertOpen) = remember { mutableStateOf(false) }
        val (isDeleteAlertOpen, setIsDeleteAlertOpen) = remember { mutableStateOf(false) }
        val scrollState = rememberScrollState()
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp
            ),
            modifier = modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
        ) {
            Text("Use contentDescription when an element doesn't have a meaningful label in code.")
            Text("Use the Layout Inspector or TalkBack to check an element's label.")
            Text("A contentDescription must include the element's on-screen text (if any) to avoid impacting the Voice Access experience.")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Labelled icon buttons", style = MaterialTheme.typography.bodyLarge)
            Row {
                IconButton(
                    onClick = { setIsAddUserAlertOpen(true) }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.outline_person_add_24),
                        contentDescription = "Add user"
                    )
                }

                IconButton(
                    onClick = { setIsDeleteAlertOpen(true) },
                    modifier = Modifier.semantics { contentDescription = "Delete file" }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.outline_delete_24),
                        contentDescription = null
                    )
                }
            }
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Enhanced link label", style = MaterialTheme.typography.bodyLarge)
            StandaloneLink("More", "https://stonemaiergames.com/games/wingspan", "More about birds")

            if (isAddUserAlertOpen) {
                ShowAlert(setIsAddUserAlertOpen, "Add person button tapped")
            }
            if (isDeleteAlertOpen) {
                ShowAlert(setIsDeleteAlertOpen, "Delete file button tapped")
            }
        }
    }
}

@Preview
@Composable
fun PreviewContentDescriptionEndScreen() {
    ContentDescriptionEndScreen {  }
}