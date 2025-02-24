/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.accessiblenames

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import digital.intopia.compose.R
import digital.intopia.compose.ui.helpers.GenericScaffold

@Composable
fun TextFieldLabelStartScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_text_field_label_start),
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
            Text("The first text field below contains placeholder text but no label. TalkBack says the placeholder when the field is empty, but not when it is populated.")
            Text("The second text field below has a label on-screen, but it is not linked to the text field in code. TalkBack says \"Empty, edit box\" when the text field receives focus.")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Material TextField with placeholder, no label", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            val (firstName, setFirstName) = remember { mutableStateOf("") }
            // FIXME: Replace the placeholder with a persistent label
            OutlinedTextField(
                value = firstName,
                placeholder = { Text("First name") },
                onValueChange = { newFirstName -> setFirstName(newFirstName) },
                modifier = Modifier.fillMaxWidth()
            )
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("TextField with separate Text label", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            UnlabelledTextField(
                "",
                "Last name"
            )
        }
    }
}

@Composable
fun UnlabelledTextField(
    value: String,
    label: String
) {
    val (textValue, setTextValue) = remember { mutableStateOf(value) }
    // FIXME: Label the text field in code while maintaining the current layout
    Text(label)
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textValue,
        onValueChange = { newTextValue -> setTextValue(newTextValue) }
    )
}

@Preview
@Composable
fun PreviewTextFieldLabelStartScreen() {
    TextFieldLabelStartScreen {  }
}