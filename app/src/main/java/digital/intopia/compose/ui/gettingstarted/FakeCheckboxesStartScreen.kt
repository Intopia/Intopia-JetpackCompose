/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.gettingstarted

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import digital.intopia.compose.R
import digital.intopia.compose.ui.helpers.GenericScaffold

@Composable
fun FakeCheckboxesStartScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(id = R.string.title_getting_started_start),
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
            Text("These checkboxes are built from generic elements. It is a poor accessibility experience.")
            Text("• No checkbox role")
            Text("• Generic \"double-tap to activate\" usage instruction")
            Text("• No \"ticked\" / \"not ticked\" state announcement")
            Text("• Unlabelled interactive element")
            Text("• On-screen label not linked to checkbox, not interactive")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("How do you get around?",
                style = MaterialTheme.typography.bodyLarge)
            BadFakeCheckbox("Walking")
            BadFakeCheckbox("Bicycle")
            BadFakeCheckbox("Scooter")
            BadFakeCheckbox("Public transport")
            BadFakeCheckbox("Car")
        }
    }
}

@Composable
fun BadFakeCheckbox(label: String, modifier: Modifier = Modifier) {
    val (isChecked, setIsChecked) = rememberSaveable { mutableStateOf(false) }
    // FIXME: 3. Apply checkbox role
    // FIXME: 2. Use toggle-specific event handler to trigger state announcement and improved usage instruction
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(painter = painterResource(
            id = if (isChecked)
                R.drawable.outline_check_box_36
            else
                R.drawable.outline_check_box_outline_blank_36),
            // FIXME: 1. Move event handler from image to row
            modifier = modifier
                .clickable { setIsChecked(!isChecked) },
            contentDescription = null)
        Text(label, style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview
@Composable
fun PreviewFakeCheckboxesStartScreen() {
    FakeCheckboxesStartScreen {  }
}

@Preview(showBackground = true)
@Composable
fun PreviewBadFakeCheckbox() {
    BadFakeCheckbox("Accept the terms")
}