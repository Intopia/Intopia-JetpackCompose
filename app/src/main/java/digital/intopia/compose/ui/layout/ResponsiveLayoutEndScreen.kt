/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.layout

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import digital.intopia.compose.R
import androidx.compose.ui.unit.dp
import digital.intopia.compose.ui.helpers.GenericScaffold
import digital.intopia.compose.ui.helpers.flights

@Composable
fun ResponsiveLayoutEndScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_responsive_layout_end),
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
            Text("The account tile below does not have a responsive layout. It ends up wrapping excessively.")
            Text("The 3 column table below does not have a responsive layout and it does not support horizontal scrolling. Content ends up wrapping at large text and display size settings.")
            Text("Tables are permitted to scroll horizontally under the W3C Web Content Accessibility Guidelines (WCAG) but you might choose to apply a responsive layout instead to maximise content visibility.")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Responsive account tile",
                style = MaterialTheme.typography.bodyLarge)
            ResponsiveAccountTile(
                name = "Personal account #3333",
                bsb = "111-222",
                account = "33-222-1111",
                available = "+ $53,768.34",
                current = "$55,945.67",
                icon = R.drawable.outline_savings_24
            )
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Responsive table layout",
                style = MaterialTheme.typography.bodyLarge)
            ResponsiveTable()
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ResponsiveAccountTile(
    name: String,
    bsb: String,
    account: String,
    available: String,
    current: String,
    icon: Int
) {
    val context = LocalContext.current
    Row(
        modifier = Modifier.semantics {
            role = Role.Button
            onClick(label = "View account details", action = null)
        }
            .padding(all = 8.dp)
            .border(2.dp, Color.Black, shape = RoundedCornerShape(8.dp))
            .background(Color.White)
            .clickable { Toast.makeText(context, "${name} Account tile tapped", Toast.LENGTH_LONG).show() }
            .padding(all = 16.dp),
    ) {
        val fontScale = LocalDensity.current.fontScale
        val layoutItemCount = if (fontScale > 1.3) 1 else Int.MAX_VALUE
        Row {
            if (fontScale <= 1.3) {
                Icon(
                    painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
            Column {
                FlowRow  {
                    Text(name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        modifier = Modifier.scale(fontScale),
                        contentDescription = null)
                }
                FlowRow(maxItemsInEachRow = layoutItemCount, modifier = Modifier.padding(vertical = 4.dp)) {
                    Text("BSB: ${bsb}")
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    Text("Acc: ${account}",
                        modifier = Modifier.semantics {
                            contentDescription = "Account number ${account}"
                        })
                }
                FlowRow(maxItemsInEachRow = layoutItemCount) {
                    Text("Available balance")
                    Spacer(modifier = Modifier.weight(1.0f))
                    Text(available, fontWeight = FontWeight.Bold)
                }
                FlowRow(maxItemsInEachRow = layoutItemCount) {
                    Text("Current balance")
                    Spacer(modifier = Modifier.weight(1.0f))
                    Text(current)
                }
            }
        }
    }
}

@Composable
fun ResponsiveTable()
{
    val fontScale = LocalDensity.current.fontScale
    if (fontScale <= 1.3) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "Flight",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(0.7f)
            )
            Text(
                "From",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
            Text("To", style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
        }
    }
    flights.forEach { flight ->
        if (fontScale <= 1.3) {
            Row {
                Text(
                    flight.flightNum,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.7f)
                )
                Text(
                    flight.startPoint,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    flight.endPoint,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f)
                )
            }
        } else {
            Column {
                Text("Flight: ${flight.flightNum}",
                    style = MaterialTheme.typography.bodyLarge)
                Text("From: ${flight.startPoint}",
                    style = MaterialTheme.typography.bodyLarge)
                Text("To: ${flight.endPoint}",
                    style = MaterialTheme.typography.bodyLarge)
                HorizontalDivider(modifier = Modifier.padding(top = 8.dp))
            }
        }
    }
}

@Preview
@Composable
fun PreviewResponsiveLayoutEndScreen() {
    ResponsiveLayoutEndScreen {  }
}