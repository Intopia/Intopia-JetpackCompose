/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import digital.intopia.compose.R
import androidx.compose.ui.unit.dp
import digital.intopia.compose.ui.helpers.Accordion
import digital.intopia.compose.ui.helpers.GenericScaffold
import digital.intopia.compose.ui.helpers.StandaloneLink

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AboutScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_about_app),
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
            Accordion(title = "Privacy statement") {
                Text("This app does not collect or store any information, including user data or personal information.")
            }
            Accordion("License") {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 8.dp)) {
                    Text("Copyright (c) 2024 Intopia Pty Ltd")
                    Text("Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the \"Software\"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:")
                    Text("The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.")
                    Text("THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.")
                }
            }
            FlowRow {
                Text("This app was built by Allison Ravenhall for ")
                StandaloneLink("Intopia.", "https://intopia.digital")
            }
            Text("It is available to clone and fork on Github.")
            HorizontalDivider()
            Text("Attributions",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.semantics { heading() })
            FlowRow {
                StandaloneLink(linkText = "Three giraffes", url = "https://commons.wikimedia.org/wiki/File:Three_giraffes_01.jpg")
                Text(" used under Creative Commons license ")
                StandaloneLink(linkText = "Attribution-Share Alike 4.0 International",url = "https://creativecommons.org/licenses/by-sa/4.0/deed.en")
            }
            FlowRow {
                StandaloneLink(linkText = "Hippopotamus", "https://commons.wikimedia.org/wiki/File:Hippo_(Hippopotamus_amphibius)_(16485955207).jpg")
                Text(" used under Creative Commons license ")
                StandaloneLink(linkText = "Attribution-Share Alike 2.0 Generic", url = "https://creativecommons.org/licenses/by-sa/2.0/deed.en")
            }
            FlowRow {
                StandaloneLink(linkText = "Cecil the lion", "https://commons.wikimedia.org/wiki/File:Cecil_the_lion_at_Hwange_National_Park_%284516560206%29.jpg")
                Text(" used under Creative Commons license ")
                StandaloneLink(linkText = "Attribution-Share Alike 2.0 Generic", url = "https://creativecommons.org/licenses/by-sa/2.0/deed.en")
            }
        }
    }
}

@Preview
@Composable
fun PreviewAboutScreen() {
    AboutScreen {  }
}