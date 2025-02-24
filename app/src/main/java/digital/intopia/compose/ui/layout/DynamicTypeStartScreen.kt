/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import digital.intopia.compose.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import digital.intopia.compose.ui.helpers.GenericScaffold

@Composable
fun DynamicTypeStartScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_dynamic_type_start),
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
            Text("The 3 text samples at the bottom of this page have fixed text sizes defined.")
            Text("The text will not scale dynamically in line with the device's text size settings.")
            Text("Do not use fixed fonts or absolute sizes when defining text.")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            // FIXME: Replace fixed unit fontSize with scaled units
            Text("This text has a fixed size defined in code using em units. This text won't scale to match the device's text size settings which is not very helpful.",
                fontSize = 3.5.em)
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            // FIXME: Replace fixed unit custom style with scaled unit style
            Text("This text uses a custom font style which in turn uses em units. It will also ignore the device text size settings so some people will find it hard to read.",
                style = myEmTextStyle)
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            // FIXME: Replace text forced not to resize with Material theme style
            NonResizingText("This text is a composable that uses scaling units but deliberately counters the fontScale value to force the text to display at a specific size.")
        }
    }
}

@Composable
fun NonResizingText(
    myText: String,
    fontSize: TextUnit = 15.sp
) {
    Text(text = myText,
        fontSize = (fontSize.value / LocalDensity.current.fontScale).sp,
    )
}

val myEmTextStyle = TextStyle(fontSize = 3.5.em)

@Preview
@Composable
fun PreviewDynamicTypeStartScreen() {
    DynamicTypeStartScreen {  }
}