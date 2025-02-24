/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import digital.intopia.compose.R
import androidx.compose.ui.unit.dp
import digital.intopia.compose.ui.helpers.Accordion
import digital.intopia.compose.ui.helpers.GenericScaffold
import digital.intopia.compose.ui.helpers.StandaloneLink

@Composable
fun ComplexImageEndScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_complex_image_end),
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
            Text("Use contentDescription to add a short description to complex images")
            Text("Use the Layout Inspector or TalkBack to check an image's label")
            Text("Add an onscreen detailed description nearby")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("HTML content models", style = MaterialTheme.typography.bodyLarge)
            Image(painterResource(R.drawable.complex),
                contentDescription = "Venn diagram of HTML content category relationships. Detailed description below.")
            Accordion("Image description") {
                Text("Content categories include:")
                Text("1. Flow content")
                Text("2. Metadata content")
                Text("3. Sectioning content")
                Text("4. Heading content")
                Text("5. Phrasing content")
                Text("6. Interactive content")
                Text("7. Embedded content",
                modifier = Modifier.padding(bottom = 16.dp))
            }
            StandaloneLink("HTML content model specification", "https://html.spec.whatwg.org/multipage/dom.html#content-models")
        }
    }
}

@Preview
@Composable
fun PreviewComplexImageEndScreen() {
    ComplexImageEndScreen {  }
}