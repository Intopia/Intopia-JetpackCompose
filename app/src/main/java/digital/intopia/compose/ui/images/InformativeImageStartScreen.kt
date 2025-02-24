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
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import digital.intopia.compose.R
import androidx.compose.ui.unit.dp
import digital.intopia.compose.ui.helpers.GenericScaffold
import digital.intopia.compose.ui.helpers.StandaloneLink

@Composable
fun InformativeImageStartScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_informative_image_start),
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
            Text("The informative image below is not labelled.")
            Text("TalkBack will say nothing, which is not appropriate since this image conveys information.")
            Text("Use contentDescription to give informative images a meaningful contextual description.")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Burmese cat colours", style = MaterialTheme.typography.bodyLarge)
            Text("The breed's original standard colour is a distinctly rich dark brown. The first blue Burmese was born in 1955 in Britain, followed by red, cream and tortoiseshell over the next decades. Chocolate first appeared in the United States. Lilac, the last major variant to appear, was likewise developed in the USA beginning in 1971.")
            Image(
                painterResource(R.drawable.burmese_cat),
                // FIXME: Describe the informative image
                contentDescription = null
            )
            Text("Chief is a male lilac Burmese cat", fontStyle = FontStyle.Italic)
            Row(
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text("Content adapted from ")
                StandaloneLink("Burmese cat - Wikipedia", "https://en.wikipedia.org/wiki/Burmese_cat#Coat_and_colour)")
            }
        }
    }
}

@Preview
@Composable
fun PreviewInformativeImageStartScreen() {
    InformativeImageStartScreen {  }
}