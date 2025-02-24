/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.accordions

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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

@Composable
fun AccordionEndScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_accordion_end),
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
            Text("The accordions below are functional and accessible.")
            Text("They have a Button role applied to indicate they're interactive.")
            Text("They report expanded / collapsed state to TalkBack.")
            Text("They have a visual indicator that they're interactive.")
            Text("They support the ability to mark up the trigger phrase as a heading (as demonstrated by \"Hippopotamus\"")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("About zoo animals", style = MaterialTheme.typography.bodyLarge)
            Accordion(
                title = "Giraffe"
            ) {
                Column ( verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(bottom = 8.dp, start = 4.dp, end = 4.dp) ){
                    Text("The giraffe is a large African hoofed mammal belonging to the genus Giraffa. It is the tallest living terrestrial animal and the largest ruminant on Earth.")
                    Image(
                        painterResource(R.drawable.giraffes),
                        contentDescription = "Three giraffes walk through tall grasses under a bright blue sky dotted with fluffy clouds."
                    )
                    Text("The giraffe's distinguishing characteristics are its extremely long neck and legs, horn-like ossicones, and spotted coat patterns.")
                }
            }
            Accordion(title = "Hippopotamus", isHeading = true) {
                Column ( verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(bottom = 8.dp, start = 4.dp, end = 4.dp) ) {
                    Text("The hippopotamus, often shortened to hippo, is a large semiaquatic mammal native to sub-Saharan Africa. Its name comes from the ancient Greek for \"river horse\".")
                    Image(
                        painterResource(R.drawable.hippo),
                        contentDescription = "A single hippo stands on sandy ground dotted with flat rocks and grasses beside a stream."
                    )
                    Text("Hippos are among the most dangerous animals in the world due to their aggressive and unpredictable nature. They are threatened by habitat loss and poaching for their meat and ivory (canine teeth).")
                }
            }
            Accordion(title = "Lion") {
                Column ( verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(bottom = 8.dp, start = 4.dp, end = 4.dp) ) {
                    Text("The lion is a large cat native to Africa and India. It is a social species, forming groups called prides. A lion's pride consists of a few adult males, related females, and cubs.")
                    Image(
                        painterResource(R.drawable.lion),
                        contentDescription = "An adult male lion lays in scrubby grassland, head raised and looking at the camera, one eye slightly squinted against the low sun."
                    )
                    Text("The lion is an apex and keystone predator; although some lions scavenge when opportunities occur and have been known to hunt humans, lions typically do not actively seek out and prey on humans.")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewAccordionEndScreen() {
    AccordionEndScreen {  }
}