/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.images

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import digital.intopia.compose.R
import androidx.compose.ui.unit.dp
import digital.intopia.compose.ui.helpers.GenericScaffold

@Composable
fun FunctionalImageEndScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_functional_image_end),
        onBackPressed = onBackPressed
    ) { modifier: Modifier ->
        val scrollState = rememberScrollState()
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
        ) {
            Text("The icon buttons below are labelled in code.")
            Text("The first button's label comes from the contentDescription applied to its child icon")
            Text("The second button's label is from its own contentDescription.")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Labelled icon button #1", style = MaterialTheme.typography.bodyLarge)
            val context = LocalContext.current
            IconButton(
                onClick = {
                    Toast.makeText(context, "Dismiss notification button tapped", Toast.LENGTH_LONG).show()
                }
            ) {
                Icon(Icons.Outlined.Clear,
                    contentDescription = "Dismiss notification")
            }
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Labelled icon button #2", style = MaterialTheme.typography.bodyLarge)
            IconButton(
                onClick = {
                    Toast.makeText(context, "Delete all files button tapped", Toast.LENGTH_LONG).show()
                },
                modifier = Modifier.semantics { contentDescription = "Delete all files" },
            ) {
                Icon(Icons.Outlined.Delete, contentDescription = null)
            }
        }
    }
}

@Preview
@Composable
fun PreviewFunctionalImageEndScreen() {
    FunctionalImageEndScreen {  }
}