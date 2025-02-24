/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.accessibledescriptions

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import digital.intopia.compose.R
import digital.intopia.compose.ui.accessiblenames.LabelledTextField
import digital.intopia.compose.ui.helpers.GenericScaffold

@Composable
fun SupportingTextEndScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_supporting_text_end),
        onBackPressed = onBackPressed
    ) { modifier: Modifier ->
        val scrollState = rememberScrollState()
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
        ) {
            Text("The text fields below both have inline help text and error text located nearby, but this information is not linked to the text field in code.")
            Text("TalkBack does not say the information in its announcement of the text field, so some users may not understand the relationship between the instructions, the error, and the text field.")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Material TextField with attached error and instruction", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            val (homePhone, setHomePhone) = remember { mutableStateOf("") }
            OutlinedTextField(
                value = homePhone,
                onValueChange = { newHomePhone -> setHomePhone(newHomePhone) },
                isError = true,
                trailingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.baseline_error_24),
                        contentDescription = null
                    ) },
                label = { Text("Home phone")},
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    Column {
                        Text("Home phone is required")
                        Text("Include area code",
                            fontSize = 12.sp,
                            style = TextStyle(color = MaterialTheme.colorScheme.onSurfaceVariant))
                    }
                }
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Not-Material labelled text field with attached error and instruction", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            LabelledTextFieldWithErrorAndHelpText(
                "",
                "Mobile phone",
                "Mobile phone is required",
                "Australian mobile must start with 04"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabelledTextFieldWithErrorAndHelpText(
    value: String,
    label: String,
    error: String? = null,
    helpText: String? = null,
    isRequired: Boolean? = false
) {
    val (textValue, setTextValue) = remember { mutableStateOf(value) }

    BasicTextField(
        value = textValue,
        modifier = Modifier.semantics (mergeDescendants = true) { contentDescription =
            label +
                    if (error != null) { ", error, $error" } else {""} +
                    if (helpText != null) {", $helpText" } else {""} +
                    if (isRequired == true) {", required" } else {""}},
        onValueChange = { newTextValue -> setTextValue(newTextValue) },
        decorationBox = @Composable { innerTextField ->
            Column {
                Text(label,
                    modifier = Modifier.clearAndSetSemantics {  })
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    propagateMinConstraints = true
                ) {
                    OutlinedTextFieldDefaults.DecorationBox(
                        value = value,
                        innerTextField = innerTextField,
                        enabled = true,
                        singleLine = true,
                        visualTransformation = VisualTransformation.None,
                        interactionSource = remember { MutableInteractionSource() },
                    )
                }
                if (error != null) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .clearAndSetSemantics {  }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_error_24),
                            contentDescription = "Error",
                            tint = Color.Red
                        )
                        Text(
                            error,
                            color = Color.Red,
                            fontSize = MaterialTheme.typography.bodySmall.fontSize)
                    }
                }
                if (helpText != null) {
                    Text(
                        helpText,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        modifier = Modifier.clearAndSetSemantics {  }
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewSupportingTextEndScreen() {
    SupportingTextEndScreen {  }
}