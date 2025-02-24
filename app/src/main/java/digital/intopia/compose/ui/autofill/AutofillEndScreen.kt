/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.autofill

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import digital.intopia.compose.R
import androidx.compose.ui.unit.dp
import digital.intopia.compose.ui.helpers.GenericScaffold
import digital.intopia.compose.ui.helpers.TextFieldWithKeyboardAndAutofill

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AutofillEndScreen(
    onBackPressed: () -> Unit
) {
    GenericScaffold(
        title = stringResource(R.string.title_autofill_end),
        onBackPressed = onBackPressed
    ) { modifier: Modifier ->
        val scrollState = rememberScrollState()
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
                .imePadding()
        ) {
            Text("The text fields below do not support autofill")
            Text("Configuring text fields to reuse existing data can reduce effort and errors.")
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            TextFieldWithKeyboardAndAutofill(
                "First name",
                KeyboardType.Text,
                AutofillType.PersonFirstName)
            TextFieldWithKeyboardAndAutofill(
                "Date of birth",
                KeyboardType.Unspecified,
                AutofillType.BirthDateFull)
            TextFieldWithKeyboardAndAutofill(
                "Address line 1",
                KeyboardType.Text,
                AutofillType.AddressStreet)
            TextFieldWithKeyboardAndAutofill(
                "Phone number",
                KeyboardType.Phone,
                AutofillType.PhoneNumber)
            TextFieldWithKeyboardAndAutofill(
                "Email",
                KeyboardType.Email,
                AutofillType.EmailAddress)
            TextFieldWithKeyboardAndAutofill(
                "Credit card number",
                KeyboardType.Number,
                AutofillType.CreditCardNumber)
            TextFieldWithKeyboardAndAutofill(
                "One-time password",
                KeyboardType.NumberPassword,
                AutofillType.SmsOtpCode)
        }
    }
}

@Preview
@Composable
fun PreviewAutofillEndScreen() {
    AutofillEndScreen {  }
}