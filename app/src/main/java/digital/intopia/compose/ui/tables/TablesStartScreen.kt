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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import digital.intopia.compose.R
import androidx.compose.ui.unit.dp
import digital.intopia.compose.ui.helpers.GenericScaffold
import digital.intopia.compose.ui.helpers.flights

@Composable
fun TablesStartScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_tables_start),
        onBackPressed = onBackPressed
    ) { modifier: Modifier ->
        val scrollState = rememberScrollState()
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
        ) {
            Text("The data table below is built from generic containers.")
            Text("TalkBack users aren't told about data relationships like row and column headers")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Intopia Sky flight list", style = MaterialTheme.typography.bodyLarge)
            Row (
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Flight", fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.7f))
                Text("From", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                Text("To", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
            }
            flights.forEach { flight ->
                Row {
                    // FIXME: Apply contentDescription to flight number column values
                    Text(flight.flightNum, modifier = Modifier.weight(0.7f))
                    // FIXME: Apply stateDescription to "From" column values
                    Text(flight.startPoint, modifier = Modifier.weight(1f))
                    // FIXME: Apply AnnotatedString text semantic to "To" column values
                    Text(flight.endPoint, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewTablesStartScreen() {
    TablesStartScreen {  }
}