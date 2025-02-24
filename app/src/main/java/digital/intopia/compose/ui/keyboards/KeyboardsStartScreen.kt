/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.keyboards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import digital.intopia.compose.R
import androidx.compose.ui.unit.dp
import digital.intopia.compose.ui.helpers.GenericScaffold
import digital.intopia.compose.ui.helpers.SimpleTextField

@Composable
fun KeyboardsStartScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_keyboards_start),
        onBackPressed = onBackPressed
    ) { modifier: Modifier ->
        val scrollState = rememberScrollState()
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
                .imePadding()
        ) {
            Text("The text fields below all use the default soft keyboard.")
            Text("Configuring TextFields to use a keyboard that reflects the expected data can reduce effort and errors.")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            // FIXME: Extend the SimpleTextField to accept a KeyboardType
            // FIXME: Apply the relevant KeyboardType to the text fields below
            SimpleTextField("First name")
            SimpleTextField("Web address")
            SimpleTextField("Age")
            SimpleTextField("Phone number")
            SimpleTextField("Email")
            SimpleTextField("Amount")
            SimpleTextField("One-time password")
        }
    }
}

@Preview
@Composable
fun PreviewKeyboardsStartScreen() {
    KeyboardsStartScreen {  }
}