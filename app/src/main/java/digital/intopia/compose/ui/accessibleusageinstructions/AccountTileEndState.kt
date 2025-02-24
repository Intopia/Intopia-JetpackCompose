/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.accessibleusageinstructions

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import digital.intopia.compose.R
import androidx.compose.ui.unit.dp
import digital.intopia.compose.ui.helpers.GenericScaffold

@Composable
fun AccountTileEndScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_account_tile_end),
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
            Text("Add a custom semantic onClick label to a Button when its label only contains information, not an action or destination.")
            Text("By default, TalkBack says the onClick label at the end of its announcement.")
            Text("Use the Layout Inspector or TalkBack to check an element's onClick label.")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text("Example content")
            AccountTileWithInstruction(
                name = "Personal Account #3333",
                BSB = "111-222",
                account = "11-222-3333",
                available = "+ $100.00",
                current = "+ $100.00",
                icon = R.drawable.outline_credit_card_24
            )
        }
    }
}

@Composable
fun AccountTileWithInstruction(
    name: String,
    BSB: String,
    account: String,
    available: String,
    current: String, icon: Int
) {
    val context = LocalContext.current
    Button(
        modifier = Modifier.semantics {
            onClick(label = "View account details", action = null)
        }
            .background(Color.White)
            .padding(all = 16.dp)
            .border(2.dp, Color.Black, shape = RoundedCornerShape(8.dp))
            .padding(top = 8.dp, bottom = 8.dp)
        ,
        onClick = { Toast.makeText(context, "${name} Account tile tapped", Toast.LENGTH_LONG).show() },
        colors = ButtonDefaults.textButtonColors(contentColor = Color.Black)
    ) {
        Row {
            if (LocalDensity.current.fontScale <= 1.3) {
                Icon(
                    painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
            Column {
                Row {
                    Text(name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null)
                }
                Row(modifier = Modifier.padding(vertical = 4.dp)) {
                    Text("BSB: ${BSB}")
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    Text("Acc: ${account}",
                        modifier = Modifier.semantics {
                            contentDescription = "Account number ${account}"
                        })
                }
                Row {
                    Text("Available balance")
                    Spacer(modifier = Modifier.weight(1.0f))
                    Text(available, fontWeight = FontWeight.Bold)
                }
                Row {
                    Text("Current balance")
                    Spacer(modifier = Modifier.weight(1.0f))
                    Text(current)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewAccountTileEndScreen() {
    AccountTileEndScreen {  }
}