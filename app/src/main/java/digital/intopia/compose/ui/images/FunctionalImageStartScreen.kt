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
import androidx.compose.ui.tooling.preview.Preview
import digital.intopia.compose.R
import androidx.compose.ui.unit.dp
import digital.intopia.compose.ui.helpers.GenericScaffold

@Composable
fun FunctionalImageStartScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_functional_image_start),
        onBackPressed = onBackPressed
    ) { modifier: Modifier ->
        val scrollState = rememberScrollState()
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp
            ),
            modifier = modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
        ) {
            Text("The icon buttons below are not labelled properly in code.")
            Text("A null contentDescription doesn't tell TalkBack users what a button's action is.")
            Text("Use contentDescription to define a descriptive label for an interactive element.")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Unlabelled icon button #1", style = MaterialTheme.typography.bodyLarge)
            val context = LocalContext.current
            IconButton(
                onClick = {
                    Toast.makeText(context, "Dismiss notification button tapped", Toast.LENGTH_LONG).show()
                }
            ) {
                // FIXME: Update the Icon contentDescription which the button will inherit.
                Icon(Icons.Outlined.Clear, contentDescription = null)
            }
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Unlabelled icon button #2", style = MaterialTheme.typography.bodyLarge)
            IconButton(
                // FIXME: Add a contentDescription to the button itself
                onClick = {
                    Toast.makeText(context, "Delete all files button tapped", Toast.LENGTH_LONG).show()
                }
            ) {
                Icon(Icons.Outlined.Delete, contentDescription = null)
            }
        }
    }
}

@Preview
@Composable
fun PreviewFunctionalImageStartScreen() {
    FunctionalImageStartScreen {  }
}