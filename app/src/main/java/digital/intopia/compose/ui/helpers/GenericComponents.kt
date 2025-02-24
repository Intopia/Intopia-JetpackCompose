/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.helpers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillNode
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalAutofill
import androidx.compose.ui.platform.LocalAutofillTree
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.collapse
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.expand
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import digital.intopia.compose.R

@Composable
fun Accordion(
    title: String,
    isHeading: Boolean = false,
    content: @Composable () -> Unit
) {
    val (isExpanded, setIsExpanded) = remember { mutableStateOf(false) }
    val iconScalingMultiplier = LocalDensity.current.fontScale

    Column {
        ListItem(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClickLabel = if (isExpanded) "Collapse" else "Expand") {
                    setIsExpanded(!isExpanded)
                }
                .semantics {
                    role = Role.Button
                    if (isHeading) { heading() }
                    if (isExpanded) {
                        collapse {
                            setIsExpanded(false)
                            return@collapse true
                        }
                    } else {
                        expand {
                            setIsExpanded(true)
                            return@expand true
                        }
                    }
                },
            headlineContent = {
                Text(
                    title,
                    fontWeight = if (isExpanded) FontWeight.Bold else FontWeight.Normal
                ) },
            leadingContent = {
                Icon(painter = painterResource(
                    id = if (isExpanded)
                        R.drawable.outline_expand_circle_up_24
                    else
                        R.drawable.outline_expand_circle_down_24),
                    modifier = Modifier.scale(iconScalingMultiplier),
                    contentDescription = null)
            }
        )
        if (isExpanded) {
            content()
        }
        HorizontalDivider()
    }
}

@Composable
fun StandaloneLink(
    linkText: String,
    url: String,
    accessibleName: String? = null
) {
    val annotatedString = buildAnnotatedString {
        val startIndex = 0
        val endIndex = linkText.length

        pushStyle(
            style = SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            )
        )
        append(linkText)
        addLink(
            url = LinkAnnotation.Url(url),
            start = startIndex,
            end = endIndex
        )
    }

    Text(annotatedString,
        modifier = Modifier.semantics {
            if (accessibleName != null) {
                contentDescription = accessibleName
            }
        })
}

@Composable
fun ShowAlert(
    setIsAlertOpen: (Boolean) -> Unit,
    alertText: String
) {
    AlertDialog(
        onDismissRequest = {
            setIsAlertOpen(false)
        },
        confirmButton = {
            TextButton(onClick = {
                setIsAlertOpen(false)
            }) {
                Text("OK")
            }
        },
        text = {
            Text(alertText)
        }
    )
}

@Composable
fun SimpleTextField(
    label: String
) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(label) }
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SimpleTextFieldWithKeyboard(
    label: String,
    keyboard: KeyboardType
) {
    val (text, setText) = remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { newText -> setText(newText) },
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboard)
    )
}















@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldWithKeyboardAndAutofill(
    label: String,
    keyboard: KeyboardType,
    autofill: AutofillType
) {
    val (text, setText) = remember { mutableStateOf("") }

    val autofillNode = AutofillNode(listOf(autofill),
        onFill = { newText -> setText(newText) } )
    LocalAutofillTree.current += autofillNode
    val currentLocalAutofill = LocalAutofill.current

    OutlinedTextField(
        value = text,
        onValueChange = { newText -> setText(newText) },
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboard),
        modifier = Modifier
            .onFocusChanged { focusState ->
                currentLocalAutofill?.run {
                    if (focusState.isFocused) {
                        requestAutofillForNode(autofillNode)
                    } else {
                        cancelAutofillForNode(autofillNode)
                    }
                }
            }
            .onGloballyPositioned {
                autofillNode.boundingBox = it.boundsInWindow()
            }
    )
}