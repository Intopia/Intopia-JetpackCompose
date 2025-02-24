/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.tables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import digital.intopia.compose.R
import androidx.compose.ui.unit.dp
import digital.intopia.compose.ui.helpers.GenericScaffold
import digital.intopia.compose.ui.helpers.flights

@Composable
fun TablesEndScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_tables_end),
        onBackPressed = onBackPressed
    ) { modifier: Modifier ->
        val scrollState = rememberScrollState()
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
        ) {
            Text("JetPack Compose doesn't have native table semantics for Android, so use one of these techniques to craft a contextual announcement for each table data cell.")
            Text("Option 1, used in column 1 (Flight): Apply a contentDescription containing the header and the value")
            Text("Option 2, used in column 2 (From): Apply a stateDescription containing the header only, to accompany the on-screen value.")
            Text("Option 3, used in column 3 (To): Define semantic text similar to the contentDescription")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Intopia Sky flight list", style = MaterialTheme.typography.bodyLarge)
            ContextualDataTable()
        }
    }
}

@Composable
fun ContextualDataTable() {
    Column ( modifier = Modifier
        .fillMaxWidth()
        .padding(all = 4.dp)) {
        Row {
            Text("Flight", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1.0f))
            Text("From", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1.0f))
            Text("To", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1.0f))
        }
        flights.forEach { flight ->
            Row(modifier = Modifier.padding(top = 4.dp)) {
                Text(flight.flightNum, modifier = Modifier
                    .weight(1.0f)
                    .semantics { contentDescription = "Flight ${flight.flightNum}" })
                Text(flight.startPoint, modifier = Modifier
                    .weight(1.0f)
                    .semantics { stateDescription = "From" })
                Text(flight.endPoint, modifier = Modifier
                    .weight(1.0f)
                    .semantics { text = AnnotatedString("To ${flight.endPoint}") })
            }
        }
    }
}

@Preview
@Composable
fun PreviewTablesEndScreen() {
    TablesEndScreen {  }
}