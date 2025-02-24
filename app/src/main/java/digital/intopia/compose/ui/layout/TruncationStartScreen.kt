/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import digital.intopia.compose.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import digital.intopia.compose.ui.helpers.GenericScaffold

@Composable
fun TruncationStartScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_truncation_start),
        onBackPressed = onBackPressed
    ) { modifier: Modifier ->
        Column(
            // FIXME: Apply vertical scrolling support
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.padding(horizontal = 16.dp)
        ) {
            Text("This page demonstrates techniques that exclude users due to truncating text.")
            Text("This page does not have scrolling applied on the assumption that the content is short enough to fit in the screen. This might be true at default text size but not when the text size is increased to maximum. It's better to apply scrolling and not need it than to not apply it and unintentionally exclude large text users.")
            Text("If you are deliberately truncating content, such as showing a preview, keep these 2 things in mind:")
            Text("1. TalkBack ignores truncation - it says everything regardless of what is on screen. It's not an equivalent experience.")
            Text("2. Large text users see less preview content than someone using default text size. Is it still useful? Consider adjusting your truncation treatment e.g. 1 line at default text size, 2 lines at 150%, 3 lines at 200% to be roughly equivalent.")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            // FIXME: Remove maxLines restriction
            Text("maxLines = 1 truncates content at large text sizes",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            // FIXME: Remove absolute height restriction
            Text("This text container has an absolute height value applied. Setting height impacts large text users more severely because more content is cut off for them.",
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.height(48.dp))
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewTruncationStartScreen() {
    TruncationStartScreen {  }
}