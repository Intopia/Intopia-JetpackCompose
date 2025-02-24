/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.formfieldinstructions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import digital.intopia.compose.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import digital.intopia.compose.ui.accessibledescriptions.LabelledTextFieldWithErrorAndHelpText
import digital.intopia.compose.ui.accessiblenames.LabelledTextField
import digital.intopia.compose.ui.helpers.GenericScaffold

@Composable
fun FormFieldInstructionsStartScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_form_field_instructions_start),
        onBackPressed = onBackPressed
    ) { modifier: Modifier ->
        val scrollState = rememberScrollState()
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
        ) {
            Text("The phone number text fields below are labelled in code, but TalkBack users don't hear the 10-digit instruction in the text field announcement.")
            Text("Both of the fields are required, but TalkBack doesn't mention this status either.")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Mandatory Material labelled text field with unattached instruction", style = MaterialTheme.typography.bodyLarge)
            val (phoneNum, setPhoneNum) = remember { mutableStateOf("") }
            OutlinedTextField(
                value = phoneNum,
                onValueChange = { newPhoneNum -> setPhoneNum(newPhoneNum) },
                label = { Text("Phone number")},
                modifier = Modifier
                    .fillMaxWidth()
            )
            // FIXME: Integrate help text into Material text field and add required status
            Text("Must be exactly 10 digits")

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Mandatory not-Material labelled text field with unattached instruction", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            LabelledTextFieldWithErrorAndHelpText(
                value = "",
                label = "Phone number"
            )
            // FIXME: Integrate help text into non-Material text field and add required status
            Text("Must be exactly 10 digits")
        }
    }
}

@Preview
@Composable
fun PreviewFormFieldInstructionsStartScreen() {
    FormFieldInstructionsStartScreen {  }
}